package com.theoremsoft.foodiecloud;



import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class) // test to run in teh context of a spring mvc application arranges for homecontroller to be registred in spring mvc to throw request against it. it coild could be made to start a server mocking the mechanics of spring mvc - the text class is injected with a mockmvc object for teh test to drive teh mockup. 

public class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;   // <2>

  @Test
  public void testHomePage() throws Exception { // defines the test i want to perform agains thte home page. it also starts with the mockmvc object to perform an http get request for / teh rooth paty form that request it sets the follwing expections 


    /*

    from the request path this sets the following expectations 

    1. the response should have an http 200 ok status 
    2. the view should have a logical name of home. 
    3. the rendered view should contain the next 'welcome to...'

    */
    mockMvc.perform(get("/"))    // <3>
    
      .andExpect(status().isOk())  // <4>
      
      .andExpect(view().name("home"))  // <5>
      
      .andExpect(content().string(           // <6>
          containsString("Welcome to...")));  
  }

}
