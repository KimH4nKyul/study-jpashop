package jpabook.jpashop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="delivery_id") // 연관관계에서 주인 테이블에 FK에 대한 조인
    private Delivery delivery;
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;         // order or cancel
}
