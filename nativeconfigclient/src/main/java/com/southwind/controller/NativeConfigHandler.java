package com.southwind.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/native")
public class NativeConfigHandler {

    @Value("${server.port}")
    private String port;

    @Value("${foo}")
    private String foo;

    @GetMapping("/index")
    public String index(){
        return this.port+"-"+this.foo;
    }

    @GetMapping("/")
    public String indexs(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/index");
        return null;
    }

    @GetMapping("/i")
    public ModelAndView i(ModelAndView modelAndView)  {
        modelAndView.setViewName("/index");
        return modelAndView;
    }
}
