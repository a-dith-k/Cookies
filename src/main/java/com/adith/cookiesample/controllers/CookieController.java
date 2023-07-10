package com.adith.cookiesample.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie")
public class CookieController {



    final Integer COOKIE_AGE_IN_SECONDS=360;

    @PostMapping("/create")
    public String createCookie(HttpServletResponse response){

        Cookie cookie= new Cookie("Auth","SecretKey");
        response.addCookie(cookie);
        cookie.setMaxAge(COOKIE_AGE_IN_SECONDS);
        return "COOKIE CREATED";

    }

    @PostMapping("/delete")
    public String deleteCookie(HttpServletResponse response){

        Cookie cookie=new Cookie("Auth","");
        response.addCookie(cookie);
        cookie.setMaxAge(0);

        return "COOKIE DELETED";
    }
}
