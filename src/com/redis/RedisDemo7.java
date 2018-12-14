package com.redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class RedisDemo7 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redis=context.getBean(RedisTemplate.class);
		SessionCallback callback=new SessionCallback() {

			@Override
			public String execute(RedisOperations osp) throws DataAccessException {
				// TODO Auto-generated method stub
				for(int i=0;i<100000;i++) {
					osp.boundValueOps("a"+i).set("a"+i);
					osp.boundValueOps("a"+i).get();
				}
				String value=(String) osp.boundValueOps("a500").get();
				return value;
				
			}
			
		};
		long start=System.currentTimeMillis();
		List value=redis.executePipelined(callback);
		System.out.println(value.get(10));
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println(time);
	}

}
