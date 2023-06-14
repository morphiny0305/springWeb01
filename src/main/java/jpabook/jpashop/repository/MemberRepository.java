package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext /** JPA 표준 어노테이션, EntityManager를 주입할 수 있음 **/
    private EntityManager em;
    public void save(Member member) {
        em.persist(member); /** JPA가 회원을 저장하는 로직 **/
    }
    public Member find(Long id) {
        return em.find(Member.class, id);
        /** JPA가 제공하는 find()메소드 **/
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
        /** JPQL : "select m from Member m", SQL이랑 다름
         * Member에 대한 별칭 m을 써야함 **/
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
