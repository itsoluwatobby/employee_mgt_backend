package com.itsOluwatobby.SpringApp.Controller;

import com.itsOluwatobby.SpringApp.Entity.Employee;
import com.itsOluwatobby.SpringApp.Error.EmployeeNotFoundException;
import com.itsOluwatobby.SpringApp.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private final EmployeeRepository repository;

    private Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }
    @PostMapping("/employees")
    public Employee saveNewEmployee(@RequestBody Employee employee) {
        LOGGER.info("Employee's Detail Entry Section");
        return repository.save(employee);
    }
    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long Id)
    throws EmployeeNotFoundException {
        LOGGER.info("Fetching Employee's Details By Id Section");
       Optional<Employee> employee = repository.findById(Id);

       if(!employee.isPresent()) {
           throw new EmployeeNotFoundException("Employee "+ Id + "Not Available");
       }
       else {
           return employee.get();
       }
    }
    @GetMapping("/employees")
    public List<Employee> fetchDepartmentList() {
        LOGGER.info("Fetching All Employee's Detail Section");
        return repository.findAll();
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,
                                   @PathVariable("id") Long Id) {
        LOGGER.info("Updating Employee's Details Section");
        Employee employee1 = repository.findById(Id).get();

        if(Objects.nonNull(employee.getEmployeeName()) &&
                !"".equalsIgnoreCase(employee.getEmployeeName())){
            employee1.setEmployeeName(employee.getEmployeeName());
        }

        if (Objects.nonNull(employee.getRole()) &&
        !"".equalsIgnoreCase(employee.getRole())) {
            employee1.setRole(employee.getRole());
        }
        return repository.save(employee1);
    }
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable("id") Long Id) {
        LOGGER.info("Delete Employee's Details Section");
        repository.deleteById(Id);
        return "Employee Details Deleted successfully!!!";
    }

}
