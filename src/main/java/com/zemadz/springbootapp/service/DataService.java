package com.zemadz.springbootapp.service;

import com.zemadz.springbootapp.domain.Field;
import com.zemadz.springbootapp.domain.Property;
import com.zemadz.springbootapp.domain.RelatedField;
import com.zemadz.springbootapp.domain.RelatedProperty;
import com.zemadz.springbootapp.model.AllData;
import com.zemadz.springbootapp.repository.FieldRepository;
import com.zemadz.springbootapp.repository.PropertyRepository;
import com.zemadz.springbootapp.repository.RelatedFieldRepository;
import com.zemadz.springbootapp.repository.RelatedPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataService {

  private final FieldRepository fieldRepository;
  private final RelatedFieldRepository relatedFieldRepository;
  private final PropertyRepository propertyRepository;
  private final RelatedPropertyRepository relatedPropertyRepository;

  @Autowired
  public DataService(
    FieldRepository fieldRepository,
    RelatedFieldRepository relatedFieldRepository,
    PropertyRepository propertyRepository,
    RelatedPropertyRepository relatedPropertyRepository
  ) {
    this.fieldRepository = fieldRepository;
    this.relatedFieldRepository = relatedFieldRepository;
    this.propertyRepository = propertyRepository;
    this.relatedPropertyRepository = relatedPropertyRepository;
  }

  @Transactional
  public AllData getAllData() {
    initializeDataIfNecessary();

    AllData allData = new AllData();
    allData.fields = fieldRepository.getFields();
    allData.properties = propertyRepository.getProperties();
    return allData;
  }

  private void initializeDataIfNecessary() {
    initializePropertyDataIfNecessary();
    initializeFieldDataIfNecessary();
  }

  private void initializeFieldDataIfNecessary() {
    if (fieldRepository.getFieldCount() != 0) {
      return;
    }

    RelatedField relatedField = new RelatedField();
    relatedField.setName("First related field");
    relatedFieldRepository.save(relatedField);

    Field field = new Field();
    field.setName("First field");
    field.setRelatedField(relatedField);
    fieldRepository.save(field);
  }

  private void initializePropertyDataIfNecessary() {
    if (propertyRepository.getPropertyCount() != 0) {
      return;
    }

    RelatedProperty relatedProperty = new RelatedProperty();
    relatedProperty.setName("First related property");
    relatedPropertyRepository.save(relatedProperty);

    Property property = new Property();
    property.setName("First property");
    property.setRelatedProperty(relatedProperty);
    propertyRepository.save(property);
  }

}
