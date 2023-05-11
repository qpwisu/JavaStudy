## 자바  개념 정리

- 컬렉션
    - int[]와 같은 배열과 다르게 가변 배열임 크기가 동적으로 증가가능
    - 데이터를 저장하는 자료 구조와 데이터를 처리하는 알고리즘을 구조화하여 클래스로 구현
    - `ArrayList<String> pitches = **new** **ArrayList**<>();`

    ```java
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
    ```



- static
    - 정적으로 생성되어 인스턴스를 생성하지 않고 사용가능 클래스명.변수명or메서드명
    - static 변수
        - 정적으로 생성되어 싱글톤 패턴을 갖음
    - static 메서드
        - 인스턴스를 생성하지않고 바로 사용가능

- 자바의 자료형
    - 기본 타입(primitive type)과 참조 타입(reference type) 나뉨
    - 기본 타입 : byte, char, short, int, long, float, double, boolean
    - 참조 타입 : class, interface, String
    - String은 참조 타입으로 생성된 null 가능

- wrapper class (래퍼 클래스)
    - 기본 타입 데이터를 객체로 다루기 위해 사용하는 클래스
    - new 사용 가능 기본 타입은 new 사용 불가능
    - 제너릭에 사용, sql 쓸때 용의
    - null을 초기화 가능
        - int a = null; 은 불가능 Integer a = null; 가능
    - 산술 연산 불가능
        - 박싱  - 기본타입 data→ wrapper 클래스 인스턴스
        - 언박싱 - wrapper 클래스 인스턴스 → 기본타입 data
    - **하지만 jdk1.5부터는 박싱,언박싱을 자동으로 해줘서 wrapper도 연산이 가능하고 wrapper과 기본 타입간의 연산도 가능**


        | 기본 타입 | 래퍼 클래스 |
        | --- | --- |
        | byte | Byte |
        | short | Short |
        | int | Integer |
        | long | Long |
        | float | Float |
        | double | Double |
        | char | Character |
        | boolean | Boolean |
    - Optional도 래퍼클래스

- 자바 스트림
    - [https://velog.io/@gmtmoney2357/자바-스트림Stream](https://velog.io/@gmtmoney2357/%EC%9E%90%EB%B0%94-%EC%8A%A4%ED%8A%B8%EB%A6%BCStream)
    - 다양한 데이터 소스(컬렉션, 배열 등)를 **표준화**된 방법으로 다루기 위한 것
        - 그 전까지는 List, Set, Map 등의 사용 방법들이 서로 달랐다.
    - 특징
        1. 데이터를 담고 있는 저장소 (컬렉션)이 아니다.
        2. 스트림은 원본 데이터 소스를 변경하지 않는다.(Read Only)
        3. 스트림은 `lterator`처럼 일회용이다. (필요하면 다시 스트림을 생성해야 함)
        4. 최종 연산 전까지 중간연산을 수행되지 않는다.(lazy)
        5. 무제한일 수도 있다. (Short Circuit 메소드를 사용해서 제한할 수 있다.)
        6. 손쉽게 병렬 처리할 수 있다. (멀티 쓰레드 사용) (`.parallel`)
        7. **기본형** 스트림으로 `IntStream`, `LongStream`, `DoubleStream`등 제공
            - 오토박싱 등의 불필요한 과정이 생략됨.
            - `Stream<Integer>` 대신에 `IntStream`을 사용하는게 더 효율적이다.
            - 뿐만 아니라 숫자의 경우 더 유용한 메서드를 `Stream<T>`보다 더 많이 제공한다.(`.sum()`, `.averge()` 등)
    - 순서
        1. 스트림 만들기
        2. 중간연산(반복 적용 가능, 연산 결과가 스트림)
        3. 최종연산 (스트림의 요소를 소모) -> 결과 리턴
    - 예시

        ```java
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("one","two","three","4","5","6"));
        arrayList.stream()
        		.distinct() //중간연산
            .limit(5) //중간연산
            .sorted() //중간연산
            .forEach(System.out::println) //최종연산
        
        arrayList.stream().filter(name->name.contains("o"))
        .forEach(System.out::println);
        ```

    - filter
        - if문이라고 생각하면 될듯.
        - 람다식의 리턴값은 boolean. true면 다음 단계 진행, false면 버려짐

        ```
        classes.stream()
        	.filter(c->c.getTitle().startWith("spring"))
        	.forEach(c->System.out.println(c.getId));
        
        classes.stream()
        	.filter(Predicate.not(OnlineClass::isClosed))
        	.forEach(c->System.out.println(c.getId));
        ```

        - 예) 이름이 3글자 이상인 데이터만 새로운 스트림으로 변경하기
    - map
        - stream을 우리가 원하는 모양의 새로운 스트림으로 변환
            - 예) 각각의 File에서 String name만 새로운 스트림으로
            - 예) string 타입 요소를 짤라서 새로운 스트림으로

        ```
         map(File::getName)
         map(s->s.subString(3))
        ```

    - limit, skip
    - 예) 최대 5개의 요소가 담긴 스트림을 리턴한다.
    - 예) 앞에서 3개를 뺀 나머지 스트림을 리턴한다.

    ```
    Stream.iterate(10, i->i+1)
    		.skip(10)
            .limit(10)
            .forEach(System.out::println)
    ```

    - collect
        - 스트림을 원하는 자료형으로 변환
        - `.collect(Collectors.*toList*());`
        - `.collect(Collectors.*toSet*());`

- **Optional<T> T에 각종 타입**
    - null이 올 수 있는 값을 감싸는 Wrapper 클래스
    - 값이 null이더라도 바로 NPE(null point exception)가 발생하지 않음

    ```java
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
    ```

- 스트림을 사용할때 ::
    - :: 기준으로 왼쪽 객체의 오른쪽 메소드를 사용한다는 내용이다
    - **`x -> new Dog(x);` 도 위와 같이 `Dog::new` 로 축약**
- 람다 함수
    - (x) → {x+1}