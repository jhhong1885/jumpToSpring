package com.mywork.boot.user.controller;

import com.mywork.boot.user.dto.UserCreateForm;
import com.mywork.boot.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signUp(UserCreateForm userCreateRequest){
        return "signup_form";
    }

    @PostMapping("/signup")
    public String SignUp(@Valid UserCreateForm userCreateRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup_form";
        }

        if(!userCreateRequest.getPassword1().equals(userCreateRequest.getPassword2())){
            bindingResult.rejectValue(
                    "password2",
                    "passwordInCorrect",
                    "비밀번호가 일치하지 않습니다."
            );

            return "signup_form";
        }

        try {
            userService.create(
                    userCreateRequest.getUsername(),
                    userCreateRequest.getPassword1(),
                    userCreateRequest.getEmail()
            );
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        }catch (Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        return "redirect:/question/list";
    }


    @GetMapping("/login")
    public String login(){
        return "login_form";
    }

}
