package com.redis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisDemo3 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redis=context.getBean(RedisTemplate.class);
		String key="hash";
		Map<String,String> map=new HashMap<String,String>();
		map.put("f1", "val1");
		map.put("f2", "val2");
		redis.opsForHash().putAll(key, map);
		redis.opsForHash().put(key, "f3", "6");
		String s1=(String) redis.opsForHash().get(key, "f3");
		System.out.println(s1);
		redis.opsForHash().put(key, "a", "5");
		redis.opsForHash().delete(key,"a");
	}

}
