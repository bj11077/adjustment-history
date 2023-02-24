package nn.ex;


import java.util.Optional;

public class Test {


    public static void main(String[] args) {
        Optional<String> nullValue = Optional.ofNullable(null);
        System.out.println(nullValue.orElse("dee"));
    }
}
