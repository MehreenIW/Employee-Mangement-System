package com.example.integrationproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
//@EnableScheduling
public class Application implements CommandLineRunner {
    @Autowired
    private KimaiClient client;
    @Autowired
    private BambooClient bambooRestClient;
    public List<Integer> inMemoryDb = new ArrayList<Integer>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Timer timer = new Timer("Timer");
        int delay = 3000;
        timer.scheduleAtFixedRate(task, 0L, (60 * 1000));

    }

    //	@Scheduled(fixedRate = 60000)
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            List<KimaiEmployee> allUsers = client.getAllEmployees();
            System.out.println("All the users : " + allUsers);

            for (KimaiEmployee customer : allUsers) {
                if (inMemoryDb.contains(customer.getId())) {
                    System.out.println("User already present");
                    //				continue;
                } else {
                    inMemoryDb.add(customer.getId());
                    System.out.println("User not present");

                    KimaiEmployee specificUser = client.getById(customer.getId());
                    String[] name = specificUser.getusername().split("\\s+|\\.");
                    String firstName = name[0];
                    String lastName = name[1];

                    BambooEmployee newEmployee = new BambooEmployee(firstName, lastName, Arrays.toString(specificUser.getRole()));
                    bambooRestClient.addNewEmployee(newEmployee);
                    System.out.println(newEmployee);

                }

            }
            System.out.println(inMemoryDb);
        }
    };

}