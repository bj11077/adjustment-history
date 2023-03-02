package nn.trade;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RequiredArgsConstructor
public abstract class CommonController<T extends BaseEntity,P,D extends BaseDto> {

    protected final CommonService<T,P,D> service;


    @GetMapping
    public List<D> getList(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public D getById(@PathVariable("id") P id){
        return service.findById(id);
    }

    @PostMapping
    public D save(@RequestBody D dto) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return service.save(dto);
    }

    @PostMapping("/save-all")
    public List<D> saveAll(@RequestBody List<D> dtoList) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return service.saveAll(dtoList);
    }

    @PutMapping
    public D update(@RequestBody D dto) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") P id){
        service.delete(id);
        return true;
    }




}
