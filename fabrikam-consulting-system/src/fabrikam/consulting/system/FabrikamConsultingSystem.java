package fabrikam.consulting.system;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;

import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;
import fabrikam.consulting.system.views.Dashboard;

public class FabrikamConsultingSystem {
	
	static List<Employee> employees = new ArrayList<>();
	static List<Department> departments = new ArrayList<>();
	static List<Project> projects = new ArrayList<>();
	
	public static void main(String[] args) throws BadLocationException {
		System.out.print("Welcome to Fabrikum Consulting System");
		
		Department d = new Department();
		d.setName("Software Department");
		d.setBudget(50000.00);
		d.setProjects(projects);
		departments.add(d);
		
		Project p = new Project();
		Project p1 = new Project();
		Project p2 = new Project();
		p.setProjectId(1);
		p.setName("P1");
		p.setBudget(10000.00);
		p.setDepartment(d);
		p.setEmployees(employees);
		
		p1.setProjectId(1);
		p1.setName("P2");
		p1.setBudget(10000.00);
		p1.setDepartment(d);
		p1.setEmployees(employees);
		
		p2.setProjectId(1);
		p2.setName("P3");
		p2.setBudget(10000.00);
		p2.setDepartment(d);
		p2.setEmployees(employees);
		projects.add(p);
		projects.add(p1);
		projects.add(p2);
		
		Employee e = new Employee();
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		e.setEmployeeId(1);
		e.setName("John");
		e.setProject(null);
		e.setSalary(20000.00);
		
		e1.setEmployeeId(2);
		e1.setName("Alan");
		e1.setProject(null);
		e1.setSalary(20000.00);
		
		e2.setEmployeeId(3);
		e2.setName("Walker");
		e2.setProject(null);
		e2.setSalary(20000.00);
		
		e3.setEmployeeId(4);
		e3.setName("Don");
		e3.setProject(null);
		e3.setSalary(20000.00);
		employees.add(e);
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		Dashboard dashboard = new Dashboard(employees, departments, projects);
		dashboard.trigger(dashboard);
	}
}
