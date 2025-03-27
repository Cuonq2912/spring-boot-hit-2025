package org.example.btvnbuoi2.service;

import org.example.btvnbuoi2.entity.Employees;
import org.example.btvnbuoi2.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository){
        this.employeesRepository = employeesRepository;
    }

    public void saveEmployee(Employees employees){
        employeesRepository.save(employees);
    }

    public void deleteEmployee(Long id){
        employeesRepository.deleteById(id);
    }

    public List<Employees> getAllEmployees(){
        return employeesRepository.findAll();
    }

    public Optional<Employees> getEmployeeById(Long id){
        return employeesRepository.findById(id);
    }

}
