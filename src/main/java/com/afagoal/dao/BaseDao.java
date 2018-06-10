package com.afagoal.dao;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by BaoCai on 17/10/21.
 * Description:
 */
public abstract class BaseDao<Entity, QEntity extends EntityPathBase<Entity>> {

    @PersistenceContext(unitName = "dashboardEntityManagerFactory")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected QEntity QEntity;

    public QEntity getQEntity() {
        return QEntity;
    }

    public void setQEntity(QEntity QEntity) {
        this.QEntity = QEntity;
    }

    public Entity save(Entity entity) {
        if (entityManager.contains(entity)) {
            return entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
            return entity;
        }
    }

    public Collection<Entity> save(Collection<Entity> entities) {
        entities.forEach(this::save);
        return entities;
    }

    public Entity remove(Entity entity) {
        entityManager.remove(entity);
        return entity;
    }

    public Collection<Entity> remove(Collection<Entity> entities) {
        entities.forEach(this::remove);
        return entities;
    }

    public Entity merge(Entity entity) {
        return entityManager.merge(entity);
    }

    public Collection<Entity> merge(Collection<Entity> entities) {
        entities.forEach(this::merge);
        return entities;
    }

    protected List<BooleanExpression> rectifyExpressions(List<BooleanExpression> expressions) {
        if (expressions == null) {
            expressions = new ArrayList<>();
        } else {
            expressions = new ArrayList<>(expressions);
        }

        return expressions;
    }

    public List<Entity> getEntities(List<BooleanExpression> expressions, List<OrderSpecifier> orders, Pageable pageable) {
        expressions = this.rectifyExpressions(expressions);

        JPAQuery<Entity> query = new JPAQuery<>(entityManager);

        query.select(QEntity)
                .from(QEntity)
                .where(expressions.toArray(new BooleanExpression[expressions.size()]));

        if (!CollectionUtils.isEmpty(orders)) {
            query.orderBy(orders.toArray(new OrderSpecifier[orders.size()]));
        }

        if (pageable != null) {
            query.offset(pageable.getOffset()).limit(pageable.getPageSize());
        }


        return query.fetch();
    }

    public List<Entity> getEntities(List<BooleanExpression> expressions, Pageable pageable) {
        return this.getEntities(expressions, null, pageable);
    }

    public Entity getEntity(List<BooleanExpression> expressions) {
        Pageable pageable = new PageRequest(0, 1);
        List<Entity> ecs = this.getEntities(expressions, pageable);
        if (CollectionUtils.isEmpty(ecs)) {
            return null;
        }

        return ecs.get(0);
    }

    public long getCount(List<BooleanExpression> expressions) {
        expressions = this.rectifyExpressions(expressions);

        JPAQuery<Long> query = new JPAQuery<>(entityManager);

        query.select(QEntity.count())
                .from(QEntity)
                .where(expressions.toArray(new BooleanExpression[expressions.size()]));

        return query.fetchFirst();
    }



}
