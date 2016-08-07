/**
 * 
 */
package rs.tijanap.gym.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rs.tijanap.gym.dao.dao.UserDao;
import rs.tijanap.gym.testModel.MyUser;

/**
 * @author tijana.pavicic
 *
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * rs.tijanap.gym.dao.UserService#insertData(rs.tijanap.gym.testModel.User)
	 */
	@Override
	public void insertUser(MyUser user) {
		userDao.insertUser(user);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rs.tijanap.gym.dao.UserService#getUserList()
	 */
	@Override
	public List<MyUser> getUserList() {
		return userDao.getUserList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rs.tijanap.gym.dao.UserService#deleteData(java.lang.String)
	 */
	@Override
	public void deleteData(String id) {
		userDao.deleteData(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rs.tijanap.gym.dao.UserService#getUser(java.lang.String)
	 */
	@Override
	public MyUser getUser(int id) {
		return userDao.getUser(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * rs.tijanap.gym.dao.UserService#updateData(rs.tijanap.gym.testModel.User)
	 */
	@Override
	public void updateData(MyUser user) {
		userDao.updateData(user);

	}

	public String getUserName(int i) {
		return userDao.getUserName(i);
	}

}
