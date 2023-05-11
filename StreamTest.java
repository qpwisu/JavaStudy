import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        // 스트림 생성
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("one","two","three","4","5","6"));
        Stream<String> stringStream = arrayList.stream();

        // 병렬처리
        Stream<String> stringStream2 = arrayList.parallelStream();

        //iterator로 생성
        Stream<Integer> iteratedStream =
                Stream.iterate(0, n -> n + 2).limit(5); //[0,2,4,6,8]

        // 기본 타입 스트림
        IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]

        // 중간 연산 filter랑  최종 연산 foreach
        stringStream.filter(name->name.contains("o")).forEach(System.out::println);

    }
}
