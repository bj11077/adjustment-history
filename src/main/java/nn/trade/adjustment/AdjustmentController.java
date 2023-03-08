package nn.trade.adjustment;

import lombok.RequiredArgsConstructor;
import nn.trade.CommonController;
import nn.trade.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adjustment")
public class AdjustmentController extends CommonController<Adjustment,Long,AdjustmentDto> {

    public AdjustmentController(AdjustmentService service) {
        super(service);
    }
}
