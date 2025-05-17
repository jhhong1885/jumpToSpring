package com.mywork.boot;

import com.mywork.boot.answer.dto.Answer;
import com.mywork.boot.question.dto.Question;
import com.mywork.boot.answer.repository.AnswerRepository;
import com.mywork.boot.question.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BootApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa(){
		Optional<Question> optional = this.questionRepository.findById(1);
		assertTrue(optional.isPresent());
		Question question = optional.get();

		List<Answer> answerList = question.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("반갑습니다.", answerList.getFirst().getContent());
	}
}
