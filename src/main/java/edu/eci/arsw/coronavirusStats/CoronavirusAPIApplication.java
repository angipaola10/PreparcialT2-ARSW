package edu.eci.arsw.coronavirusStats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Coronavirus api application.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.coronavirusStats"})
public class CoronavirusAPIApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(CoronavirusAPIApplication.class, args);
    }

}

