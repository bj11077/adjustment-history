package nn.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories
@SpringBootApplication
public class TradeHistoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeHistoryApplication.class, args);
    }

}
