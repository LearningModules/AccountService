package com.poc.accountservice.repositories;

import com.poc.accountservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by reji on 25/05/17.
 */
@Component
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByUserName(String userName);
}
