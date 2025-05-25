package com.mywork.boot.question.controller;

import org.springframework.ui.Model;
import com.mywork.boot.question.dto.Question;
import com.mywork.boot.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class questionContoller {
    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);

        return "question/list";
    }
}
