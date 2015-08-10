package com.springapp.mvc;

import com.springapp.mvc.domain.Department;
import com.springapp.mvc.domain.Project;
import com.springapp.mvc.domain.Student;
import com.springapp.mvc.service.DepartmentService;
import com.springapp.mvc.service.EmployeeService;
import com.springapp.mvc.service.ProjectService;
import com.springapp.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private StudentService studentService;
	private ProjectService projectService;
	private EmployeeService employeeService;
	private DepartmentService departmentService;


	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	@RequestMapping(value="/insert",method = RequestMethod.GET)
	public String insert(){
		studentService.insert(new Student("John", 25));
		return "hello";
	}

	@RequestMapping(value="/insertPrj",method = RequestMethod.GET)
	public String createUpdate(){
		projectService.createUpdate(new Project("WEBSITE"));
		return "hello";
	}

	@RequestMapping(value="/insertDep",method = RequestMethod.GET)
	public String createUpdateDep(){
		departmentService.createUpdateDep(new Department("Auto"));
		return "hello";
	}
}