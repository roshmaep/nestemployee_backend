package com.example.nestemployeeapp_backend.dao;

import com.example.nestemployeeapp_backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
    @Query(value = "SELECT `id`, `code`, `cpassword`, `designation`, `email`, `name`, `password`, `phone`, `username` FROM `employee` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<Employee>GetUserLogin(@Param("username")String username,@Param("password")String password);
}
