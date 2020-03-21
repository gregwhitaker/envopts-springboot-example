package envopts.example;

import com.github.gregwhitaker.envopts.EnvOpts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        // Getting the ENV_OPTS environment variable and parsing it for use by the application
        EnvOpts.parse();

        SpringApplication.run(Application.class);
    }
}
