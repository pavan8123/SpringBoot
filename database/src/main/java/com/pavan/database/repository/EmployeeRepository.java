package com.pavan.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavan.database.model.Emoloyee;

public interface EmployeeRepository extends JpaRepository<Emoloyee, Integer> {

}
