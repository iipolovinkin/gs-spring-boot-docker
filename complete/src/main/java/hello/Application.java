package hello;

import io.sentry.Sentry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        String dsn = "http://857a6e1731ba4c7e8709259031f05183@localhost:8000/1";
        Sentry.init(dsn);
        SpringApplication.run(Application.class, args);
    }

}
