package nn.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @TODO
 * CommonService 및 CommonController 상속제거 ( past 브랜치로 이동 )
 * 1. 응답용DTO , 요청용DTO 구분이 힘들어짐
 * 2. Swagger사용시 각 요청에 대해 상세한 설명하기가 힘듬
 */

@EnableJpaRepositories
@SpringBootApplication
public class TradeHistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeHistoryApplication.class, args);
    }

}
