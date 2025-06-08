package com.mywork.boot.question.service;

import com.mywork.boot.question.dto.Question;
import com.mywork.boot.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public Page<Question> getPageList(int page){
        //createdAt 으로 order 정렬 초기화
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createdAt"));

        //order by 정렬을 적용하는 방법
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }
}
