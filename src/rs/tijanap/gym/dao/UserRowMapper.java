/**
 * 
 */
package rs.tijanap.gym.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import rs.tijanap.gym.testModel.MyUser;

/**
 * @author tijana.pavicic
 *
 */
public class UserRowMapper implements RowMapper<MyUser> {

	@Override
	public MyUser mapRow(ResultSet resultSet, int line) throws SQLException {
		UserExtractor userExtractor = new UserExtractor();
		return userExtractor.extractData(resultSet);
	}

}
