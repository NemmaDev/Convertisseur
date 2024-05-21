package conver;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class conversion {

	private JFrame frame;
	private JTextField txteuro;
	private JTextField txtdollar;
	private JTextField txtfrcfa;
	private DecimalFormat f= new DecimalFormat("#.###");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					conversion window = new conversion();
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
	public conversion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(10, 11, 473, 57);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Systeme de Conversion des Devises");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 5, 453, 41);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 79, 473, 271);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel euro = new JLabel("Euro :");
		euro.setHorizontalAlignment(SwingConstants.CENTER);
		euro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		euro.setBounds(30, 48, 76, 26);
		panel_1.add(euro);
		
		JLabel lblDollars = new JLabel("Dollars :");
		lblDollars.setHorizontalAlignment(SwingConstants.CENTER);
		lblDollars.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDollars.setBounds(30, 113, 76, 26);
		panel_1.add(lblDollars);
		
		JLabel lblFrcfa = new JLabel("FRCFA :");
		lblFrcfa.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrcfa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFrcfa.setBounds(30, 168, 76, 26);
		panel_1.add(lblFrcfa);
		
		txteuro = new JTextField();
		txteuro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int euro= Integer.parseInt(txteuro.getText());
				
				double dollar=(euro*1.09);
				double frcfa= euro*655.80;
				txtdollar.setText(String.valueOf(dollar));
				txtfrcfa.setText(String.valueOf(frcfa));
			
				
			}
		});
		txteuro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txteuro.setBounds(126, 45, 154, 34);
		panel_1.add(txteuro);
		txteuro.setColumns(10);
		
		txtdollar = new JTextField();
		txtdollar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				double dollar= Integer.parseInt(txtdollar.getText());
				double euro= dollar*0.92;
				double frcfa=dollar*601.36;
				txteuro.setText(String.valueOf(euro));
				txtfrcfa.setText(String.valueOf(frcfa));
			}
		});
		txtdollar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtdollar.setColumns(10);
		txtdollar.setBounds(126, 110, 154, 34);
		panel_1.add(txtdollar);
		
		txtfrcfa = new JTextField();
		txtfrcfa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				double frcfa= Integer.parseInt(txtfrcfa.getText());
				
				double dollar= Math.round(((frcfa*0.0017)*100000.0)/100000.0);
				double euro=Math.round (((frcfa*0.0015)*100000.0)/100000.0);
				txteuro.setText(String.valueOf(euro));
				txtdollar.setText(String.valueOf(dollar));
			}
		});
		txtfrcfa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtfrcfa.setColumns(10);
		txtfrcfa.setBounds(126, 165, 154, 34);
		panel_1.add(txtfrcfa);
		
		JButton btnNewButton = new JButton("ACTUALISER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txteuro.setText("");
           	 	txtdollar.setText("");
           	 	txtfrcfa.setText("");
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(158, 226, 164, 23);
		panel_1.add(btnNewButton);
	}
}
