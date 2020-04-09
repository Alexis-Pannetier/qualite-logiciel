package com.tactfactory.monprojetsb.qualitelogiciel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojetsb.qualitelogiciel.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
