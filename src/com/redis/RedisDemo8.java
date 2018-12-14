package com.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisDemo8 implements MessageListener{
	private RedisTemplate redis;
	

	public RedisTemplate getRedis() {
		return redis;
	}


	public void setRedis(RedisTemplate redis) {
		this.redis = redis;
	}


	@Override
	public void onMessage(Message message, byte[] bytes) {
		// TODO Auto-generated method stub
		byte[] body=message.getBody();
		String msgBody=(String)getRedis().getValueSerializer().deserialize(body);
		System.out.println(msgBody);
		byte[] channel=message.getChannel();
		String channelStr=(String)getRedis().getStringSerializer().deserialize(channel);
		System.out.println(channelStr);
		String byteStr=new String(bytes);
		System.out.println(byteStr);
	}
	

}
