package com.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisDemo2 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redis=context.getBean(RedisTemplate.class);
		redis.opsForValue().set("c","2");
		String s1=(String) redis.opsForValue().get("c");
		System.out.println(s1);
		long s2=redis.opsForValue().increment("c", 5);
		System.out.println(s2);
		//TemplateRedis不支持减法
		long s3=redis.getConnectionFactory().getConnection().decrBy(redis.getKeySerializer().serialize("c"), 2);
	    System.out.println(s3);
	}

}
