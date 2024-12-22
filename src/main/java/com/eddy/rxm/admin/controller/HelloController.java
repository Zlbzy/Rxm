package com.eddy.rxm.admin.controller;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.auth.service.LoginService;
import com.eddy.rxm.common.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final LoginService loginService;

    @GetMapping("/hello")
    public String hello(){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encode = passwordEncoder.encode("123");
//        System.out.println(encode);
//
//        return "Hello World!! " + encode;
        return "hello world!";
    }




}
