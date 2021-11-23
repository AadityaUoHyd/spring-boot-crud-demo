package org.aadi.springboot.demo;

import org.aadi.springboot.demo.entity.Department;
import org.aadi.springboot.demo.restTemplateClient.RestTemplateConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudDemoApplication.class, args);
		crudConsumerCallDemo();
	}

	public static void crudConsumerCallDemo() {

		//calling POST using RestTemplate exchange()
		Department department1 = new Department();
		department1.setDepartmentName("IT");
		department1.setDepartmentAddress("Delhi");
		department1.setDepartmentCode("IT-101");

		Department department2 = new Department();
		department2.setDepartmentName("CS");
		department2.setDepartmentAddress("Hyd.");
		department2.setDepartmentCode("CS-201");

		Department department3 = new Department();
		department3.setDepartmentName("HR");
		department3.setDepartmentAddress("Pune");
		department3.setDepartmentCode("HR-301");

		System.out.println("\n-----------------------------createClientDept--------------------------------\n");
		RestTemplateConsumer.createClientDept(department1);
		RestTemplateConsumer.createClientDept(department2);
		RestTemplateConsumer.createClientDept(department3);

		//calling GET by ID using RestTemplate exchange()
		System.out.println("\n----------------------------getClientDeptById---------------------------------\n");
		RestTemplateConsumer.getClientDeptById(2);

		//calling GET using RestTemplate exchange()
		System.out.println("\n----------------------------getClientDeptList---------------------------------\n");
		RestTemplateConsumer.getClientDeptList();

		//calling PUT using RestTemplate exchange()
		Department updateDepartment = new Department();
		updateDepartment.setDepartmentId(2L);
		updateDepartment.setDepartmentName("Accounts");
		updateDepartment.setDepartmentAddress("Kolkata");
		updateDepartment.setDepartmentCode("AC-304");

		System.out.println("\n-----------------------------updateClientDept--------------------------------\n");
		RestTemplateConsumer.updateClientDept(2, updateDepartment);

		//calling DELETE using RestTemplate exchange()
		System.out.println("\n-----------------------------deleteClientDept--------------------------------\n");
		RestTemplateConsumer.deleteClientDept(3);
	}

}