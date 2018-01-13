package com.spsolutions.grand.security.jwt;

import com.spsolutions.grand.util.JwtTokenUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static java.util.Collections.emptyList;


/**
 * @author Stelan Briyan
 */
public class TokenAuthenticationService {
    private final static Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationService.class);

    public static final long EXPIRATION_TIME = 86400000; // 24 Hour
    public static final String SECRET = "ThisIsASecret";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse res, Authentication auth) {
        String JWT = Jwts.builder()
                .setSubject(auth.getName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
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

        JwtUser user = (JwtUser) auth.getPrincipal();
        tokenResponse.setUserFullname(user.getFirstname() + " " + user.getLastname());
        try {
            res.getWriter().write(tokenResponse.toString());
            res.setContentType("application/json");
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                    null;
        }
        return null;
    }
}
