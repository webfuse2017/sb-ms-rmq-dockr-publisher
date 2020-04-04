package com.webfuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webfuse.model.Employee;
import com.webfuse.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/publisher/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/publish")
	public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {

		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		rabbitMQSender.send(emp);

		return "Message sent to the queue Successfully";
	}

}
