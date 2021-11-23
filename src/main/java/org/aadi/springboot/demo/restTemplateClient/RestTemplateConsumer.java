package org.aadi.springboot.demo.restTemplateClient;

import java.util.Arrays;

import org.aadi.springboot.demo.entity.Department;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateConsumer {

	private static RestTemplate restTemplate = new RestTemplate();
	private static String SERVER_BASE_URL = "http://localhost:8081/api/v1/departments/"; 

	// Calling POST using RestTemplate exchange()
	public static void createClientDept(Department dept) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Department> entity = new HttpEntity<Department>(dept,headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				SERVER_BASE_URL, HttpMethod.POST, entity, String.class);

		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println(" ********************************************************* ");
		System.out.println(" ###Status code of createClientDept is - "+statusCode);
		String user = responseEntity.getBody();
		System.out.println("User is - "+user);
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("Response Headers is - "+responseHeaders);

	}

	// Calling GET using RestTemplate exchange()
	public static void getClientDeptList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				SERVER_BASE_URL, HttpMethod.GET, entity, String.class);

		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println(" ###Status code of getClientDeptList is - "+statusCode);
		String user = responseEntity.getBody();
		System.out.println("User is - "+user);
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("Response Headers is - "+responseHeaders);
	}

	// Calling GET by ID using RestTemplate exchange()
	public static void getClientDeptById(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				SERVER_BASE_URL+id, HttpMethod.GET, entity, String.class);

		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println(" ###Status code of getClientDeptById is - "+statusCode);
		String user = responseEntity.getBody();
		System.out.println("User is - "+user);
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("Response Headers is - "+responseHeaders);
	}

	// Calling PUT using RestTemplate exchange()
	public static void updateClientDept(int id, Department dept) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Department> entity = new HttpEntity<Department>(dept,headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				SERVER_BASE_URL+id, HttpMethod.PUT, entity, String.class);

		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println(" ###Status code of putClientDeptById is - "+statusCode);
		String user = responseEntity.getBody();
		System.out.println("User is - "+user);
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("Response Headers is - "+responseHeaders);
	}

	// Calling DELETE using RestTemplate exchange()
	public static void deleteClientDept(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Department> entity = new HttpEntity<Department>(headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				SERVER_BASE_URL+id, HttpMethod.DELETE, entity, String.class);

		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println(" ###Status code of deleteClientDeptById is - "+statusCode);
		System.out.println("User is deleted.");
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("Response Headers is - "+responseHeaders);
	}

}