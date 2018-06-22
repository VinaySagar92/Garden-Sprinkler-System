/**
 * @date 12/07/2016
 */

package High;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Medium.Scheduler;
import Medium.Temperature;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.awt.Color;



/**
 * 
 * @author VINAY SAGAR GONABAVI and SHIVAM VARMA
 *
 */

public class Main extends JFrame{
	Container ct;
	private JPanel panel,configurationPanel, panel_1, panel_3, panelGarden_1,groupConfiguration,confPanel,welcome1,panelinstruction,StatusPanel,paneladdon, groupConfiguration_1,panel_2,schedulePanel,temperaturePanel1;
	private JButton button1,button2,button3,button4,btnNewButton_1,welcomebutton1,insttocontrol, b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18, btnNewButton_2,back1,save1,saveSchedule,saveConfButton,scheduleButton,temperatureButton,addontocontrol, statusButtonPanel,statustocontrol, confPaneltocontrol,scheduletocontrol,temptocontrol,addonbutton,enableNorth,enableSouth,enableEast,enableWest,disableNorth,disableSouth,disableEast,disableWest, enableButton3,graphBack2, disableButton3;
	private JTextField nameField, textField44;
	private JLabel lblNewLabel_1, lblNewLabel_2,sprink1,sprink2,sprink3,sprink4,sprink5,sprink6,sprink7,sprink8,sprink9,sprink10,sprink11,sprink12,sprink13,sprink14,sprink15,sprink16, northText, eastText, westText, southText, lblWelcomeToHummingbee, lblhummingbee11, lblhummingbee12, lblNewLabel565656, lblNewLabel, lblhummingbee_1, lblhummingbee_2, lblhummingbee_3;
	public JComboBox dayCombo,hourCombo,minuteCombo,rateCombo,durationCombo, M1,M2,M3,M4,T1,T2,T3,T4,W1,W2,W3,W4,Th1,Th2,Th3,Th4,F1,F2,F3,F4,S1,S2,S3,S4,Su1,Su2,Su3,Su4, areaCombo,temperatureCombo;
	private JCheckBox C1,C2,C3,C4,C5,C6,C7;
	
	private JPasswordField passwordField;
	private int temperature=63;
	
	private Scheduler scheduleN, scheduleE, scheduleS, scheduleW;
	private Temperature tN, tE, tS, tW;
	Graph graphPanel;
	private ListenButton l= new ListenButton();
	private ListenCheckBox lc=new ListenCheckBox();
	FileWriter fw;
	LinkedHashMap<String, Double> XYvalues = new LinkedHashMap<String, Double>();
	//Group g;
	//String fileName;
	FileReader fR;
	private boolean enable=true, enableN=true, enableE=true, enableS=true, enableW=true;
	
	/**
	 * @param null
	 */
	
	public Main() {
		
		Toolkit t=Toolkit.getDefaultToolkit();
		t.getScreenSize();
		this.setBounds(6, 6, 714, 457);
		
		ct=getContentPane();
		getContentPane().setLayout(null); 
																					//addon configuration eanble/diable panel starts here
		paneladdon = new ImagePanel(new ImageIcon(".\\Images\\schedule.jpg").getImage()); 
		paneladdon.setBounds(0, 0, 696, 410);
	//	getContentPane().add(paneladdon);
		
		enableNorth = new JButton("Enable ");
		enableNorth.setBounds(79, 55, 97, 25);
		paneladdon.add(enableNorth);
		enableNorth.addActionListener(l);
		
		disableNorth = new JButton("Disable");
		disableNorth.setBounds(79, 93, 97, 25);
		paneladdon.add(disableNorth);
		disableNorth.addActionListener(l);
		
		enableEast = new JButton("Enable");
		enableEast.setBounds(440, 53, 97, 25);
		paneladdon.add(enableEast);
		enableEast.addActionListener(l);
		
		disableEast = new JButton("Disable");
		disableEast.setBounds(440, 93, 97, 25);
		paneladdon.add(disableEast);
		disableEast.addActionListener(l);
		
		enableWest = new JButton("Enable");
		enableWest.setBounds(79, 249, 97, 25);
		paneladdon.add(enableWest);
		enableWest.addActionListener(l);
		
		disableWest = new JButton("Disable");
		disableWest.setBounds(79, 287, 97, 25);
		paneladdon.add(disableWest);
		disableWest.addActionListener(l);
		
		enableSouth = new JButton("Enable");
		enableSouth.setBounds(440, 249, 97, 25);
		paneladdon.add(enableSouth);
		enableSouth.addActionListener(l);
		
		disableSouth = new JButton("Disable");
		disableSouth.setBounds(440, 287, 97, 25);
		paneladdon.add(disableSouth);
		
		JLabel qwq = new JLabel("North region");
		qwq.setBounds(89, 151, 77, 16);
		paneladdon.add(qwq);
		
		JLabel wew = new JLabel("East region");
		wew.setBounds(460, 151, 77, 16);
		paneladdon.add(wew);
		
		JLabel ere = new JLabel("West region");
		ere.setBounds(89, 344, 74, 16);
		paneladdon.add(ere);
		
		JLabel trt = new JLabel("South region");
		trt.setBounds(460, 344, 77, 16);
		paneladdon.add(trt);
		
		addontocontrol = new JButton("Back");
		addontocontrol.setBounds(587, 13, 97, 49);
		paneladdon.add(addontocontrol);
		addontocontrol.addActionListener(l);
		disableSouth.addActionListener(l);
																							//addon panel ends here
		panel_2 = new JPanel();																//graph panel starts here
		panel_2.setBounds(0, 0, 714, 435);
//		getContentPane().add(panel_2);
		 panel_2.setLayout(null);
//		panel_2.setLayout(absolute);
//		
		graphBack2 = new JButton("Back");
		graphBack2.setBounds(60, 388, 75, 29);
		panel_2.add(graphBack2);
		graphBack2.addActionListener(l);
		
	    panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 714, 376);
		panel_2.add(panel_3);
//		graphBack2.addActionListener(l);													//graph panel ends here
	                                           				//temp panel starts
	
		
		temperaturePanel1 = new ImagePanel(new ImageIcon(".\\Images\\temperature1.jpg").getImage()); 
		temperaturePanel1.setBounds(0, 0, 708, 429);
	//	getContentPane().add(temperaturePanel1);
		temperaturePanel1.setLayout(null);
		
		JLabel label98 = new JLabel("Current temperature is   :");
		label98.setBounds(185, 194, 171, 28);
		temperaturePanel1.add(label98);
		
		temperatureCombo = new JComboBox();
		temperatureCombo.setModel(new DefaultComboBoxModel(new String[] {"30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		temperatureCombo.setBounds(346, 196, 84, 27);
		temperatureCombo.setSelectedIndex(33);
		temperaturePanel1.add(temperatureCombo);
		
		
		JLabel label96 = new JLabel("degree Farenheit");
		label96.setBounds(426, 200, 113, 16);
		temperaturePanel1.add(label96);
		
		 temptocontrol = new JButton("Save");
		temptocontrol.setBounds(322, 253, 84, 37);
		temperaturePanel1.add(temptocontrol);
		
		lblhummingbee11 = new JLabel("@HummingBee");
		lblhummingbee11.setBounds(595, 395, 107, 28);
		temperaturePanel1.add(lblhummingbee11);
		temptocontrol.addActionListener(l);							//temp panel ends
																	//schedule panel starts
		 schedulePanel =new ImagePanel(new ImageIcon(".\\Images\\schedule.jpg").getImage()); 
		schedulePanel.setBounds(0, 0, 714, 435);
	//	getContentPane().add(schedulePanel);
		schedulePanel.setLayout(null);
		
		javax.swing.border.Border border=LineBorder.createBlackLineBorder();
		
		northText = new JLabel("",SwingConstants.CENTER);
		
		northText.setBackground(Color.LIGHT_GRAY);
	//	northText.setEditable(false);
		northText.setBounds(0, 0, 328, 143);
		//northText.a
		schedulePanel.add(northText);
		northText.setBorder(border);
//		northText.setColumns(10);
		
		eastText = new JLabel("",SwingConstants.CENTER);
		eastText.setBackground(Color.LIGHT_GRAY);
	//	eastText.setEditable(false);
		eastText.setBounds(380, 0, 328, 143);
		schedulePanel.add(eastText);
		eastText.setBorder(border);
	//	eastText.setColumns(10);
		
		westText = new JLabel("",SwingConstants.CENTER);
		westText.setBackground(Color.LIGHT_GRAY);
//		westText.setEditable(false);
		westText.setBounds(6, 218, 328, 143);
		schedulePanel.add(westText);
		westText.setBorder(border);
//		westText.setColumns(10);
		
		southText = new JLabel("",SwingConstants.CENTER);
		southText.setBackground(Color.LIGHT_GRAY);
//		southText.setEditable(false);
		southText.setBounds(380, 218, 328, 143);
		schedulePanel.add(southText);
		southText.setBorder(border);
	//	southText.setColumns(10);
		
		JLabel labelregin1 = new JLabel("North Region");
		labelregin1.setBounds(123, 146, 94, 16);
		schedulePanel.add(labelregin1);
		
		JLabel labelregi2 = new JLabel("East Region");
		labelregi2.setBounds(500, 146, 83, 16);
		schedulePanel.add(labelregi2);
		
		JLabel labelregi3 = new JLabel("West Region");
		labelregi3.setBounds(123, 373, 94, 16);
		schedulePanel.add(labelregi3);
		
		JLabel labelregi4 = new JLabel("South Region");
		labelregi4.setBounds(500, 366, 83, 16);
		schedulePanel.add(labelregi4);
		
		 scheduletocontrol = new JButton("Back");
		scheduletocontrol.setBounds(286, 382, 117, 36);
		schedulePanel.add(scheduletocontrol);
		
		lblhummingbee12 = new JLabel("@HummingBee");
		lblhummingbee12.setBounds(607, 404, 107, 31);
		schedulePanel.add(lblhummingbee12);
		scheduletocontrol.addActionListener(l);
																	//schedule panel ends

	
		                                               //status panel start here
		StatusPanel = new ImagePanel(new ImageIcon(".\\Images\\gardenImage.jpg").getImage());
		StatusPanel.setBounds(0, 6, 708, 423);
		StatusPanel.setLayout(null);
		
	    statustocontrol = new JButton("Back");
		statustocontrol.setBounds(279, 372, 117, 45);
		StatusPanel.add(statustocontrol);
		statustocontrol.addActionListener(l);
		
		sprink2 = new JLabel("New label");
		sprink2.setBounds(179, 23, 40, 40);
		StatusPanel.add(sprink2);
		
		sprink1 = new JLabel("New label");
		sprink1.setBounds(307, 23, 40, 40);
		StatusPanel.add(sprink1);
		
		sprink3 = new JLabel("New label");
		sprink3.setIcon(new ImageIcon(".\\Images\\on.jpg"));
		sprink3.setBounds(307, 116, 40, 40);
		StatusPanel.add(sprink3);
		
		sprink5 = new JLabel("New label");
		sprink5.setBounds(564, 116, 40, 40);
		StatusPanel.add(sprink5);
		
		sprink4 = new JLabel("New label");
		sprink4.setBounds(447, 23, 40, 40);
		StatusPanel.add(sprink4);
		
		sprink6 = new JLabel("New label");
		sprink6.setBounds(584, 222, 40, 40);
		StatusPanel.add(sprink6);
		
		sprink8 = new JLabel("New label");
		sprink8.setBounds(447, 185, 40, 40);
		StatusPanel.add(sprink8);
		
		sprink7 = new JLabel("New label");
		sprink7.setBounds(495, 295, 40, 40);
		StatusPanel.add(sprink7);
		
		sprink9 = new JLabel("New label");
		sprink9.setBounds(356, 281, 40, 40);
		StatusPanel.add(sprink9);
		
		sprink10 = new JLabel("New label");
		sprink10.setBounds(419, 360, 40, 40);
		StatusPanel.add(sprink10);
		
		sprink11 = new JLabel("New label");
		sprink11.setBounds(239, 281, 40, 40);
		StatusPanel.add(sprink11);
		
		sprink12 = new JLabel("New label");
		sprink12.setBounds(200, 372, 40, 40);
		StatusPanel.add(sprink12);
		
		sprink13 = new JLabel("New label");
		sprink13.setBounds(45, 321, 40, 40);
		StatusPanel.add(sprink13);
		
		sprink14 = new JLabel("New label");
		sprink14.setBounds(129, 222, 40, 40);
		StatusPanel.add(sprink14);
		
		sprink15 = new JLabel("New label");
		sprink15.setBounds(16, 174, 40, 40);
		StatusPanel.add(sprink15);
		
		sprink16 = new JLabel("New label");
		sprink16.setBounds(129, 116, 40, 40);
		StatusPanel.add(sprink16);
		
		lblNewLabel565656 = new JLabel("@HummingBee");
		lblNewLabel565656.setBounds(608, 0, 100, 30);
		StatusPanel.add(lblNewLabel565656);
		                                              //status panel ends here               
		                                            //panel instruction starts here
		panelinstruction = new ImagePanel(new ImageIcon(".\\Images\\instruction.jpg").getImage()); 
		panelinstruction.setBounds(0, 0, 710, 430);
	//	getContentPane().add(panelinstruction);
		panelinstruction.setLayout(null);
		
		JTextArea textAreaInst = new JTextArea();
		textAreaInst.setText("Welcome to Humming Bee Home Garden Sprinkler System!\n\nPlease keep the following in mind while operating the system:-\n\n1. You can schedule the system by group on weekly basis for different timings on each day.\n\n2. Based on the temperature, your schedule will be overridden considering the health of plants.\n\n3. You can enable or disable the system.\n\n4. You can view the graph of water consumed for a week by group.\n");
		textAreaInst.setLineWrap(true);
		textAreaInst.setEditable(false);
		textAreaInst.setBounds(0, 0, 696, 351);
		panelinstruction.add(textAreaInst);
		textAreaInst.setOpaque(false);
		
		insttocontrol = new JButton("Next");
		insttocontrol.setBounds(284, 363, 117, 43);
		panelinstruction.add(insttocontrol);
		
		lblNewLabel = new JLabel("@HummingBee");
		lblNewLabel.setBounds(611, 402, 99, 28);
		panelinstruction.add(lblNewLabel);
		insttocontrol.addActionListener(l);
		       										////panel instruction ends here
													// welcome1 starts here	
		
		
		welcome1 = new ImagePanel(new ImageIcon(".\\Images\\water.jpg").getImage()); 
		welcome1.setBounds(0, 0, 714, 435);
		getContentPane().add(welcome1);
		welcome1.setLayout(null);
		
		JLabel lblNewLabel55 = new JLabel("User Login");
		lblNewLabel55.setBounds(196, 125, 112, 32);
		welcome1.add(lblNewLabel55);
		
		textField44 = new JTextField();
		textField44.setBounds(390, 125, 118, 32);
		welcome1.add(textField44);
		textField44.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(196, 232, 94, 25);
		welcome1.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(390, 232, 118, 25);
		welcome1.add(passwordField);
		
		 welcomebutton1 = new JButton("Next");
		welcomebutton1.setBounds(308, 349, 117, 46);
		welcome1.add(welcomebutton1);
		
		lblWelcomeToHummingbee = new JLabel("WELCOME TO HUMMINGBEE HOME GARDEN SPRINKLER SYSYTEM");
		lblWelcomeToHummingbee.setHorizontalAlignment(SwingConstants.CENTER);
	//	lblWelcomeToHummingbee.(true);
	//	lblWelcomeToHummingbee.setBackground(Color.WHITE);
		int style=Font.BOLD+Font.ITALIC;
		
		Font font=new Font("serif",style,21);
		lblWelcomeToHummingbee.setFont(font);
		lblWelcomeToHummingbee.setBounds(21, 23, 687, 90);
		welcome1.add(lblWelcomeToHummingbee);
		
		 JLabel lblhummingbee44 = new JLabel("@HummingBee");
		lblhummingbee44.setBounds(615, 410, 99, 25);
		welcome1.add(lblhummingbee44);
		welcomebutton1.addActionListener(l);
	//	ct.add(welcome1);
		              									//welcome1 ends here
	             									//CofPanel starts here
	    confPanel = new ImagePanel(new ImageIcon(".\\Images\\water.jpg").getImage()); 
		confPanel.setBounds(0, 6, 708, 423);
	//	getContentPane().add(confPanel);
		confPanel.setLayout(null);
	//	ct.add(confPanel);
		
		 C1 = new JCheckBox("Monday");
		C1.setBounds(69, 91, 128, 23);
		confPanel.add(C1);
		C1.addItemListener(lc);
		
		 C2 = new JCheckBox("Tuesday");
		C2.setBounds(69, 138, 128, 23);
		confPanel.add(C2);
		C2.addItemListener(lc);
		
		 C3 = new JCheckBox("Wednesday");
		C3.setBounds(69, 189, 128, 23);
		confPanel.add(C3);
		C3.addItemListener(lc);
		
		 C4 = new JCheckBox("Thursday");
		C4.setBounds(69, 241, 128, 23);
		confPanel.add(C4);
		C4.addItemListener(lc);
		
		 C5 = new JCheckBox("Friday");
		C5.setBounds(69, 297, 128, 23);
		confPanel.add(C5);
		C5.addItemListener(lc);
		
		 C6 = new JCheckBox("Saturday");
		C6.setBounds(69, 347, 128, 23);
		confPanel.add(C6);
		C6.addItemListener(lc);
		
		 C7 = new JCheckBox("Sunday");
		C7.setBounds(69, 394, 128, 23);
		confPanel.add(C7);
		C7.addItemListener(lc);
		
		JLabel lblNewLabel23 = new JLabel("Start Time");
		lblNewLabel23.setBounds(265, 22, 70, 41);
		confPanel.add(lblNewLabel23);
		
		 M1 = new JComboBox();
		M1.setEnabled(false);
		M1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		M1.setBounds(209, 91, 84, 27);
		confPanel.add(M1);
		
		 M2 = new JComboBox();
		M2.setEnabled(false);
		M2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		M2.setBounds(329, 91, 84, 27);
		confPanel.add(M2);
		
		 M3 = new JComboBox();
		M3.setEnabled(false);
		M3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		M3.setBounds(443, 91, 84, 27);
		confPanel.add(M3);
		
		 M4 = new JComboBox();
		M4.setEnabled(false);
		M4.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3"}));
		M4.setBounds(570, 91, 84, 27);
		confPanel.add(M4);
		
		 T1 = new JComboBox();
		T1.setEnabled(false);
		T1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		T1.setBounds(200, 138, 85, 27);
		confPanel.add(T1);
		
		 T2 = new JComboBox();
		T2.setEnabled(false);
		T2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		T2.setBounds(329, 138, 84, 27);
		confPanel.add(T2);
		
		 T3 = new JComboBox();
		T3.setEnabled(false);
		T3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		T3.setBounds(443, 138, 84, 27);
		confPanel.add(T3);
		
		 T4 = new JComboBox();
		T4.setEnabled(false);
		T4.setModel(new DefaultComboBoxModel(new String[] { "1", "2","3"}));
		T4.setBounds(570, 138, 84, 27);
		confPanel.add(T4);
		
		 W1 = new JComboBox();
		W1.setEnabled(false);
		W1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		W1.setBounds(200, 189, 84, 27);
		confPanel.add(W1);
		
		 W2 = new JComboBox();
		W2.setEnabled(false);
		W2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		W2.setBounds(329, 189, 84, 27);
		confPanel.add(W2);
		
		 W3 = new JComboBox();
		W3.setEnabled(false);
		W3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		W3.setBounds(443, 185, 84, 27);
		confPanel.add(W3);
		
		 W4 = new JComboBox();
		W4.setEnabled(false);
		W4.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3"}));
		W4.setBounds(570, 185, 84, 27);
		confPanel.add(W4);
		
		 Th1 = new JComboBox();
		Th1.setEnabled(false);
		Th1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		Th1.setBounds(200, 241, 84, 27);
		confPanel.add(Th1);
		
		 Th2 = new JComboBox();
		Th2.setEnabled(false);
		Th2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		Th2.setBounds(329, 241, 84, 27);
		confPanel.add(Th2);
		
		 Th3 = new JComboBox();
		Th3.setEnabled(false);
		Th3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		Th3.setBounds(443, 241, 84, 27);
		confPanel.add(Th3);
		
		 Th4 = new JComboBox();
		Th4.setEnabled(false);
		Th4.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3"}));
		Th4.setBounds(570, 237, 84, 27);
		confPanel.add(Th4);
		
		 F1 = new JComboBox();
		F1.setEnabled(false);
		F1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		F1.setBounds(200, 297, 84, 27);
		confPanel.add(F1);
		
		 F2 = new JComboBox();
		F2.setEnabled(false);
		F2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		F2.setBounds(329, 297, 84, 27);
		confPanel.add(F2);
		
		 F3 = new JComboBox();
		F3.setEnabled(false);
		F3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		F3.setBounds(443, 297, 84, 27);
		confPanel.add(F3);
		
		 F4 = new JComboBox();
		F4.setEnabled(false);
		F4.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3"}));
		F4.setBounds(570, 297, 84, 27);
		confPanel.add(F4);
		
		S1 = new JComboBox();
		S1.setEnabled(false);
		S1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		S1.setBounds(200, 347, 84, 27);
		confPanel.add(S1);
		
		S2 = new JComboBox();
		S2.setEnabled(false);
		S2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		S2.setBounds(329, 347, 84, 27);
		confPanel.add(S2);
		
		S3 = new JComboBox();
		S3.setEnabled(false);
		S3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		S3.setBounds(443, 347, 84, 27);
		confPanel.add(S3);
		
		S4 = new JComboBox();
		S4.setEnabled(false);
		S4.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3"}));
		S4.setBounds(570, 347, 84, 27);
		confPanel.add(S4);
		
		Su1 = new JComboBox();
		Su1.setEnabled(false);
		Su1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		Su1.setBounds(200, 394, 84, 27);
		confPanel.add(Su1);
		
		Su2 = new JComboBox();
		Su2.setEnabled(false);
		Su2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		Su2.setBounds(329, 394, 84, 27);
		confPanel.add(Su2);
		
		Su3 = new JComboBox();
		Su3.setEnabled(false);
		Su3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		Su3.setBounds(443, 394, 84, 27);
		confPanel.add(Su3);
		
		Su4 = new JComboBox();
		Su4.setEnabled(false);
		Su4.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3"}));
		Su4.setBounds(570, 394, 84, 27);
		confPanel.add(Su4);
		
		JLabel lblHour11 = new JLabel("Hour");
		lblHour11.setBounds(223, 63, 61, 16);
		confPanel.add(lblHour11);
		
		JLabel lblMinute = new JLabel("Minute");
		lblMinute.setBounds(341, 63, 61, 16);
		confPanel.add(lblMinute);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(453, 60, 61, 16);
		confPanel.add(lblDuration);
		
		JLabel lblRate = new JLabel("Rate(Units)");
		lblRate.setBounds(570, 63, 84, 16);
		confPanel.add(lblRate);
		
		 saveConfButton = new JButton("SAVE");
		saveConfButton.setBounds(596, 6, 84, 45);
		confPanel.add(saveConfButton);
		saveConfButton.addActionListener(l);
		
		lblNewLabel_2 = new JLabel("Select Area");
		lblNewLabel_2.setBounds(29, 22, 92, 16);
		confPanel.add(lblNewLabel_2);
		
		areaCombo = new JComboBox();
		areaCombo.setModel(new DefaultComboBoxModel(new String[] {"N", "S", "E", "W"}));
		areaCombo.setBounds(145, 15, 61, 27);
		confPanel.add(areaCombo);
		
		confPaneltocontrol = new JButton("BACK");
		confPaneltocontrol.setBounds(489, 7, 84, 45);
		confPanel.add(confPaneltocontrol);
		
		lblhummingbee_1 = new JLabel("@HummingBee");
		lblhummingbee_1.setBounds(0, 0, 100, 23);
		confPanel.add(lblhummingbee_1);
		saveConfButton.addActionListener(l);
		confPaneltocontrol.addActionListener(l);
	                                                           //confPanel ends here       
		
		
	    groupConfiguration = new JPanel();                 //group congiguration panel starts here
	    groupConfiguration_1 = new ImagePanel(new ImageIcon(".\\Images\\water.jpg").getImage());    //look
		groupConfiguration_1.setBounds(6, 6, 702, 423);
		groupConfiguration_1.setLayout(null);
		
		JLabel photolabel = new JLabel();
		photolabel.setBounds(401, 0, 301, 264);
		photolabel.setIcon(new ImageIcon(new ImageIcon(".\\Images\\gardenArea.jpg").getImage().getScaledInstance(301, 264, Image.SCALE_DEFAULT)));
	    groupConfiguration_1.add(photolabel);
		
	    back1 = new JButton("Back");
		back1.setBounds(6, 6, 117, 59);
		groupConfiguration_1.add(back1);
		back1.addActionListener(l);
		
	    save1 = new JButton("Save");
		save1.setBounds(547, 335, 127, 59);
		groupConfiguration_1.add(save1);
		save1.addActionListener(l);
		
		JLabel lblNewLabel2 = new JLabel("Select Area");
		lblNewLabel2.setBounds(61, 100, 78, 26);
		groupConfiguration_1.add(lblNewLabel2);
		
		JComboBox comboBox12 = new JComboBox();
		comboBox12.setModel(new DefaultComboBoxModel(new String[] {"NORTH", "SOUTH", "EAST", "WEST"}));
		comboBox12.setBounds(169, 101, 117, 27);
		groupConfiguration_1.add(comboBox12);
		
		JLabel lblNewLabel3 = new JLabel("Select day");
		lblNewLabel3.setBounds(61, 145, 78, 26);
		groupConfiguration_1.add(lblNewLabel3);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", ""}));
		comboBox1.setBounds(169, 146, 117, 27);
		groupConfiguration_1.add(comboBox1);
		
		JLabel lblNewLabel4 = new JLabel("Select start time  -  ");
		lblNewLabel4.setBounds(61, 205, 127, 16);
		groupConfiguration_1.add(lblNewLabel4);
		
		JLabel lblHour1 = new JLabel("Hour");
		lblHour1.setBounds(111, 233, 61, 16);
		groupConfiguration_1.add(lblHour1);
		
		JLabel lblNewLabel5 = new JLabel("minutes");
		lblNewLabel5.setBounds(223, 233, 61, 16);
		groupConfiguration_1.add(lblNewLabel5);
		
		JComboBox comboBox2= new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox2.setBounds(111, 261, 77, 27);
		groupConfiguration_1.add(comboBox2);
		
		JComboBox comboBox3 = new JComboBox();
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox3.setBounds(212, 261, 74, 27);
		groupConfiguration_1.add(comboBox3);
		
		JLabel lblNewLabel6 = new JLabel("Duration(Minutes)      :  ");
		lblNewLabel6.setBounds(61, 316, 149, 26);
		groupConfiguration_1.add(lblNewLabel6);
		
		JComboBox comboBox4 = new JComboBox();
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox4.setBounds(243, 317, 78, 27);
		groupConfiguration_1.add(comboBox4);
		
		JLabel lblNewLabel7= new JLabel("Water Flow Intensity  :  ");
		lblNewLabel7.setBounds(61, 378, 149, 16);
		groupConfiguration_1.add(lblNewLabel7);
		
		JComboBox comboBox5 = new JComboBox();
		comboBox5.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "2"}));
		comboBox5.setBounds(223, 374, 78, 27);
		groupConfiguration_1.add(comboBox5);
		
		JLabel lblNewLabel_8 = new JLabel("units");
		lblNewLabel_8.setBounds(303, 378, 61, 16);
		groupConfiguration_1.add(lblNewLabel_8);
		
	    configurationPanel = new JPanel();                        // individual sprinkler starts here
	    configurationPanel.setLayout(null);
	    configurationPanel = new ImagePanel(new ImageIcon(".\\Images\\water.jpg").getImage());   //look
     	configurationPanel.setBounds(6, 6, 702, 423);
     	
     	JLabel lblNewLabel1 = new JLabel("Name of the Sprinkler");
     	lblNewLabel1.setBounds(114, 66, 223, 29);
     	configurationPanel.add(lblNewLabel1);
     	
     	nameField = new JTextField();
     	nameField.setToolTipText("");
     	nameField.setBounds(349, 67, 213, 26);
     	configurationPanel.add(nameField);
     	nameField.setColumns(10);
     	
     	lblNewLabel_1 = new JLabel("Select day                              :");
     	lblNewLabel_1.setBounds(114, 128, 228, 29);
     	configurationPanel.add(lblNewLabel_1);
     	
     	String day[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
     	
        dayCombo = new JComboBox(day);
     	dayCombo.setBounds(349, 124, 213, 39);    	
     	configurationPanel.add(dayCombo);
     	
     	JLabel lblNewLabel_2 = new JLabel("Time to Start                         :");
     	lblNewLabel_2.setBounds(114, 214, 197, 26);
     	configurationPanel.add(lblNewLabel_2);
     	
        hourCombo = new JComboBox();
     	hourCombo.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
     	hourCombo.setToolTipText("");
     	hourCombo.setBounds(367, 215, 70, 27);
     	configurationPanel.add(hourCombo);
     	
     	JLabel lblHour = new JLabel("Hour");
     	lblHour.setBounds(330, 219, 42, 16);
     	configurationPanel.add(lblHour);
     	
     	JLabel lblMinute11 = new JLabel("Minute");
     	lblMinute11.setBounds(477, 219, 61, 16);
     	configurationPanel.add(lblMinute11);
     	
        minuteCombo = new JComboBox();
     	minuteCombo.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
     	minuteCombo.setToolTipText("");
     	minuteCombo.setBounds(545, 215, 70, 27);
     	configurationPanel.add(minuteCombo);
     	
     	JLabel lblDuration11 = new JLabel("Duration(Minutes)                   :");
     	lblDuration11.setBounds(114, 295, 197, 26);
     	configurationPanel.add(lblDuration11);
     	
        durationCombo = new JComboBox();
     	durationCombo.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
     	durationCombo.setToolTipText("");
     	durationCombo.setBounds(349, 296, 70, 27);
     	configurationPanel.add(durationCombo);
     	
     	JLabel lblNewLabel33 = new JLabel("Water Flow rate");
     	lblNewLabel33.setBounds(114, 376, 197, 26);
     	configurationPanel.add(lblNewLabel33);
     	
     	 rateCombo = new JComboBox();
     	rateCombo.setModel(new DefaultComboBoxModel(new String[] {"0.5 ", "1", "2"}));
     	rateCombo.setBounds(335, 376, 84, 28);
     	configurationPanel.add(rateCombo);
     	
     	JLabel lblNewLabel_4 = new JLabel("units");
     	lblNewLabel_4.setBounds(418, 381, 61, 16);
     	configurationPanel.add(lblNewLabel_4);
     	
        saveSchedule = new JButton("Save");
     	saveSchedule.setBounds(568, 368, 117, 45);
     	configurationPanel.add(saveSchedule);
     	saveSchedule.addActionListener(l);
     	
        btnNewButton_1 = new JButton("Back");
     	btnNewButton_1.setBounds(6, 6, 84, 45);
     	configurationPanel.add(btnNewButton_1);
     	btnNewButton_1.addActionListener(l);
     	
     	JLabel label = new JLabel("");
     	label.setBounds(85, 154, 223, 29);
     	configurationPanel.add(label);                                // configuration panel ends here
		
		panelGarden_1=new ImagePanel(new ImageIcon(".\\Images\\gardenImage.jpg").getImage());
		panelGarden_1.setBounds(6, 6, 702, 463);
		panelGarden_1.setLayout(null);                          // garden layout panel
		
		
		b1 = new JButton("N1");
		b1.setBounds(179, 17, 25, 29);
		panelGarden_1.add(b1);
		b1.addActionListener(l);
		
        b2 = new JButton("N2");
		b2.setBounds(342, 6, 32, 29);
		panelGarden_1.add(b2);
		b2.addActionListener(l);
		
	    b3 = new JButton("N3");
		b3.setBounds(292, 103, 25, 29);
		panelGarden_1.add(b3);
		b3.addActionListener(l);
		
		b4 = new JButton("N4");
		b4.setBounds(464, 72, 25, 29);
		panelGarden_1.add(b4);
		b4.addActionListener(l);
		
		 b8 = new JButton("E3");
		b8.setBounds(464, 251, 25, 29);
		panelGarden_1.add(b8);
		b8.addActionListener(l);
		
		 b7 = new JButton("E2");
		b7.setBounds(642, 216, 25, 29);
		panelGarden_1.add(b7);
		b7.addActionListener(l);
		
	    b9 = new JButton("S3");
		b9.setBounds(384, 343, 25, 29);
		panelGarden_1.add(b9);
		b9.addActionListener(l);
		
	    b10 = new JButton("S4");
		b10.setBounds(247, 378, 32, 29);
		panelGarden_1.add(b10);
		b10.addActionListener(l);
		
	    b11 = new JButton("S1");
		b11.setBounds(320, 251, 32, 29);
		panelGarden_1.add(b11);
		b11.addActionListener(l);
		
        b13 = new JButton("W1");
		b13.setBounds(205, 216, 32, 29);
		panelGarden_1.add(b13);
		b13.addActionListener(l);
		
        b15 = new JButton("W2");
		b15.setBounds(127, 127, 31, 29);
		panelGarden_1.add(b15);
		b15.addActionListener(l);
		
        b16 = new JButton("W4");
		b16.setBounds(31, 288, 32, 29);
		panelGarden_1.add(b16);
		b16.addActionListener(l);
		
        b14 = new JButton("W3");
		b14.setBounds(31, 144, 32, 29);
		panelGarden_1.add(b14);
		b14.addActionListener(l);
      
		b12 = new JButton("S2");
		b12.setBounds(172, 307, 32, 29);
		panelGarden_1.add(b12);		
		b12.addActionListener(l);
		
        b5 = new JButton("E1");
		b5.setBounds(533, 144, 25, 29);
		panelGarden_1.add(b5);
		b5.addActionListener(l);
		
	     b6 = new JButton("E4");
		b6.setBounds(585, 343, 25, 29);
		panelGarden_1.add(b6);
		b6.addActionListener(l);
		
      	btnNewButton_2 = new JButton("Back To Menu");
		btnNewButton_2.setBounds(0, 6, 99, 51);
		panelGarden_1.add(btnNewButton_2);
		
		lblhummingbee_2 = new JLabel("@HummingBee");
		lblhummingbee_2.setBounds(603, 54, 99, 29);
		panelGarden_1.add(lblhummingbee_2);
		btnNewButton_2.addActionListener(l);                              // garden layout panel ends here
		
		panel = new JPanel();                                            //First panel starts here
		panel.setBounds(6, 6, 714, 457);
	
		panel_1 = new ImagePanel(new ImageIcon(".\\Images\\sprinkler.jpg").getImage());
		panel_1.setBounds(6, 6, 714, 429);
		panel_1.setLayout(null);
		
		button1 = new JButton("Garden layout");
		button1.setBounds(6, 6, 173, 102);
		button1.addActionListener(l);
		panel_1.add(button1);
		
		button3 = new JButton("Configuration by group");
		button3.setBounds(6, 289, 173, 102);
		panel_1.add(button3);
		button3.addActionListener(l);
		
		
		button4 = new JButton("Water Usage ");
		button4.setBounds(524, 293, 163, 95);
		panel_1.add(button4);
		button4.addActionListener(l);  
		
		statusButtonPanel = new JButton("View Status");
		statusButtonPanel.setBounds(290, 152, 150, 35);
		panel_1.add(statusButtonPanel);
		statusButtonPanel.addActionListener(l);
		
		scheduleButton = new JButton("View Schedule");
		scheduleButton.setBounds(524, 6, 163, 102);
		panel_1.add(scheduleButton);
		scheduleButton.addActionListener(l);
		
		temperatureButton = new JButton("Temperature");
		temperatureButton.setBounds(290, 249, 150, 35);
		panel_1.add(temperatureButton);
		temperatureButton.addActionListener(l);
		
		enableButton3 = new JButton("Enable");
		enableButton3.setBounds(241, 43, 85, 29);
		panel_1.add(enableButton3);
		enableButton3.addActionListener(l);
		
		disableButton3 = new JButton("Disable");
		disableButton3.setBounds(371, 43, 85, 29);
		panel_1.add(disableButton3);
		
		lblhummingbee_3 = new JLabel("@HummingBee");
		lblhummingbee_3.setBounds(606, 400, 102, 29);
		panel_1.add(lblhummingbee_3);
		
		 addonbutton = new JButton("Group Act/Deact");
		addonbutton.setBounds(290, 345, 150, 35);
		panel_1.add(addonbutton);
		addonbutton.addActionListener(l);
		disableButton3.addActionListener(l);
		
		
		   //First panel ends here
		
	
	}
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main m1 = new Main();
					m1.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
/**
* 
* @author VINAY SAGAR GONABAVI and SHIVAM VARMA
*
**/
class ListenButton implements ActionListener {
	
	String fileName;
	String details;
	
		/**
		 * @param fileName: String
		 */
	
	     public void loadFile(String fileName){
	    	 this.fileName=fileName;
	    	 
	    	 FileWriter fw;
				try {
					fw = new FileWriter(fileName);
					BufferedWriter bw=new BufferedWriter(fw);
					
					if(C1.isSelected()){
						
					   details=areaCombo.getSelectedItem().toString()+","+"Monday"+","+M1.getSelectedItem()+","+M2.getSelectedItem()+","+M3.getSelectedItem()+","+M4.getSelectedItem();
					   bw.write(details);
					   bw.newLine();
					   System.out.println(details);
					   
						}
					if(C2.isSelected()){
						details=areaCombo.getSelectedItem().toString()+","+"Tuesday"+","+T1.getSelectedItem()+","+T2.getSelectedItem()+","+T3.getSelectedItem()+","+T4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C3.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Wednesday"+","+W1.getSelectedItem()+","+W2.getSelectedItem()+","+W3.getSelectedItem()+","+W4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C4.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Thursday"+","+Th1.getSelectedItem()+","+Th2.getSelectedItem()+","+Th3.getSelectedItem()+","+Th4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C5.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Friday"+","+F1.getSelectedItem()+","+F2.getSelectedItem()+","+F3.getSelectedItem()+","+F4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C6.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Saturday"+","+S1.getSelectedItem()+","+S2.getSelectedItem()+","+S3.getSelectedItem()+","+S4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C7.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Sunday"+","+Su1.getSelectedItem()+","+Su2.getSelectedItem()+","+Su3.getSelectedItem()+","+Su4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					
					bw.close();
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
	    	 
	     }

		/**
		 * @param ActioneEvent e
		 */
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button1){
			    ct.removeAll();
				ct.add(panelGarden_1);
				
				}
			if(e.getSource()==b1||e.getSource()==b2||e.getSource()==b3||e.getSource()==b4||e.getSource()==b5||e.getSource()==b6||e.getSource()==b7||e.getSource()==b8||e.getSource()==b9||e.getSource()==b10||e.getSource()==b11||e.getSource()==b12||e.getSource()==b13||e.getSource()==b14||e.getSource()==b15||e.getSource()==b16||e.getSource()==b17||e.getSource()==b18){
				ct.removeAll();
				String name= ((JButton) e.getSource()).getText();
				nameField.setText("Sprinkler "+name);
				ct.add(confPanel);
				
			}
			if(e.getSource()==btnNewButton_1){
				ct.removeAll();
				ct.add(panelGarden_1);
			}
			
			
			if(e.getSource()==btnNewButton_2||e.getSource()==back1){
				ct.removeAll();
				ct.add(panel_1);
			}
			if(e.getSource()==button2){
				ct.removeAll();
				ct.add(configurationPanel);
			}
			if(e.getSource()==button3){
				ct.removeAll();
				ct.add(confPanel);
			}
			if(e.getSource()==button4){
				
				XYvalues.put("N", (double)scheduleN.g.groupWaterUsage);
				XYvalues.put("E", (double)scheduleE.g.groupWaterUsage);
				XYvalues.put("S",(double) scheduleS.g.groupWaterUsage);
				XYvalues.put("W",(double) scheduleW.g.groupWaterUsage);
				String xRepresentation="region";
				String yRepresentation="water usage(units)";
				
			    Graph graphPanel= new Graph(XYvalues, 200, xRepresentation, yRepresentation, 200.0);
				graphPanel.setPreferredSize(new Dimension(714,390));
				panel_3.add(graphPanel);
				ct.removeAll();
				ct.add(panel_2);
				
			}
			
			if(e.getSource()==scheduleButton){
				
				northText.setText("<html>"+scheduleN.sup[0]+"<br>"+scheduleN.sup[1]+"<br>"+scheduleN.sup[2]+"<br>"+scheduleN.sup[3]+"<br>"+scheduleN.sup[4]+"<br>"+scheduleN.sup[5]+"<html>");
				eastText.setText("<html>"+scheduleE.sup[0]+"<br>"+scheduleE.sup[1]+"<br>"+scheduleE.sup[2]+"<br>"+scheduleE.sup[3]+"<br>"+scheduleE.sup[4]+"<br>"+scheduleE.sup[5]+"<html>");
				southText.setText("<html>"+scheduleS.sup[0]+"<br>"+scheduleS.sup[1]+"<br>"+scheduleS.sup[2]+"<br>"+scheduleS.sup[3]+"<br>"+scheduleS.sup[4]+"<br>"+scheduleS.sup[5]+"<html>");
				westText.setText("<html>"+scheduleW.sup[0]+"<br>"+scheduleW.sup[1]+"<br>"+scheduleW.sup[2]+"<br>"+scheduleW.sup[3]+"<br>"+scheduleW.sup[4]+"<br>"+scheduleW.sup[5]+"<html>");
				ct.removeAll();
				ct.add(schedulePanel);
			}
			if(e.getSource()==scheduletocontrol){
				ct.removeAll();
				ct.add(panel_1);
			}
			if(e.getSource()==temperatureButton){
				
				ct.removeAll();
				ct.add(temperaturePanel1);
			}
	   		if(e.getSource()==temptocontrol){
	   			temperature=Integer.valueOf(temperatureCombo.getSelectedItem().toString());
				System.out.println("Current temperature is set to"+temperature);
	   			ct.removeAll();
	   			ct.add(panel_1);
	   		}
			
	   		if(e.getSource()==graphBack2){
	   			ct.removeAll();
	   			ct.add(panel_1);
	   		}
	   		
			if(e.getSource()==saveSchedule){
			
				}
			if(e.getSource()==welcomebutton1){
				ct.removeAll();
				ct.add(panelinstruction);
			}
			
			
			if(e.getSource()==insttocontrol){
				ct.removeAll();
				ct.add(panel_1);
			}
			if(e.getSource()==statustocontrol){
				ct.removeAll();
				ct.add(panel_1);
			}
			if(e.getSource()==confPaneltocontrol){
				ct.removeAll();
				ct.add(panel_1);
			}
			
		
			if(e.getSource()==enableButton3){
				
				button1.setEnabled(true);
				//button2.setEnabled(true);
				button3.setEnabled(true);
				button4.setEnabled(true);
				temperatureButton.setEnabled(true);
				scheduleButton.setEnabled(true);
				statusButtonPanel.setEnabled(true);
				
				enable=true;
			}
			if(e.getSource()==disableButton3){
				
				button1.setEnabled(false);
				button3.setEnabled(false);
				button4.setEnabled(false);
				temperatureButton.setEnabled(false);
				scheduleButton.setEnabled(false);
				enable=false;
			}
			
			if(e.getSource()==statusButtonPanel){
				ct.removeAll();
				ct.add(StatusPanel);
				
				
				if((temperature>90 || temperature <55 || enable == false)){
					
					
					tN = new Temperature("N", temperature, enable);
					tE = new Temperature("E", temperature, enable);
					tS = new Temperature("S", temperature, enable);
					tW = new Temperature("W", temperature, enable);
					
					tN.setSchedule();
					tE.setSchedule();
					tS.setSchedule();
					tW.setSchedule();
					
					
					System.out.println(tN.g.groupN[0].status + " " + tN.g.groupN[0].functional);
					System.out.println(tE.g.groupE[0].status + " " + tE.g.groupE[0].functional);
					System.out.println(tS.g.groupS[0].status + " " + tS.g.groupS[0].functional);
					System.out.println(tW.g.groupW[0].status + " " + tW.g.groupW[0].functional);
					
					if(tN.g.groupN[0].status=="ON"&& tN.g.groupN[0].functional =="OK" && enableN == true)
						sprink1.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else {
						if(tN.g.groupN[0].functional =="NOT")
							sprink1.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
						else
						sprink1.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					}
					
					if(tN.g.groupN[1].status=="ON"&& tN.g.groupN[0].functional =="OK" && enableN == true)
						sprink2.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else {
						if(tN.g.groupN[1].functional =="NOT")
							sprink2.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
						else
						sprink2.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					}
					
					if(tN.g.groupN[2].status=="ON"&& tN.g.groupN[0].functional =="OK" && enableN == true)
						sprink3.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else {
						if(tN.g.groupN[0].functional =="NOT")
							sprink3.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
						else
						sprink3.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					}
					
					if(tN.g.groupN[3].status=="ON"&& tN.g.groupN[0].functional =="OK" && enableN == true)
						sprink4.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else {
						if(tN.g.groupN[0].functional =="NOT")
							sprink4.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
						else
						sprink4.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					}
					
					
					
					
					if(tE.g.groupE[0].status=="ON"&& tE.g.groupE[0].functional =="OK" && enableE == true)
						sprink5.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else 
						sprink5.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					
					if(tE.g.groupE[1].status=="ON"&& tE.g.groupE[1].functional =="OK" && enableE == true)
						sprink6.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else 
						sprink6.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					
					if(tE.g.groupE[2].status=="ON"&& tE.g.groupE[2].functional =="OK" && enableE == true)
						sprink7.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else 
						sprink7.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					
					if(tE.g.groupE[3].status=="ON"&& tE.g.groupE[3].functional =="OK" && enableE == true)
						sprink8.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else 
						sprink8.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					
					
					
					if(tS.g.groupS[0].status=="ON"&& tS.g.groupS[0].functional =="OK" && enableS == true)
						sprink9.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else 
						sprink9.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					
					if(tS.g.groupS[1].status=="ON"&& tS.g.groupS[1].functional =="OK" && enableS == true)
						sprink10.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else 
						sprink10.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					
					if(tS.g.groupS[2].status=="ON"&& tS.g.groupS[2].functional =="OK" && enableS == true)
						sprink11.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else 
						sprink11.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					
					if(tS.g.groupS[3].status=="ON"&& tS.g.groupS[3].functional =="OK" && enableS == true)
						sprink12.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else 
						sprink12.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					
					
					if(tW.g.groupW[0].status=="ON" && tW.g.groupW[0].functional =="OK" && enableW == true)
						sprink13.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else {
						if(tW.g.groupW[0].functional =="NOT")
						sprink13.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
							else
						sprink13.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					}
					
					
					if(tW.g.groupW[1].status=="ON"&& tW.g.groupW[1].functional =="OK" && enableW == true)
						sprink14.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else {
						if(tW.g.groupW[1].functional =="NOT")
							sprink14.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
						else
						sprink14.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					}
					
					
					if(tW.g.groupW[2].status=="ON"&& tW.g.groupW[2].functional =="OK" && enableW == true)
						sprink15.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else {
						if(tW.g.groupW[2].functional =="NOT")
							sprink15.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
						else
						sprink15.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					}
					
					
					if(tW.g.groupW[3].status=="ON"&& tW.g.groupW[3].functional =="OK" && enableW == true)
						sprink16.setIcon(new ImageIcon(".\\Images\\ON.gif"));
					else {
						if(tW.g.groupW[3].functional =="NOT")
							sprink16.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
						else
						sprink16.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
					}
				}
					
				else{
				
				scheduleN = new Scheduler("N");
				scheduleE = new Scheduler("E");
				scheduleS = new Scheduler("S");
				scheduleW = new Scheduler("W");
				try {
					scheduleN.setSchedule();
					scheduleE.setSchedule();
					scheduleS.setSchedule();
					scheduleW.setSchedule();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				if(scheduleN.g.groupN[0].status=="ON" && scheduleN.g.groupN[0].functional =="OK" && enableN == true)
					sprink1.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink1.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				if(scheduleN.g.groupN[1].status=="ON" && scheduleN.g.groupN[1].functional =="OK" && enableN == true)
					sprink2.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink2.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				if(scheduleN.g.groupN[2].status=="ON"&& scheduleN.g.groupN[2].functional =="OK" && enableN == true)
					sprink3.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink3.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				if(scheduleN.g.groupN[3].status=="ON"&& scheduleN.g.groupN[3].functional =="OK" && enableN == true)
					sprink4.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink4.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				
				if(scheduleE.g.groupE[0].status=="ON"&& scheduleE.g.groupE[0].functional =="OK" && enableE == true)
					sprink5.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink5.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				if(scheduleE.g.groupE[1].status=="ON"&& scheduleE.g.groupE[1].functional =="OK" && enableE == true)
					sprink6.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink6.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				if(scheduleE.g.groupE[2].status=="ON"&& scheduleE.g.groupE[2].functional =="OK" && enableE == true)
					sprink7.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink7.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				if(scheduleE.g.groupE[3].status=="ON"&& scheduleE.g.groupE[3].functional =="OK" && enableE == true)
					sprink8.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink8.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				
				
				if(scheduleS.g.groupS[0].status=="ON"&& scheduleS.g.groupS[0].functional =="OK" && enableS == true)
					sprink9.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink9.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				if(scheduleS.g.groupS[1].status=="ON"&& scheduleS.g.groupS[1].functional =="OK" && enableS == true)
					sprink10.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink10.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				if(scheduleS.g.groupS[2].status=="ON"&& scheduleS.g.groupS[2].functional =="OK" && enableS == true)
					sprink11.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink11.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				if(scheduleS.g.groupS[3].status=="ON"&& scheduleS.g.groupS[3].functional =="OK" && enableS == true)
					sprink12.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else 
					sprink12.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				
				
				
				
				if(scheduleW.g.groupW[0].status=="ON"&& scheduleW.g.groupW[0].functional =="OK" && enableW == true)
					sprink13.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else {
					if(scheduleW.g.groupW[0].functional =="NOT")
					sprink13.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
					else
					sprink13.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				}
				
				
				if(scheduleW.g.groupW[1].status=="ON"&& scheduleW.g.groupW[1].functional =="OK" && enableW == true)
					sprink14.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else {
					if(scheduleW.g.groupW[1].functional =="NOT")
						sprink14.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
					else
					sprink14.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				}
				
				
				if(scheduleW.g.groupW[2].status=="ON"&& scheduleW.g.groupW[2].functional =="OK" && enableW == true)
					sprink15.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else {
					if(scheduleW.g.groupW[2].functional =="NOT")
						sprink15.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
					else
					sprink15.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				}
				
				
				if(scheduleW.g.groupW[3].status=="ON"&& scheduleW.g.groupW[3].functional =="OK" && enableW == true)
					sprink16.setIcon(new ImageIcon(".\\Images\\ON.gif"));
				else {
					if(scheduleW.g.groupW[3].functional =="NOT")
						sprink16.setIcon(new ImageIcon(".\\Images\\NOT.jpg"));
					else
					sprink16.setIcon(new ImageIcon(".\\Images\\OFF.jpg"));
				}
			}
		}
				

			if(e.getSource()==saveConfButton){
				
				switch ((String)areaCombo.getSelectedItem()) {
				case "N":
					loadFile(".\\Text\\N.txt");
					
					break;
				case "S":
					loadFile(".\\Text\\S.txt");
					
					break;
				case "E":
					loadFile(".\\Text\\E.txt");
					
					break;
				case "W":
					loadFile(".\\Text\\W.txt");
					
					break;

				default:
					break;
				}
				
				FileWriter fw;
				try {
					fw = new FileWriter(fileName);
					BufferedWriter bw=new BufferedWriter(fw);
					
					if(C1.isSelected()){
					   details=areaCombo.getSelectedItem().toString()+","+"Monday"+" , "+M1.getSelectedItem()+","+M2.getSelectedItem()+","+M3.getSelectedItem()+","+M4.getSelectedItem();
					   bw.write(details);
					   bw.newLine();
					   System.out.println(details);
						}
					if(C2.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Tuesday"+","+T1.getSelectedItem()+","+T2.getSelectedItem()+","+T3.getSelectedItem()+","+T4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C3.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Wednesday"+","+W1.getSelectedItem()+","+W2.getSelectedItem()+","+W3.getSelectedItem()+","+W4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C4.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Thursday"+","+Th1.getSelectedItem()+","+Th2.getSelectedItem()+","+Th3.getSelectedItem()+","+Th4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C5.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Friday"+","+F1.getSelectedItem()+","+F2.getSelectedItem()+","+F3.getSelectedItem()+","+F4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C6.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Saturday"+","+S1.getSelectedItem()+","+S2.getSelectedItem()+","+S3.getSelectedItem()+","+S4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					if(C7.isSelected()){
						 details=areaCombo.getSelectedItem().toString()+","+"Sunday"+","+Su1.getSelectedItem()+","+Su2.getSelectedItem()+","+Su3.getSelectedItem()+","+Su4.getSelectedItem();
						System.out.println(details);
						bw.write(details);
						bw.newLine();
						}
					
					bw.close();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
			
			if(e.getSource()==addonbutton){
				ct.removeAll();
				ct.add(paneladdon);
				
			}
			if(e.getSource()==addontocontrol){
				ct.removeAll();
				ct.add(panel_1);
			}
			if(e.getSource()==enableNorth){
				enableN = true;
			}
			if(e.getSource()==disableNorth){
				enableN = false;
			}
			if(e.getSource()==enableSouth){
				enableS = true;
			}
			if(e.getSource()==disableSouth){
				enableS = false;
			}
			
			if(e.getSource()==enableEast){
				enableE = true;
			}
			if(e.getSource()==disableEast){
				enableE = false;
			}
			if(e.getSource()==enableWest){
				enableW = true;
			}
			if(e.getSource()==disableWest){
				enableW = false;
			}
			
			repaint();
			revalidate();
		
		}
		
	}

/**
* 
* @author VINAY SAGAR GONABAVI and SHIVAM VARMA
*
**/
class ListenCheckBox implements ItemListener{

	
	/**
	 * @param ItemEvent e
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==C1){
			if(C1.isSelected()){
			M1.setEnabled(true);
			M2.setEnabled(true);
			M3.setEnabled(true);
			M4.setEnabled(true);
			}
			else{
				M1.setEnabled(false);
				M2.setEnabled(false);
				M3.setEnabled(false);
				M4.setEnabled(false);
			}
			}
		if(e.getSource()==C2){
			if(C2.isSelected()){
			T1.setEnabled(true);
			T2.setEnabled(true);
			T3.setEnabled(true);
			T4.setEnabled(true);
			}
			else{
				T1.setEnabled(false);
				T2.setEnabled(false);
				T3.setEnabled(false);
				T4.setEnabled(false);
			}
		}
		if(e.getSource()==C3){
			if(C3.isSelected()){
			W1.setEnabled(true);
			W2.setEnabled(true);
			W3.setEnabled(true);
			W4.setEnabled(true);
			}
			else{
				W1.setEnabled(false);
				W2.setEnabled(false);
				W3.setEnabled(false);
				W4.setEnabled(false);
			}
		}
		if(e.getSource()==C4){
			if(C4.isSelected()){
			Th1.setEnabled(true);
			Th2.setEnabled(true);
			Th3.setEnabled(true);
			Th4.setEnabled(true);
			}
			else{
				Th1.setEnabled(false);
				Th2.setEnabled(false);
				Th3.setEnabled(false);
				Th4.setEnabled(false);
			}
		}
		if(e.getSource()==C5){
			if(C5.isSelected()){
			F1.setEnabled(true);
			F2.setEnabled(true);
			F3.setEnabled(true);
			F4.setEnabled(true);
			}
			else{
				F1.setEnabled(false);
				F2.setEnabled(false);
				F3.setEnabled(false);
				F4.setEnabled(false);
			}
		}
		if(e.getSource()==C6){
			if(C6.isSelected()){
			S1.setEnabled(true);
			S2.setEnabled(true);
			S3.setEnabled(true);
			S4.setEnabled(true);
			}
			else{
				S1.setEnabled(false);
				S2.setEnabled(false);
				S3.setEnabled(false);
				S4.setEnabled(false);
			}
		}
		if(e.getSource()==C7){
			if(C7.isSelected()){
			Su1.setEnabled(true);
			Su2.setEnabled(true);
			Su3.setEnabled(true);
			Su4.setEnabled(true);
			}
			else{
				Su1.setEnabled(false);
				Su2.setEnabled(false);
				Su3.setEnabled(false);
				Su4.setEnabled(false);
			}
		}
		
	}
	
}
}