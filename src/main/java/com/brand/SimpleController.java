package com.brand;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test" )
public class SimpleController {
	  @RequestMapping(value = "hello", method = RequestMethod.GET)
      @ResponseBody
      public Map<String, Object> helloWorld(@RequestParam (value="user", required=false,
      defaultValue="World") String userName) {
		  Map<String, Object> map = new HashMap<String, Object>();
		  map.put("Hello", userName);
             return map;
     }
}
