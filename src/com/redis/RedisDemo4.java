package com.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class RedisDemo4 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redis1=context.getBean(RedisTemplate.class);
		SessionCallback callback=new SessionCallback(){

			@Override
			public String execute(RedisOperations ops) throws DataAccessException {
				// TODO Auto-generated method stub
				ops.boundValueOps("one").set("ÕÅÈý");
				return (String) ops.boundValueOps("one").get();
			}
			
		};
		String s1=(String)redis1.execute(callback);
		System.out.println(s1);
	}

}
