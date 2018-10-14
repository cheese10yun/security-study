package spring.security.study.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //@formatter:off

        http
                .authorizeRequests().antMatchers("/auth").permitAll();

        http
            .authorizeRequests()
                .anyRequest().authenticated()
                    .antMatchers("/delete/**").hasRole("ADMIN")
                    .antMatchers("/home/**").hasAuthority("USER")
                    .antMatchers("/delete/**").hasAuthority("ADMIN")
                    .antMatchers("/delete/**").hasAnyAuthority("ADMIN", "MANAGER")
                ;


        // login
        http
            .formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/doLogin")
        ;
        // Login

        // Logout
        http
            .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/doLogout", "GET"))
        ;
        // Logout



        http.csrf().disable();

        //@formatter:on
    }
}
