import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTest {
    public static void main(String[] args) {
        // 배열 - 추가 삭제 불가 오직 read
        String[] array = new String[0];
        String[] array2 = {"sd","dsa"};
        System.out.println(array2[0]);
        // 컬렉션 ArrayList
        ArrayList<String> al = new ArrayList<>();
        // String[] arraylist로 변환
        al.addAll(Arrays.asList(array));

        ArrayList<String> al2 = new ArrayList<>(10);
        ArrayList<String> al3 = new ArrayList<>(Arrays.asList("sds","sd"));
        al3.add(0,"sa");

        al3.add("sa2");
        al3.set(0,"asdda");
        al3.remove(0);
        al3.remove("as");
        System.out.println(al3.contains("as"));
        System.out.println(al3.indexOf("as"));
        System.out.println(al3.get(0));
        al3.clear();
    }
}
