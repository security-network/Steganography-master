import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;



public class steganography extends JFrame {

	private JPanel contentPane;
	private JTextField txtEncSrc;
	private JTextField txtEncDes;
	private JTextField txtDecSrc;
	private JTextField txtDecDes;
	private JPasswordField txtEncPass;
	private JPasswordField txtDecPass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					steganography frame = new steganography();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public steganography() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnl_enc = new JPanel();
		tabbedPane.addTab("Encode", null, pnl_enc, null);
		pnl_enc.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][]"));
		
		JLabel lblSource = new JLabel("Source: ");
		pnl_enc.add(lblSource, "cell 3 1,alignx left");
		
		txtEncSrc = new JTextField();
		txtEncSrc.setText("C:\\Users\\Sieu\\Desktop\\TextToEncode.txt");
		txtEncSrc.setToolTipText("\u0110\u01B0\u1EDDng d\u1EABn ch\u1EE9a d\u1EEF li\u1EC7u c\u1EA7n che gi\u1EA5u");
		pnl_enc.add(txtEncSrc, "flowx,cell 4 1,alignx left");
		txtEncSrc.setColumns(30);
		
		JLabel lblDestination_1 = new JLabel("Destination: ");
		pnl_enc.add(lblDestination_1, "cell 3 3,alignx left");
		
		txtEncDes = new JTextField();
		txtEncDes.setText("C:\\Users\\Sieu\\Desktop\\a phai lam sao - Dan Truong.wav");
		txtEncDes.setToolTipText("\u0110\u01B0\u1EDDng d\u1EABn file l\u00E0m v\u1ECF b\u1ECDc");
		txtEncDes.setColumns(30);
		pnl_enc.add(txtEncDes, "flowx,cell 4 3,alignx left");
		
		JButton btnEncSrc = new JButton("Browser");
		btnEncSrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Browser b = new Browser();
				txtEncSrc.setText(b.OpenB());
			}
		});
		pnl_enc.add(btnEncSrc, "cell 4 1");
		
		JButton btnEncDes = new JButton("Browser");
		btnEncDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Browser b = new Browser();
				txtEncDes.setText(b.OpenB());
			}
		});
		pnl_enc.add(btnEncDes, "cell 4 3");
		
		JLabel lblPassword = new JLabel("Password:");
		pnl_enc.add(lblPassword, "cell 3 5,alignx left");
		
		txtEncPass = new JPasswordField();
		txtEncPass.setColumns(20);
		pnl_enc.add(txtEncPass, "flowx,cell 4 5,alignx left");
		
		JButton btnEmb = new JButton("Embedded");
		btnEmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				embTextToAudio emb = new embTextToAudio();
				try {
					emb.Encoder(txtEncSrc.getText(), txtEncDes.getText(),txtEncPass.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		pnl_enc.add(btnEmb, "cell 4 5,alignx left");
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pnl_enc, tabbedPane}));
		
		JPanel pnl_dec = new JPanel();
		tabbedPane.addTab("Decode", null, pnl_dec, null);
		pnl_dec.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][]"));
		
		JLabel lblSource_1 = new JLabel("Source: ");
		pnl_dec.add(lblSource_1, "cell 3 1,alignx left");
		
		txtDecSrc = new JTextField();
		txtDecSrc.setText("C:\\Users\\Sieu\\Desktop\\Steganography-master\\testAudio.wav");
		txtDecSrc.setToolTipText("\u0110\u01B0\u1EDDng d\u1EABn ch\u1EE9a file c\u1EA7n l\u1EA5y d\u1EEF li\u1EC7u che gi\u1EA5u");
		pnl_dec.add(txtDecSrc, "cell 4 1,alignx left");
		txtDecSrc.setColumns(30);
		
		JButton btnDecSrc = new JButton("Browser");
		btnDecSrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Browser b = new Browser();
				txtDecSrc.setText(b.OpenB());
			}
		});
		pnl_dec.add(btnDecSrc, "cell 5 1");
		
		JLabel lblDestination = new JLabel("Destination:");
		pnl_dec.add(lblDestination, "cell 3 3,alignx trailing");
		
		txtDecDes = new JTextField();
		txtDecDes.setText("C:\\Users\\Sieu\\Desktop\\Tex.txt");
		txtDecDes.setToolTipText("Th\u01B0 m\u1EE5c l\u01B0u tr\u1EEF d\u1EEF li\u1EC7u gi\u1EA3i m\u00E3");
		pnl_dec.add(txtDecDes, "cell 4 3,alignx left");
		txtDecDes.setColumns(30);
		
		JButton btnDecDes = new JButton("Browser");
		btnDecDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Browser b = new Browser();
				txtDecDes.setText(b.OpenB());
			}
		});
		pnl_dec.add(btnDecDes, "cell 5 3");
		
		JLabel label_1 = new JLabel("Password:");
		pnl_dec.add(label_1, "cell 3 5,alignx left");
		
		txtDecPass = new JPasswordField();
		txtDecPass.setColumns(20);
		pnl_dec.add(txtDecPass, "cell 4 5");
		
		JButton btnExt = new JButton("Extract");
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				embTextToAudio exct = new embTextToAudio();
				exct.Decoder(txtDecSrc.getText(), txtDecDes.getText(),txtDecPass.getText());
			}
		});
		pnl_dec.add(btnExt, "cell 4 5,aligny top");
		
		JPanel pnl_aut = new JPanel();
		tabbedPane.addTab("Author", null, pnl_aut, null);
		
		JTextArea txtrTeamStudentAt = new JTextArea();
		txtrTeamStudentAt.setBackground(UIManager.getColor("menu"));
		txtrTeamStudentAt.setText("Team student at University of Information Technology\r\nTrainer: Nguyen Duy\r\nMember: Nguyen Hung Nhuan\r\n\tLe Viet Hung\r\n\tPhung Nhuc Sau");
		txtrTeamStudentAt.setEditable(false);
		pnl_aut.add(txtrTeamStudentAt);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		JProgressBar pgb = new JProgressBar();
		panel_3.add(pgb);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JLabel label = new JLabel("Size:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(label);
		
		JLabel lblSize = new JLabel("None");
		panel_5.add(lblSize);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setHgap(100);
		panel_3.add(panel_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(128, 128, 128)), "", TitledBorder.TRAILING, TitledBorder.BOTTOM, null, new Color(128, 128, 128)));
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setVgap(15);
		contentPane.add(panel_6, BorderLayout.NORTH);
		
		JLabel lblStegenogeaphy = new JLabel("STEGANOGRAPHY");
		lblStegenogeaphy.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		panel_6.add(lblStegenogeaphy);

	}
	
}
