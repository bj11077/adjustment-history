package nn.trade;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@RequiredArgsConstructor
public abstract class CommonService<T,P> {

    protected final JpaRepository<T,P> repository;


    public List<T> findAll(){
        return repository.findAll();
    }

    public T findById(P id){
        return repository.findById(id).orElseThrow();
    }






}
