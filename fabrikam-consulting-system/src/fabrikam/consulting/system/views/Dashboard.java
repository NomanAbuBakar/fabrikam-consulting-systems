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
	 */
	public Dashboard() {
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
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Departments");
		btnNewButton_2.setBounds(10, 121, 156, 48);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Projects");
		btnNewButton.setBounds(10, 180, 156, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setBounds(10, 239, 156, 46);
		panel.add(btnNewButton_3);
		
		JTextArea txtrProjects = new JTextArea();
		txtrProjects.setColumns(3);
		txtrProjects.setText("Employees");
		txtrProjects.setBounds(198, 11, 245, 370);
		txtrProjects.setLineWrap(true);
		frame.getContentPane().add(txtrProjects);
		
		
		JTextArea txtrDepartments = new JTextArea();
		txtrDepartments.setText("Departments");
		txtrDepartments.setLineWrap(true);
		txtrDepartments.setColumns(3);
		txtrDepartments.setBounds(479, 11, 245, 370);
		frame.getContentPane().add(txtrDepartments);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("Projects");
		textArea_1.setLineWrap(true);
		textArea_1.setColumns(3);
		textArea_1.setBounds(759, 11, 245, 370);
		frame.getContentPane().add(textArea_1);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(444, 11, 17, 370);
		frame.getContentPane().add(scrollBar_1);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(724, 11, 17, 370);
		frame.getContentPane().add(scrollBar_2);
		
		JScrollBar scrollBar_3 = new JScrollBar();
		scrollBar_3.setBounds(1004, 11, 17, 370);
		frame.getContentPane().add(scrollBar_3);
		
	}
}
