package com.zemadz.springbootapp.repository;

import com.zemadz.springbootapp.domain.RelatedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RelatedPropertyRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public RelatedProperty save(RelatedProperty relatedProperty) {
    entityManager.persist(relatedProperty);
    return relatedProperty;
  }

}
