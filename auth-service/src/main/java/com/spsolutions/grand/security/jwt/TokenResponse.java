package com.spsolutions.grand.security.jwt;

import java.util.Date;


/**
 * @author Stelan Briyan
 */
public class TokenResponse {
    private String token;
    private String refreshToken;
    private String prefix;
    private String username;
    private Date expirationDate;
    private String userFullname;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("\"token\":\"" + token + "\",");
        stringBuffer.append("\"refreshToken\":\"" + refreshToken + "\",");
        stringBuffer.append("\"prefix\":\"" + prefix + "\",");
        stringBuffer.append("\"expirationDate\":\"" + expirationDate + "\",");
        stringBuffer.append("\"status\":\"" + 200 + "\",");
        stringBuffer.append("\"username\":\"" + username + "\",");
        stringBuffer.append("\"userFullname\":\"" + userFullname + "\"");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
