package com.mywork.boot.question.controller;

import com.mywork.boot.answer.dto.AnswerForm;
import com.mywork.boot.question.dto.QuestionForm;
import com.mywork.boot.question.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import com.mywork.boot.question.dto.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionContoller {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        Page<Question> paging = this.questionService.getPageList(page);
        model.addAttribute("paging", paging);

        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(
            Model model,
            @PathVariable("id") Integer id,
            AnswerForm answerForm
    ){
        Optional<Question> list = this.questionService.getQuestionDetail(id);
        list.ifPresent(question -> model.addAttribute("question", question));

        return "question_detail";
    }

    @GetMapping(value="/create")
    public String createView(
            QuestionForm questionForm
    ){
        return "question_form";
    }

    @PostMapping(value="/create")
    public String create(
            @Valid QuestionForm questionForm,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
