package com.employeeManagement.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagement.service.entities.Personal_tab;

public interface PersonalRepo extends JpaRepository<Personal_tab, Long> {

}
