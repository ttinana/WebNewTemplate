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
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertData(MyUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MyUser> getUserList() {
		List<MyUser> userList = new ArrayList<MyUser>();
		String sql = "select * from myuser";
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		// userList = jdbcTemplate.queryForList(sql, MyUser.class);
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
	public MyUser getUser(int id) {
		List<MyUser> userList = new ArrayList<MyUser>();
		String sql = "select * from myuser where UserId= ?";
		userList = jdbcTemplate.query(sql,  new Object[] { id }, new UserRowMapper());
		return userList.get(0);
	}

	@Override
	public String getUserName(int id) {
		String sql = "select firstname from myuser where UserId= ?";
		String name = jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
		return name;
	}

}
