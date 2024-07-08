package likelionjpa.jpashop.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

//데이터베이스와 상호작용하는 레포지토리(저장소)->여기서 CRUD가능
//DB의 엔티티에 접근하여 상호작용 함.(Entity를 통해 테이블이 생성이 되면, 받아온 정보를 DB에 CRUD)
@Repository //데이터 접근 계층임을 나타냄
public class DeliveryRepository {

    //엔티티매니저를 em에 주입해줌.(JPA의 핵심 인터페이스)
    //CRUD 작업, 쿼리 실행 등의 DB작업을 수행해줌.(+트랜잭션 관리, 영속성 컨텍스트 관리)
    @PersistenceContext
    private EntityManager em;

    //새로운 Delivery를 DB에 저장
    public Long save(Delivery delivery){
        em.persist(delivery);
        return delivery.getId();
    }

    //Delivery 조회
    public Delivery find(Long id){
        return em.find(Delivery.class,id);
    }
}
