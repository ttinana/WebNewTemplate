package rs.tijanap.gym.dao.service;

import java.util.List;

import rs.tijanap.gym.aspect.LoggingAspect;
import rs.tijanap.gym.testModel.MyUser;

public class UserServiceImplProxy extends UserServiceImpl {
	@Override
	public List<MyUser> getUserList() {
		// here I am actually adding Logging advice
		LoggingAspect lObject = new LoggingAspect();
		lObject.loginPrimitiveAdviceToExplainAOPspring();
		// here I am doing the actual call of a method
		return super.getUserList();
	}

}
