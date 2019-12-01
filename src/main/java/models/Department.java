package models;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private String description;
    private int total_employees;

    public Department(String name, String description, int total_employees) {
        this.name = name;
        this.description = description;
        this.total_employees = total_employees;
    }


