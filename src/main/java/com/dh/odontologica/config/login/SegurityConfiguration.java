package com.dh.odontologica.config.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SegurityConfiguration  extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //***********************************Metodos**************************************//
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/user/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated().and()
//                .formLogin();

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**")
                .permitAll()
                .antMatchers("/domicilio/crear").hasRole("ADMIN")
                .antMatchers("/odontologo/crear").hasRole("ADMIN")
                .antMatchers("/pacientes/crear").hasRole("ADMIN")
                .antMatchers("/turno/crear").hasRole("USER")
                .anyRequest()
                .authenticated().and()
                .httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

    //******************************************************************************************//

}



