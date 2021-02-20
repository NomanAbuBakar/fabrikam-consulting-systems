package fabrikam.consulting.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;

public class Utilities {
	public static boolean isNullOrEmptyCollection(final Collection<?> c) {
	    return c == null || c.isEmpty();
	}
	
	public static boolean isNullOrEmptyMap(final Map<?,?> c) {
	    return c == null || c.isEmpty();
	}
	
	public static boolean isNullOrEmptyString(String s) {
	    return s == null ||s.isEmpty() || s.trim().length() < 1;
	}
	
	public static boolean validateIfNullOrInvalidInteger(Integer number) {
		if (null == number || number < 0) {
			return true;
		}
		return false;
	}
	
	public static boolean validateIfNullOrInvalidDouble(Double number) {
		if (null == number) {
			return true;
		}
		return false;
	}
	
	public static boolean ifEmployeeExists(List<Employee> employees, Employee employee) {
		if (null == employee || validateIfNullOrInvalidInteger(employee.getEmployeeId())) {
			return false;
		}
		for (Employee emp : employees) {
			if (employee.getEmployeeId().toString().equalsIgnoreCase(emp.getEmployeeId().toString())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean ifDepartmentExists(List<Department> departments, Department department) {
		if (null == department || isNullOrEmptyString(department.getName())) {
			return false;
		}
		for (Department dpt : departments) {
			if (department.getName().equalsIgnoreCase(dpt.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean ifProjectExists(List<Project> projects, Project project) {
		if (null == project || validateIfNullOrInvalidInteger(project.getProjectId())) {
			return false;
		}
		for (Project prjct : projects) {
			if (project.getProjectId().toString().equalsIgnoreCase(prjct.getProjectId().toString())) {
				return true;
			}
		}
		return false;
	}
}
