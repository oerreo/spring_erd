package likelionjpa.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;

    @Embedded //속성들에 관하여 추상화시키고 싶고 그러한사항에 대하여 새로운테이블로 정의하고 싶지 않을때 사용
    private Address address;

    //현재 테이블 기준 일대다로 매핑
    @OneToMany(mappedBy = "member") //CasCade되지 않고 read전용의 JoinMapping이 형성된다.
    private List<Order> orders = new ArrayList<>();
}
