package illutech.com.database.Configuration;


import illutech.com.database.entities.Department;
import illutech.com.database.entities.Employee;
import illutech.com.database.entities.Project;
import illutech.com.database.entities.Users;
import jakarta.annotation.sql.DataSourceDefinition;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class databaseConfiguration {
    public static Session Config(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Project.class);
        configuration.addAnnotatedClass(Users.class);
        configuration.setProperties(getProperties());
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory.openSession();
    }
    private static Properties getProperties(){
        final String hostName = "localhost";
        final String portNumber = "5432";
        final String implementationMode = getImplementationMode();

        final String url = "jdbc:postgresql://"+hostName+":"+portNumber+"/employee";

        Properties props = new Properties();
        props.put("hibernate.connection.username","postgres");
        props.put("hibernate.connection.password","nimakarimian76");
        props.put("hibernate.connection.driver_class","org.postgresql.Driver");
        props.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.connection.url",url);
        props.put("current_session_context_class","thread");
        props.put("hibernate.hbm2ddl.auto", implementationMode);
        props.put("hibernate.show_sql","true");
        props.put("hibernate.default_schema","public");
        return props;
    }

    private static String getImplementationMode() {
        return "update";
    }
}
