package com.chengannagari.s.dashboard.Reposiyory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.chengannagari.s.dashboard.Entity.Login;
import com.chengannagari.s.dashboard.Entity.User;
import com.chengannagari.s.dashboard.Entity.UserDTO;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAll();
Optional<User> findByFirstName(String firstName);
boolean existsByFirstName(String firstName);
}
