package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void DepartmentInstantiatesCorrectly() throws Exception{
        Department department =setupDepartment();
        assertTrue(department instanceof Department);
    }
    @Test
    public void getName() {
        Department department =setupDepartment();
        assertEquals("ICT", department.getName());
    }
    @Test
    public void getDescription() {
        Department department =setupDepartment();
        assertEquals("ict support", department.getDescription());
    }

}