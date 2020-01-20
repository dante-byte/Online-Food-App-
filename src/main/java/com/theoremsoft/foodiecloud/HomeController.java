package com.theoremsoft.foodiecloud;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller            // <1> identifies this class asa a compnet form component scannng
public class HomeController { // spring componet scanning automatically discovers it and creates an instance of homecontroller as a bean in teh spring application context. 

  @GetMapping("/")     // <2>
  public String home() {
    return "home";     // <3>
  }

}

