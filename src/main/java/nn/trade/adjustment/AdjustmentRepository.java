package nn.trade.adjustment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdjustmentRepository extends JpaRepository<Adjustment,Long> {

    List<Adjustment> findByTitle(String title);

}
