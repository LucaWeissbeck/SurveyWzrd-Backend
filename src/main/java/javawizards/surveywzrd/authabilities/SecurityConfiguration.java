package javawizards.surveywzrd.authabilities;

import javawizards.surveywzrd.users.Administrator;
import javawizards.surveywzrd.users.AdministratorRepository;
import javawizards.surveywzrd.users.AuthToken;
import javawizards.surveywzrd.users.AuthTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    AuthTokenRepository authTokenRepository;
    AdministratorRepository administratorRepository;

    @Autowired
    public SecurityConfiguration(AuthTokenRepository authTokenRepository, AdministratorRepository administratorRepository){
        this.authTokenRepository = authTokenRepository;
        this.administratorRepository = administratorRepository;
    }

    private static final String[] AUTH_WHITELIST = {

            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v2/api-docs",
            "/webjars/**"
    };

    @Override
    public void configure(final WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/survey/public/**").antMatchers(AUTH_WHITELIST);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        APIKeyAuthFilter filter = new APIKeyAuthFilter("x-api-key");
        filter.setAuthenticationManager(new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String auth_token_request = (String) authentication.getPrincipal();
                Optional<AuthToken> tolookfor = authTokenRepository.findByauthKey(auth_token_request);
                if (!tolookfor.isPresent()){
                    throw new BadCredentialsException("The API key was not found or not the expected value.");
                }
                //Debugging:
                /*AuthToken authToken = tolookfor.get();
                Optional<Administrator> administrator = administratorRepository.findById(authToken.getAdmin().getId());
                System.out.println(administrator.get().getEmail());*/

                authentication.setAuthenticated(true);
                return authentication;
            }
        });
        httpSecurity.
                antMatcher("/**").
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().addFilter(filter).authorizeRequests().anyRequest().authenticated();
    }

}