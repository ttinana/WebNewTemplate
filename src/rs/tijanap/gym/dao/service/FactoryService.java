package rs.tijanap.gym.dao.service;

import rs.tijanap.gym.testModel.Tea;
import rs.tijanap.gym.testModel.MyUser;

public class FactoryService {
	// such a nice example
	public Object getBean(String beanType){
		// instead of this (how AOP works):
		//if(beanType.equals("userService"))return new UserServiceImpl();
		// real ApplicationContext does this:
		if(beanType.equals("userService"))return new UserServiceImplProxy();
		if(beanType.equals("user"))return new MyUser();
		if(beanType.equals("tea"))return new Tea();
		return null;
		
	}

}
