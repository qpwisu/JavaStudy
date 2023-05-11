class Name{
    static int aaa = 10;
    static void print() { //클래스 메소드
        System.out.println("내 이름은 홍길동입니다.");
    }
    void print2() { //인스턴스 메소드
        System.out.println("내 이름은 이순신입니다.");
    }
}
public class StaticTest {
    public static void main(String[] args) {
        Name.print(); //인스턴스를 생성하지 않아도 호출이 가능
        Name name = new Name(); //인스턴스 생성
        name.aaa++;
        System.out.println(name.aaa);
        System.out.println(Name.aaa);
        name.print2(); //인스턴스를 생성하여야만 호출이 가능
    }
}