package likelionjpa.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "items") //생략 시 클래스 이름으로 테이블명 지정
@Entity  //DB의 테이블과 1대1 맵핑됨.
@Getter @Setter
//관계형 데이터베이스에는 상속 관계가 없고, 슈퍼타입 서브타입이라는 유사관계만 존재
//상속관계를 매핑해줘야함.
//JOINED, SINGLE_TABLE, TABLE_PER_CLASS
// SINGLE_TABLE : 서비스 규모가 크지않고 간단히 구현하고 싶을 때 사용, 한 테이블에 다 저장하고 DTYPE으로 구분
//INSERT, SELECT쿼리가 한 번에 이루어지고 조인이 필요없기에 성능이 좋음. 1개의 테이블만 생성
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//부모 클래스에 선언한다. 하위 클래스를 구분하는 용도의 컬럼이다. 관례는 default = DTYPE
@DiscriminatorColumn(name = "dtype")
public abstract class Item {
    //Id값으로 지정하고(PK) 자동으로 값이 정해지도록(1씩 증가)
    @Id @GeneratedValue
    //해당 멤버 변수와 테이블의 컬럼 매핑-생략 시 컬럼명 = 필드명
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    //현재 테이블 기준 일대다로 매핑
    @OneToMany(mappedBy = "item") //CasCade되지 않고 read전용의 JoinMapping이 형성된다.
    private List<OrderItem> orderItems = new ArrayList<>();

    //item에 대해 다대다 매핑 ->JoinTable?
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="order_id")
    private Order order;
}
