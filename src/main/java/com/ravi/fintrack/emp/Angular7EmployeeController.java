package com.ravi.fintrack.emp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/emp")
public class Angular7EmployeeController {

//	private Employee employee;
	private static Map<Integer,Employee> empMap;
	private static int primaryKey = 0;
	
	public Angular7EmployeeController() {
		empMap = new HashMap<>();
		++primaryKey;
		empMap.put(Integer.valueOf(primaryKey), new Employee("Hai"));
	}
	
	private int getPrimaryKey() {
		return primaryKey++;
	} 
	
	@PostMapping(value="/save")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee save(@RequestBody Employee employee) {
		System.out.println("Request data is : "+employee);
		employee.setId(getPrimaryKey());
		empMap.put(employee.getId(), employee);
		System.out.println(empMap);
		return employee;
	} 
	
	@GetMapping(value="/getAll")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getAll(){
		List<Employee> empList =  empMap.values().stream().collect(Collectors.toList());
		System.out.println(empList);
		return empList;
	}
	
	@GetMapping(value="/health")
	public String health() {
		return "Employee";
	}
	
}
