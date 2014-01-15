package com.lister.sports.implementation.monitor;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lister.sports.exception.SportsException;
import com.lister.sports.interfaces.monitor.MonitorDao;
import com.lister.sports.interfaces.monitor.MonitorService;
import com.lister.sports.model.Monitor;
import com.lister.sports.webservice.monitor.MonitorForm;

/**
 * @author sai_pranav
 *
 */

@Component
@Transactional
public class MonitorServiceImpl implements MonitorService {

	@Autowired
	MonitorDao monitorDao;
	
	public int recordPageHits(String ipAddress, MonitorForm monitorForm) throws SportsException, HibernateException{
		Monitor monitor = new Monitor();
		monitor.setIpAddress(ipAddress);
		monitor.setPage(monitorForm.getPage());
		monitor.setTimestamp(new Timestamp(new Date().getTime()));
		return monitorDao.recordPageHits(monitor);
	}

}
