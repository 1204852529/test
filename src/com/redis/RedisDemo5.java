package com.redis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class RedisDemo5 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redis=context.getBean(RedisTemplate.class);
		SessionCallback callback=new SessionCallback() {

			@Override
			public String execute(RedisOperations ops) throws DataAccessException {
				// TODO Auto-generated method stub
				ops.multi();
				ops.boundValueOps("s").set("111");
				String value=(String) ops.boundValueOps("s").get();//没执行，所以是null
				List list=ops.exec();
				String value1=(String) ops.boundValueOps("s").get();
				return value1;
			}
			
		};
		String value=(String) redis.execute(callback);
		System.out.println(value);
	}

}
