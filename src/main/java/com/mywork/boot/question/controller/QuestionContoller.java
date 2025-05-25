package com.mywork.boot.question.controller;

import com.mywork.boot.question.service.QuestionService;
import org.springframework.ui.Model;
import com.mywork.boot.question.dto.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionContoller {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model){
        List<Question> questionList = this.questionService.getQuestionList();
        model.addAttribute("questionList", questionList);

        return "question/list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Optional<Question> list = this.questionService.getQuestionDetail(id);
        list.ifPresent(question -> model.addAttribute("question", question));

        return "question/detail";
    }
}
