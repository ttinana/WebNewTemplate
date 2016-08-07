package rs.tijanap.gym.dao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

@Repository
public class HibernateDaoImpl {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public int getUserCount() {
		String hql = "select count(*) from MyUser";
		Query query =getSessionFactory().openSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
		
	}

}
