package com.mywork.boot.qa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JumpController {

    @GetMapping("/jump")
    @ResponseBody
    public String jump(){
        return "jump";
    }
}
