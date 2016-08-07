/**
 * 
 */
package rs.tijanap.gym.testModel;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author tijana.pavicic
 *
 */
@Entity
public class MyUser {
	@Id
	private int userId;
	private String firstName;
	public MyUser() {
		super();
	}
	public MyUser(int userId, String firstName) {
		this.userId=userId;
		this.firstName=firstName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	

}
