package illutech.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication //TODO Remember to add datasource to the classpath
@PropertySource("classpath:Application.properties")
public class Main {
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");
    }
}