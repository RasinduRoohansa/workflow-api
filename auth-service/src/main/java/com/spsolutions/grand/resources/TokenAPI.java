package com.spsolutions.grand.resources;

import com.spsolutions.grand.domain.User;
import com.spsolutions.grand.mappers.AuthUserMapper;
import com.spsolutions.grand.security.jwt.SocialRequest;
import com.spsolutions.grand.security.jwt.TokenAuthenticationService;
import com.spsolutions.grand.security.jwt.TokenResponse;
import com.spsolutions.grand.util.JwtTokenUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping("/")
public class TokenAPI {
    private final static Logger LOGGER = LoggerFactory.getLogger(TokenAPI.class);

    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    @Autowired
    private AuthUserMapper userMapper;

    @RequestMapping(value = "refreshToken", method = RequestMethod.POST)
    public Map<String, Object> refreshToken(@RequestBody Map<String, Object> map) {
        Map<String, Object> response = new HashMap<>();
        Object refreshToken = map.get("refreshToken");
        if (refreshToken != null) {
            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            response.put("token", jwtTokenUtil.refreshToken(refreshToken.toString()));
        }
        return response;
    }

    @RequestMapping(value = "socialLogin", method = RequestMethod.POST)
    public void socialLogin(HttpServletResponse res, @RequestBody SocialRequest request) {
        User user = this.userMapper.findByEmail(request.getEmail());

        if (user != null) {
            String JWT = Jwts.builder()
                    .setSubject(user.getFirstname())
                    .setExpiration(new Date(System.currentTimeMillis() + TokenAuthenticationService.EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, TokenAuthenticationService.SECRET)
                    .compact();
            res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);

            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            String refreshToken = jwtTokenUtil.refreshToken(JWT);
            Date expirationDateFromToken = jwtTokenUtil.getExpirationDateFromToken(JWT);

            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(JWT);
            tokenResponse.setPrefix(TOKEN_PREFIX);
            tokenResponse.setExpirationDate(expirationDateFromToken);
            tokenResponse.setRefreshToken(refreshToken);
            tokenResponse.setUserFullname(user.getFirstname() + " " + user.getLastname());
            tokenResponse.setUsername(user.getUsername());
            try {
                res.getWriter().write(tokenResponse.toString());
                res.setContentType("application/json");
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        }
    }
}
