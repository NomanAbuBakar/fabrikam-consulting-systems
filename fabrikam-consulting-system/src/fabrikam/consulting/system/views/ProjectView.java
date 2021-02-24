package fabrikam.consulting.system.views;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;

import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;

public class ProjectView {

	private JFrame frame;
	private List<Employee> employees = null;
	private List<Department> departments = null;
	private List<Project> projects = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectView window = new ProjectView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjectView() {
		initialize();
	}
	
	public ProjectView(List<Employee> employees, List<Department> departments, List<Project> projects) {
		this.employees = employees;
		this.departments = departments;
		this.projects = projects;
		initialize();
	}
	
	public void trigger(ProjectView window) {
		try {
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
