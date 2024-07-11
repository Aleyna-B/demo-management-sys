package com.managementsys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.managementsys.entity.CustomerInfo;
import com.managementsys.service.CustomerInfoService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerInfoService cis;

	@GetMapping("/OurCustomers")
	public String listAllCustomers(Model model)
	{
		model.addAttribute("allcustomers",cis.getAllCustomerInfo() );
		return "allcustomers";			//return this view
	}
	
	@GetMapping("/OurCustomers/Create")
	public String newCustomerForm(Model model)
	{
		CustomerInfo customer = new CustomerInfo();
		model.addAttribute("customer", customer);
		return "create_customer";
	}
	
	@PostMapping("/OurCustomers")
	public String saveNewCustomer(@ModelAttribute("customer") CustomerInfo c)
	{
		try {
		cis.addCustomerInfo(c);
		return "redirect:/OurCustomers";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "redirect:/OurCustomers";
		}
	}
	
	@GetMapping("/OurCustomers/Edit/{id}")
	public String updateCustomerForm(@PathVariable Long id,Model model)
	{
		try {
			model.addAttribute("idofthecustomer", cis.findBycustomerId(id));
			return "edit_customer";
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "redirect:/OurCustomers";
		}		
	}
	
	@PostMapping("/OurCustomers/{id}")
	public String updateCustomer(@PathVariable Long id,Model model,@ModelAttribute("custo") CustomerInfo custo)
	{
		try {
			CustomerInfo existingc = cis.findBycustomerId(id);
			existingc.setName(custo.getName());
			existingc.setSurname(custo.getSurname());
			existingc.setAdress(custo.getAdress());
			existingc.setDob(custo.getDob());
			cis.updateCustomerInfo(existingc);
			return "redirect:/OurCustomers";
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "redirect:/OurCustomers";
		}		
	}
	
	@GetMapping("/OurCustomers/{id}")
	public String deleteCustomer(@PathVariable Long id)
	{
		try {
			cis.deleteCustomerInfoById(id);
			return "redirect:/OurCustomers";
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				return "redirect:/OurCustomers";
			}
	}
}
