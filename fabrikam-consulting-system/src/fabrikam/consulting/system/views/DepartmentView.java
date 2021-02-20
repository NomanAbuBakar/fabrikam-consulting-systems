package fabrikam.consulting.system.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class DepartmentView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		JLabel lblNewLabel = new JLabel("Departments");
		lblNewLabel.setBounds(10, 21, 156, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Add Department");
		btnNewButton_1.setBounds(10, 62, 156, 48);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Department");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 121, 156, 48);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Delete Department");
		btnNewButton.setBounds(10, 180, 156, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setBounds(10, 239, 156, 46);
		panel.add(btnNewButton_3);
		
		JTextArea txtrProjects = new JTextArea();
		txtrProjects.setColumns(3);
		txtrProjects.setText("Projects");
		txtrProjects.setBounds(487, 22, 506, 344);
		txtrProjects.setLineWrap(true);
		frame.getContentPane().add(txtrProjects);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(995, 139, 17, 344);
		frame.getContentPane().add(scrollBar);
		
		textField = new JTextField();
		textField.setBounds(219, 88, 219, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 159, 219, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(219, 229, 219, 29);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
