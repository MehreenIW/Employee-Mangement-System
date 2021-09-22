package com.example.integrationproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private Logger logging = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private KimaiClient client;

    @Autowired
    private BambooClient bambooRestClient;

    @Autowired
    private InMemoryDb inMemoryDb;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        String argument = args[0];
        int period = Integer.parseInt(argument);
        logging.info("The timer interval is : " + period + " min");
        Timer timer = new Timer("Timer");
        timer.scheduleAtFixedRate(task, 0L, period * (60 * 1000));

    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            List<KimaiEmployee> allUsers = client.getAllEmployees();
            logging.info("All the users : " + allUsers);

            for (KimaiEmployee customer : allUsers) {
                if (inMemoryDb.getInMemoryDb().contains(customer.getId())) {
                    logging.info("User already present");
                    continue;
                } else {
                    inMemoryDb.getInMemoryDb().add(customer.getId());
                    logging.info("User not present");

                    KimaiEmployee specificUser = client.getById(customer.getId());
                    String[] name = specificUser.getusername().split("\\s+|\\.");
                    String firstName = name[0];
                    String lastName = name[1];

                    BambooEmployee newEmployee = new BambooEmployee(firstName, lastName, Arrays.toString(specificUser.getRole()));
                    bambooRestClient.addNewEmployee(newEmployee);
                    System.out.println(newEmployee);

                }

            }
            logging.info("ID of users in Kimai sent to Bamboo " + inMemoryDb.getInMemoryDb().toString());
        }
    };

}