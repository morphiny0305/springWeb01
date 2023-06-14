package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;
    
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item; /** 주문상품 **/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id") /** 하나의 오더가 여러개의 오더 아이템을 가질 수 있으므로 **/
    private Order order; /** 주문 **/

    private int orderPrice; /** 주문가격 **/
    private int count; /** 주문 수량 **/
}
