package nn.trade.adjustment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import nn.trade.CommonController;
import nn.trade.CommonService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "네임네임",description = "설명설명")
@RestController
@RequestMapping("/api/adjustment")
public class AdjustmentController extends CommonController<Adjustment,Long,AdjustmentDto> {
    public AdjustmentController(AdjustmentService service) {
        super(service);
    }
}
