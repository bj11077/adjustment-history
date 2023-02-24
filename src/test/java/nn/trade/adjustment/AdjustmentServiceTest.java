package nn.trade.adjustment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdjustmentServiceTest {

    @Autowired
    AdjustmentService service;


    @Test
    void findByTitle() {
        service.findAllByTitle("title");
    }

}