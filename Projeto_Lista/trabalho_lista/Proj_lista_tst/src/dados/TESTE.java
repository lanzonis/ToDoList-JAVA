package dados;

//Realizando o import 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Component;

// ps alguns imports e a variavel Pane_back foram importados automaticamente

// o que foi criado pelo design não irei comentar
//criando a classe Teste
public class TESTE extends JFrame {
	// Variaveis globais
	// instanciando as listas que serão utilizadas A1 - para a prioridade Alta, B1 -
	// para a prioridade baixa, M1- para a prioridade Media
	private DefaultListModel<String> listModel_A1;
	private DefaultListModel<String> listModel_B1;
	private DefaultListModel<String> listModel_M1;
	private DefaultListModel<String>listModel_H;
	private JPanel Pane_back;
	// Criando o metodo Jlist para utiliza-lo no painel em que irei inserir a lista
	private JList<String> lista_A;
	private JList<String> lista_B;
	private JList<String> lista_M;
	private JList<String> lista_H;
	// variavel que recebe o textField
	private JTextField textField_Inserir;
	// variavel global cima/baixo
	private int j = 0;

	// feito automaticamente quando criei o projeto, utilizei o eclipse
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TESTE frame = new TESTE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// construtor
	public TESTE() {
		// criando o objeto das listas
		listModel_A1 = new DefaultListModel<>();
		listModel_M1 = new DefaultListModel<>();
		listModel_B1 = new DefaultListModel<>();
		listModel_H = new DefaultListModel<>();
		//inserindo cada lista em seu respectivo Jlist
		lista_A = new JList<>(listModel_A1);
		lista_M = new JList<>(listModel_M1);
		lista_B = new JList<>(listModel_B1);
		lista_H = new JList<>(listModel_H);
		
		Conexao_teste cx = new Conexao_teste();

		// parte grafica foi realizada no painel design
		setTitle("Lista to Do");// mudando o titulo do painel principal
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 561);
		Pane_back = new JPanel();
		Pane_back.setBackground(new Color(64, 128, 128));
		Pane_back.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Pane_back);
		Pane_back.setLayout(null);

		JPanel Panel_ToDo = new JPanel();
		Panel_ToDo.setBounds(391, 10, 379, 494);
		Panel_ToDo.setBorder(null);
		Pane_back.add(Panel_ToDo);
		Panel_ToDo.setLayout(null);

		JLabel titulo_lb1_ToDo = new JLabel("To do List:");
		titulo_lb1_ToDo.setBounds(143, 10, 103, 25);
		Panel_ToDo.add(titulo_lb1_ToDo);
		titulo_lb1_ToDo.setVerticalAlignment(SwingConstants.TOP);
		titulo_lb1_ToDo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo_lb1_ToDo.setFont(new Font("Tahoma", Font.BOLD, 20));

		JPanel panel_ADD = new JPanel();
		panel_ADD.setBounds(15, 10, 318, 494);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 56, 379, 438);
		Panel_ToDo.add(panel);
		panel.setLayout(null);

		JPanel panel_Palta = new JPanel();
		panel_Palta.setBounds(0, 22, 379, 92);
		panel.add(panel_Palta);
		panel_Palta.setBackground(new Color(240, 240, 240));
		panel_Palta.setLayout(null);

		JPanel panel_P1 = new JPanel();
		panel_P1.setBounds(0, 0, 379, 24);
		panel_P1.setBackground(new Color(234, 77, 77));
		panel_Palta.add(panel_P1);
		SpringLayout sl_panel_P1 = new SpringLayout();
		panel_P1.setLayout(sl_panel_P1);

		JLabel lblNewLabel = new JLabel("ALTA");
		sl_panel_P1.putConstraint(SpringLayout.NORTH, lblNewLabel, 5, SpringLayout.NORTH, panel_P1);
		sl_panel_P1.putConstraint(SpringLayout.WEST, lblNewLabel, 174, SpringLayout.WEST, panel_P1);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_P1.add(lblNewLabel);

		JCheckBox chckbx_A = new JCheckBox("");
		chckbx_A.setBackground(new Color(234, 77, 77));
		sl_panel_P1.putConstraint(SpringLayout.NORTH, chckbx_A, 0, SpringLayout.NORTH, panel_P1);
		sl_panel_P1.putConstraint(SpringLayout.SOUTH, chckbx_A, 24, SpringLayout.NORTH, panel_P1);
		sl_panel_P1.putConstraint(SpringLayout.EAST, chckbx_A, -10, SpringLayout.EAST, panel_P1);
		panel_P1.add(chckbx_A);
		
		//atribuindo as listas criadas noPane
		JScrollPane scrollPane = new JScrollPane(lista_A);
		scrollPane.setBounds(0, 23, 379, 69);
		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_Palta.add(scrollPane);

		JPanel panel_Pmedia = new JPanel();
		panel_Pmedia.setBounds(0, 141, 379, 92);
		panel.add(panel_Pmedia);
		panel_Pmedia.setBackground(new Color(240, 240, 240));
		panel_Pmedia.setLayout(null);

		JPanel panel_P5 = new JPanel();
		panel_P5.setBounds(0, 0, 379, 24);
		panel_P5.setBackground(new Color(255, 128, 0));
		panel_Pmedia.add(panel_P5);
		SpringLayout sl_panel_P5 = new SpringLayout();
		panel_P5.setLayout(sl_panel_P5);

		JLabel lblNewLabel_1_3 = new JLabel("MÉDIA");
		sl_panel_P5.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3, 5, SpringLayout.NORTH, panel_P5);
		sl_panel_P5.putConstraint(SpringLayout.WEST, lblNewLabel_1_3, 170, SpringLayout.WEST, panel_P5);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_P5.add(lblNewLabel_1_3);

		JCheckBox chckbx_M = new JCheckBox("");
		chckbx_M.setBackground(new Color(255, 128, 0));
		sl_panel_P5.putConstraint(SpringLayout.NORTH, chckbx_M, 0, SpringLayout.NORTH, panel_P5);
		sl_panel_P5.putConstraint(SpringLayout.SOUTH, chckbx_M, 24, SpringLayout.NORTH, panel_P5);
		sl_panel_P5.putConstraint(SpringLayout.EAST, chckbx_M, -10, SpringLayout.EAST, panel_P5);
		panel_P5.add(chckbx_M);

		JScrollPane scrollPane_1 = new JScrollPane(lista_M);
		scrollPane_1.setBounds(0, 24, 379, 68);
		panel_Pmedia.add(scrollPane_1);

		JPanel panel_Pbaixa = new JPanel();
		panel_Pbaixa.setBounds(0, 256, 379, 92);
		panel.add(panel_Pbaixa);
		panel_Pbaixa.setBackground(new Color(240, 240, 240));
		panel_Pbaixa.setLayout(null);

		JPanel panel_P9 = new JPanel();
		panel_P9.setBounds(0, 0, 379, 24);
		panel_P9.setBackground(new Color(106, 171, 64));
		panel_Pbaixa.add(panel_P9);
		SpringLayout sl_panel_P9 = new SpringLayout();
		panel_P9.setLayout(sl_panel_P9);

		JLabel lblNewLabel_1_7 = new JLabel("BAIXA");
		sl_panel_P9.putConstraint(SpringLayout.NORTH, lblNewLabel_1_7, 5, SpringLayout.NORTH, panel_P9);
		sl_panel_P9.putConstraint(SpringLayout.WEST, lblNewLabel_1_7, 170, SpringLayout.WEST, panel_P9);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_P9.add(lblNewLabel_1_7);

		JCheckBox chckbx_B = new JCheckBox("");
		chckbx_B.setBackground(new Color(106, 171, 64));
		sl_panel_P9.putConstraint(SpringLayout.NORTH, chckbx_B, 0, SpringLayout.NORTH, panel_P9);
		sl_panel_P9.putConstraint(SpringLayout.SOUTH, chckbx_B, 0, SpringLayout.SOUTH, panel_P9);
		sl_panel_P9.putConstraint(SpringLayout.EAST, chckbx_B, -10, SpringLayout.EAST, panel_P9);
		panel_P9.add(chckbx_B);

		JScrollPane scrollPane_2 = new JScrollPane(lista_B);
		scrollPane_2.setBounds(0, 23, 379, 69);
		panel_Pbaixa.add(scrollPane_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(0, 368, 379, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);

		// Janela editar foi criada, essa janela criei fora da parte gráfica
		JFrame novaJanela = new JFrame("EDITAR");// nome da janela e criando um frame
		novaJanela.setSize(400, 200);// tamanho
		novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// inserindo o a operação de fechar default
		novaJanela.setVisible(false);// criei a janela como não visivel primeiramente, se tornando visivel assim que
										// clico no botão de editar
		novaJanela.setLocation(300, 300);// posição da tela
		JPanel Panel_Editar = new JPanel();// criando um Panel para utiliza-lo no frame
		novaJanela.getContentPane().add(Panel_Editar);// adicionando o Panel no frame
		JLabel Jlbl_Editar = new JLabel("EDITE O TEXTO NOVO: ");// inserindo uma label com texto
		Jlbl_Editar.setFont(new Font("Tahoma", Font.BOLD, 11));// mudando os atributos da label
		Jlbl_Editar.setVerticalAlignment(SwingConstants.TOP);// mudando a posição da label
		Jlbl_Editar.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField Jtxt_Editar = new JTextField(20);// criando um text field
		Jtxt_Editar.setBounds(150, 150, 30, 10);// tamanho do text field
		JButton Jbtn_Editar2 = new JButton("Enviar a lista");// criando um botão
		Jbtn_Editar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));// mudando o cursor
		Jbtn_Editar2.setBounds(SwingConstants.BOTTOM, 100, 50, 50);

		// adicionando tudo ao frame da nova janela
		Panel_Editar.add(Jlbl_Editar);
		Panel_Editar.add(Jtxt_Editar);
		Panel_Editar.add(Jbtn_Editar2);
		// criando uma ação para o botão "Enviar a lista" que envia o texto escrito na
		// nova janela para a janela com as listas
		Jbtn_Editar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pegando o texto que foi inserido no text field e o atribuindo a variavel
				// Txt_sub
				String Txt_sub = Jtxt_Editar.getText();
				// declarando uma variavel local
				int i = 0;
				if (chckbx_A.isSelected()) {
					// pego o indice selecionado na lista e insiro na variavel i
					i = lista_A.getSelectedIndex();
					// altero o indice na lista igual ao que foi selecionado, atribuindo o novo
					// texto
					listModel_A1.set(i, i + 1 + " " + Txt_sub);
					// o i + 1 foi utilizado como teste para verificar como o indice da lista estava
					// se comportando não é necessário no código final (como um contador)

					// faço o mesmo para o restante das opções
				} else if (chckbx_M.isSelected()) {
					i = lista_M.getSelectedIndex();
					listModel_M1.set(i, i + 1 + " " + Txt_sub);
				} else if (chckbx_B.isSelected()) {
					i = lista_B.getSelectedIndex();
					listModel_B1.set(i, i + 1 + " " + Txt_sub);

				}
				// após apertar o botão zero as checkbox's selecionadas
				chckbx_A.setSelected(false);
				chckbx_M.setSelected(false);
				chckbx_B.setSelected(false);

				// apago o texto que ficou na textbox
				Jtxt_Editar.setText("");
				// e fecho a janela de editar
				novaJanela.dispose();
			}
		});

		// botão de editar
		JButton Jbtn_Editar = new JButton("");
		Jbtn_Editar.setToolTipText("EDITAR");
		// utilizei icones
		Jbtn_Editar.setIcon(new ImageIcon("C:\\Users\\redev\\Downloads\\editar.png"));

		// Ação para o botão editar
		Jbtn_Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// seleção basica para verificar se alguma prioridade foi selecionada
				if (chckbx_A.isSelected() == false & chckbx_B.isSelected() == false & chckbx_M.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Selecione uma prioridade");
				} else {
					// tentei realizar a set visible true apenas no else mas não funcionou, tive que
					// fazer a seleção if para cada item novamente
					if (chckbx_A.isSelected()) {
						novaJanela.setVisible(true);

					} else if (chckbx_M.isSelected()) {
						novaJanela.setVisible(true);

					} else if (chckbx_B.isSelected()) {
						novaJanela.setVisible(true);

					}

				}

			}
		});
		Jbtn_Editar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Jbtn_Editar.setBounds(0, 0, 126, 70);
		panel_1.add(Jbtn_Editar);
		// botão remover
		JButton Jbtn_remover = new JButton("");
		Jbtn_remover.setToolTipText("LIXEIRA");
		Jbtn_remover.setIcon(new ImageIcon("C:\\Users\\redev\\Downloads\\excluir.png"));

		// ação para o botão
		Jbtn_remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// faço a mesma verificação para cada checkbox
				if (chckbx_A.isSelected() == false & chckbx_B.isSelected() == false & chckbx_M.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Selecione uma prioridade");
				} else {
					// verifico a checkbox selecionada
					if (chckbx_A.isSelected()) {
						// pego o indice por seleção direto, sem a variavel i pois não irei alterar o
						// index na lista, apenas remove-lo
						listModel_A1.remove(lista_A.getSelectedIndex());
					} else if (chckbx_M.isSelected()) {
						listModel_M1.remove(lista_M.getSelectedIndex());
					} else if (chckbx_B.isSelected()) {
						listModel_B1.remove(lista_B.getSelectedIndex());
					}
				}
				// tiro a seleção de todas as caixas
				chckbx_A.setSelected(false);
				chckbx_B.setSelected(false);
				chckbx_M.setSelected(false);
			}
		});
		// atributos do botão
		Jbtn_remover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Jbtn_remover.setBounds(244, 0, 135, 70);
		panel_1.add(Jbtn_remover);

		// botão para mover o item da lista para cima
		JButton Jbtn_cima = new JButton("");
		Jbtn_cima.setToolTipText("UP");
		Jbtn_cima.setIcon(new ImageIcon("C:\\Users\\redev\\Downloads\\seta-dupla-para-cima (1).png"));
		Jbtn_cima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// mais uma seleção para verificar alguma check box foi selecionada
				if (chckbx_A.isSelected() == false & chckbx_B.isSelected() == false & chckbx_M.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Selecione uma Propriedade");
				} else {
					// variavel local
					String Txt_subir;

					if (chckbx_A.isSelected()) {
						// atribuo o indice selecionado a variavel J
						j = lista_A.getSelectedIndex();
						// faço uma verificação para ver se algo foi selecionado
						if (j > 0) {
							// atribuo o texto na posição J para a variavel
							Txt_subir = listModel_A1.elementAt(j);
							// adiciono na lista o texto com a variavel j-1, que é uma posição acima da
							// selecionada
							listModel_A1.add(j - 1, Txt_subir);
							// removo o indice selecionado da lista
							listModel_A1.remove(lista_A.getSelectedIndex());
						} else {
							// caso o usuário não selecione nenhum indice ou chegue ao topo da lista
							JOptionPane.showMessageDialog(null, "Não há como subir mais / Selecione um item da lista");
						}
						// faço o mesmo para as outras listas
					} else if (chckbx_M.isSelected()) {
						j = lista_M.getSelectedIndex();
						if (j > 0) {
							Txt_subir = listModel_M1.elementAt(j);
							listModel_M1.add(j - 1, Txt_subir);
							listModel_M1.remove(lista_M.getSelectedIndex());
						} else {
							JOptionPane.showMessageDialog(null, "Não há como subir mais / Selecione um item da lista");
						}
					} else if (chckbx_B.isSelected()) {
						j = lista_B.getSelectedIndex();
						if (j > 0) {
							Txt_subir = listModel_B1.elementAt(j);
							listModel_B1.add(j - 1, Txt_subir);
							listModel_B1.remove(lista_B.getSelectedIndex());
						} else {
							JOptionPane.showMessageDialog(null, "Não há como subir mais / Selecione um item da lista");
						}
					}
				}
			}
		});
		Jbtn_cima.setBounds(125, 0, 119, 32);
		Jbtn_cima.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(Jbtn_cima);

		// botão mover para baixo
		JButton Jbtn_baixo = new JButton("");
		Jbtn_baixo.setToolTipText("DOWN");
		Jbtn_baixo.setIcon(new ImageIcon("C:\\Users\\redev\\Downloads\\setas-duplas-para-baixo (1).png"));
		Jbtn_baixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// verificação basica
				if (chckbx_A.isSelected() == false & chckbx_B.isSelected() == false & chckbx_M.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Selecione uma Propriedade");
				} else {
					// praticamente a mesma coisa do botão cima as diferenças irei comentar
					String Txt_descer;
					if (chckbx_A.isSelected()) {
						j = lista_A.getSelectedIndex();
						// nessa verificação o indice precisa ser maior que zero E menor que o tamanho
						// da lista -1 (para não funcionar com o ultimo item da lista)
						if (j >= 0 && j < listModel_A1.getSize() - 1) {
							Txt_descer = listModel_A1.elementAt(j);
							// tive que inverter a posição do remove e add em relação ao botao "cima "
							listModel_A1.remove(j);
							listModel_A1.add(1 + j, Txt_descer);
							// Sysout abaixo foi um teste que estava realizando para verificar o
							// funcionamento (o que determinou que eu teria que inverter o remove e o add)
							// System.out.println(lista_A.getSelectedIndex() + " " + listModel_A1.getSize()
							// + " " + j + " " + Txt_descer);
						} else {
							JOptionPane.showMessageDialog(null, "Não há como descer mais / Selecione um item da lista");
						}
					} else if (chckbx_M.isSelected()) {
						j = lista_M.getSelectedIndex();
						if (j >= 0 && j < listModel_M1.getSize() - 1) {
							Txt_descer = listModel_M1.elementAt(j);
							listModel_M1.remove(j);
							listModel_M1.add(1 + j, Txt_descer);
						} else {
							JOptionPane.showMessageDialog(null, "Não há como descer mais / Selecione um item da lista");
						}
					} else if (chckbx_B.isSelected()) {
						j = lista_B.getSelectedIndex();
						if (j >= 0 && j < listModel_B1.getSize() - 1) {
							Txt_descer = listModel_B1.elementAt(j);
							listModel_B1.remove(j);
							listModel_B1.add(j + 1, Txt_descer);

						} else {
							JOptionPane.showMessageDialog(null, "Não há como descer mais / Selecione um item da lista");
						}
					}
				}

			}
		});

		//feito no design
		Jbtn_baixo.setBounds(125, 38, 119, 32);
		Jbtn_baixo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(Jbtn_baixo);
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

		// Botão adicionar
		JButton btn_adicionar = new JButton("");
		btn_adicionar.setIcon(new ImageIcon("C:\\Users\\redev\\Downloads\\adicionar-ficheiro.png"));
		btn_adicionar.addActionListener(new ActionListener() {
			// Ação do botão adicionar
			public void actionPerformed(ActionEvent e) {
				// verificação basica
				if (chbx_Alta.isSelected() == false & chbx_Media.isSelected() == false
						& chbx_Baixa.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Selecione uma prioridade");

				} else {
					// atribuo o que foi escrito no textfield a variavel campotexto
					String campotexto = textField_Inserir.getText();

					// verificação caso não tenha nada escrito no text field
					if (campotexto.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Digite um texto");

					} else if (chbx_Alta.isSelected() == true) {
						// adiciono o texto do textField a lista junto com seu indice + 1 (Como
						// comentado antes o indice foi inserido para testar a funcionalidade da lista )
						listModel_A1.addElement((listModel_A1.getSize() + 1) + " " + campotexto);
						cx.inserir_a1(campotexto);

					} else if (chbx_Media.isSelected() == true) {
						listModel_M1.addElement((listModel_M1.getSize() + 1) + " " + campotexto);
						cx.inserir_m1(campotexto);
					} else if (chbx_Baixa.isSelected() == true) {
						listModel_B1.addElement((listModel_B1.getSize() + 1) + " " + campotexto);
						cx.inserir_b1(campotexto);
					}
				}
				//zero o textfield e as checkbox's
				textField_Inserir.setText("");
				chbx_Alta.setSelected(false);
				chbx_Media.setSelected(false);
				chbx_Baixa.setSelected(false);
			}

		});
		//inserir o botão adicionar 
		btn_adicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_adicionar.setForeground(new Color(0, 0, 0));
		btn_adicionar.setToolTipText("Adiciona item a lista");
		btn_adicionar.setBounds(10, 331, 140, 42);
		panel_ADD.add(btn_adicionar);
		
		JButton btnNewButton = new JButton("Histórico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame janelaHist = new JFrame("Histórico");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(160, 331, 148, 42);
		panel_ADD.add(btnNewButton);

	}
}
