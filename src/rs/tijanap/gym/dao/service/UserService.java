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
	
	 public void insertUser(MyUser user);  
	 public List<MyUser> getUserList();  
	 public void deleteData(String id);  
	 public MyUser getUser(int id);  
	 public void updateData(MyUser user);  

}
