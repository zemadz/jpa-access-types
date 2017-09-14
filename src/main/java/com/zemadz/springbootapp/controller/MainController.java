package com.zemadz.springbootapp.controller;

import com.zemadz.springbootapp.model.AllData;
import com.zemadz.springbootapp.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  private final DataService dataService;

  @Autowired
  public MainController(DataService dataService) {
    this.dataService = dataService;
  }

  @RequestMapping(value = "/")
  @ResponseBody
  AllData index() {
    return dataService.getAllData();
  }

}
