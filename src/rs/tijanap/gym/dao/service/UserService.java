/**
 * 
 */
package rs.tijanap.gym.dao.service;

import java.util.List;

import rs.tijanap.gym.testModel.MyUser;

/**
 * @author tijana.pavicic
 *
 */
public interface UserService {
	
	 public void insertData(MyUser user);  
	 public List<MyUser> getUserList();  
	 public void deleteData(String id);  
	 public MyUser getUser(String id);  
	 public void updateData(MyUser user);  

}
