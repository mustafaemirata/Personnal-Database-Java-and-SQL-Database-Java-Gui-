package Database;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ekleme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ad_soyad_text;
	private JTextField yaş_text_box;
	private JTextField departman_textbox;
	private JTextField maas_textbox;
	private String isim;
	private JTextField soyad_textbox;
	
	String personelAd;
	String personelSoyad;
	String personelYas;
	String personelDepartman;
	String personelMaas;
	String peronelMedeniDurum;
	String peronelCinsiyet ;
	protected String personelCinsiyet;
	protected String personelMedeniDurum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ekleme frame = new Ekleme("e");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 public static Connection Connection() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver"); 
	            String url = "jdbc:mysql://localhost:3306/personeller";

	            String kullaniciAdi = "root";
	            String sifre = "1187";
	            Connection baglanti = DriverManager.getConnection(url, kullaniciAdi, sifre);
	            return baglanti;
	        } catch (Exception e) {
	            System.out.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
	            return null;
	        }
	    }
	/**
	 * Create the frame.
	 * @param isim 
	 */
	public Ekleme(String kullaniciadi) {
		isim=kullaniciadi;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Yeni Personel Ekle");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setBounds(313, 10, 158, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ad- Soyad:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(30, 71, 99, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Yaş:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(30, 153, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Departman:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(30, 196, 88, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Maaş:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(30, 240, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cinsiyet: ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(30, 280, 88, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Medeni Durum:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(30, 325, 99, 13);
		contentPane.add(lblNewLabel_6);
		
		ad_soyad_text = new JTextField();
		ad_soyad_text.setBounds(279, 68, 96, 19);
		contentPane.add(ad_soyad_text);
		ad_soyad_text.setColumns(10);
		
		yaş_text_box = new JTextField();
		yaş_text_box.setBounds(279, 151, 96, 19);
		contentPane.add(yaş_text_box);
		yaş_text_box.setColumns(10);
		
		departman_textbox = new JTextField();
		departman_textbox.setBounds(279, 196, 96, 19);
		contentPane.add(departman_textbox);
		departman_textbox.setColumns(10);
		
		maas_textbox = new JTextField();
		maas_textbox.setBounds(279, 238, 96, 19);
		contentPane.add(maas_textbox);
		maas_textbox.setColumns(10);
		
		
		
		
		String cinsiyet[]= {"Seçim Yapınız","Erkek","Kadın"};
		JComboBox cinsiyet_combobox = new JComboBox(cinsiyet);
		
		cinsiyet_combobox.setBounds(279, 277, 110, 21);
	
		contentPane.add(cinsiyet_combobox);
		
		
		
		String medeni[]= {"Seçim Yapınız","Bekar","Evli"};
		JComboBox medenidurum_combobox = new JComboBox(medeni);
		
		medenidurum_combobox.setBounds(279, 322, 110, 21);
		contentPane.add(medenidurum_combobox);
		
		JButton kayıtekle_btn = new JButton("Kayıt Ekle");
		kayıtekle_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 personelAd=ad_soyad_text.getText();
				 personelSoyad=soyad_textbox.getText();
				 personelYas=yaş_text_box.getText();
				 personelDepartman=departman_textbox.getText();
				 personelMaas=maas_textbox.getText();
				 peronelMedeniDurum=(String) medenidurum_combobox.getSelectedItem();
				 peronelCinsiyet = (String) cinsiyet_combobox.getSelectedItem();
				
				
			    try {
                    Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/personeller", "root", "1187");

                    DatabaseMetaData meta = baglanti.getMetaData();
                    ResultSet rs = meta.getCatalogs();
                    boolean kullaniciVar = false;
                    while (rs.next()) {
                        String dbName = rs.getString(1);
                        if (dbName.equals(personelAd)) {
                            kullaniciVar = true;
                            break;
                        }
                    }
                    rs.close();

                    if (kullaniciVar) {
                        JOptionPane.showMessageDialog(null, "Bu kullanıcı mevcut. Başka bir isim giriniz.", "Dikkat!", JOptionPane.ERROR_MESSAGE);
                    } else {
                       
                       

                    	String sql = "INSERT INTO bilgiler (Cinsiyet,isim,soyisim,Yaş,MedeniDurum,departman,maaş) VALUES (?,?,?,?,?,?,?)";
                    	PreparedStatement preparedStatement = baglanti.prepareStatement(sql);

                    	personelAd = ad_soyad_text.getText();
                    	personelSoyad = soyad_textbox.getText();
                    	personelYas = yaş_text_box.getText();
                    	personelDepartman = departman_textbox.getText();
                    	personelMaas = maas_textbox.getText();
                    	peronelMedeniDurum = (String) medenidurum_combobox.getSelectedItem();
                    	peronelCinsiyet = (String) cinsiyet_combobox.getSelectedItem();

                    	preparedStatement.setString(1, personelCinsiyet);
                    	preparedStatement.setString(2, personelAd);
                    	preparedStatement.setString(3, personelSoyad);
                    	preparedStatement.setString(4, personelYas);
                    	preparedStatement.setString(5, personelMedeniDurum);
                    	preparedStatement.setString(6, personelDepartman);
                    	preparedStatement.setString(7, personelMaas);
                    	preparedStatement.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Bilgiler Eklendi!", "Dikkat!", JOptionPane.ERROR_MESSAGE);

                      
                    }

                    baglanti.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
                }
				
				
				
				
			}
		});
		kayıtekle_btn.setBounds(290, 372, 99, 21);
		contentPane.add(kayıtekle_btn);
		
		JLabel lblNewLabel_7 = new JLabel("Soyad");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(30, 109, 69, 13);
		contentPane.add(lblNewLabel_7);
		
		soyad_textbox = new JTextField();
		soyad_textbox.setBounds(279, 107, 96, 19);
		contentPane.add(soyad_textbox);
		soyad_textbox.setColumns(10);

	}
}
