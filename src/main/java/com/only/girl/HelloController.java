package com.only.girl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/greet")
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Resource
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
        return cupSize+age+"==>"+content+"" +
                "<br>" +
                girlProperties.getCupSize()+girlProperties.getAge();
    }


    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String forwardPage(){
        return "index";
    }

    @RequestMapping(value = "/{id}/demo",method = RequestMethod.GET)
    public String demo(@PathVariable("id") Integer t){
        return "id = "+t;
    }

    @GetMapping("/demo")
    public String demoParam(@RequestParam(value = "param",required = false,defaultValue = "我不爱你") String p){
        return "param = "+p;
    }
}

