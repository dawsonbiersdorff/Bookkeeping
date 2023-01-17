import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.HashMap;

public class MyGUIProject implements ActionListener {

	private JTextArea tipsArea;
	private JTextField totalTips;
	private JTextArea output;
	private JTextArea serverNameArea;
	private JTextField serverName;
	private JTextArea totalSalesArea;
	private JTextField totalSales;
	private JTextArea foodSalesArea;
	private JTextField foodSales;
	private JTextArea alcSalesArea;
	private JTextField alcSales;
	private JTextArea bottleSalesArea;
	private JTextField bottleSales;
	private JTextArea cashSalesArea;
	private JTextField cashSales;
	private JTextArea ccRefArea;
	private JTextField ccRef;
	private JTextArea giftCardTipsArea;
	private JTextField giftCardTips;
	private JTextField saBox;
	private JTextField hoursBox;
	private Servers server;
	private JTextArea saOutput;
	private HashMap<String, Double> serverMap = new HashMap<String, Double>();
	private HashMap<String, Double> saMap = new HashMap<String, Double>();
	private HashMap<String, Double> saHoursMap = new HashMap<String, Double>();
	private HashMap<String, String> saTipsMap = new HashMap<String, String>();
	private HashMap<String, Double> expoMap = new HashMap<String, Double>();
	private HashMap<String, Double> barMap = new HashMap<String, Double>();
	private HashMap<String, Double> cashMap = new HashMap<String, Double>();
	private JButton b;
	private JButton a;
	private JButton x;
	private JButton y;
	private JButton z;
	private JButton saCalculate;
	private JButton saEnter;
	private JButton removeServer;
	private JButton remove;
	private int numSA;
	private TipOut sa;
	private JTextField serverRemoveName;
	private boolean correctValues = true;

	
	public MyGUIProject() {
			
		JFrame mainFrame = new JFrame("My First GUI");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500,500);
        
        mainFrame.setLayout(new BorderLayout(50,50));
        
        numSA = 0;
        sa = new TipOut();
        
        x = new JButton("Open Server Window");
        x.addActionListener(this);
        
        
        y = new JButton("Open SA Window");
        y.addActionListener(this);
        
        z = new JButton("Open Bar Window");
        z.addActionListener(this);
        
        GridLayout grid = new GridLayout(3, 2, 25, 40);
        JPanel panel = new JPanel();
		panel.setLayout(grid);
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		//grid.setVgap(50);
		
		JTextArea serverDescription = new JTextArea("Open window to enter servers and caclculate tips earned and tip out.");
		serverDescription.setEditable(false);
		serverDescription.setLineWrap(true);
		serverDescription.setWrapStyleWord(true);
		
        panel.add(x);
        panel.add(serverDescription);
        panel.add(y);
        panel.add(new JTextArea("Test Area"));
        panel.add(z);
        panel.add(new JTextArea("Test Area"));
        
        mainFrame.getContentPane().add(BorderLayout.CENTER, panel);
        mainFrame.setVisible(true);
        
	}
	
	public JPanel createNumbersPanel() {
		JPanel numbersPanel = new JPanel();
		numbersPanel.setLayout(new BoxLayout(numbersPanel, BoxLayout.PAGE_AXIS));
		//numbersPanel.add(Box.createRigidArea(new Dimension(0,5)));
		numbersPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

		
		serverNameArea = new JTextArea("Name:");
		serverNameArea.setEditable(false);
		serverName = new JTextField(15);
		numbersPanel.add(serverNameArea);
		numbersPanel.add(serverName);
		
		tipsArea = new JTextArea("Total Tips:");
		tipsArea.setEditable(false);
		totalTips = new JTextField(15);
		numbersPanel.add(tipsArea);
		numbersPanel.add(totalTips);
		
		totalSalesArea = new JTextArea("Total Sales:");
		totalSalesArea.setEditable(false);
		totalSales = new JTextField(15);
		numbersPanel.add(totalSalesArea);
		numbersPanel.add(totalSales);
		
		foodSalesArea = new JTextArea("Food Sales:");
		foodSalesArea.setEditable(false);
		foodSales = new JTextField(15);
		numbersPanel.add(foodSalesArea);
		numbersPanel.add(foodSales);
		
		alcSalesArea = new JTextArea("Alcohol Sales:");
		alcSalesArea.setEditable(false);
		alcSales = new JTextField(15);
		numbersPanel.add(alcSalesArea);
		numbersPanel.add(alcSales);
		
		bottleSalesArea = new JTextArea("Bottled Wine Sales:");
		bottleSalesArea.setEditable(false);
		bottleSales = new JTextField(15);
		numbersPanel.add(bottleSalesArea);
		numbersPanel.add(bottleSales);
		
		cashSalesArea = new JTextArea("Cash Sales:");
		cashSalesArea.setEditable(false);
		cashSales = new JTextField(15);
		numbersPanel.add(cashSalesArea);
		numbersPanel.add(cashSales);
		
		ccRefArea = new JTextArea("CC Ref:");
		ccRefArea.setEditable(false);
		ccRef = new JTextField(15);
		numbersPanel.add(ccRefArea);
		numbersPanel.add(ccRef);
		
		giftCardTipsArea = new JTextArea("Gift Card Tips:");
		giftCardTipsArea.setEditable(false);
		giftCardTips = new JTextField(15);
		numbersPanel.add(giftCardTipsArea);
		numbersPanel.add(giftCardTips);
		
		
		return numbersPanel;
	}
	
	private void openRemoveServerFrame() {
		JFrame removeServer = new JFrame("Remove Server");
		
		removeServer.setLayout(new FlowLayout());
		
		serverRemoveName = new JTextField(15);
		
		remove = new JButton("Remove Server");
		remove.addActionListener(this);
		
		removeServer.add(serverRemoveName);
		removeServer.add(remove);
		
		removeServer.setSize(300, 300);
		removeServer.setVisible(true);
		
	}
	
	public String serversToString() {
		StringBuilder s = new StringBuilder();
		
		for (String x: serverMap.keySet()) {
			s.append(x + ": " + serverMap.get(x) + "\n");
		}
		return s.toString();
	}
	
	public String saToString() {
		StringBuilder s = new StringBuilder();
		
		for (String x: saMap.keySet()) {
			s.append(x + ": " + saMap.get(x) + "\n");
		}
		return s.toString();
	}
	
	public void openSAFrame() {
		
		JFrame saFrame = new JFrame("SA Frame");
        saFrame.setSize(500,500);
        
        JPanel saPanel = createSAPanel();
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		saEnter = new JButton("Enter SA");
		saEnter.addActionListener(this);
		buttonPanel.add(saEnter);
		
		saCalculate = new JButton("Calculate SA Tips");
		saCalculate.addActionListener(this);
		buttonPanel.add(saCalculate);
		
		saOutput = new JTextArea(5, 40);		
		
		saFrame.getContentPane().add(BorderLayout.NORTH, buttonPanel);
		saFrame.getContentPane().add(BorderLayout.CENTER, saPanel);
		saFrame.getContentPane().add(BorderLayout.SOUTH, saOutput);
		
		saFrame.setVisible(true);

	}
	
	public JPanel createSAPanel() {
		JPanel saPanel = new JPanel();
		saPanel.setLayout(new BoxLayout(saPanel, BoxLayout.PAGE_AXIS));
		saPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		JTextArea saName = new JTextArea("Enter SA Name:");
		saName.setEditable(false);
		saBox = new JTextField(15);
		saPanel.add(saName);
		saPanel.add(saBox);
		
		JTextArea hoursWorked = new JTextArea("Hours Worked:");
		hoursWorked.setEditable(false);
		hoursBox = new JTextField(15);
		saPanel.add(hoursWorked);
		saPanel.add(hoursBox);
		
		return saPanel;
	}
	
	public void openServerFrame() {
		
		server = new Servers();
		
		JFrame frame = new JFrame("Server Frame");
        frame.setSize(500,500);
        a = new JButton("Print Servers");
        b = new JButton("Calculate");
        removeServer = new JButton("Remove Server");
        output = new JTextArea(5, 40);
        
        b.addActionListener(this);
        a.addActionListener(this);
        removeServer.addActionListener(this);

        
        JPanel panel = createNumbersPanel();
        JPanel northPanel = new JPanel(new FlowLayout());
        
        northPanel.add(b);
        northPanel.add(a);
        northPanel.add(removeServer);
        
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.NORTH, northPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, output);
        frame.setVisible(true);
	}
	
	public void openBarFrame() {
		
	}
	
	public String calculateTotalSATipOut() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		double tipSum = 0;
		double hoursSum = 0;
		double tips = 0;
		
		for (String x: saMap.keySet()) {
			tipSum += saMap.get(x);
		}
		
		for (String x: saHoursMap.keySet()) {
			hoursSum += saHoursMap.get(x);
		}
		
		StringBuilder s = new StringBuilder();
		
		double hourly = sa.calculateHourly(hoursSum, tipSum);
		
		for (String x: saHoursMap.keySet()) {
			tips = sa.calculateTipOut(saHoursMap.get(x), hourly);
			saTipsMap.put(x, df.format(tips));
		}
		
		for (String y: saTipsMap.keySet()) {
			s.append(y + " made a total of " + saTipsMap.get(y) + " dollars.\n");
		}
		
		return s.toString();
	}
	
	public double convertInput(JTextField input) {
		String s = input.getText();
		double ret = 0;
		try {
			ret =  Double.parseDouble(s);
		} catch (NumberFormatException e) {
			 return -1;
		}
		return ret;
	}
	
	public void checkValid(double value, JTextField field, String type) {
		if (value == -1) {
			field.setBorder(BorderFactory.createLineBorder(Color.RED));
			correctValues = false;
		} else {
			field.setBorder(new JTextField().getBorder());
			switch (type) {
				case "Tips": server.setTips(value);
							break;
			
				case "Sales": server.setSales(value);
							break;
							
				case "FoodSales": server.setFoodSales(value);
							break;
							
				case "AlcSales": server.setAlcSales(value);
							break;
						
				case "BottleSales": server.setBottledWine(value);
							break;
							
				case "GiftCard": server.setGiftCardTips(value);
							break;
							
				case "CashSales": server.setCash(value);
							break;
							
				case "CCRef": server.setCcRef(value);
							break;
							
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==b) {
			// Get Total Tips
			double tips = convertInput(totalTips);
			checkValid(tips, totalTips, "Tips");
			
			// Get Total Sales
			double salesNum = convertInput(totalSales);
			checkValid(salesNum, totalSales, "Sales");
			
			// Get Food Sales
			double foodSalesNum = convertInput(foodSales);
			checkValid(foodSalesNum, foodSales, "FoodSales");
			
			// Get Alcohol Sales
			double alcoholSales = convertInput(alcSales);
			checkValid(alcoholSales, alcSales, "AlcSales");
			
			// Get Bottle Sales
			double bottledWine = convertInput(bottleSales);
			checkValid(bottledWine, bottleSales, "BottleSales");
			
			// Get Gift Card Tips
			double giftCards = convertInput(giftCardTips);
			checkValid(giftCards, giftCardTips, "GiftCard");
			
			// Get Cash Sales
			double cash = convertInput(cashSales);
			checkValid(cash, cashSales, "CashSales");
			
			// Get Server Name
			String serverNameString = serverName.getText();
			
			// Get ccRef
			double cc = convertInput(ccRef);
			checkValid(cc, ccRef, "CCRef");
			
			if (correctValues == true) {
				saMap.put(serverNameString, server.calculateSATipOut(1));
				expoMap.put(serverNameString, server.getExpoTipOut());
				barMap.put(serverNameString, server.getBarTipOut());
				serverMap.put(serverNameString, server.calculateTotalTips(1, 1));
				cashMap.put(serverNameString, server.getCash());
				
				output.setText(server.toString(serverNameString));
			} else {
				output.setText("Incorrect value entered.");
				correctValues = true;
			}
			
		} else if (e.getSource()==a) {
			
			output.setText(serversToString());

		} else if (e.getSource()==y) {
			openSAFrame();
		} else if (e.getSource()==x) {
			openServerFrame();
		} else if (e.getSource()==z) {
			openBarFrame();
		} else if (e.getSource()==saEnter) {
			
			String saName = saBox.getText();	
			double hours = convertInput(hoursBox);
			if (hours == -1) {
				saOutput.setText("Invalid Input");
				hoursBox.setBorder(BorderFactory.createLineBorder(Color.RED));
			} else {
				hoursBox.setBorder(new JTextField().getBorder());
				saHoursMap.put(saName, hours);
				numSA += 1;
				saOutput.setText(saName + " has been added with a total of " + hours + " hours.");
			}

		} else if (e.getSource()==saCalculate) {
			
			String saTipOut = calculateTotalSATipOut();
			saOutput.setText(String.valueOf(saTipOut));
		} else if (e.getSource()==removeServer) {
			openRemoveServerFrame();
		} else if (e.getSource()==remove) {
			String name = serverRemoveName.getText();
			System.out.println(name);
			serverMap.remove(name);
			saMap.remove(name);
		}
		
	}

	public static void main(String[] args) {
		
		new MyGUIProject();
	}

}
