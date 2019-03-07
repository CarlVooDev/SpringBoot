/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.ereservation.vista.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Carl
 */
@Controller
@RequestMapping("app")
public class LoginController {
    
    @GetMapping(value={"/login", "/"})
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        String errorMessage = "Usuario no autorizado, debe autentificarse";
        mav.addObject("errorMsg", errorMessage);
        mav.setViewName("login");
        return mav;
    }
    
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
}
