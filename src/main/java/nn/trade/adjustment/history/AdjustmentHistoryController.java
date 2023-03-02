package nn.trade.adjustment.history;


import nn.trade.CommonController;
import nn.trade.CommonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/adjustment-history")
public class AdjustmentHistoryController extends CommonController<AdjustmentHistory,Long,AdjustmentHistoryDto> {

    public AdjustmentHistoryController(AdjustmentHistoryService service) {
        super(service);
    }
}
