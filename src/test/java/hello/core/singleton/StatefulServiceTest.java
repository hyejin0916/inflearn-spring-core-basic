package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A 사용자 10,000원 주문
        int priceA = statefulService1.order("userA", 10000);
        // ThreadB: B 사용자 20,000원 주문
        int priceB = statefulService2.order("userB", 20000);

        // ThreadA: A 사용자 주문 금액 조회 -> 10,000원을 기대했지만, 기대와 다르게 20,000원 출력
//        int price = statefulService1.getPrice();
        System.out.println("price = " + priceA);

//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}