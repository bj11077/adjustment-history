package nn.trade;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequiredArgsConstructor
public abstract class CommonController<T extends BaseEntity,P,D extends BaseDto> {

    protected final CommonService<T,P,D> service;


    @GetMapping
    public List<D> getList(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public D getById(@PathVariable("id") Long id){
        return null;
    }


}
