package rs.tijanap.gym.dao.service;

import java.util.List;

import rs.tijanap.gym.dao.dao.NamedParameterJdbcTemplateImpl;
import rs.tijanap.gym.testModel.MyUser;

public class UserServiceNPJTimpl {
	private NamedParameterJdbcTemplateImpl namedParameterJdbcTemplateImpl;

	public NamedParameterJdbcTemplateImpl getNamedParameterJdbcTemplateImpl() {
		return namedParameterJdbcTemplateImpl;
	}

	public void setNamedParameterJdbcTemplateImpl(NamedParameterJdbcTemplateImpl namedParameterJdbcTemplateImpl) {
		this.namedParameterJdbcTemplateImpl = namedParameterJdbcTemplateImpl;
	}

	public void insertUser(MyUser user) {
		this.getNamedParameterJdbcTemplateImpl().insertUser(user);

	}

	public void updateUser(MyUser user) {
		this.getNamedParameterJdbcTemplateImpl().updateUser(user);

	}

	public void deleteUser(String id) {
		this.getNamedParameterJdbcTemplateImpl().deleteUser(id);

	}

	public MyUser getUser(int id) {
		return this.getNamedParameterJdbcTemplateImpl().getUser(id);
	}

	public String getUserName(int i) {
		return this.getNamedParameterJdbcTemplateImpl().getUserName(i);
	}

	public List<MyUser> getUserList() {
		return this.getNamedParameterJdbcTemplateImpl().getUsersList();
	}

}
