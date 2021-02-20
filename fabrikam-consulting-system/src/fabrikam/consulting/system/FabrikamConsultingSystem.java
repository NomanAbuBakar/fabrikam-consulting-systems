package fabrikam.consulting.system;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;
import fabrikam.consulting.system.views.EmployeeView;

public class FabrikamConsultingSystem {
	
	static List<Employee> employees = null;
	static List<Department> departments = null;
	static List<Project> projects = null;
	private JFrame frame;
	
	public static void main(String[] args) {
		System.out.print("Welcome to Fabrikum Consulting System");
	
	        EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FabrikamConsultingSystem window = new FabrikamConsultingSystem();
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
	public FabrikamConsultingSystem() {
		initialize();
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
