import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        // null 값 넣기
        Optional<String> optional = Optional.empty();

        System.out.println(optional); // Optional.empty
        System.out.println(optional.isPresent()); // false

        // Optional의 value는 절대 null이 아니다. null이면 npe 뜸
        Optional<String> optional2 = Optional.of("MyName");

        // Optional의 value는 값이 있을 수도 있고 null 일 수도 있다.
        Optional<String> optional3 = Optional.ofNullable(null);
        String name = optional.orElse("anonymous"); // 값이 없다면 "anonymous" 를 리턴
        System.out.println(name);
        // null인지 아닌지 확인
        if (optional3.isPresent()){
            System.out.println("null 아님");
        }
        else{
            System.out.println("null임");
        }
        // null이 아니면 실행
        optional3.ifPresent(n -> {System.out.println(n);});
    }
}
