package com.delight.studySpring.order.repository;

import com.delight.studySpring.order.dto.OrderItemQueryDto;
import com.delight.studySpring.order.dto.OrderQueryDto;
import com.delight.studySpring.order.dto.OrderSampleQueryDto;
import com.delight.studySpring.order.entity.Order;
import com.delight.studySpring.order.dto.OrderSearchDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager entityManager;

    public void save(Order order) {
        entityManager.persist(order);
    }

    public Order findOne(Long id) {
        return entityManager.find(Order.class, id);
    }

    public List<Order> findAll() {
        return entityManager.createQuery("select o from Order o", Order.class)
                .getResultList();
    }

    public List<Order> findAllWithItem() {
        // fix Query dsl
        return entityManager.createQuery(
                        "select distinct o from Order o " +
                                "join fetch o.member m " +
                                "join fetch o.delivery d " +
                                "join fetch o.orderItems oi " +
                                "join fetch oi.item i", Order.class)
                .setFirstResult(1)
                .setMaxResults(100)
                .getResultList();
    }

    /**
     * fetch join으로 필요한 데이터 한 번에 가져오기
     * LAZY 무시하고 진짜 객체에 값을 채워서 반환한다.
     * LAZY + 페치 조인으로 거의 대부분의 성능 문제를 해결할 수 있음
     */
    public List<Order> findAllWithMemberDelivery() {
        return entityManager.createQuery(
                        "select o from Order o " +
                                "left join fetch o.member m " +
                                "left join fetch o.delivery d", Order.class)
                .getResultList();
    }

    /**
     * ToOne(OneToOne, ManyToOne) 관계를 모두 페치 조인으로 가져온다.
     * ToOne 관계는 row 를 증가시키지 않기 때문에 페이징 쿼리에 영향을 주지 않는다.
     */
    public List<Order> findAllWithMemberDelivery(int offset, int limit) {
        return entityManager.createQuery(
                        "select o from Order o " +
                                "join fetch o.member m " +
                                "join fetch o.delivery d", Order.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }


    public List<Order> findAllByString(OrderSearchDto orderSearchDto) {
        String jpql = "select o From Order o join o.member m";
        boolean isFirstCondition = true;

        //주문 상태 검색
        if (orderSearchDto.getOrderStatus() != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " o.status = :status";
        }

        //회원 이름 검색
        if (StringUtils.hasText(orderSearchDto.getMemberName())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class).setMaxResults(1000); //최대 1000건
        if (orderSearchDto.getOrderStatus() != null) {
            query = query.setParameter("status", orderSearchDto.getOrderStatus());
        }
        if (StringUtils.hasText(orderSearchDto.getMemberName())) {
            query = query.setParameter("name", orderSearchDto.getMemberName());
        }
        return query.getResultList();
    }

    public List<OrderSampleQueryDto> findOrderDtoList() {
        return entityManager.createQuery("select OrderSimpleQueryDto" +
                "(o.id, m.name, o.orderDate, o.status, d.address) " +
                "from Order o " +
                "join o.member m " +
                "join o.delivery d", OrderSampleQueryDto.class).getResultList();
    }


    public List<OrderQueryDto> findOrderQueryDtoList() {
        List<OrderQueryDto> result = findOrders();
        result.forEach(o -> {
            List<OrderItemQueryDto> orderItems = findOrderItems(o.getOrderId());
            o.setOrderItems(orderItems);
        });

        return result;
    }

    private List<OrderItemQueryDto> findOrderItems(Long id) {
        return entityManager.createQuery("select OrderItemQueryDto" +
                        "(oi.order.id, oi.item.name, oi.orderPrice, oi.count)" +
                        "from OrderItem oi " +
                        "join oi.item i " +
                        "where oi.order.id =: id", OrderItemQueryDto.class)
                .setParameter("id", id)
                .getResultList();
    }

    private List<OrderQueryDto> findOrders() {
        return entityManager.createQuery("select OrderQueryDto" +
                        "(o.id, m.name, o.orderDate, o.status, d.address)" +
                        "from Order o " +
                        "join o.member m " +
                        "join o.delivery d ", OrderQueryDto.class)
                .getResultList();
    }
}
