package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // 스프링 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig에 있는 환경 설정 정보를 가지고 스프링이 @Bean이라 적힌 메서드들을 스프링 컨테이너에 넣어서 관리해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // 첫번째: 찾을 메서드명, 두번째: 타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
