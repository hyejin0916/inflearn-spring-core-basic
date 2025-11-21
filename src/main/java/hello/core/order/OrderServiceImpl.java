package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // private final: 외부에서 바꿀 수 없고, 객체 생성 시 반드시 값이 들어가야 하는 안전한 필드
    // final: 한 번 값이 할당되면 변경 불가(생성자에서 반드시 초기화해야 하고, 그 뒤에는 바뀌지 않음)

    @Autowired // 생성자가 1개이면 @Autowired 생략 가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    // 생성자: 이 클래스의 객체를 만들 때 필요한 값을 넣어주고 초기 설정을 하는 특별한 메서드
    // 생성자 주입: 생성자를 통해 의존성을 넣어주는 방식
    // this: 현재 객체 필드를 가리키는 키워드, 파라미터 이름과 충돌할 때 필요

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 싱글톤 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
