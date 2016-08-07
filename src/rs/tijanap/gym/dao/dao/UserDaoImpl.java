package rs.tijanap.gym.dao.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import rs.tijanap.gym.dao.UserRowMapper;
import rs.tijanap.gym.testModel.MyUser;

@Component
public class UserDaoImpl implements UserDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//@Override // jdbcTemplate version
	public void insertUser1(MyUser user) {
		String sql = "insert into MyUser (UserId, FirstName) values (?,?)";
		jdbcTemplate.update(sql, new Object[] { user.getUserId(), user.getFirstName() });

	}
	/***********************************************/
	@Override
	public void insertUser(MyUser user) {
		String sql = "insert into MyUser (UserId, FirstName) values (:id,:name)";
		SqlParameterSource namedParameterMap = new MapSqlParameterSource("id", user.getUserId()).addValue("name", user.getFirstName());
		namedParameterTemplate.update(sql, namedParameterMap);
	}
	
	@Override
	public void updateData(MyUser user) {
		String sql = "update myuser set firstname=:name where UserId=:id";
		SqlParameterSource namedParameterMap = new MapSqlParameterSource("id", user.getUserId()).addValue("name", user.getFirstName());
		namedParameterTemplate.update(sql, namedParameterMap);

	}

	@Override
	public void deleteData(String id) {
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
	public MyUser getUser(int id) {
		List<MyUser> userList = new ArrayList<MyUser>();
		String sql = "select * from myuser where UserId= ?";
		userList = jdbcTemplate.query(sql, new Object[] { id }, new UserRowMapper());
		return userList.get(0);
	}

	@Override
	public String getUserName(int id) {
		String sql = "select firstname from myuser where UserId= ?";
		String name = jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
		return name;
	}
	
	// note update statement executes stored procedures in jdbc template!
	// EXECUTE statement CREATE TABLE etc...
	public void createUserTable(){
		String str = "CREATE TABLE MyUserTable (UserId INT PRIMARY KEY, FirstName VARCHAR(50))";
		jdbcTemplate.execute(str);
	}

}
