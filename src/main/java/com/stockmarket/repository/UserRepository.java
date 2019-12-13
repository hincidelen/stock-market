package com.stockmarket.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockmarket.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}