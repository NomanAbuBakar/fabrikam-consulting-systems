package fabrikam.consulting.system.data.layer;

import java.util.ArrayList;
import java.util.List;

import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;
import fabrikam.consulting.utils.Utilities;

public class DataLayerImpl extends AbstractDataLayer {
	
	@Override
	public List<Employee> addEmployee(Employee employee) {
		if (Utilities.validateIfNullOrInvalidInteger(employee.getEmployeeId())) {
			System.out.println("Dapartment can't be added as employee id has been provided null/empty!");
			return null;
		}
		List <Employee> employees = null;
		System.out.println("Going to add Employee with id: [" +employee.getEmployeeId()+ "]");
		employees = new ArrayList<>();
		employees.add(employee);
		return employees;
	}
	
	@Override
	public List<Employee> addEmployee(List<Employee> employees, Employee employee) {
		if (Utilities.validateIfNullOrInvalidInteger(employee.getEmployeeId())) {
			System.out.println("Dapartment can't be added as employee id has been provided null/empty!");
			return employees;
		}
		System.out.println("Going to add Employee with id: [" +employee.getEmployeeId()+ "]");
		if (Utilities.isNullOrEmptyCollection(employees)) {
			employees = new ArrayList<>();
			employees.add(employee);
			return employees;
		} else {
			employees.add(employee);
			return employees;
		}
	}
	
	@Override
	public Employee updateEmployee(List<Employee> employees, Employee employee) {
		if (Utilities.isNullOrEmptyCollection(employees)) {
			System.out.println("Can't return employee as no employees found in system.");
			return null;
		}
		if (null == employee) {
			System.out.println("Can't return employee as employee content not been passed in request!");
			return null;
		}
		if (Utilities.validateIfNullOrInvalidInteger(employee.getEmployeeId())) {
			System.out.println("Can't return employee as employee id has not been passed in request!");
			return null;
		}
		System.out.println("Going to update Employee with id: [" +employee.getEmployeeId()+ "]");
		for (Employee emp : employees) {
			if (employee.getEmployeeId().toString().equalsIgnoreCase(emp.getEmployeeId().toString())) {
				if (!Utilities.isNullOrEmptyString(employee.getName())) {
					emp.setName(employee.getName());
				}
				if (!Utilities.validateIfNullOrInvalidDouble(employee.getSalary())) {
					emp.setSalary(employee.getSalary());
				}
				if (null != employee.getProject()) {
					emp.setProject(employee.getProject());
				}
				return emp;
			}
		}
		return null;
	}
	
	@Override
	public List<Employee> removeEmployee(List<Employee> employees, Employee employee) {
		List<Employee> filteredEmployees = null;
		if (Utilities.isNullOrEmptyCollection(employees)) {
			System.out.println("Can't remove employee as there is already no employee found.");
			return employees;
		}
		if (Utilities.validateIfNullOrInvalidInteger(employee.getEmployeeId())) {
			System.out.println("Can't remove employee as no employee id has been passed in request!");
			return employees;
		}
		System.out.println("Going to add Employee with id: [" +employee.getEmployeeId()+ "");
		filteredEmployees = new ArrayList<>();
		for (Employee emp : employees) {
			if (!employee.getEmployeeId().toString().equalsIgnoreCase(emp.getEmployeeId().toString())) {
				filteredEmployees.add(emp);
			}
		}
		return filteredEmployees;
	}
	
	@Override
	public Employee getEmployeeById(List<Employee> employees, Integer employeeId) {
		if (Utilities.isNullOrEmptyCollection(employees)) {
			System.out.println("Can't return employee as no employees found in system.");
			return null;
		}
		if (Utilities.validateIfNullOrInvalidInteger(employeeId)) {
			System.out.println("Can't return employee as employee id has not been passed in request!");
			return null;
		}
		System.out.println("Going to get Employee with id: [" +employeeId+ "]");
		
		for (Employee emp : employees) {
			if (employeeId.toString().equalsIgnoreCase(emp.getEmployeeId().toString())) {
				return emp;
			}
		}
		return null;
	}
	
	@Override
	public List<Employee> getEmployeeByName(List<Employee> employees, String name) {
		List<Employee> filteredEmployees = null;
		if (Utilities.isNullOrEmptyCollection(employees)) {
			System.out.println("Can't return employee as no employees found in system.");
			return employees;
		}
		if (Utilities.isNullOrEmptyString(name)) {
			System.out.println("Can't return employee as employee name has not been passed in request!");
			return employees;
		}
		System.out.println("Going to get Employee with name: [" +name+ "]");
		filteredEmployees = new ArrayList<>();
		for (Employee emp : employees) {
			if (name.equalsIgnoreCase(emp.getName())) {
				filteredEmployees.add(emp);
			}
		}
		return filteredEmployees;
	}
	
	@Override
	public List<Employee> getEmployees(List<Employee> employees, Employee employee) {
		List<Employee> filteredEmployees = null;
		if (Utilities.isNullOrEmptyCollection(employees)) {
			System.out.println("Can't return employee as no employees found in system.");
			return employees;
		}
		if (Utilities.validateIfNullOrInvalidInteger(employee.getEmployeeId()) && Utilities.isNullOrEmptyString(employee.getName())) {
			System.out.println("Can't return employee as employee id/name has not been passed in request!");
			return employees;
		}
		System.out.println("Going to get Employee with id: [" +employee.getEmployeeId()+ "] and name: [" +employee.getName()+ "]");
		filteredEmployees = new ArrayList<>();
		for (Employee emp : employees) {
			if (employee.getEmployeeId().toString().equalsIgnoreCase(emp.getEmployeeId().toString())) {
				filteredEmployees.add(emp);
				continue;
			}
			if (!Utilities.isNullOrEmptyString(employee.getName()) && employee.getName().equalsIgnoreCase(emp.getName())) {
				filteredEmployees.add(emp);
			}
		}
		return filteredEmployees;
	}
	
	@Override
	public List<Department> addDepartment(Department department) {
		if (Utilities.isNullOrEmptyString(department.getName())) {
			System.out.println("Dapartment can't be added as deparment name has been provided null/empty!");
			return null;
		}
		List <Department> departments = null;
		System.out.println("Going to add Department with Name: [" +department.getName()+ "]");
		departments = new ArrayList<>();
		departments.add(department);
		return departments;
	}
	
	@Override
	public List<Department> addDepartment(List<Department> departments, Department department) {
		if (Utilities.isNullOrEmptyString(department.getName())) {
			System.out.println("Dapartment can't be added as deparment name has been provided null/empty!");
			return departments;
		}
		System.out.println("Going to add Department with Name: [" +department.getName()+ "]");
		if (Utilities.isNullOrEmptyCollection(departments)) {
			departments = new ArrayList<>();
			departments.add(department);
			return departments;
		} else {
			departments.add(department);
			return departments;
		}
	}
	
	@Override
	public void updateDepartment(List<Department> departments, Department department) {
		if (Utilities.isNullOrEmptyCollection(departments)) {
			System.out.println("Can't update department as no departments found in system.");
			return;
		}
		if (Utilities.isNullOrEmptyString(department.getName())) {
			System.out.println("Can't update department as department name has not been passed in request!");
			return;
		}
		System.out.println("Going to update Employee with id: [" +department.getName()+ "]");
		for (Department dpt : departments) {
			if (department.getName().equalsIgnoreCase(dpt.getName())) {
					if (!Utilities.validateIfNullOrInvalidDouble(department.getBudget())) {
						dpt.setBudget(department.getBudget());
					}
					if (!Utilities.isNullOrEmptyCollection(department.getProjects()) ) {
						dpt.setProjects(department.getProjects());
					}
			}
		}
	}
	
	@Override
	public void updateDepartment(List<Department> departments, Department department, boolean addProjects) {
		if (Utilities.isNullOrEmptyCollection(departments)) {
			System.out.println("Can't update department as no departments found in system.");
			return;
		}
		if (Utilities.isNullOrEmptyString(department.getName())) {
			System.out.println("Can't update department as department name has not been passed in request!");
			return;
		}
		System.out.println("Going to update Employee with id: [" +department.getName()+ "]");
		for (Department dpt : departments) {
			if (department.getName().equalsIgnoreCase(dpt.getName())) {
					if (!Utilities.validateIfNullOrInvalidDouble(department.getBudget())) {
						dpt.setBudget(department.getBudget());
					}
					if (!Utilities.isNullOrEmptyCollection(department.getProjects())) {
						if (addProjects) {
							dpt.getProjects().addAll(department.getProjects());
						} else {
							dpt.setProjects(department.getProjects());
						}
					}
			}
		}
	}

	@Override
	public List<Department> removeDepartment(List<Department> departments, Department department) {
		List<Department> filteredDepartments = null;
		if (Utilities.isNullOrEmptyCollection(departments)) {
			System.out.println("Can't remove department as there is already no department found.");
			return departments;
		}
		if (null == department) {
			System.out.println("Can't remove department has been provided null.");
			return departments;
		}
		
		if (Utilities.isNullOrEmptyString(department.getName())) {
			System.out.println("Can't remove department as no department name has been passed in request!");
			return departments;
		}
		System.out.println("Going to remove department with id: [" +department.getName()+ "");
		filteredDepartments = new ArrayList<>();
		for (Department dpt : departments) {
			if (!department.getName().equalsIgnoreCase(dpt.getName())) {
				filteredDepartments.add(dpt);
			}
		}
		return filteredDepartments;
	}
	
	@Override
	public List<Department> getDepartmentByName(List<Department> departments, String name) {
		List<Department> filteredDepartments = null;
		if (Utilities.isNullOrEmptyCollection(departments)) {
			System.out.println("Can't return department as no departments found in system.");
			return departments;
		}
		if (Utilities.isNullOrEmptyString(name)) {
			System.out.println("Can't return department as department name has not been passed in request!");
			return departments;
		}
		System.out.println("Going to get department with name: [" +name+ "]");
		filteredDepartments = new ArrayList<>();
		for (Department dpt : departments) {
			if (name.equalsIgnoreCase(dpt.getName())) {
				filteredDepartments.add(dpt);
			}
		}
		return filteredDepartments;
	}
	
	@Override
	public List<Department> getDepartment(List<Department> departments, Department department) {
		List<Department> filteredDepartments = null;
		if (Utilities.isNullOrEmptyCollection(departments)) {
			System.out.println("Can't return department as no departments found in system.");
			return departments;
		}
		if (null == department) {
			System.out.println("Can't return department as no request content has been provided.");
			return departments;
		}
		if (Utilities.isNullOrEmptyString(department.getName())) {
			System.out.println("Can't return employee as department name has not been passed in request!");
			return departments;
		}
		System.out.println("Going to get Employee with name: [" +department.getName()+ "]");
		filteredDepartments = new ArrayList<>();
		for (Department dpt : departments) {
			if (department.getName().equalsIgnoreCase(dpt.getName())) {
				filteredDepartments.add(dpt);
			}
		}
		return filteredDepartments;
	}
	
	@Override
	public List<Project> addProject(Project project) {
		if (null == project) {
			System.out.println("Project can't be added as project has been provided null!");
			return null;
		}
		if (Utilities.isNullOrEmptyString(project.getName())) {
			System.out.println("Project can't be added as project name has been provided null/empty!");
			return null;
		}
		List <Project> projects = null;
		System.out.println("Going to add project with Name: [" +project.getName()+ "]");
		projects = new ArrayList<>();
		projects.add(project);
		return projects;
	}
	
	@Override
	public List<Project> addProject(List<Project> projects, Project project) {
		if (null == project) {
			System.out.println("Project can't be added as project has been provided null!");
			return null;
		}
		if (Utilities.isNullOrEmptyString(project.getName())) {
			System.out.println("Dapartment can't be added as deparment name has been provided null/empty!");
			return projects;
		}
		System.out.println("Going to add project with Name: [" +project.getName()+ "]");
		if (Utilities.isNullOrEmptyCollection(projects)) {
			projects = new ArrayList<>();
			projects.add(project);
			return projects;
		} else {
			projects.add(project);
			return projects;
		}
	}
	
	@Override
	public void updateProject(List<Project> projects, Project project) {
		if (Utilities.isNullOrEmptyCollection(projects)) {
			System.out.println("Can't update project as no project found in system.");
			return;
		}
		if (null == project) {
			System.out.println("project can't be added as project has been provided null!");
			return;
		}
		if (Utilities.isNullOrEmptyString(project.getName())) {
			System.out.println("Can't update project as project name has not been passed in request!");
			return;
		}
		System.out.println("Going to update project with id: [" +project.getName()+ "]");
		for (Project prjct : projects) {
			if (project.getName().equalsIgnoreCase(prjct.getName())) {
					if (!Utilities.validateIfNullOrInvalidDouble(project.getBudget())) {
						prjct.setBudget(project.getBudget());
					}
					if (null != project.getDepartment()) {
						prjct.setDepartment(project.getDepartment());
					}
					if (!Utilities.isNullOrEmptyCollection(project.getEmployees()) ) {
						prjct.setEmployees(project.getEmployees());
					}
			}
		}
	}
	
	@Override
	public void updateProject(List<Project> projects, Project project, boolean addEmployees) {
		if (Utilities.isNullOrEmptyCollection(projects)) {
			System.out.println("Can't update project as no projects found in system.");
			return;
		}
		if (Utilities.isNullOrEmptyString(project.getName())) {
			System.out.println("Can't update project as project name has not been passed in request!");
			return;
		}
		System.out.println("Going to update project with id: [" +project.getName()+ "]");
		for (Project prjct : projects) {
			if (project.getName().equalsIgnoreCase(prjct.getName())) {
					if (!Utilities.validateIfNullOrInvalidDouble(project.getBudget())) {
						prjct.setBudget(project.getBudget());
					}
					if (null != project.getDepartment()) {
						prjct.setDepartment(project.getDepartment());
					}
					if (!Utilities.isNullOrEmptyCollection(project.getEmployees())) {
						if (addEmployees) {
							prjct.getEmployees().addAll(project.getEmployees());
						} else {
							prjct.setEmployees(project.getEmployees());
						}
					}
			}
		}
	}

	@Override
	public List<Project> removeProject(List<Project> projects, Project project) {
		List<Project> filteredProjects = null;
		if (Utilities.isNullOrEmptyCollection(projects)) {
			System.out.println("Can't remove project as there is already no department found.");
			return projects;
		}
		if (null == projects) {
			System.out.println("Can't remove project has been provided null.");
			return projects;
		}
		
		if (Utilities.isNullOrEmptyString(project.getName())) {
			System.out.println("Can't remove project as no project name has been passed in request!");
			return projects;
		}
		System.out.println("Going to remove project with name: [" +project.getName()+ "");
		filteredProjects = new ArrayList<>();
		for (Project prjct : projects) {
			if (!project.getName().equalsIgnoreCase(prjct.getName())) {
				filteredProjects.add(prjct);
			}
		}
		return filteredProjects;
	}
	
	@Override
	public List<Project> getProjectByName(List<Project> projects, String name) {
		List<Project> filteredProjects = null;
		if (Utilities.isNullOrEmptyCollection(projects)) {
			System.out.println("Can't return project as no projects found in system.");
			return projects;
		}
		if (Utilities.isNullOrEmptyString(name)) {
			System.out.println("Can't return project as project name has not been passed in request!");
			return projects;
		}
		System.out.println("Going to get project with name: [" +name+ "]");
		filteredProjects = new ArrayList<>();
		for (Project prjct : projects) {
			if (name.equalsIgnoreCase(prjct.getName())) {
				filteredProjects.add(prjct);
			}
		}
		return filteredProjects;
	}
	
	@Override
	public List<Project> getProject(List<Project> projects, Project project) {
		List<Project> filteredProjects = null;
		if (Utilities.isNullOrEmptyCollection(projects)) {
			System.out.println("Can't return project as no departments found in system.");
			return projects;
		}
		if (null == project) {
			System.out.println("Can't return project as no request content has been provided.");
			return projects;
		}
		if (Utilities.isNullOrEmptyString(project.getName())) {
			System.out.println("Can't return project as project name has not been passed in request!");
			return projects;
		}
		System.out.println("Going to get project with name: [" +project.getName()+ "]");
		filteredProjects = new ArrayList<>();
		for (Project prjct : projects) {
			if (project.getName().equalsIgnoreCase(prjct.getName())) {
				filteredProjects.add(prjct);
			}
		}
		return filteredProjects;
	}
}
