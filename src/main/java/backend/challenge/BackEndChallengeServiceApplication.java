package backend.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

@SpringBootApplication
public class BackEndChallengeServiceApplication {

    @Bean
    public HttpHeaders httpHeaders() {
        return new HttpHeaders();
    }

    public static void main(String[] args) {
        SpringApplication.run(BackEndChallengeServiceApplication.class, args);
    }

}
