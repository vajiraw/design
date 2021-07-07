package com.indigo.fashion;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.indigo.fashion.service.CityServiceImpl;

@SpringBootTest
public class CityServiceTest {
	
	
	CityServiceImpl cityServiceImpl = new CityServiceImpl();
	
	@Test
	@DisplayName("find all cities are grater than 0 ")
	public void findAll() {
		List<String> words = Arrays.asList("work","sonna","punk","weed");
		System.out.println(words.contains("weed"));
		System.out.println("add ");
		Assertions.assertTrue(cityServiceImpl.contais("sonna"));
	}

}
