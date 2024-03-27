package Database;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String isim;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage("e");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   

  
	

	/**
	 * Create the frame.
	 * @param kullaniciadi 
	 */
	public HomePage(String kullaniciadi) {
		isim=kullaniciadi;
		setBackground(new Color(128, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton ekle_btn =  new JButton(new ImageIcon(getClass().getResource("ekle(1).png")));
		ekle_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
                
                Ekleme ekleme = new Ekleme(isim);
                ekleme.setVisible(true);
			}
		});
		ekle_btn.setBounds(112, 189, 85, 63);
		contentPane.add(ekle_btn);
		
		JButton rehber_btn =  new JButton(new ImageIcon(getClass().getResource("rehber(1).png")));
		rehber_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
                
                Sorgular sorgu = new Sorgular();
                sorgu.setVisible(true);
			}
		});
		rehber_btn.setBounds(458, 189, 85, 63);
		contentPane.add(rehber_btn);
	}
}
