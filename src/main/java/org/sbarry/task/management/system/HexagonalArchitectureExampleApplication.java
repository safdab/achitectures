package org.sbarry.task.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "classpath:application.properties" })
public class HexagonalArchitectureExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalArchitectureExampleApplication.class, args);
    }

}
