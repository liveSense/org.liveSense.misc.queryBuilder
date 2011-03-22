package org.liveSense.misc.queryBuilder;

import javax.persistence.Column;
import javax.persistence.Id;

public class TestBean {
	@Id
	@Column(name="ID")
	Integer id;
	
	@Column(name="CODE")
	String code;

	@Column(name="ID_CUSTOMER")
	String customerId;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


}
