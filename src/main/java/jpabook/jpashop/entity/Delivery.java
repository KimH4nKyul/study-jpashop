package jpabook.jpashop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class  Delivery {
    @Id
    @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery") // 연관관계에서 종속 테이블이 매핑
    private Order order;

    @Embedded
    private Address address;

//    @Enumerated(EnumType.ORDINAL) // 값이 숫자로 들어감. 주의, 중간에 새로운 상태 값이 추가되면 값이 밀림.
    @Enumerated(EnumType.STRING) // ORDINAL은 새로운 값이 있을 때 값이 밀리기 때문에, STRING으로 값의 안정성을 추구함.
    private DeliveryStatus status; // ready or comp
}
