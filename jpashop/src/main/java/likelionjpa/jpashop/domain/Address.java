package likelionjpa.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

//속성들에 관하여 추상화시키고 싶고 그러한사항에 대하여 새로운테이블로 정의하고 싶지 않을때 사용
@Embeddable  //얘 쓰면 Setter 안 써도 됨.
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
