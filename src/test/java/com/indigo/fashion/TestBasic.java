package com.indigo.fashion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.indigo.fashion.model.City;


public class TestBasic {
	
	@Before 
	public void setAll() {
		System.out.println("All about to fail");
	}
	
	
	@Test
	public void testOne() {
		//assertThat(new City()).
		
		assertThat(new City())
	      .isInstanceOf(Object.class);

	}
	

}
