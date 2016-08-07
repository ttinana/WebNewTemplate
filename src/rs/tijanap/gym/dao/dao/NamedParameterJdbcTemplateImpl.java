package rs.tijanap.gym.dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import rs.tijanap.gym.dao.UserRowMapper;
import rs.tijanap.gym.testModel.MyUser;

public class NamedParameterJdbcTemplateImpl extends NamedParameterJdbcDaoSupport {

	public void insertUser(MyUser user) {
		String sql = "insert into MyUser (UserId, FirstName) values (:id,:name)";
		SqlParameterSource namedParameterMap = new MapSqlParameterSource("id", user.getUserId()).addValue("name",
				user.getFirstName());
		this.getNamedParameterJdbcTemplate().update(sql, namedParameterMap);
	}

	public void updateUser(MyUser user) {
		String sql = "update myuser set firstname=:name where UserId=:id";
		SqlParameterSource namedParameterMap = new MapSqlParameterSource("id", user.getUserId()).addValue("name",
				user.getFirstName());
		this.getNamedParameterJdbcTemplate().update(sql, namedParameterMap);

	}

	public void deleteUser(String id) {
		// TODO Auto-generated method stub

	}

	public List<MyUser> getUsersList() {
		List<MyUser> userList = new ArrayList<MyUser>();
		String sql = "select * from myuser";
		userList = this.getNamedParameterJdbcTemplate().query(sql, new UserRowMapper());
		return userList;
	}

	public MyUser getUser(int id) {
		List<MyUser> userList = new ArrayList<MyUser>();
		String sql = "select * from myuser where UserId= :id";
		userList = this.getNamedParameterJdbcTemplate().query(sql, new MapSqlParameterSource("id", id),
				new UserRowMapper());

		return userList.get(0);
	}

	public String getUserName(int id) {
		String sql = "select firstname from myuser where UserId= :id";
		String name = this.getNamedParameterJdbcTemplate().queryForObject(sql, new MapSqlParameterSource("id", id),
				String.class);
		return name;
	}

	// note update statement executes stored procedures in jdbc template!
	// EXECUTE statement CREATE TABLE etc...
	public void createUserTable() {
		String str = "CREATE TABLE MyUserTable (UserId INT PRIMARY KEY, FirstName VARCHAR(50))";
		//this.getNamedParameterJdbcTemplate().execute(sql, action);
	}
}
