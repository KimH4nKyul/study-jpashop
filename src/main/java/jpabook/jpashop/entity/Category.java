package jpabook.jpashop.entity;

import jpabook.jpashop.entity.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="category_item", joinColumns=@JoinColumn(name="category_id"), inverseJoinColumns = @JoinColumn(name="item_id")) // 다대다 관계에서도 연관관계의 주인이 필요하며, 이를 위해 중간 테이블 매핑을 해줘야 함. 여기선 Category가 주인
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
