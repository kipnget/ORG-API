package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        Employee employee=setEmployee();
        assertEquals("nehemiah",employee.getName());
    }

    @Test
    public void getPosition() {
        Employee employee=setEmployee();
        assertEquals("ict manager",employee.getPosition());
    }

