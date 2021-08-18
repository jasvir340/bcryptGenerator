package com.topnotch.bcryptGenerator.controller;

import com.topnotch.bcryptGenerator.model.BCryptObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BCryptController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String encryptString(@RequestParam(value = "encryptString", required = false) String encryptString,Model model) {

        String encryptedString = null;

        if (encryptString != null && !encryptString.isEmpty()) {
            encryptedString = passwordEncoder.encode(encryptString);

            System.out.println(encryptedString);

            model.addAttribute("encryptedString", encryptedString);
        }

        model.addAttribute("bCryptObject", new BCryptObject());

        return "welcome.html";
    }

    @PostMapping("/")
    public String testString(@ModelAttribute("bCryptObject") BCryptObject bCryptObject, Model model){

        if(bCryptObject != null){
            if(bCryptObject.isEqual(passwordEncoder)){
                model.addAttribute("match","yes");
            }else{
                model.addAttribute("match","no");
            }
        }else{
            model.addAttribute("bCryptObject", new BCryptObject());
        }

        return "welcome.html";
    }
}
