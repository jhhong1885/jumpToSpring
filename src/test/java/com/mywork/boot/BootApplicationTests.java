package com.mywork.boot;

import com.mywork.boot.entity.Question;
import com.mywork.boot.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class BootApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa(){
		Question q1 = new Question();
		q1.setSubject("test");
		q1.setContent("테스트입니다.");
		q1.setCreateAt(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("스프링부트 테스트");
		q2.setContent("스프링 테스트입니다.");
		q2.setCreateAt(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장
	}
}
