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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Dashboard {

	private JFrame frame;
	private JTable table;

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
		txtrProjects.setText("Projects");
		txtrProjects.setBounds(201, 11, 830, 370);
		txtrProjects.setLineWrap(true);
		frame.getContentPane().add(txtrProjects);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(220, 23, 725, 345);
		frame.getContentPane().add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1014, 23, 17, 358);
		frame.getContentPane().add(scrollBar);
	}
}
