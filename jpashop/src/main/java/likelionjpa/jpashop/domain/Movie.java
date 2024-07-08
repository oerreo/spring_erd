package likelionjpa.jpashop.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
//하위 클래스에 선언(서브타입)
//엔티티를 저장할 때 슈퍼타입의 구분 컬럼에 저장할 값을 지정. 어노테이션을 선언하지 않을 경우 기본값으로 클래스 이름이 들어간다?
@DiscriminatorValue("Movie")
@Getter @Setter
public class Movie extends Item {
    private String director;
    private String actor;
}