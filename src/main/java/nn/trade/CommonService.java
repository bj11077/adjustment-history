package nn.trade;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;



@RequiredArgsConstructor
public abstract class CommonService<T extends BaseEntity,P,D extends BaseDto> {

    protected final JpaRepository<T,P> repository;

    public abstract Class<D> getDtoClass();


    public List<D> findAll(){
        List<T> result = repository.findAll();
        return result.stream().map(this::toDto).collect(Collectors.toList());
    }

    public D findById(P id){
        return toDto(repository.findById(id).orElseThrow());
    }

    public D save(D dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object toEntity = getDtoClass().getMethod("toEntity").invoke(dto);
        System.out.println(toEntity.toString());
        return toDto(repository.save((T) toEntity));
    }

    public List<D> saveAll(List<D> dtoList){
        List<T> toEntityList = dtoList.stream().map(e -> {
            try {
                return  (T)getDtoClass().getMethod("toEntity").invoke(e);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            } catch (InvocationTargetException ex) {
                throw new RuntimeException(ex);
            } catch (NoSuchMethodException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());
        return repository.saveAll(toEntityList).stream().map(this::toDto).collect(Collectors.toList());
    }


    public void delete(P id){
        repository.deleteById(id);
    }

    private D toDto(T value)  {
        D dto = null;
        try {
            dto = getDtoClass().getDeclaredConstructor(value.getClass()).newInstance(value);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }




}
