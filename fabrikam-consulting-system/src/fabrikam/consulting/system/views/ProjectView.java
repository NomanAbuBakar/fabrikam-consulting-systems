package fabrikam.consulting.system.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;

import fabrikam.consulting.system.data.layer.AbstractDataLayer;
import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;
import fabrikam.consulting.utils.Utilities;

public class ProjectView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private List<Employee> employees = null;
	private List<Department> departments = null;
	private List<Project> projects = null;
	private JTextField textField_4;

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
		frame.setBounds(100, 100, 1057, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		AbstractDataLayer dl = AbstractDataLayer.getInstance();
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 166, 392);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Projects");
		lblNewLabel.setBounds(10, 21, 156, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Add Project");
		btnNewButton_1.setBounds(10, 62, 156, 48);
		
		// Add Project
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				Project project = new Project();
				List<Department> dpartments = new ArrayList<>();
				List<Employee> emplyees = null;
				
				if (Utilities.isNullOrEmptyString(textField.getText())) {
					JOptionPane.showMessageDialog(frame, "Project can't be added without Id.");
					return;
				}
				if (Utilities.isNullOrEmptyString(textField_1.getText())) {
					JOptionPane.showMessageDialog(frame, "Project can't be added without Name.");
					return;
				}
				if (Utilities.isNullOrEmptyString(textField_2.getText())) {
					JOptionPane.showMessageDialog(frame, "Project can't be added without Budget.");
					return;
				}
				project.setProjectId(Integer.parseInt(textField.getText().trim()));
				if (!Utilities.isNullOrEmptyString(textField_1.getText())) {
					project.setName(textField_1.getText().trim());
				}
				if (!Utilities.isNullOrEmptyString(textField_2.getText()) && !Utilities.validateIfNullOrInvalidDouble(Double.parseDouble(textField_2.getText()))) {
					project.setBudget(Double.parseDouble(textField_2.getText().trim()));
				}
				// Department
				dpartments = dl.getDepartmentByName(departments, textField_3.getText());
				if (!Utilities.isNullOrEmptyCollection(dpartments)) {
					project.setDepartment(dpartments.get(0));
				}
				// Employees
				if (!Utilities.isNullOrEmptyString(textField_4.getText())) {
					emplyees = getEmployees(textField_4.getText().trim(), dl);
				}
				if (!Utilities.isNullOrEmptyCollection(emplyees)) {
					project.setEmployees(emplyees);
				}
				if (ifAlreadyExist(project.getProjectId())) {
					JOptionPane.showMessageDialog(frame, "Project Already Exists!");
					return;
				}
				dl.addProject(projects, project);
				refresh();
				
			}
		});
		panel.add(btnNewButton_1);
		
		// Update Project
		JButton btnNewButton_2 = new JButton("Update Project");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project project = new Project();
				List<Department> dpartments = new ArrayList<>();
				List<Employee> employees = null;
				if (Utilities.isNullOrEmptyString(textField.getText())) {
					JOptionPane.showMessageDialog(frame, "Project can't be updated without Id.");
					return;
				}
				if (!Utilities.isNullOrEmptyString(textField_3.getText())) {
					dpartments = dl.getDepartmentByName(departments, textField_3.getText().trim());
				}
				if (!Utilities.isNullOrEmptyString(textField_4.getText())) {
					employees = getEmployees(textField_4.getText().trim(), dl);
				}
				
				project.setProjectId(Integer.parseInt(textField.getText().trim()));
				if (!Utilities.isNullOrEmptyString(textField_1.getText())) {
					project.setName(textField_1.getText().trim());
				}
				if (!Utilities.isNullOrEmptyString(textField_2.getText()) && !Utilities.validateIfNullOrInvalidDouble(Double.parseDouble(textField_2.getText()))) {
					project.setBudget(Double.parseDouble(textField_2.getText().trim()));
				}
				if (!Utilities.isNullOrEmptyCollection(dpartments)) {
					if (!ifDeptAlreadyExist(dpartments.get(0).getName())) {
						JOptionPane.showMessageDialog(frame, "Requested department for update doesn't exist!");
						return;
					}
					project.setDepartment(dpartments.get(0));
				}
				if (!Utilities.isNullOrEmptyCollection(employees)) {
					project.setEmployees(employees);
				}
				if (!ifAlreadyExist(project.getProjectId())) {
					JOptionPane.showMessageDialog(frame, "Requested Project doesn't exist!");
					return;
				}
				dl.updateProject(projects, project);
				refresh();
			}
		});
		btnNewButton_2.setBounds(10, 121, 156, 48);
		panel.add(btnNewButton_2);
		
		// Remove Employee
		JButton btnNewButton = new JButton("Remove Project");
		btnNewButton.setBounds(10, 180, 156, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project project = new Project();
				if (Utilities.isNullOrEmptyString(textField.getText())) {
					JOptionPane.showMessageDialog(frame, "Project can't be removed without Id.");
					return;
				}
				project.setProjectId(Integer.parseInt(textField.getText().trim()));
				if (!ifAlreadyExist(Integer.parseInt(textField.getText().trim()))) {
					JOptionPane.showMessageDialog(frame, "Request Project doesn't exist.");
					return;
				}
				projects = dl.removeProject(projects, project);
				refresh();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setBounds(10, 239, 156, 46);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard pv;
				try {
					pv = new Dashboard(employees, departments, projects);
					frame.dispose();
					pv.trigger(pv);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(219, 82, 239, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 140, 239, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(219, 198, 239, 29);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(219, 64, 219, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(219, 122, 219, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblSalary = new JLabel("Budget");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalary.setBounds(219, 180, 219, 14);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartment.setBounds(219, 238, 219, 14);
		frame.getContentPane().add(lblDepartment);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 254, 239, 29);
		frame.getContentPane().add(textField_3);
		
		JTextArea txtrProjects = new JTextArea();
		txtrProjects.setColumns(3);
		txtrProjects.setBounds(502, 22, 488, 344);
		JScrollPane scrollBar = new JScrollPane(txtrProjects);
		//scrollBar.setBounds(990, 22, 17, 344);
		scrollBar.setBounds(502, 22, 488, 344);
		//txtrProjects.setLineWrap(true);
		showProjects(txtrProjects);
		//frame.getContentPane().add(txtrProjects);
		frame.getContentPane().add(scrollBar);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 310, 239, 29);
		frame.getContentPane().add(textField_4);
		
		JLabel lblEmployees = new JLabel("Employee Id's (Comma Seperated)");
		lblEmployees.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployees.setBounds(219, 294, 219, 14);
		frame.getContentPane().add(lblEmployees);
	}
	
	private void showProjects(JTextArea jTextArea) {
		StringBuilder sb = new StringBuilder();
		Integer counter = 0;
		if (!Utilities.isNullOrEmptyCollection(employees)) {
			for (Project project : projects) {
				++counter;
				sb.append(" Project " + String.valueOf(counter));
				if (!Utilities.validateIfNullOrInvalidInteger(project.getProjectId())) {
					sb.append("\n > Id: " + project.getProjectId().toString());
				}
				if (!Utilities.isNullOrEmptyString(project.getName())) {
					sb.append("\n > Name: " + project.getName().toString());
				}
				if (!Utilities.validateIfNullOrInvalidDouble(project.getBudget())) {
					sb.append("\n > Budget: " + project.getBudget().toString());
				}
				if (null != project.getDepartment() && !Utilities.isNullOrEmptyString(project.getDepartment().getName())) {
					sb.append("\n > Department: " +project.getDepartment().getName());
				}
				if (!Utilities.isNullOrEmptyCollection(project.getEmployees())) {
					sb.append("\n > Emloyees: " );
					if (project.getEmployees().size() == 1) {
						sb.append(project.getEmployees().get(0).getName());
					} else {
						for (int i = 0; i< project.getEmployees().size() ; i++) {
							if (i == (project.getEmployees().size() -1)) {
								sb.append(" and " +project.getEmployees().get(i).getName());
							} else if (i == (project.getEmployees().size() -2)) {
								sb.append(project.getEmployees().get(i).getName());
							} else {
								sb.append(project.getEmployees().get(i).getName() + ", ");
							}
						}
					}
				}
				sb.append("\n\n\n");
			}
			jTextArea.setText(sb.toString());
		}
	}
	
	private void refresh() {
		ProjectView prjctView;
		prjctView = new ProjectView(employees, departments, projects);
		frame.dispose();
		prjctView.trigger(prjctView);
	}
	
	private List<Employee> getEmployees(String commaSeperatedProjectName, AbstractDataLayer dl) {
		String [] employes = commaSeperatedProjectName.split(",");
		List<Employee> emplyees = new ArrayList<>();
		for (String employee : employes)
		{
			emplyees.addAll(dl.getEmployeeByName(this.employees, employee.trim()));
		}
		return emplyees;
	}
	
	private boolean ifAlreadyExist(Integer id) {
		for (Project project : projects) {
			if (id.toString().trim().equalsIgnoreCase(project.getProjectId().toString())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean ifDeptAlreadyExist(String name) {
		for (Department dpt : departments) {
			if (name.trim().equalsIgnoreCase(dpt.getName())) {
				return true;
			}
		}
		return false;
	}
}
