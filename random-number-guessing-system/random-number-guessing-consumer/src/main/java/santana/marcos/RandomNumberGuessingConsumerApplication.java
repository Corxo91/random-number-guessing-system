package santana.marcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RandomNumberGuessingConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RandomNumberGuessingConsumerApplication.class, args);
    }
}