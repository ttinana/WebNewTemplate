package rs.tijanap.gym.dao.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import rs.tijanap.gym.dao.UserRowMapper;
import rs.tijanap.gym.testModel.MyUser;

@Component
public class UserDaoImpl implements UserDao {
	
	 @Autowired  
	 DataSource dataSource;  

	@Override
	public void insertData(MyUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MyUser> getUserList() {
		List<MyUser> userList = new ArrayList<MyUser>();

		String sql = "select * from myuser";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	@Override
	public void updateData(MyUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteData(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public MyUser getUser(String id) {
		  List<MyUser> userList = new ArrayList<MyUser>();  
		  String sql = "select * from myuser where UserId= " + id;  
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		  userList = jdbcTemplate.query(sql, new UserRowMapper());  
		  return userList.get(0);  
	}

}
