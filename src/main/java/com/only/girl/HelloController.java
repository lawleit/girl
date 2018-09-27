package com.only.girl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Resource
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return cupSize+age+"==>"+content+"" +
                "<br>" +
                girlProperties.getCupSize()+girlProperties.getAge();
    }


    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String forwardPage(){
        return "index";
    }
}

