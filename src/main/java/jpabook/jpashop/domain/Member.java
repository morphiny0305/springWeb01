package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    /** mappedBy = "member" : 오더테이블에 있는 멤버 필드에 의해 맵핑이 됨을 선언 = 읽기전용) / 오더 테이블하고 n:1관계 설정 - 오더테이블이 n **/
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    private String username;


}
