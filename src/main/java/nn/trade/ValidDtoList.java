package nn.trade;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ValidDtoList<T> {

    @Valid
    private List<T> dtoList;

    public ValidDtoList() {
        this.dtoList = new ArrayList<>();
    }
}
