//Justin Cai, jc5pz
//Ayush Mayur, am3nz
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PineapplePizzaExample extends JFrame {
	private JLabel buttonEventLabel;
	private JRadioButton rdbtnYes;
	private JRadioButton rdbtnNo;
	private JTextField toppings;

	/**
     * Launch the application.
     */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					PineapplePizzaExample exam = new PineapplePizzaExample();

					// Resize to fit content
					//exam.pack();
					// Display the Window
					exam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public PineapplePizzaExample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Initial Size (minW minH maxW maxH)
		setBounds(100, 100, 450, 300);
		// Set what happens when you click the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Give it a layout: border = N, S, E, W, and Center
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		try {
			BufferedImage pic = ImageIO.read(new File("pineapple-pizza.jpg"));
			JLabel label = new JLabel(new ImageIcon(pic));
			p.add(label);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Add it to the top!
		getContentPane().add(p, BorderLayout.NORTH);


		// Panel 4 first, but with "Hello World"
		// then change it to the question, then add yes/no radio buttons
		// then add box for other toppings
		// then add image to the top
		// then mention pack() and how it changes
		// Remember: any data elements, set as fields (access them in inner classes)
		JPanel p4 = new JPanel();
		p4.add(new JLabel("Do you like pineapple on your pizza?"));
		rdbtnYes = new JRadioButton("Yes");
		rdbtnNo = new JRadioButton("No");
		ButtonGroup pineapple = new ButtonGroup();
		pineapple.add(rdbtnYes);
		pineapple.add(rdbtnNo);
		p4.add(rdbtnYes);
		p4.add(rdbtnNo);

		getContentPane().add(p4, BorderLayout.CENTER);

		JPanel p2 = new JPanel();

		p2.add(new JLabel("Other Toppings: "));

		toppings = new JTextField(15);
		p2.add(toppings);

		JButton btn = new JButton("Add");
		p2.add(btn);
		buttonEventLabel = new JLabel();
		p2.add(buttonEventLabel);
		getContentPane().add(p2, BorderLayout.SOUTH);
	}
}