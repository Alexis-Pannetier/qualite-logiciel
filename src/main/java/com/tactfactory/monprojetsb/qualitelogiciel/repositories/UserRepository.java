package com.tactfactory.monprojetsb.qualitelogiciel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tactfactory.monprojetsb.qualitelogiciel.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User getUserById(Long id);

}
