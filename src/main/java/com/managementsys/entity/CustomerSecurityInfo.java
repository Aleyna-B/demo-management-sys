package com.managementsys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_sec_info")
public class CustomerSecurityInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "security_id")
	private long secId;
	
	@Column(name = "password")
	private String password;
	@Column(name = "active")
	private boolean active;
	@Column(name = "roles")
	private String role;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private CustomerInfo customerInfo;	//mappedBy = olan obje
	
	
}
