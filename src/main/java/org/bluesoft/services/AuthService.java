package org.bluesoft.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import io.smallrye.jwt.util.KeyUtils;
import org.bluesoft.errors.AppException;
import org.bluesoft.models.session.BlUser;
import org.bluesoft.models.session.UserCredentials;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.crypto.SecretKey;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class AuthService {
    private SecretKey secretKey;

    @Inject
    BlUserService userService;

    @Inject
    JWTParser parser;

    public AuthService() throws Exception {
        this.secretKey = KeyUtils.generateSecretKey(SignatureAlgorithm.HS512);
    }

    public TokenResponse generateJwt(UserCredentials credentials) {
        try {
            BlUser user=validateUser (credentials.getUsername(), credentials.getPassword());
            JwtClaimsBuilder accessTokenBuild = Jwt.issuer("aquaher")
                    .subject(user.getId());
            getClaims(user).forEach(accessTokenBuild::claim);
            String accessToken= accessTokenBuild.sign();


            String refreshToken = Jwt.issuer("aquaher")
                    .subject(user.getId())
                    .claim("upn", user.getUsername())
                    .claim("preferred_username", user.getUsername())
                    .sign(secretKey);

            return new TokenResponse(accessToken, 36000, refreshToken, 36000, "Bearer", "openid profile email");
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    private BlUser validateUser (String username, String password) {
        List<BlUser> user = userService.getByUsername(username);
        if (user.isEmpty()) {
            throw new AppException("Usuario invalido.");
        } else if(BlUserService.checkPassword(password, user.get(0).getPassword())) {
            return user.get(0);
        } else {
            throw new AppException("Contraseña invalida.");
        }
    }

    public Map<String, Object> getClaims(BlUser user) {
        long now = System.currentTimeMillis() / 1000;
        long exp = now + 36000;

        Map<String, Object> claims = new HashMap<>();
        claims.put("exp", exp);
        claims.put("iat", now);
        claims.put("jti", java.util.UUID.randomUUID().toString());
        claims.put("iss", "aquaher");
        claims.put("aud", "account");
        claims.put("sub", user.getId());
        claims.put("typ", "Bearer");
        claims.put("azp", "frontend");
        claims.put("sid", java.util.UUID.randomUUID().toString());
        claims.put("acr", "1");
        claims.put("allowed-origins", Arrays.asList(
                "https://app.grupoheredia.com.ec/*",
                "https://app.grupoheredia.com.ec",
                "/*",
                "http://localhost:3001/*",
                "http://localhost:3001"
        ));
        claims.put("realm_access", Map.of("roles", Arrays.asList(
                "default-roles-aquaher",
                "offline_access",
                "uma_authorization"
        )));
        claims.put("resource_access", Map.of("account", Map.of("roles", Arrays.asList(
                "manage-account",
                "manage-account-links",
                "view-profile"
        ))));
        claims.put("scope", "openid profile email");
        claims.put("email_verified", true);
        claims.put("preferred_username", user.getUsername());
        claims.put("name", user.getFirstname()+" "+user.getLastname());
        claims.put("given_name", user.getFirstname());
        claims.put("family_name", user.getLastname());
        claims.put("group", Arrays.asList("/"+user.getType()));
        return claims;
    }

    public Object generateUserInfo(String authorizationHeader) {
        try{
            String token = authorizationHeader.substring("Bearer ".length()).trim();
            JsonWebToken jwt = parser.parse(token);
            return new UserInfoResponse(
                    jwt.getClaim("sub").toString(),
                    jwt.getClaim("email_verified").toString(),
                    jwt.getClaim("name").toString(),
                    jwt.getClaim("preferred_username").toString(),
                    jwt.getClaim("given_name").toString(),
                    jwt.getClaim("family_name").toString(),
                    jwt.getClaim("group").toString());
        }
        catch (ParseException e){
            throw new AppException("Token invalido.");
        }
    }

    public static class TokenResponse {
        private String access_token;
        private int expires_in;
        private String refresh_token;
        private int refresh_expires_in;
        private String token_type;
        private String scope;

        public TokenResponse(String access_token, int expires_in, String refresh_token, int refresh_expires_in, String token_type, String scope) {
            this.access_token = access_token;
            this.expires_in = expires_in;
            this.refresh_token = refresh_token;
            this.refresh_expires_in = refresh_expires_in;
            this.token_type = token_type;
            this.scope = scope;
        }

        public String getAccess_token() {
            return access_token;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public int getRefresh_expires_in() {
            return refresh_expires_in;
        }

        public String getToken_type() {
            return token_type;
        }

        public String getScope() {
            return scope;
        }
    }

    public static class UserInfoResponse {
        private String sub;
        private String email_verified;
        private String name;
        private String preferred_username;
        private String given_name;
        private String family_name;
        private List<String> group;

        public UserInfoResponse(String sub, String email_verified, String name, String preferred_username, String given_name, String family_name, String group) {
            this.sub = sub;
            this.email_verified = email_verified;
            this.name = name;
            this.preferred_username = preferred_username;
            this.given_name = given_name;
            this.family_name = family_name;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                this.group = objectMapper.readValue(group, new TypeReference<List<String>>() {});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getSub() {
            return sub;
        }

        public String getEmail_verified() {
            return email_verified;
        }

        public String getName() {
            return name;
        }

        public String getPreferred_username() {
            return preferred_username;
        }

        public String getGiven_name() {
            return given_name;
        }

        public String getFamily_name() {
            return family_name;
        }

        public List<String> getGroup() {
            return group;
        }
    }
}
