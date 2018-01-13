package com.spsolutions.grand.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author Stelan Briyan
 */
public class JWTAuthenticationFilter extends GenericFilterBean {
    private final static Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationService.class);

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        try {
            Authentication authentication = TokenAuthenticationService
                    .getAuthentication((HttpServletRequest) request);

            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("{");
                stringBuffer.append("\"status\":\"" + 403 + "\",");
                stringBuffer.append("\"msg\":\"" + e.getMessage() + "\"");
                stringBuffer.append("}");
                response.getWriter().write(stringBuffer.toString());
                response.setContentType("application/json");
            } catch (IOException ex) {
                LOGGER.info(ex.getMessage());
            }
        }
    }
}
