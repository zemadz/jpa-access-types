package com.zemadz.springbootapp.repository;

import com.zemadz.springbootapp.domain.RelatedField;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RelatedFieldRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public RelatedField save(RelatedField relatedField) {
    entityManager.persist(relatedField);
    return relatedField;
  }

}
