import java.text.DecimalFormat;

public class Servers {
	
	private double sales;
	private double foodSales;
	private double alcSales;
	private double bottledWine;
	private double tips;
	private double ccRef;
	private double cash;
	private double giftCardTips;
	private double saTipOut;
	private double expoTipOut;
	private double barTipOut;
	double coeff;
	private DecimalFormat df;
	
	Servers() {
		sales = 0;
		foodSales = 0;
		alcSales = 0;
		bottledWine = 0;
		tips = 0;
		ccRef = 0;
		cash = 0;
		giftCardTips = 0;
		coeff = 4;
		df = new DecimalFormat("0.00");
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public double getFoodSales() {
		return foodSales;
	}

	public void setFoodSales(double foodSales) {
		this.foodSales = foodSales;
	}

	public double getAlcSales() {
		return alcSales;
	}

	public void setAlcSales(double alcSales) {
		this.alcSales = alcSales;
	}

	public double getBottledWine() {
		return bottledWine;
	}

	public void setBottledWine(double bottledWine) {
		this.bottledWine = bottledWine;
	}

	public double getTips() {
		return tips;
	}

	public void setTips(double tips) {
		this.tips = tips;
	}

	public double getCcRef() {
		return ccRef;
	}

	public void setCcRef(double ccRef) {
		this.ccRef = ccRef;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public double getGiftCardTips() {
		return giftCardTips;
	}

	public void setGiftCardTips(double giftCardTips) {
		this.giftCardTips = giftCardTips;
	}
	
	public double calculateSATipOut(int numSA) {
		double saTip = ((Math.round((sales * .008)*coeff)/coeff));
		setSATipOut(saTip);
		return saTip;
	}
	
	public double calculateExpoTipOut(int numExpo) {
		return ((Math.round((numExpo * .01)* coeff)/coeff));
	}
	
	public double calculateAlcTipOut() {
		return ((Math.round((alcSales * .09)*coeff)/coeff));
	}
	
	public double calculateBottleTipOut() {
		return (bottledWine * .045);
	}
	
	public void setSATipOut(double tipOut) {
		this.saTipOut = tipOut;
	}
	
	public double getSATipOut() {
		return saTipOut;
	}
	
	public double getExpoTipOut() {
		return expoTipOut;
	}

	public void setExpoTipOut(double expoTipOut) {
		this.expoTipOut = expoTipOut;
	}

	public double getBarTipOut() {
		return barTipOut;
	}

	public void setBarTipOut(double barTipOut) {
		this.barTipOut = barTipOut;
	}
	
	public double calculateTipOut(int numSA, int numExpo) {
		double saTip = calculateSATipOut(numSA);
		setSATipOut(saTip);
		double expoTip = calculateExpoTipOut(numExpo);
		setExpoTipOut(expoTip);
		double alcTip = calculateAlcTipOut();
		double bottleTip = calculateBottleTipOut();
		setBarTipOut(alcTip + bottleTip);
		double totalTip = saTip + expoTip + alcTip + bottleTip;
		return totalTip;
	}
	
	public double calculateTotalTips(int numSA, int numExpo) {
		double tipOut = calculateTipOut(numSA, numExpo);
		double total = tips + giftCardTips - tipOut - ccRef;
		df.format(total);
		return total;
	}
	
	public String toString(String name) {
		double tips1 = calculateTotalTips(1, 1);
		double tipOut = calculateTipOut(1, 1);
		String ret = name + " made a total of " + tips1 + " dollars after tipping out " + tipOut + " dollars.";
		return ret;
	}

}
