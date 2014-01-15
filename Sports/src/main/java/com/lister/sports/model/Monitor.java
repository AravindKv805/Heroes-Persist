package com.lister.sports.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author sai_pranav
 *
 */
@Entity
@Table(name="monitor")
public class Monitor {

	@Id
	@GenericGenerator(name="monitor_seq_gen" , strategy="increment")
	@GeneratedValue(generator="monitor_seq_gen")
	@Column(name = "id")
	private int id;
	
	@Column(name = "ip_address")
	private String ipAddress;
	
	@Column(name = "page")
	private String page;
	
	@Column(name = "timestamp")
	private Timestamp Timestamp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Timestamp getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		Timestamp = timestamp;
	}
	
}
