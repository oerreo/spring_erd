package likelionjpa.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity  //DB의 테이블과 1대1 맵핑됨.
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    //
    @Embedded  //속성들에 관하여 추상화시키고 싶고 그러한사항에 대하여 새로운테이블로 정의하고 싶지 않을때 사용
    private Address address;

    private DeliveryStatus status;
}
