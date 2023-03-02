package nn.trade.adjustment.mapping;


import nn.trade.CommonController;
import nn.trade.adjustment.history.AdjustmentHistory;
import nn.trade.adjustment.history.AdjustmentHistoryDto;
import nn.trade.adjustment.history.AdjustmentHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/adjustment-mapping")
public class AdjustmentMappingController extends CommonController<AdjustmentMapping,Long, AdjustmentMappingDto> {

    public AdjustmentMappingController(AdjustmentMappingService service) {
        super(service);
    }
}
