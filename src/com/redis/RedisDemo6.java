package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class RedisDemo6 {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("localhost",6379);
		long start=System.currentTimeMillis();
		Pipeline pipeline=jedis.pipelined();
		for(int i=0;i<=100000;i++) {
			pipeline.set("a"+i, "key"+i);
			pipeline.get("a"+i);
		}
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println(time);
	}

}
