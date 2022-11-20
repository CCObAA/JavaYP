package com.example.calcjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String GetCal(Model model,
                       @RequestParam(value = "firstNumber",required = false, defaultValue = "1") int firstNumber,
                       @RequestParam(value = "secondNumber", required = false, defaultValue = "1") int secondNumber,
                       @RequestParam(value="sign",required = false, defaultValue = "+")String sign){
        model.addAttribute("result", method(firstNumber,secondNumber,sign));
        return ("home");
    }
    @PostMapping("/")
    public String PostCal(Model model,
                           @RequestParam(value = "firstNumber", required = false, defaultValue = "1") int firstNumber,
                           @RequestParam(value = "secondNumber", required = false, defaultValue = "1") int secondNumber,
                           @RequestParam(value="sign", required = false, defaultValue = "+")  String sign){
        model.addAttribute("result", method(firstNumber,secondNumber,sign));
        return ("home");
    }

    private int method(int firstNumber, int secondNumber, String sign){
        int result = 0;
        switch (sign){
            case  "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> result = firstNumber / secondNumber;
        }
        return result;
    }
}
