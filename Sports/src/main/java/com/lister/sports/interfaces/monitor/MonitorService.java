package com.lister.sports.interfaces.monitor;

import org.hibernate.HibernateException;

import com.lister.sports.exception.SportsException;
import com.lister.sports.webservice.monitor.MonitorForm;

/**
 * @author sai_pranav
 *
 */
public interface MonitorService {

	public int recordPageHits(String ipAddress, MonitorForm monitorForm) throws SportsException, HibernateException;
	
}
