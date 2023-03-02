package nn.trade.adjustment.history;

import nn.trade.adjustment.Adjustment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdjustmentHistoryRepository extends JpaRepository<AdjustmentHistory,Long>{
}
