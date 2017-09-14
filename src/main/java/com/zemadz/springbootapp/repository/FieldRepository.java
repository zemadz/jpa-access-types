package com.zemadz.springbootapp.repository;

import com.zemadz.springbootapp.domain.Field;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FieldRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public List<Field> getFields() {
    return entityManager
      .createQuery("SELECT f FROM Field f", Field.class)
      .getResultList();
  }

  public long getFieldCount() {
    return (long) entityManager.createQuery("SELECT COUNT(f) FROM Field f")
      .getSingleResult();
  }

  public Field save(Field field) {
    entityManager.persist(field);
    return field;
  }

}
