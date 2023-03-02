package nn.trade.adjustment.mapping;

import nn.trade.adjustment.history.AdjustmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdjustmentMappingRepository extends JpaRepository<AdjustmentMapping,Long>{
}
