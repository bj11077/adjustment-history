package nn.trade.adjustment;


import lombok.extern.slf4j.Slf4j;
import nn.trade.CommonService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class AdjustmentService extends CommonService {

    public AdjustmentService(AdjustmentRepository repository) {
        super(repository);
    }

    public void findAllByTitle(String id){
        List<Adjustment> result = ((AdjustmentRepository) repository).findByTitle(id);
        result.forEach(e-> System.out.println(e.getTitle()));
    }
}
