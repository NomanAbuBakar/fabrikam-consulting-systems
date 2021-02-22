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
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import fabrikam.consulting.system.models.Department;
import fabrikam.consulting.system.models.Employee;
import fabrikam.consulting.system.models.Project;
import fabrikam.consulting.utils.Utilities;

public class Dashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws BadLocationException 
	 */
	public Dashboard() throws BadLocationException {
		initialize();
	}
	
	public void trigger() {
		try {
			Dashboard window = new Dashboard();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws BadLocationException 
	 */
	private void initialize() throws BadLocationException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1057, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 176, 392);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fabrikum Consulting System");
		lblNewLabel.setBounds(10, 21, 156, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Employees");
		btnNewButton_1.setBounds(10, 62, 156, 48);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeView ev = new EmployeeView();
				frame.dispose();
				ev.trigger();
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Departments");
		btnNewButton_2.setBounds(10, 121, 156, 48);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentView dv = new DepartmentView();
				frame.dispose();
				dv.trigger();
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Projects");
		btnNewButton.setBounds(10, 180, 156, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectView pv = new ProjectView();
				frame.dispose();
				pv.trigger();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setBounds(10, 239, 156, 46);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnNewButton_3);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(444, 11, 17, 370);
		frame.getContentPane().add(scrollBar_1);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(724, 11, 17, 370);
		frame.getContentPane().add(scrollBar_2);
		
		JScrollBar scrollBar_3 = new JScrollBar();
		scrollBar_3.setBounds(1004, 11, 17, 370);
		frame.getContentPane().add(scrollBar_3);
		
		// Employees
		JTextPane textPaneEmp = new JTextPane();
		textPaneEmp.setBounds(214, 11, 230, 370);
		alignCenterJTextPane(textPaneEmp);
		setJTextPaneHeader(textPaneEmp, "Employees");
		frame.getContentPane().add(textPaneEmp);
		showEmployees(textPaneEmp, null);
		
		// Departments
		JTextPane textPaneDpt = new JTextPane();
		textPaneDpt.setBounds(494, 11, 230, 370);
		alignCenterJTextPane(textPaneDpt);
		setJTextPaneHeader(textPaneDpt, "Departments");
		frame.getContentPane().add(textPaneDpt);
		showDepartments(textPaneDpt, null);
		
		// Projects
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(774, 11, 230, 370);
		alignCenterJTextPane(textPane_2);
		setJTextPaneHeader(textPane_2, "Projects");
		textPane_2.setEditable(false);
		showProjects(textPane_2, null);
	    
		
		frame.getContentPane().add(textPane_2);
		
	}
	
	private void showEmployees(JTextPane jTextPane, List<Employee> employees) throws BadLocationException {
		StyledDocument document = jTextPane.getStyledDocument();
		SimpleAttributeSet attributes = new SimpleAttributeSet();
		if (!Utilities.isNullOrEmptyCollection(employees)) {
			for (Employee employee : employees) {
				document.insertString(document.getLength(), "\n"+employee.getName() , attributes);
			}
			jTextPane.setDocument(document);
		}
	}
	
	private void showDepartments(JTextPane jTextPane, List<Department> departments) throws BadLocationException {
		StyledDocument document = new DefaultStyledDocument();
		SimpleAttributeSet attributes = new SimpleAttributeSet();
		if (!Utilities.isNullOrEmptyCollection(departments)) {
			for (Department department : departments) {
				document.insertString(document.getLength(), "\n"+department.getName() , attributes);
			}
			jTextPane.setDocument(document);
		}
	}
	
	private void showProjects(JTextPane jTextPane, List<Project> projects) throws BadLocationException {
		StyledDocument document = new DefaultStyledDocument();
		SimpleAttributeSet attributes = new SimpleAttributeSet();
		if (!Utilities.isNullOrEmptyCollection(projects)) {
			for (Project project : projects) {
				document.insertString(document.getLength(), "\n"+project.getName() , attributes);
			}
			jTextPane.setDocument(document);
		}
	}
	
	private void setJTextPaneHeader(JTextPane jTextPane, String header) throws BadLocationException {
		StyledDocument document = jTextPane.getStyledDocument();
		SimpleAttributeSet attributes = new SimpleAttributeSet();
		attributes.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
		attributes.addAttribute(StyleConstants.CharacterConstants.Underline, Boolean.TRUE);
		document.insertString(document.getLength(), header, attributes);
		jTextPane.setDocument(document);
	}
	
	private void alignCenterJTextPane(JTextPane jTextPane) {
		StyledDocument doc = jTextPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}
}
