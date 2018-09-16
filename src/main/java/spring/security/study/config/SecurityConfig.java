package spring.security.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //@formatter:off
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}pass").roles("USER");
        //@formatter:on

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
