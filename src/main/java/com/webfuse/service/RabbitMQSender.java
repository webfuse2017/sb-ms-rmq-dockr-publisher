package com.webfuse.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.webfuse.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${webfuse.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${webfuse.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Employee company) {
		amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Sent message = " + company + ", using routingkey = " + routingkey);
	}
}