package trabalho_lista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ListaFram extends JFrame {
	private DefaultListModel<String> listModel;
    private JList<String> lista;
	private JPanel Pane_back;
	private JTextField textField_Inserir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaFram frame = new ListaFram();
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
	public ListaFram() {
		setTitle("Lista to Do");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 561);
		Pane_back = new JPanel();
		Pane_back.setBackground(new Color(106, 171, 84));
		Pane_back.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Pane_back);
		SpringLayout sl_Pane_back = new SpringLayout();
		Pane_back.setLayout(sl_Pane_back);
		
		JPanel Panel_ToDo = new JPanel();
		sl_Pane_back.putConstraint(SpringLayout.NORTH, Panel_ToDo, 5, SpringLayout.NORTH, Pane_back);
		sl_Pane_back.putConstraint(SpringLayout.WEST, Panel_ToDo, 386, SpringLayout.WEST, Pane_back);
		sl_Pane_back.putConstraint(SpringLayout.SOUTH, Panel_ToDo, -15, SpringLayout.SOUTH, Pane_back);
		sl_Pane_back.putConstraint(SpringLayout.EAST, Panel_ToDo, -15, SpringLayout.EAST, Pane_back);
		Panel_ToDo.setBorder(null);
		Pane_back.add(Panel_ToDo);
		Panel_ToDo.setLayout(null);
		
		JLabel titulo_lb1_ToDo = new JLabel("To do List:");
		titulo_lb1_ToDo.setBounds(116, 5, 103, 25);
		Panel_ToDo.add(titulo_lb1_ToDo);
		sl_Pane_back.putConstraint(SpringLayout.NORTH, titulo_lb1_ToDo, 10, SpringLayout.NORTH, Pane_back);
		sl_Pane_back.putConstraint(SpringLayout.WEST, titulo_lb1_ToDo, 475, SpringLayout.WEST, Pane_back);
		sl_Pane_back.putConstraint(SpringLayout.SOUTH, titulo_lb1_ToDo, 53, SpringLayout.NORTH, Pane_back);
		sl_Pane_back.putConstraint(SpringLayout.EAST, titulo_lb1_ToDo, -80, SpringLayout.EAST, Pane_back);
		titulo_lb1_ToDo.setVerticalAlignment(SwingConstants.TOP);
		titulo_lb1_ToDo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo_lb1_ToDo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_ADD = new JPanel();
		sl_Pane_back.putConstraint(SpringLayout.NORTH, panel_ADD, 5, SpringLayout.NORTH, Pane_back);
		sl_Pane_back.putConstraint(SpringLayout.WEST, panel_ADD, 10, SpringLayout.WEST, Pane_back);
		sl_Pane_back.putConstraint(SpringLayout.SOUTH, panel_ADD, 0, SpringLayout.SOUTH, Panel_ToDo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(106, 171, 84));
		panel.setBounds(0, 56, 379, 438);
		Panel_ToDo.add(panel);
		panel.setLayout(null);
		
		JPanel panel_Palta = new JPanel();
		panel_Palta.setBounds(0, 22, 379, 92);
		panel.add(panel_Palta);
		panel_Palta.setBackground(new Color(240, 240, 240));
		panel_Palta.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_P1 = new JPanel();
		panel_P1.setBackground(new Color(234, 77, 77));
		panel_Palta.add(panel_P1);
		panel_P1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("ALTA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_P1.add(lblNewLabel);
		
		JPanel Panel_P2 = new JPanel();
		panel_Palta.add(Panel_P2);
		Panel_P2.setLayout(null);
		
		JLabel Jlbl_A1 = new JLabel("New label");
		Jlbl_A1.setHorizontalAlignment(SwingConstants.LEFT);
		Jlbl_A1.setBounds(10, 1, 271, 21);
		Panel_P2.add(Jlbl_A1);
		
		JRadioButton Selecao_A1 = new JRadioButton("");
		Selecao_A1.setBounds(352, 1, 21, 21);
		Panel_P2.add(Selecao_A1);
		
		JButton btnNewButton = new JButton("↥");
		btnNewButton.setBounds(301, 1, 45, 21);
		Panel_P2.add(btnNewButton);
		
		JPanel panel_P3 = new JPanel();
		panel_Palta.add(panel_P3);
		panel_P3.setLayout(null);
		
		JLabel Jlbl_A2 = new JLabel("New label");
		Jlbl_A2.setBounds(10, 0, 231, 23);
		panel_P3.add(Jlbl_A2);
		
		JRadioButton Selecao_A2 = new JRadioButton("");
		Selecao_A2.setBounds(352, 0, 21, 21);
		panel_P3.add(Selecao_A2);
		
		JButton btnNewButton_1 = new JButton("↥");
		btnNewButton_1.setBounds(255, 2, 45, 21);
		panel_P3.add(btnNewButton_1);
		
		JPanel panel_P4 = new JPanel();
		panel_Palta.add(panel_P4);
		panel_P4.setLayout(null);
		
		JLabel Jlbl_A3 = new JLabel("New label");
		Jlbl_A3.setBounds(10, 0, 232, 23);
		panel_P4.add(Jlbl_A3);
		
		JRadioButton Selecao_A3 = new JRadioButton("");
		Selecao_A3.setBounds(352, 0, 21, 21);
		panel_P4.add(Selecao_A3);
		
		JButton btnNewButton_2 = new JButton("↥");
		btnNewButton_2.setBounds(255, 2, 45, 21);
		panel_P4.add(btnNewButton_2);
		
		JPanel panel_Pmedia = new JPanel();
		panel_Pmedia.setBounds(0, 141, 379, 92);
		panel.add(panel_Pmedia);
		panel_Pmedia.setBackground(new Color(240, 240, 240));
		panel_Pmedia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_P5 = new JPanel();
		panel_P5.setBackground(new Color(255, 128, 0));
		panel_Pmedia.add(panel_P5);
		panel_P5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_3 = new JLabel("MÉDIA");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_P5.add(lblNewLabel_1_3);
		
		JPanel panel_P6 = new JPanel();
		panel_Pmedia.add(panel_P6);
		panel_P6.setLayout(null);
		
		JLabel Jlbl_M1 = new JLabel("New label");
		Jlbl_M1.setBounds(10, 0, 242, 23);
		panel_P6.add(Jlbl_M1);
		
		JRadioButton Selecao_M1 = new JRadioButton("");
		Selecao_M1.setBounds(352, 0, 21, 21);
		panel_P6.add(Selecao_M1);
		
		JButton btnNewButton_3 = new JButton("↥");
		btnNewButton_3.setBounds(255, 1, 45, 21);
		panel_P6.add(btnNewButton_3);
		
		JPanel panel_P7 = new JPanel();
		panel_Pmedia.add(panel_P7);
		panel_P7.setLayout(null);
		
		JLabel Jlbl_M2 = new JLabel("New label");
		Jlbl_M2.setBounds(10, 0, 238, 23);
		panel_P7.add(Jlbl_M2);
		
		JRadioButton Selecao_M2 = new JRadioButton("");
		Selecao_M2.setBounds(352, 0, 21, 21);
		panel_P7.add(Selecao_M2);
		
		JButton btnNewButton_4 = new JButton("↥");
		btnNewButton_4.setBounds(255, 2, 45, 21);
		panel_P7.add(btnNewButton_4);
		
		JPanel panel_P8 = new JPanel();
		panel_Pmedia.add(panel_P8);
		panel_P8.setLayout(null);
		
		JLabel Jlbl_M3 = new JLabel("New label");
		Jlbl_M3.setBounds(10, 0, 244, 23);
		panel_P8.add(Jlbl_M3);
		
		JRadioButton Selecao_M3 = new JRadioButton("");
		Selecao_M3.setBounds(352, 0, 21, 21);
		panel_P8.add(Selecao_M3);
		
		JButton btnNewButton_5 = new JButton("↥");
		btnNewButton_5.setBounds(256, 3, 45, 21);
		panel_P8.add(btnNewButton_5);
		
		JPanel panel_Pbaixa = new JPanel();
		panel_Pbaixa.setBounds(0, 256, 379, 92);
		panel.add(panel_Pbaixa);
		panel_Pbaixa.setBackground(new Color(240, 240, 240));
		panel_Pbaixa.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_P9 = new JPanel();
		panel_P9.setBackground(new Color(64, 128, 128));
		panel_Pbaixa.add(panel_P9);
		panel_P9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_7 = new JLabel("BAIXA");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_P9.add(lblNewLabel_1_7);
		
		JPanel panel_P10 = new JPanel();
		panel_Pbaixa.add(panel_P10);
		panel_P10.setLayout(null);
		
		
		JLabel Jlbl_B1 = new JLabel("New label");
		Jlbl_B1.setBounds(10, 0, 240, 23);
		panel_P10.add(Jlbl_B1);
		
		JRadioButton Selecao_B1 = new JRadioButton("");
		Selecao_B1.setBounds(352, 0, 21, 21);
		panel_P10.add(Selecao_B1);
		
		JButton btnNewButton_6 = new JButton("↥");
		btnNewButton_6.setBounds(257, 2, 45, 21);
		panel_P10.add(btnNewButton_6);
		
		JPanel panel_P11 = new JPanel();
		panel_Pbaixa.add(panel_P11);
		panel_P11.setLayout(null);
		
		JLabel Jlbl_B2 = new JLabel("New label");
		Jlbl_B2.setBounds(10, 0, 240, 23);
		panel_P11.add(Jlbl_B2);
		
		JRadioButton Selecao_B2 = new JRadioButton("");
		Selecao_B2.setBounds(352, 0, 21, 21);
		panel_P11.add(Selecao_B2);
		
		JButton btnNewButton_7 = new JButton("↥");
		btnNewButton_7.setBounds(258, 4, 45, 21);
		panel_P11.add(btnNewButton_7);
		
		JPanel panel_P12 = new JPanel();
		panel_Pbaixa.add(panel_P12);
		panel_P12.setLayout(null);
		
		JLabel Jlbl_B3 = new JLabel("New label");
		Jlbl_B3.setBounds(10, 0, 247, 23);
		panel_P12.add(Jlbl_B3);
		
		JRadioButton Selecao_B3 = new JRadioButton("");
		Selecao_B3.setBounds(352, 2, 21, 21);
		panel_P12.add(Selecao_B3);
		
		JButton btnNewButton_8 = new JButton("↥");
		btnNewButton_8.setBounds(258, 3, 45, 21);
		panel_P12.add(btnNewButton_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(106, 171, 84));
		panel_1.setBounds(0, 368, 379, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JFrame novaJanela = new JFrame("EDITAR");
		novaJanela.setSize(400,200);
		novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		novaJanela.setVisible(false);
		novaJanela.setLocation(300,300 );
		JPanel Panel_Editar = new JPanel();
		novaJanela.getContentPane().add(Panel_Editar);
		JLabel Jlbl_Editar = new JLabel("EDITE O TEXTO NOVO: ");
		Jlbl_Editar.setFont(new Font("Tahoma", Font.BOLD, 11));
		Jlbl_Editar.setVerticalAlignment(SwingConstants.TOP);
		Jlbl_Editar.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField Jtxt_Editar = new JTextField(20);
		Jtxt_Editar.setBounds(150, 150, 30, 10);
		JButton Jbtn_Editar2 = new JButton("Enviar a lista");
		Jbtn_Editar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Jbtn_Editar2.setBounds(SwingConstants.BOTTOM, 100, 50, 50);
		
		Panel_Editar.add(Jlbl_Editar);
		Panel_Editar.add(Jtxt_Editar);
		Panel_Editar.add(Jbtn_Editar2);
		
		Jbtn_Editar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				String Txt_sub = Jtxt_Editar.getText();
				if (Selecao_A1.isSelected()) {
					Jlbl_A1.setText(Txt_sub);
					Selecao_A1.setSelected(false);
				}else if(Selecao_A2.isSelected()) {
					Jlbl_A2.setText(Txt_sub);
					Selecao_A2.setSelected(false);
				}else if(Selecao_A3.isSelected()) {
					Jlbl_A3.setText(Txt_sub);
					Selecao_A3.setSelected(false);
				}else if(Selecao_M1.isSelected()) {
					Jlbl_M1.setText(Txt_sub);
					Selecao_M1.setSelected(false);
				}else if(Selecao_M2.isSelected()) {
					Jlbl_M2.setText(Txt_sub);
					Selecao_M2.setSelected(false);
				}else if(Selecao_M3.isSelected()) {
					Jlbl_M3.setText(Txt_sub);
					Selecao_M3.setSelected(false);
				}else if(Selecao_B1.isSelected()) {
					Jlbl_B1.setText(Txt_sub);
					Selecao_B1.setSelected(false);
				}else if(Selecao_B2.isSelected()) {
					Jlbl_B2.setText(Txt_sub);
					Selecao_B2.setSelected(false);
				}else if(Selecao_B3.isSelected()) {
					Jlbl_B3.setText(Txt_sub);
					Selecao_B3.setSelected(false);
				}
				
				novaJanela.dispose();
					Jtxt_Editar.setText("");
			}
		});
		JButton Jbtn_Editar = new JButton("EDITAR\r\n\r\n");
		Jbtn_Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Selecao_A1.isSelected() == false & Selecao_A2.isSelected() == false & Selecao_A3.isSelected() == false & 
						Selecao_B1.isSelected() == false & Selecao_B2.isSelected() == false & Selecao_B3.isSelected() == false & 
						Selecao_M1.isSelected() == false & Selecao_M2.isSelected() == false & Selecao_M3.isSelected() == false ) {
					JOptionPane.showMessageDialog(null, "Selecione algum item da lista para altera-lo");
					
				}else if(Selecao_A1.isSelected()) {
					novaJanela.setVisible(true);
					
				}else if(Selecao_A2.isSelected()) {
					novaJanela.setVisible(true);
					
				}else if(Selecao_A3.isSelected()) {
					novaJanela.setVisible(true);
					
				}else if(Selecao_M1.isSelected()) {
					novaJanela.setVisible(true);
					
				}else if(Selecao_M2.isSelected()) {
					novaJanela.setVisible(true);
					
				}else if(Selecao_M3.isSelected()) {
					novaJanela.setVisible(true);
					
				}else if(Selecao_B1.isSelected()) {
					novaJanela.setVisible(true);
					
				}else if(Selecao_B2.isSelected()) {
					novaJanela.setVisible(true);
					
				}else if(Selecao_B3.isSelected()) {
					novaJanela.setVisible(true);
					
				}
			}
		});
		Jbtn_Editar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Jbtn_Editar.setBounds(0, 0, 126, 70);
		panel_1.add(Jbtn_Editar);
		
		JButton Jbtn_remover = new JButton("REMOVER");
		Jbtn_remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Selecao_A1.isSelected() == false & Selecao_A2.isSelected() == false & Selecao_A3.isSelected() == false & 
						Selecao_B1.isSelected() == false & Selecao_B2.isSelected() == false & Selecao_B3.isSelected() == false & 
						Selecao_M1.isSelected() == false & Selecao_M2.isSelected() == false & Selecao_M3.isSelected() == false ) {
					JOptionPane.showMessageDialog(null, "Selecione algum item da lista para altera-lo");
				}else {
					if (Selecao_A1.isSelected()) {
						Jlbl_A1.setText("");
						Selecao_A1.setSelected(false);
					}else if(Selecao_A2.isSelected()) {
						Jlbl_A2.setText("");
						Selecao_A2.setSelected(false);
					}else if(Selecao_A3.isSelected()) {
						Jlbl_A3.setText("");
						Selecao_A3.setSelected(false);
					}else if(Selecao_M1.isSelected()) {
						Jlbl_M1.setText("");
						Selecao_M1.setSelected(false);
					}else if(Selecao_M2.isSelected()) {
						Jlbl_M2.setText("");
						Selecao_M2.setSelected(false);
					}else if(Selecao_M3.isSelected()) {
						Jlbl_M3.setText("");
						Selecao_M3.setSelected(false);
					}else if(Selecao_B1.isSelected()) {
						Jlbl_B1.setText("");
						Selecao_B1.setSelected(false);
					}else if(Selecao_B2.isSelected()) {
						Jlbl_B2.setText("");
						Selecao_B2.setSelected(false);
					}else if(Selecao_B3.isSelected()) {
						Jlbl_B3.setText("");
						Selecao_B3.setSelected(false);
					}
				}
			}
		});
		Jbtn_remover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Jbtn_remover.setBounds(244, 0, 135, 70);
		panel_1.add(Jbtn_remover);
		sl_Pane_back.putConstraint(SpringLayout.EAST, panel_ADD, 328, SpringLayout.WEST, Pane_back);
		panel_ADD.setBorder(null);
		Pane_back.add(panel_ADD);
		panel_ADD.setLayout(null);
		
		JLabel Titulo_lb2_ADD = new JLabel("ADD\r\n");
		Titulo_lb2_ADD.setBounds(137, 5, 44, 25);
		Titulo_lb2_ADD.setVerticalAlignment(SwingConstants.TOP);
		Titulo_lb2_ADD.setHorizontalAlignment(SwingConstants.LEFT);
		Titulo_lb2_ADD.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_ADD.add(Titulo_lb2_ADD);
		
		JLabel lb3_Inserir = new JLabel("INSERIR A LISTA:");
		lb3_Inserir.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb3_Inserir.setBounds(10, 40, 150, 13);
		panel_ADD.add(lb3_Inserir);
		
		textField_Inserir = new JTextField();
		textField_Inserir.setBounds(10, 78, 298, 33);
		panel_ADD.add(textField_Inserir);
		textField_Inserir.setColumns(10);
		
		JCheckBox chbx_Alta = new JCheckBox("ALTA  ");
		chbx_Alta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chbx_Alta.setFont(new Font("Tahoma", Font.BOLD, 10));
		chbx_Alta.setForeground(new Color(234, 77, 77));
		chbx_Alta.setBounds(10, 154, 93, 21);
		panel_ADD.add(chbx_Alta);
		
		JCheckBox chbx_Media = new JCheckBox("MÉDIA");
		chbx_Media.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chbx_Media.setFont(new Font("Tahoma", Font.BOLD, 10));
		chbx_Media.setForeground(new Color(255, 128, 0));
		chbx_Media.setBounds(10, 177, 93, 21);
		panel_ADD.add(chbx_Media);
		
		JCheckBox chbx_Baixa = new JCheckBox("BAIXA");
		chbx_Baixa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chbx_Baixa.setFont(new Font("Tahoma", Font.BOLD, 10));
		chbx_Baixa.setForeground(new Color(64, 128, 128));
		chbx_Baixa.setBounds(10, 200, 93, 21);
		panel_ADD.add(chbx_Baixa);
		
		JLabel lb_Prioridades = new JLabel("Prioridade:");
		lb_Prioridades.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_Prioridades.setBounds(10, 135, 150, 13);
		panel_ADD.add(lb_Prioridades);
		
		JButton btn_adicionar = new JButton("ADICIONAR A LISTA\r\n\r\n");
		btn_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chbx_Alta.isSelected() == false & chbx_Media.isSelected() == false & chbx_Baixa.isSelected()==false ) {
					JOptionPane.showMessageDialog(null, "Selecione uma prioridade");
				}else {
					if(chbx_Alta.isSelected() == true) {
						Jlbl_A3.setText(Jlbl_A2.getText());
						Jlbl_A2.setText(Jlbl_A1.getText());
						String campoTexto = textField_Inserir.getText();
						Jlbl_A1.setText(campoTexto);
					}else if(chbx_Media.isSelected() == true) {
						Jlbl_M3.setText(Jlbl_M2.getText());
						Jlbl_M2.setText(Jlbl_M1.getText());
						String campoTexto = textField_Inserir.getText();
						Jlbl_M1.setText(campoTexto);
					}else if (chbx_Baixa.isSelected()==true){
						Jlbl_B3.setText(Jlbl_B2.getText());
						Jlbl_B2.setText(Jlbl_B1.getText());
						String campoTexto = textField_Inserir.getText();
						Jlbl_B1.setText(campoTexto);
					}
				}
					textField_Inserir.setText("");
					chbx_Alta.setSelected(false);
					chbx_Media.setSelected(false);
					chbx_Baixa.setSelected(false);
				}
			
		});
		btn_adicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_adicionar.setForeground(new Color(0, 0, 0));
		btn_adicionar.setToolTipText("Adiciona item a lista");
		btn_adicionar.setBounds(63, 400, 172, 42);
		panel_ADD.add(btn_adicionar);
		
		
	}
}
