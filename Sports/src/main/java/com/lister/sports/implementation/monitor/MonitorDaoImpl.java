package com.lister.sports.implementation.monitor;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lister.sports.interfaces.monitor.MonitorDao;
import com.lister.sports.interfaces.utility.UtilityDao;
import com.lister.sports.model.Monitor;

/**
 * @author sai_pranav
 *
 */

@Repository
public class MonitorDaoImpl implements MonitorDao {

	@Autowired
	UtilityDao utilityDao;
	
	public int recordPageHits(Monitor monitor) {
		Session session = utilityDao.getSession();
		try {
			session.save(monitor);
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}
		return monitor.getId();
	}

}
