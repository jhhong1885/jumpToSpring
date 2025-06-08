package com.mywork.boot;

import com.mywork.boot.answer.repository.AnswerRepository;
import com.mywork.boot.question.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Commit
class BootApplicationTests {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa(){
	}
}
