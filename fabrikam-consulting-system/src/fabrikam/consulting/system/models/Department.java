package fabrikam.consulting.system.models;

import java.util.List;

public class Department {
	private String name = null;
	private Double budget = null;
	private List<Project> projects = null;

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
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [name=");
		builder.append(name);
		builder.append(", budget=");
		builder.append(budget);
		builder.append(", projects=");
		builder.append(projects);
		builder.append("]");
		return builder.toString();
	}
}
