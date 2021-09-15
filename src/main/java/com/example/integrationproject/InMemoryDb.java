package com.example.integrationproject;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryDb {

    List<Integer> inMemoryDb = new ArrayList<Integer>();

    public List<Integer> getInMemoryDb() {
        return inMemoryDb;
    }

}
