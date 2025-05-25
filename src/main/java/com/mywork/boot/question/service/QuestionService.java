package com.mywork.boot.question.service;

import com.mywork.boot.question.dto.Question;
import com.mywork.boot.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getQuestionList(){
        return this.questionRepository.findAll();
    }

    public Optional<Question> getQuestionDetail(int id){
        return this.questionRepository.findById(id);
    }
}
