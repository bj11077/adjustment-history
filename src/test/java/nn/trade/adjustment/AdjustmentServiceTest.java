package nn.trade.adjustment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdjustmentServiceTest {

    @Autowired
    AdjustmentService service;


    @Test
    void findByTitle() {
        service.findAllByTitle("title");
    }

    @Test
    void findAllTest(){
        List<AdjustmentDto> result = service.findAll();
        result.forEach(e-> System.out.println(e.getTitle()));
    }
}