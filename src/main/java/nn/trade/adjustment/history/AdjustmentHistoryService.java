package nn.trade.adjustment.history;


import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import nn.trade.CommonService;
import nn.trade.adjustment.Adjustment;
import nn.trade.adjustment.AdjustmentDto;
import nn.trade.adjustment.AdjustmentRepository;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AdjustmentHistoryService extends CommonService<AdjustmentHistory,Long,AdjustmentHistoryDto> {
    public AdjustmentHistoryService(AdjustmentHistoryRepository repository, EntityManager em) {
        super(repository, em);
    }

    @Override
    public Class<AdjustmentHistoryDto> getDtoClass() {
        return AdjustmentHistoryDto.class;
    }

}
