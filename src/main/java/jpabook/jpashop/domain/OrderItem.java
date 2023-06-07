package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id") /** 하나의 오더가 여러개의 오더 아이템을 가질 수 있으므로 **/
    private Order order;

    private int orderPrice; /** 주문가격 **/
    private int count; /** 주문 수량 **/
}
