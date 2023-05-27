package net.youtube.springboot.controller;

import net.youtube.springboot.model.Employee;
import net.youtube.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//   Display List Of Employees

    @GetMapping ("/")
    public String viewHomePage(Model model){

//        model.addAttribute("listEmployees",employeeService.getAllEmployees());
//        return "index";

        return findPaginated(1, "firstName" , "asc" , model );

    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //Create Model attribute to bind form data

        Employee employee = new Employee();

        model.addAttribute("employee",employee);

        return "new_employee";
    }

    @PostMapping("saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        // Save Employee To the Data Base

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id , Model model){

        // Get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee",employee);

        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id ){

        // call delete employee method

        this.employeeService.deleteEmployeeById(id);

        return "redirect:/";
    }

    // we need this type of url now >>> /page/1?sortField=name&sortDir=asc
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo ,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,

                                Model model){

        int pageSize = 5;

        Page<Employee> page = employeeService.findPaginated(pageNo , pageSize , sortField , sortDir);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage" , pageNo);
        model.addAttribute("totalPages" , page.getTotalPages());
        model.addAttribute("totalItems" , page.getTotalElements());

        // these three attribute added for Sort feature
        model.addAttribute("sortField" , sortField );
        model.addAttribute("sortDir" , sortDir );
        model.addAttribute("reverseSortDir" , sortDir.equals("asc") ? "desc" : "asc" );


        model.addAttribute("listEmployees" , listEmployees);

        return "index";

    }
}
