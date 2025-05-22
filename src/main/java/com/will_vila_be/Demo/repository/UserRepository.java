package com.will_vila_be.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.will_vila_be.Demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
