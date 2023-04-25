package nn.trade.adjustment;

import io.swagger.v3.oas.annotations.tags.Tag;
import nn.trade.CommonController;
import nn.trade.CommonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "네임네임",description = "설명설명")
@RestController
@RequestMapping("/api/adjustment")
public class AdjustmentController  extends CommonController<Adjustment,AdjustmentDto,AdjustmentDto> {

    public AdjustmentController(CommonService<Adjustment, AdjustmentDto, AdjustmentDto> service) {
        super(service);
    }

}
