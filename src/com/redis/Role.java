package com.redis;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String roleName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redis=context.getBean(RedisTemplate.class);
		Role role =new Role();
		role.setId(1l);
		role.setRoleName("ÕÅÈý");
		SessionCallback callBack=new SessionCallback<Role>() {

			@Override
			public <K, V> Role execute(RedisOperations<K,V> ops) throws DataAccessException {
				// TODO Auto-generated method stub
				ops.boundValueOps((K) "two").set((V) role);
				return (Role) ops.boundValueOps((K) "two").get();
			}
		};
		Role saveRole=(Role)redis.execute(callBack);
		System.out.println(saveRole.getRoleName()+saveRole.getId());
		
	}

}
