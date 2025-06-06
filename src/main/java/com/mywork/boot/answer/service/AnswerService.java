package com.mywork.boot.answer.service;

import com.mywork.boot.answer.dto.Answer;
import com.mywork.boot.answer.repository.AnswerRepository;
import com.mywork.boot.question.dto.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content){
        Answer answer = new Answer();

        answer.setContent(content);
        answer.setCreatedAt(LocalDateTime.now());
        answer.setQuestion(question);

        this.answerRepository.save(answer);
    }
}
