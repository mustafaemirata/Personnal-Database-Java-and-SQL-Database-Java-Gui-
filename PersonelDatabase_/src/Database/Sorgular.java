package Database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Sorgular extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField aratma_textbox;
    private JLabel lblNewLabel;
    private JTable table;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sorgular frame = new Sorgular();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   
    
    
    
    
    
    
    
    public Sorgular() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 712, 493);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 224, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        aratma_textbox = new JTextField();
        aratma_textbox.setBounds(165, 39, 181, 32);
        contentPane.add(aratma_textbox);
        aratma_textbox.setColumns(10);
        
        
        JPanel bilgiler_panel = new JPanel();
        bilgiler_panel.setBounds(10, 116, 678, 330);
        contentPane.add(bilgiler_panel);
        bilgiler_panel.setLayout(null);

        // JScrollPane oluştur ve tabloyu bu JScrollPane içine yerleştir
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 48, 668, 112);
        bilgiler_panel.add(scrollPane);
        bilgiler_panel.setVisible(false);

        // JTable'ı JScrollPane içine yerleştir
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"ID Numaras\u0131", "Cinsiyet", "\u0130sim", "Soyisim", "Ya\u015F", "Medeni Durum", "Departman", "Maa\u015F"
        	}
        ));
        scrollPane.setViewportView(table);
        
        lblNewLabel_1 = new JLabel("KAYIT BULUNDU!");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1.setBounds(268, 10, 140, 13);
        bilgiler_panel.add(lblNewLabel_1);

        JButton arat_btn = new JButton("Arat");
        arat_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 try {
        			
        	            Class.forName("com.mysql.jdbc.Driver"); 
        	            String url = "jdbc:mysql://localhost:3306/personeller";

        	            String kullaniciAdi = "root";
        	            String sifre = "1187";
        	            Connection baglanti = DriverManager.getConnection(url, kullaniciAdi, sifre);
        	         
        	            String arananIsim = aratma_textbox.getText();

        	            // Sorguyu hazırla
        	            String sorgu = "SELECT * FROM bilgiler WHERE isim LIKE ?";
        	            PreparedStatement preparedStatement = baglanti.prepareStatement(sorgu);
        	            preparedStatement.setString(1, "%" + arananIsim + "%");

        	            // Sorguyu çalıştır ve sonuçları al
        	            ResultSet resultSet = preparedStatement.executeQuery();

        	            // Tabloyu temizle
        	            DefaultTableModel model = (DefaultTableModel) table.getModel();
        	            model.setRowCount(0);

        	            // Sonuçları tabloya ekle
        	            while (resultSet.next()) {
        	                Object[] row = new Object[7]; // 7 sütun var
        	                for (int i = 0; i < 7; i++) {
        	                    row[i] = resultSet.getObject(i + 1); 
        	                }
        	                model.addRow(row);
        	            }
        	            bilgiler_panel.setVisible(true);
                        
        	            
        	        } catch (Exception es) {
        	     
                        JOptionPane.showMessageDialog(null, "Girdiğiniz personelin bilgisi bulunamadı.", "Dikkat!", JOptionPane.ERROR_MESSAGE);

        	            
        	        }
        	}
        });
        arat_btn.setFont(new Font("Times New Roman", Font.BOLD, 12));
        arat_btn.setBounds(388, 36, 59, 37);
        contentPane.add(arat_btn);

        lblNewLabel = new JLabel("Personel İsmi Giriniz");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel.setBounds(165, 16, 181, 13);
        contentPane.add(lblNewLabel);

      
    }
}
