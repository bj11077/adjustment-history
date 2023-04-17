package nn.trade;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;



@RequiredArgsConstructor
public abstract class CommonService<ENT extends BaseEntity,REQ extends BaseDto,RES extends BaseDto> {

    protected final JpaRepository<ENT,Long> repository;

    protected final EntityManager em;

    public abstract Class<REQ> getRequestDtoClass();

    public abstract Class<RES> getResponseDtoClass();


    public List<RES> findAll(){
        List<ENT> result = repository.findAll();
        return result.stream().map(this::toDto).collect(Collectors.toList());
    }

    public RES findById(Long id){
        return toDto(repository.findById(id).orElseThrow());
    }

    @Transactional
    public RES save(REQ dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object toEntity = getRequestDtoClass().getMethod("toEntity").invoke(dto);
        System.out.println(toEntity.toString());
        ENT save = repository.saveAndFlush((ENT) toEntity);
        em.refresh(save);
        return toDto(save);
    }

    @Transactional
    public List<RES> saveAll(List<REQ> dtoList){
        List<ENT> toEntityList = dtoList.stream().map(e -> {
            try {
                return  (ENT)getRequestDtoClass().getMethod("toEntity").invoke(e);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            } catch (InvocationTargetException ex) {
                throw new RuntimeException(ex);
            } catch (NoSuchMethodException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());
        List<ENT> result = repository.saveAllAndFlush(toEntityList);
        result.forEach(em::refresh);
        return repository.saveAll(toEntityList).stream().map(this::toDto).collect(Collectors.toList());
    }


    public void delete(Long id){
        repository.deleteById(id);
    }

    private RES toDto(ENT value)  {
        RES dto = null;
        try {
            dto = getResponseDtoClass().getDeclaredConstructor(value.getClass()).newInstance(value);
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