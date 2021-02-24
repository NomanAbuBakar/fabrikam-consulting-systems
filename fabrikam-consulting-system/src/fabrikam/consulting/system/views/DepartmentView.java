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

public class DepartmentView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
					DepartmentView window = new DepartmentView();
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
	public DepartmentView() {
		initialize();
	}
	
	public DepartmentView(List<Employee> employees, List<Department> departments, List<Project> projects) {
		this.employees = employees;
		this.departments = departments;
		this.projects = projects;
		initialize();
	}
	
	public void trigger(DepartmentView window) {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 166, 392);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		AbstractDataLayer dl = AbstractDataLayer.getInstance();
		
		JLabel lblNewLabel = new JLabel("Deparments");
		lblNewLabel.setBounds(10, 21, 156, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		
		// Add Department
		JButton btnNewButton_1 = new JButton("Add Department");
		btnNewButton_1.setBounds(10, 62, 156, 48);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Department department = new Department();
				List<Project> projects = null;
				if (Utilities.isNullOrEmptyString(textField.getText())) {
					JOptionPane.showMessageDialog(frame, "Department can't be added without Name.");
					return;
				}
				if (ifAlreadyExist(textField.getText())) {
					JOptionPane.showMessageDialog(frame, "Department already exists!");
					return;
				}
				if (Utilities.isNullOrEmptyString(textField_1.getText())) {
					JOptionPane.showMessageDialog(frame, "Department can't be added without Budget.");
					return;
				}
				if (!Utilities.isNullOrEmptyString(textField_2.getText())) {
					projects = getProjects(textField_2.getText(), dl);
				}
				department.setName(textField.getText().trim());
				department.setBudget(Double.valueOf(textField_1.getText().trim()));
				if (!Utilities.isNullOrEmptyCollection(projects)) {
					department.setProjects(projects);
				}
				if (ifAlreadyExist(department.getName())) {
					JOptionPane.showMessageDialog(frame, "Department Already Exists!");
					return;
				}
				departments = dl.addDepartment(departments, department);
				refresh();
			}
		});
		panel.add(btnNewButton_1);
		
		// Update Department
		JButton btnNewButton_2 = new JButton("Update Department");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Department department = new Department();
				List<Project> projects = null;
				if (Utilities.isNullOrEmptyString(textField.getText())) {
					JOptionPane.showMessageDialog(frame, "Department can't be updated without Name.");
					return;
				}
				department.setName(textField.getText().trim());
				if (!Utilities.isNullOrEmptyString(textField_1.getText()) && !Utilities.validateIfNullOrInvalidDouble(Double.parseDouble(textField_1.getText()))) {
					department.setBudget(Double.valueOf(textField_1.getText().trim()));
				}
				if (!Utilities.isNullOrEmptyString(textField_2.getText())) {
					projects = getProjects(textField_2.getText(), dl);
				}
				if (!Utilities.isNullOrEmptyCollection(projects)) {
					department.setProjects(projects);
				}
				dl.updateDepartment(departments, department);
				refresh();
			}
		});
		btnNewButton_2.setBounds(10, 121, 156, 48);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Remove Department");
		btnNewButton.setBounds(10, 180, 156, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Department department = new Department();
				if (Utilities.isNullOrEmptyString(textField.getText())) {
					JOptionPane.showMessageDialog(frame, "Department can't be removed without Name.");
					return;
				}
				department.setName(textField.getText().trim());
				departments = dl.removeDepartment(departments, department);
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
		
//		JScrollBar scrollBar = new JScrollBar();
//		scrollBar.setBounds(990, 22, 17, 344);
//		frame.getContentPane().add(scrollBar);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(219, 64, 219, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Budget");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(219, 122, 219, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblSalary = new JLabel("Project Names (Comma Seperated)");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalary.setBounds(219, 180, 219, 14);
		frame.getContentPane().add(lblSalary);
		
		JTextArea txtDepts = new JTextArea();
		txtDepts.setColumns(3);
		txtDepts.setBounds(502, 22, 488, 344);
		JScrollPane scrollBar = new JScrollPane(txtDepts);
		//scrollBar.setBounds(990, 22, 17, 344);
		scrollBar.setBounds(502, 22, 488, 344);
		//txtrProjects.setLineWrap(true);
		showDepartments(txtDepts);
		//frame.getContentPane().add(txtrProjects);
		frame.getContentPane().add(scrollBar);
				
	}
	
	private void refresh() {
		DepartmentView emp;
		emp = new DepartmentView(employees, departments, projects);
		frame.dispose();
		emp.trigger(emp);
	}
	
	private void showDepartments(JTextArea jTextArea) {
		StringBuilder sb = new StringBuilder();
		Integer counter = 0;
		if (!Utilities.isNullOrEmptyCollection(departments)) {
			for (Department department : departments) {
				++counter;
				sb.append(" Department " + String.valueOf(counter));
				if (!Utilities.isNullOrEmptyString(department.getName())) {
					sb.append("\n > Name: " + department.getName().toString());
				}
				if (!Utilities.validateIfNullOrInvalidDouble(department.getBudget())) {
					sb.append("\n > Budget: " + department.getBudget().toString());
				}
				if (!Utilities.isNullOrEmptyCollection(department.getProjects())) {
					sb.append("\n > Projects: " );
					if (department.getProjects().size() == 1) {
						sb.append(department.getProjects().get(0).getName());
					} else {
						for (int i = 0; i< department.getProjects().size() ; i++) {
							if (i == (department.getProjects().size() -1)) {
								sb.append(" and " +department.getProjects().get(i).getName());
							} else if (i == (department.getProjects().size() -2)) {
								sb.append(department.getProjects().get(i).getName());
							} else {
								sb.append(department.getProjects().get(i).getName() + ", ");
							}
						}
					}
				}
				sb.append("\n\n\n");
			}
			jTextArea.setText(sb.toString());
		}
	}
	
	private List<Project> getProjects(String commaSeperatedProjectName, AbstractDataLayer dl) {
		String [] projects = commaSeperatedProjectName.split(",");
		List<Project> projcts = new ArrayList<>();
		for (String project : projects)
		{
			projcts.addAll(dl.getProjectByName(this.projects, project.trim()));
		}
		return projcts;
	}
	
	private boolean ifAlreadyExist(String name) {
		for (Department dpt : departments) {
			if (name.trim().equalsIgnoreCase(dpt.getName())) {
				return true;
			}
		}
		return false;
	}
}
