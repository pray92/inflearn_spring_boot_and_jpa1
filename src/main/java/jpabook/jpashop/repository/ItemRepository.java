package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        if(item.getId() == null){
            em.persist(item);
        } else{
            // 준영속 엔티티 -> 영속 엔티티
            // 모든 데이터를 바꿔침
            // Mechanism
            // 1. 파라미터로 넘어온 준영속 엔티티의 식별자 값으로 1차 캐시에서 엔티티 조회
            // 1-1. 만약 1차 캐시에 엔티티가 없으면 데이터베이스에서 엔티티 조회, 1차 캐시에 저장
            // 2. 조회한 영속 엔티티에 준영속 엔티티 값을 채워 넣음
            // (준영속 엔티티의 모든 값을 영속 엔티티에 밀어 넣음)
            // 3. 영속 상태 엔티티를 반환
            // (준영속 엔티티가 '아니다'. 값만 밀어 넣는 용도이기 때문.
            // 후 처리를 원하면 merge에서 반환하는 엔티티를 사용)
            em.merge(item);
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
