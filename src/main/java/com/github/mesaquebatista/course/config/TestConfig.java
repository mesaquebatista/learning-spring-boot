package com.github.mesaquebatista.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.mesaquebatista.course.entities.Order;
import com.github.mesaquebatista.course.entities.User;
import com.github.mesaquebatista.course.entities.enums.OrderStatus;
import com.github.mesaquebatista.course.repositories.OrderRepository;
import com.github.mesaquebatista.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2023-04-12T20:00:00Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2023-04-12T20:30:00Z"), OrderStatus.SHIPPED, u2);
		Order o3 = new Order(null, Instant.parse("2023-04-12T21:00:00Z"), OrderStatus.CANCELED, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
}
