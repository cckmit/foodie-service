package com.foodie.portal;

import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class FoodieApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .environment(new StandardEncryptableEnvironment())
                .sources(FoodieApplication.class).run(args);
    }

}
