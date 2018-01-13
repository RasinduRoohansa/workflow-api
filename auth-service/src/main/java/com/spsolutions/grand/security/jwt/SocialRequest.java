package com.spsolutions.grand.security.jwt;

public class SocialRequest {
    private String provider;
    private String email;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
