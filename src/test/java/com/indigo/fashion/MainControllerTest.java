package com.indigo.fashion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.indigo.fashion.service.CityService;

public class MainControllerTest {
	
	
	@Mock
	private CityService cityServicel;
	
	@BeforeEach
    void setUp() {
        System.out.println("B4");
    }

    @Test
    void shouldReturnXYZ() {
       //test code
    }

}
//https://stackoverflow.com/questions/48852347/maven-does-not-pick-up-tests-in-spring-boot-app