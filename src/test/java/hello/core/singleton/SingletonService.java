package hello.core.singleton;

// 프로젝트에 영향을 주지않기위해 test에 만듦
public class SingletonService {

    // 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();
    // 자기자신을 내부의 private으로 하나 가짐
    // static으로 가지고 있음 -> 클래스 레벨에 올라가기 때문에 하나만 존재하게 됨
    // 자바가 뜰 때 바로 생성돼서 올라감

    // 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService () {
        // private은 자기 자신을 호출할 수 있음
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
