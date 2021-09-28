package com.sc.pioneers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sc.pioneers.config.APISuccessPayload;
import com.sc.pioneers.entities.Customer;
import com.sc.pioneers.entities.vo.AppUserTokenVO;
import com.sc.pioneers.entities.vo.CustomerSchemeVO;
import com.sc.pioneers.services.IAuthService;
import com.sc.pioneers.services.ICustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	
	//ICustomerService customerService=new CustomerService();
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	IAuthService authService;
	
	@PostMapping("/customers")
	public ResponseEntity<APISuccessPayload> addCustomer(@RequestBody Customer c)
	{
		String result=customerService.addCustomer(c);
		
		APISuccessPayload payload=APISuccessPayload.build(result, result,HttpStatus.CREATED);
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<APISuccessPayload>(payload,HttpStatus.CREATED);
		
		return response;
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<APISuccessPayload> getCustomerById(@PathVariable int id)
	{
		Customer c=customerService.getCustomerById(id);
		
		APISuccessPayload payload=APISuccessPayload.build(c,"Customer Found", HttpStatus.OK);
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<>(payload,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/customers")
	public  ResponseEntity<APISuccessPayload> getAllCustomers()
	{
		List<Customer> list=customerService.getAllCustomers();
		
		APISuccessPayload payload=new APISuccessPayload();
		payload.setBody(list);
		payload.setStatus(200);
		payload.setHttpStatus(String.valueOf(HttpStatus.OK));
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage("Customers Found");
		
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<>(payload,HttpStatus.OK);
		
		return response;
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<APISuccessPayload> updateCustomer(@PathVariable int id,@RequestBody Customer c)
	{
		String result=customerService.updateCustomer(id, c);
		
		APISuccessPayload payload=new APISuccessPayload();
		payload.setBody(result);
		payload.setStatus(200);
		payload.setHttpStatus(String.valueOf(HttpStatus.OK));
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage(result);
		
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<>(payload,HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<APISuccessPayload> deleteCustomer(@RequestHeader("X-SCB-Username") String username,
			@RequestHeader("X-SCB-Token") String token,@PathVariable int id)
	{
		AppUserTokenVO tokenVO=new AppUserTokenVO(username, token);
		if(authService.authenticate(tokenVO))
		{
		
		String result=customerService.deleteCustomer(id);
		

		APISuccessPayload payload=new APISuccessPayload();
		payload.setBody(result);
		payload.setStatus(200);
		payload.setHttpStatus(String.valueOf(HttpStatus.OK));
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage(result);
		
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<>(payload,HttpStatus.OK);
		return response;
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/customers/accounttype/{accountType}")
	public ResponseEntity<APISuccessPayload> getCustomerByAccountType(@PathVariable String accountType)
	{
		List<Customer> list=customerService.getCustomersByAccountType(accountType);
		

		APISuccessPayload payload=new APISuccessPayload();
		payload.setBody(list);
		payload.setStatus(200);
		payload.setHttpStatus(String.valueOf(HttpStatus.OK));
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage("Customers Found");
		
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<>(payload,HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("/customers/schemes/{id}")
	public ResponseEntity<APISuccessPayload> getSchemeForCustomerById(@PathVariable int id)
	{
		List<CustomerSchemeVO> list=customerService.getSchemesForCustomer(id);
		
		APISuccessPayload payload=APISuccessPayload.build(list,"Customer Found", HttpStatus.OK);
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<>(payload,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/customers/authenticated-only")
	public  ResponseEntity<APISuccessPayload> getAllCustomersAO(@RequestHeader("X-SCB-Username") String username,
																@RequestHeader("X-SCB-Token") String token
																)
	{
		AppUserTokenVO tokenVO=new AppUserTokenVO(username, token);
		if(authService.authenticate(tokenVO))
		{
		List<Customer> list=customerService.getAllCustomers();
		
		APISuccessPayload payload=new APISuccessPayload();
		payload.setBody(list);
		payload.setStatus(200);
		payload.setHttpStatus(String.valueOf(HttpStatus.OK));
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage("Customers Found");
		
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<>(payload,HttpStatus.OK);
		
		return response;
		}
		else
		{
			return null;
		}
	}
	
	
}
