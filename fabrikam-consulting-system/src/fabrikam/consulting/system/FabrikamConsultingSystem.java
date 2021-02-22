package fabrikam.consulting.system;

import java.util.List;

import javax.swing.text.BadLocationException;

import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;
import fabrikam.consulting.system.views.Dashboard;

public class FabrikamConsultingSystem {
	
	static List<Employee> employees = null;
	static List<Department> departments = null;
	static List<Project> projects = null;
	
	public static void main(String[] args) throws BadLocationException {
		System.out.print("Welcome to Fabrikum Consulting System");
		Dashboard dashboard = new Dashboard();
		dashboard.trigger();
	}
}
