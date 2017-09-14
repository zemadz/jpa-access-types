package com.zemadz.springbootapp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Property {

  private Long id;

  private String name;

  private RelatedProperty relatedProperty;

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "related_property_id")
  public RelatedProperty getRelatedProperty() {
    return relatedProperty;
  }

  public void setRelatedProperty(RelatedProperty relatedProperty) {
    this.relatedProperty = relatedProperty;
  }

}
