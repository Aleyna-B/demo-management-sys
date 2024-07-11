package com.managementsys.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsys.entity.CustomerInfo;
import com.managementsys.repository.CustomerRepo;
import com.managementsys.service.CustomerInfoService;

@Service		//abstract olur mu?
public class CustomerInfoImpl implements CustomerInfoService{
	@Autowired
	private CustomerRepo cı;

	@Override
	public List<CustomerInfo> getAllCustomerInfo() {
		return cı.findAll();		
	}

	@Override
	public CustomerInfo addCustomerInfo(CustomerInfo customer) {
		return cı.save(customer);
	}

	@Override
	public CustomerInfo updateCustomerInfo(CustomerInfo customer) {
		return cı.save(customer);
	}

	@Override
	public void deleteCustomerInfoById(Long Id) {
		cı.deleteById(Id);	
	}
	
	@Override
	public CustomerInfo findBycustomerId(Long customerId) {
		return cı.findBycustomerId(customerId);
	}

	@Override
	public CustomerInfo findBysurname(String surname) {
		return cı.findBysurname(surname);
	}
	
}
