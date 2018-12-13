package com.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisDemo9 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redis=context.getBean(RedisTemplate.class);
		String channel="chat";
		redis.convertAndSend(channel,"i am lazy");
	}

}
