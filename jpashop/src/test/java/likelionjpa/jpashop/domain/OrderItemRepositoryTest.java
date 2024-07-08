package likelionjpa.jpashop.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)  //Spring 테스트 컨텍스트를 사용하여 테스트를 실행
@SpringBootTest   //Spring Boot 애플리케이션 컨텍스트를 로드하여 통합 테스트를 실행
public class OrderItemRepositoryTest {
    @Autowired  //스프링 컨텍스트에서 OrderItemRepository을 주입
    OrderItemRepository orderItemRepository;

    @Test  //JUnit 프레임워크에서 테스트 메서드를 표시
    @Rollback(false) // Transaction으로 인한 테이블 리셋 방지  //테스트가 끝난 후에도 데이터베이스의 변경 사항을 롤백하지 않도록 설정
    @Transactional  // 메서드를 트랜잭션 범위에서 실행
    public void testOrderItem() throws Exception{
        //given
        OrderItem orderItem = new OrderItem();

        //when
        Long savedId = orderItemRepository.save(orderItem);
        OrderItem findOrderItem = orderItemRepository.find(savedId);

        //Assertions -> 테스트 결과를 검증
        //then
        Assertions.assertThat(findOrderItem.getId()).isEqualTo(orderItem.getId());

        Assertions.assertThat(findOrderItem).isEqualTo(orderItem);
        //영속성 컨텍스트에서 엔티티가 관리되고 있다. ID가 같으면 같은 놈으로 인식
        System.out.println("equals?" + (findOrderItem == orderItem));
    }
}