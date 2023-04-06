package illutech.com;

import illutech.com.database.Configuration.databaseConfiguration;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //TODO Remember to add datasource to the classpath
@PropertySource("classpath:Application.properties")
public class Main {
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");
    }
}