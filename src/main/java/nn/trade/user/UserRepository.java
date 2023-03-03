package nn.trade.user;

import nn.trade.adjustment.Adjustment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

}
