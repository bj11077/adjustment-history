package nn.trade.adjustment.mapping;


import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import nn.trade.CommonService;
import nn.trade.adjustment.history.AdjustmentHistory;
import nn.trade.adjustment.history.AdjustmentHistoryDto;
import nn.trade.adjustment.history.AdjustmentHistoryRepository;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AdjustmentMappingService extends CommonService<AdjustmentMapping,Long, AdjustmentMappingDto> {
    public AdjustmentMappingService(AdjustmentMappingRepository repository, EntityManager em) {
        super(repository, em);
    }

    @Override
    public Class<AdjustmentMappingDto> getDtoClass() {
        return AdjustmentMappingDto.class;
    }

}
