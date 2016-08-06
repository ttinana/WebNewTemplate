/**
 * 
 */
package rs.tijanap.gym.dao.dao;

/**
 * @author tijana.pavicic
 *
 */
import java.util.List;  
import rs.tijanap.gym.testModel.*;  
  
public interface UserDao {  
 public void insertData(MyUser user);  
 public List<MyUser> getUserList();  
 public void updateData(MyUser user);  
 public void deleteData(String id);  
 public MyUser getUser(String id);  
  
}
