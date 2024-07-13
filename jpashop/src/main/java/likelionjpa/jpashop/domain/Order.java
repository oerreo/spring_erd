package likelionjpa.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="orders")
@Entity  //DB의 테이블과 1대1 맵핑됨.
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    //FK매핑
    @ManyToOne(fetch=FetchType.LAZY)
    //Join 할 Column 지정(매핑할 FK)
    //Member테이블의 member_id을 참조하여 가져옴
    @JoinColumn(name = "member_id")
    private Member member;

    //현재 테이블 기준 일대다로 매핑
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL) //CasCade되지 않고 read전용의 JoinMapping이 형성된다.
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    private OrderStatus status;

    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
