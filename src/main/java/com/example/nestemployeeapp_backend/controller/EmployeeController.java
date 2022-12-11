package com.example.nestemployeeapp_backend.controller;

import com.example.nestemployeeapp_backend.dao.EmployeeDao;
import com.example.nestemployeeapp_backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao dao;
    @CrossOrigin(origins = "*")
   @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> EmployeeAdd(@RequestBody Employee e) {
       dao.save(e);
       HashMap<String, String> status = new HashMap<>();
       status.put("status", "success");
       return status;

   }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody Employee e){
        List<Employee> employees = (List<Employee>) dao.GetUserLogin(e.getUsername(), e.getPassword());
        HashMap<String,String> hashMap = new HashMap<>();
        if(employees.size() ==0 ){
            hashMap.put("status","failed");
        }else{
            hashMap.put("status","success");
            hashMap.put("userId",String.valueOf(employees.get(0).getId()));
        }
        return hashMap;
    }

}
