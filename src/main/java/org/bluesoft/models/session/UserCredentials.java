package org.bluesoft.models.session;

public class UserCredentials {
    private String username;
    private String password;
    private String grant_type;
    private String client_id;
    private String client_secret;
    private String refresh_token;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGrantType() {
        return grant_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
}
