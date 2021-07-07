package com.indigo.fashion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.indigo.fashion.web.MainController;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestingWebApplicationTests {
	
	
	@Autowired
	private MainController main;
	
	@Test
	public void contextLoadTest() {
		
		//assertThat(main).isNotNull();
		Assertions.assertNotNull(main);
	}
}
