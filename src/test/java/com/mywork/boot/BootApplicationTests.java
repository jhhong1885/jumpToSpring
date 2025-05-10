package com.mywork.boot;

import com.mywork.boot.entity.Question;
import com.mywork.boot.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

@SpringBootTest
class BootApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa(){
		Optional<Question> optional = this.questionRepository.findById(1);
		assertTrue(optional.isPresent());

		Question question = optional.get();
		question.setSubject("hello world");
		this.questionRepository.save(question);
	}
}
