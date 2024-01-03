package com.project.questApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questApp.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
