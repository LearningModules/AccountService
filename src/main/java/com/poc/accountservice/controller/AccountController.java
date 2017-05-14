package com.poc.accountservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by z001nlh on 5/14/17.
 */
@RestController()
public class AccountController {
    @RequestMapping( path = "/")
    public String welcomeMessage()
    {
        return "server is working";
    }

}
