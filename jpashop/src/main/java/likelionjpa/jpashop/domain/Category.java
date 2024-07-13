package likelionjpa.jpashop.domain;

import jakarta.persistence.*;
import likelionjpa.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "categories")
@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;

    //item에 대해 다대다 매핑 ->JoinTable?
    @ManyToMany
    @JoinTable(name = "category_items",
                //중간 테이블을 만들어주지 않고 jointable 어노테이션을 통해 다대다 관계를 일대다,다대일로 풀어줌
                joinColumns = @JoinColumn(name = "category_id"),
                inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    //동일한 엔티티에 대해 self로 연관관계 생성(매핑) ->상속
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //연관관계 편의 메서드
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }

}
