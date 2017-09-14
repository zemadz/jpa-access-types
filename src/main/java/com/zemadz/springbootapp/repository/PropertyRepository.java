package com.zemadz.springbootapp.repository;

import com.zemadz.springbootapp.domain.Property;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public List<Property> getProperties() {
    return entityManager
      .createQuery("SELECT p FROM Property p", Property.class)
      .getResultList();
  }

  public long getPropertyCount() {
    return (long) entityManager.createQuery("SELECT COUNT(p) FROM Property p")
      .getSingleResult();
  }

  public Property save(Property property) {
    entityManager.persist(property);
    return property;
  }

}
