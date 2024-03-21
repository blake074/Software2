package co.edu.unbosque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
    public Test(){
        test();
    }
    public void test(){
        System.out.println("test");
    }
}
