package org.sid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Config {

    //bcrypt password encoder n'est pas instancié par spring
    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }


}
