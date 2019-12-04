import com.google.gson.Gson;
import dao.Sql2oEmployeeDao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import models.Department;
import models.Employee;
import models.News;
import org.sql2o.*;
import static  spark.Spark.*;

public class App {

    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);


        Sql2oNewsDao newsDao;
        Sql2oDepartmentDao departmentDao; //
        Sql2oEmployeeDao employeeDao;
        Connection conn;
        Gson gson= new Gson();

//        String connectionString = "jdbc:postgresql://localhost:5432/organapi";
//        Sql2o sql2o = new Sql2o(connectionString, "nehemiah", "123");

        departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        employeeDao = new Sql2oEmployeeDao(DB.sql2o);
        newsDao = new Sql2oNewsDao(DB.sql2o);
        final String cannotBeEmptyMsg = "An error occured",cannotBeEmpty;
//        conn = sql2o.open();
        staticFileLocation("/public");

        get("/",((request, response) -> "Welcome to organisational api"));

        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());//send it back to be displayed
        });
        get("/employees", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(employeeDao.getAll());//send it back to be displayed
        });
        get("/news", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(newsDao.getAll());//send it back to be displayed
        });


        //find department by id
        get("/departments/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findById(id));
        });

        //get news by department id
        get("/news/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int department_id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(newsDao.getAllNewsByDepartment(department_id));
        });

        //get employees in a department
        get("/employees/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int department_id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(employeeDao.getAllEmployeesByDepartment(department_id));
        });

        //post new department
        post("/departments/new", "application/json", (req, res) -> { // here we accept a request in JSON
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.type("application/json");
            res.status(201);// update the response status code
            return gson.toJson(department);
        });


        //create new employee
        post("/employees/new", "application/json", (req, res) -> {
            Employee employee = gson.fromJson(req.body(), Employee.class);
            employeeDao.add(employee);
            res.type("application/json");
            res.status(201);
            return gson.toJson(employee);
        });

        // create news
        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.type("application/json");
            res.status(201);
            return gson.toJson(news);
        });





    }
}
