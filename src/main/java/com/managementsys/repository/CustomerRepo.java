package com.managementsys.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.managementsys.entity.CustomerInfo;

public interface CustomerRepo extends JpaRepository<CustomerInfo,Long>{

	public CustomerInfo findBycustomerId(Long customerId);
	public CustomerInfo findBysurname(String surname);
}
