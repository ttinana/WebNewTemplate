/**
 * 
 */
package rs.tijanap.gym.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import rs.tijanap.gym.testModel.MyUser;

/**
 * @author tijana.pavicic
 *
 */
public class UserExtractor {

	public MyUser extractData(ResultSet resultSet) throws SQLException, DataAccessException  {
		MyUser user = new MyUser();

		user.setUserId(resultSet.getInt(1));
		user.setFirstName(resultSet.getString(2));
		return user;
	}

}
