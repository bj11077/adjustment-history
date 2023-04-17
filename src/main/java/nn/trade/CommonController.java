package nn.trade;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RequiredArgsConstructor
public abstract class CommonController<ENT extends BaseEntity,REQ extends BaseDto,RES extends BaseDto> {

    protected final CommonService<ENT,REQ,RES> service;

    @GetMapping
    public ResponseDto<List<RES>> getList(){
        return ResponseDto.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseDto<RES> getById(@PathVariable("id") Long id){
        return ResponseDto.ok(service.findById(id));
    }

    @PostMapping
    public ResponseDto<RES> save(@Valid @RequestBody REQ dto) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return ResponseDto.ok(service.save(dto));
    }

    @PostMapping("/save-all")
    public ResponseDto<List<RES>> saveAll(@Valid @RequestBody ValidDtoList<REQ> dtoList) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return ResponseDto.ok(service.saveAll(dtoList.getDtoList()));
    }

    @PutMapping
    public ResponseDto<RES> update(@RequestBody REQ dto) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return ResponseDto.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseDto<Boolean> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseDto.ok(true);
    }




}