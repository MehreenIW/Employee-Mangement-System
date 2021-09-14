package com.example.integrationproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private KimaiClient client;
	@Autowired
	private BambooClient bambooRestClient;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		int id = ThreadLocalRandom.current().nextInt(1000);
//		Employee newUser = new Employee("Dosmf", "dfddd@yahoo.com", "jgdffgjhg", new String[]{"ROLE_DEVELOPER"});
//		System.out.println("A newly created user "+ newUser);
//		client.create(newUser);

//		Employee employee = client.getById(id);
//		System.out.println("A newly created user "+ employee);

		//	Get all employees

		List<KimaiEmployee> allUsers = client.getAllEmployees();
		System.out.println("All the users : " + allUsers);

		for (KimaiEmployee customer : allUsers) {
			System.out.println(customer.getusername());
			System.out.println(customer.getId());

			//	Get employee by id

			KimaiEmployee specificUser = client.getById(customer.getId());
			String[] name = specificUser.getusername().split("\\s+|\\.");
			System.out.println(Arrays.toString(name));
			String firstName = name[0];
			String lastName = name[1];

			// POST

			BambooEmployee newEmployee = new BambooEmployee(firstName, lastName, Arrays.toString(specificUser.getRole()));
			System.out.println(newEmployee.getLastName());
			bambooRestClient.addNewEmployee(newEmployee);
			System.out.println(newEmployee);

		}
	}
}
