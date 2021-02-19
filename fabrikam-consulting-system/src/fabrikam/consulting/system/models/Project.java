package fabrikam.consulting.system.models;

import java.util.List;

public class Project {
	private Integer projectId = null;
	private String name = null;
	private Double budget = null;
	private Department department = null;
	private List<Employee> employees = null;

	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [projectId=");
		builder.append(projectId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", budget=");
		builder.append(budget);
		builder.append(", department=");
		builder.append(department);
		builder.append(", employees=");
		builder.append(employees);
		builder.append("]");
		return builder.toString();
	}
}
