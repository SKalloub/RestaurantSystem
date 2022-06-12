package com.example.finalproject_restapp.resturantmanagment.resource.repository;


import com.example.finalproject_restapp.resturantmanagment.model.TempUser;

public interface EmployeeRepository {
    static EmployeeRepository getInstance() {
        return null;
    }
    boolean verify(TempUser user);

}
