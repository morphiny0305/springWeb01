package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne /** 멤버 테이블하고 n:1관계 설정 _ 오더테이블이 n **/
    @JoinColumn(name = "member_id")    /** 외래키 설정 - 멤버 테이블의 member_id가 외래키 **/
    private Member member;

    private List<OrderItem> orderItems = new ArrayList<>();

    private Delivery delivery;

    private LocalDateTime orderDate; /** 주문시간 **/

    private OrderStatus status; /** 주문 상태 [ORDER, CANCEL] **/


}
