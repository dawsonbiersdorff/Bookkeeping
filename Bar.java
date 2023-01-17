
public class Bar {
	
	private int tillNumber;
	private double cashSales;
	private double change;
	private double tips;
	private double foodSales;
	private final double SAPERCENT = .006;
	private final double EXPOPERCENT = .015;
	private int numExpo;
	private int numSA;
	private double hoursWorked;
	
	Bar(int tillNumber) {
		this.tillNumber = tillNumber;
	}
	
	public int getTillNumber() {
		return tillNumber;
	}
	
	public void setTillNumber(int tillNumber) {
		this.tillNumber = tillNumber;
	}
	
	public double getCashSales() {
		return cashSales;
	}
	
	public void setCashSales(int cashSales) {
		this.cashSales = cashSales;
	}
	
	public double getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
	
	public double getTips() {
		return tips;
	}
	
	public void setTips(int tips) {
		this.tips = tips;
	}
	
	public double getFoodSales() {
		return foodSales;
	}
	
	public void setFoodSales(int foodSales) {
		this.foodSales = foodSales;
	}
	
	public int getNumExpo() {
		return numExpo;
	}

	public void setNumExpo(int numExpo) {
		this.numExpo = numExpo;
	}

	public int getNumSA() {
		return numSA;
	}

	public void setNumSA(int numSA) {
		this.numSA = numSA;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double calculateSATipOut() {
		return foodSales * (numSA * SAPERCENT);
	}
	
	public double calculateExpoTipOut() {
		return foodSales * (numExpo * EXPOPERCENT);
	}
	
	public double calculateTotalTips() {
		return tips - calculateSATipOut() - calculateExpoTipOut();
	}
	
	public double calculateHourly() {
		return calculateTotalTips() / hoursWorked;
	}
	
	public String calculateServerTips(String server, double hoursWorked) {
		double tips = calculateHourly() * hoursWorked;
		String ret = "Kenzie's tips made are: " + tips + ".";
		return ret;
	}
}
