package com.github.mesaquebatista.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mesaquebatista.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
