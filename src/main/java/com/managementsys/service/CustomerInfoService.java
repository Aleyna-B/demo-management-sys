package com.managementsys.service;

import java.util.List;

import com.managementsys.entity.CustomerInfo;

public interface CustomerInfoService {
	public List<CustomerInfo> getAllCustomerInfo();
	public CustomerInfo addCustomerInfo(CustomerInfo customer);
	public CustomerInfo updateCustomerInfo(CustomerInfo customer);
	public void deleteCustomerInfoById(Long Id);
	public CustomerInfo findBycustomerId(Long customerId);
	public CustomerInfo findBysurname(String surname);
}
