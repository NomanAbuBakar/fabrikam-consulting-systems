package fabrikam.consulting.system.data.layer;

import java.util.List;

import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;

public abstract class AbstractDataLayer {
	
	public static AbstractDataLayer getInstance() {
		return new DataLayerImpl();
	}
	
	public abstract List<Employee> addEmployee(Employee employee);
	public abstract List<Employee> addEmployee(List<Employee> employees, Employee employee);
	public abstract Employee updateEmployee(List<Employee> employees, Employee employee);
	public abstract List<Employee> removeEmployee(List<Employee> employees, Employee employee);
	public abstract Employee getEmployeeById(List<Employee> employees, Integer employeeId);
	public abstract List<Employee> getEmployeeByName(List<Employee> employees, String name);
	public abstract List<Employee> getEmployees(List<Employee> employees, Employee employee);
	public abstract List<Department> addDepartment(Department department);
	public abstract List<Department> addDepartment(List<Department> departments, Department department);
	public abstract void updateDepartment(List<Department> departments, Department department);
	public abstract void updateDepartment(List<Department> departments, Department department, boolean addProjects);
	public abstract List<Department> removeDepartment(List<Department> departments, Department department);
	public abstract List<Department> getDepartmentByName(List<Department> departments, String name);
	public abstract List<Department> getDepartment(List<Department> departments, Department department);
	public abstract List<Project> addProject(Project project);
	public abstract List<Project> addProject(List<Project> projects, Project project);
	public abstract void updateProject(List<Project> projects, Project project);
	public abstract void updateProject(List<Project> projects, Project project, boolean addEmployees);
	public abstract List<Project> removeProject(List<Project> projects, Project project);
	public abstract List<Project> getProjectByName(List<Project> projects, String name);
	public abstract List<Project> getProject(List<Project> projects, Project project);
}
