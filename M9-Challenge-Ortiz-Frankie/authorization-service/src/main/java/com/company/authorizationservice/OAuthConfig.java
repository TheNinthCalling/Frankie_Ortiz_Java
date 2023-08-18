package com.company.authorizationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuthConfig  extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;

    @Autowired
    public OAuthConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("html5")
                .authorizedGrantTypes("password")
                .scopes("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")
                .secret("$2a$10$0Mf57EA3kipR1ej14v/tpeZ5UvV7kmcym57hfztwF79seJc.ulnHS")
                .and()
                .withClient("html6")
                .authorizedGrantTypes("password")
                .scopes("ROLE_USER")
                //password is app_secret2, Authorization is: Basic aHRtbDY6YXBwX3NlY3JldDI=
                .secret("$2a$12$dfqtpHdz5Svgji6e18m.pehAOoc0Xw/9NEOhReehbhap0F9dHhCQq")
                .and()
                .withClient("ninja3")
                .authorizedGrantTypes("password")
                .scopes("ROLE_MANAGER")
                //password is ninja_stars, Authorization is: Basic bmluamEzOm5pbmphX3N0YXJz
                .secret("$2a$12$mIR3SzVc2d7l9jQRYPYRbeHCBty.LYWRY6MfI9ggIgwyYPX4MGanS");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager);
    }
}