package likelionjpa.jpashop.domain;

import jakarta.persistence.*;
import likelionjpa.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name="orderitem_id")
    private Long id;

    //현재 테이블 기준 다대일로 매핑
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_id")
    //Item은 추상 클래스라 객체는 못 만듦 = new로 인스턴스를 만들지는 못하지만 선언은 가능?
    private Item item;

    //현재 테이블 기준 다대일로 매핑
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    private int orderPrice;

    private int count;
}
