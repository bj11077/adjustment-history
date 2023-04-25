package nn.trade.adjustment;


import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import nn.trade.CommonService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AdjustmentService  extends CommonService<Adjustment,AdjustmentDto,AdjustmentDto> {

    public AdjustmentService(JpaRepository<Adjustment, Long> repository, EntityManager em) {
        super(repository, em);
    }

    @Override
    public Class<AdjustmentDto> getRequestDtoClass() {
        return AdjustmentDto.class;
    }

    @Override
    public Class<AdjustmentDto> getResponseDtoClass() {
        return AdjustmentDto.class;
    }
}
