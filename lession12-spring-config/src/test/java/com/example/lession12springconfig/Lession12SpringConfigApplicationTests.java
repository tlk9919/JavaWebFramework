package com.example.lession12springconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession12SpringConfigApplicationTests {
	@Autowired
	private MyConfig myConfig;

	@Test
	void contextLoads() {
		System.out.println(myConfig);
	}

}
