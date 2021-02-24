package fabrikam.consulting.system.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

import fabrikam.consulting.system.data.layer.AbstractDataLayer;
import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;
import fabrikam.consulting.utils.Utilities;

public class EmployeeView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private List<Employee> employees = null;
	private List<Department> departments = null;
	private List<Project> projects = null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeView window = new EmployeeView();
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
	public EmployeeView() {
		initialize();
	}
	
	public EmployeeView(List<Employee> employees, List<Department> departments, List<Project> projects) {
		this.employees = employees;
		this.departments = departments;
		this.projects = projects;
		initialize();
	}
	
	public void trigger(EmployeeView window) {
		try {
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void trigger(EmployeeView window, List<Employee> employees, List<Department> departments, List<Project> projects) {
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
		
		JLabel lblNewLabel = new JLabel("Employees");
		lblNewLabel.setBounds(10, 21, 156, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Add Employee");
		btnNewButton_1.setBounds(10, 62, 156, 48);
		
		// Add Employee
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				Employee employee = new Employee();
				if (Utilities.isNullOrEmptyString(textField.getText())) {
					JOptionPane.showMessageDialog(frame, "Employee can't be added without Id.");
					return;
				}
				if (Utilities.isNullOrEmptyString(textField_1.getText())) {
					JOptionPane.showMessageDialog(frame, "Employee can't be added without Name.");
					return;
				}
				if (Utilities.isNullOrEmptyString(textField_2.getText())) {
					JOptionPane.showMessageDialog(frame, "Employee can't be added without Salary.");
					return;
				}
				if (ifAlreadyExist(Integer.parseInt(textField.getText().trim()))) {
					JOptionPane.showMessageDialog(frame, "Employee Already Exists!");
					return;
				}
				List<Project> project = dl.getProjectByName(projects, textField_3.getText());
				employee.setEmployeeId(Integer.parseInt(textField.getText().trim()));
				employee.setName(textField_1.getText());
				if (null != project) {
					employee.setProject(project.get(0));
				}
				employee.setSalary(Double.valueOf(textField_2.getText().trim()));
				dl.addEmployee(employees, employee);
				refresh();
				
			}
		});
		panel.add(btnNewButton_1);
		
		// Update Employee
		JButton btnNewButton_2 = new JButton("Update Employee");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee employee = new Employee();
				List<Project> project= null;
				if (Utilities.isNullOrEmptyString(textField.getText().trim())) {
					JOptionPane.showMessageDialog(frame, "Employee can't be updated without Id.");
					return;
				}
				if (!Utilities.isNullOrEmptyString(textField_3.getText().trim())) {
					project = dl.getProjectByName(projects, textField_3.getText().trim());
				}
				
				employee.setEmployeeId(Integer.parseInt(textField.getText()));
				employee.setName(textField_1.getText().trim());
				if (!Utilities.isNullOrEmptyString(textField_2.getText().trim())) {
					employee.setSalary(Double.valueOf(textField_2.getText().trim()));
				}
				if (null != project) {
					employee.setProject(project.get(0));
				}
				employee = dl.updateEmployee(employees, employee);
				if (null == employee) {
					JOptionPane.showMessageDialog(frame, "Employee not found!.");
					return;
				}
				refresh();
			}
		});
		btnNewButton_2.setBounds(10, 121, 156, 48);
		panel.add(btnNewButton_2);
		
		// Remove Employee
		JButton btnNewButton = new JButton("Remove Employee");
		btnNewButton.setBounds(10, 180, 156, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee employee = new Employee();
				if (Utilities.isNullOrEmptyString(textField.getText())) {
					JOptionPane.showMessageDialog(frame, "Employee can't be removed without Id.");
					return;
				}
				List<Project> project = dl.getProjectByName(projects, textField_2.getText());
				employee.setEmployeeId(Integer.parseInt(textField.getText().trim()));
				employee.setName(textField_1.getText());
				employee.setProject(project.get(0));
				if (!Utilities.isNullOrEmptyString(textField_3.getText())) {
					employee.setSalary(Double.valueOf(textField_3.getText().trim()));
				}
				employees = dl.removeEmployee(employees, employee);
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
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalary.setBounds(219, 180, 219, 14);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblDepartment = new JLabel("Project Name");
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
		showEmployees(txtrProjects);
		//frame.getContentPane().add(txtrProjects);
		frame.getContentPane().add(scrollBar);
	}
	
	private void showEmployees(JTextArea jTextArea) {
		StringBuilder sb = new StringBuilder();
		Integer counter = 0;
		if (!Utilities.isNullOrEmptyCollection(employees)) {
			for (Employee employee : employees) {
				++counter;
				sb.append(" Employee " + String.valueOf(counter));
				if (!Utilities.validateIfNullOrInvalidInteger(employee.getEmployeeId())) {
					sb.append("\n > Id: " + employee.getEmployeeId().toString());
				}
				if (!Utilities.isNullOrEmptyString(employee.getName())) {
					sb.append("\n > Name: " + employee.getName().toString());
				}
				if (!Utilities.validateIfNullOrInvalidDouble(employee.getSalary())) {
					sb.append("\n > Salary: " + employee.getSalary().toString());
				}
				if (null != employee.getProject() && !Utilities.isNullOrEmptyString(employee.getProject().getName())) {
					sb.append("\n > Project: " +employee.getProject().getName());
				}
				sb.append("\n\n\n");
			}
			jTextArea.setText(sb.toString());
		}
	}
	
	private void refresh() {
		EmployeeView emp;
		emp = new EmployeeView(employees, departments, projects);
		frame.dispose();
		emp.trigger(emp);
	}
	
	private boolean ifAlreadyExist(Integer id) {
		for (Employee emp : employees) {
			if (id.toString().trim().equalsIgnoreCase(emp.getEmployeeId().toString())) {
				return true;
			}
		}
		return false;
	}
	
	private void insertTableRow(DefaultTableModel model) {
		if (!Utilities.isNullOrEmptyCollection(this.employees)) {
			for (Employee employee : this.employees) {
				model.insertRow(model.getRowCount(), new Object[] {employee.getName(), employee.getSalary(), "P1"});
			}
		}
	}
}
