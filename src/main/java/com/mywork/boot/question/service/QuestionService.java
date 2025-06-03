package com.mywork.boot.question.service;

import com.mywork.boot.question.dto.Question;
import com.mywork.boot.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Question getQuestion(int id){
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else {
            throw new DataRetrievalFailureException("question not found");
        }
    }

    public List<Question> getQuestionList(){
        return this.questionRepository.findAll();
    }

    public Optional<Question> getQuestionDetail(int id){
        return this.questionRepository.findById(id);
    }

    public void create(String subject, String content){
        Question question = new Question();

        question.setSubject(subject);
        question.setContent(content);
        question.setCreatedAt(LocalDateTime.now());

        this.questionRepository.save(question);
    }
}
