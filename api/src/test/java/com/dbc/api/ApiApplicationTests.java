package com.dbc.api;

import com.dbc.entity.entity.PureUserEntity;
import com.dbc.service.RedisTemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {
	@Autowired
	RedisTemplateService redisTemplateService;

	@Test
	void contextLoads() {
	}
}
