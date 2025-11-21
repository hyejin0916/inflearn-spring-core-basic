package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core", // 탐색 시작 위치 지정
//        basePackageClasses = AutoAppConfig.class, // AutoAppConfig가 존재하는 package인 hello.core로 지정됨
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 스프링 빈 등록에서 제외할 것들을 지정
        // Configuration을 제외하는 이유: AppConfig에서 @Configuration이 붙어있기 때문에 충돌이 일어나는 것을 방지하기 위해
        // @Configuration 내부에는 @Component도 포함되어있어 @ComponentScan에 걸림
        // 실무에서는 보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지 않음 -> 현재 예제를 살려두기위해 임의로 선택한 방식
)
// @ComponentScan은 @Component가 붙은 클래스를 찾아서 모두 자동으로 스프링 빈으로 등록해줌
public class AutoAppConfig {
}
