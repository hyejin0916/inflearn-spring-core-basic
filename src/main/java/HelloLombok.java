import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
// getter, setter 등을 롬복이 자동으로 만들어줌
// 생성자 관련된 것들도 롬복이 지원
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asas");

        String name = helloLombok.getName();
        System.out.println("name = " + name);

        System.out.println("helloLombok = " + helloLombok);
    }
}
