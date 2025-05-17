package org.example.btvnonline1;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class BtvnOnline1Application {

    public static void main(String[] args) {

        Environment environment = SpringApplication.run(BtvnOnline1Application.class, args).getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        String port = environment.getProperty("server.port");

        if(appName != null){
            appName = appName.toUpperCase();
        }
        log.info("----------------START {} APPLICATION----------------", appName);
        log.info("      Application       : {}", appName);
        log.info("      Url swagger-ui      : http://localhost:{}/swagger-ui.html", port);
        log.info("----------------START SUCCESS {} APPLICATION----------------",appName);
    }

}
