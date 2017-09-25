package com.zhousz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  
  @RequestMapping(value = "/index")
  public String toIndex(){
    return "index";
  }
  
  @RequestMapping(value = "/login")
  public String toLogin(){
    return "login";
  }

  @RequestMapping(value = "/tvadio")
  public String toTvadio(){
    return "tvadio";
  }
  
  
  
}
