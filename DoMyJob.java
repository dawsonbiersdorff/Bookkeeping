
public class DoMyJob {

	public static void main(String[] args) {
		
		DoMyJob a = new DoMyJob();
		
		double tips = 150;
		double ccRef = 3.97;
		
		double saTipOut = a.calculateSA(500, 1);
		double expoTipOut = a.calculateExpo(50, 140, 350, 530);
		double barTipOut = a.calculateBar(54, 24, 8, 48, 48);
		double totalTipOut = saTipOut + expoTipOut + barTipOut;
		
		double finalTips = tips - totalTipOut - ccRef;
		
		System.out.println("Your SA tip out is: " + saTipOut);
		System.out.println("Your expo tip out is: " + expoTipOut);
		System.out.println("Your bar tip out is: " + barTipOut);
		System.out.println("Your total tip out is: " + totalTipOut);
		
		System.out.println("CC Tips + GC Tips = " + tips + " - " + totalTipOut + " - " + ccRef + 
				" = " + finalTips);

	}
	
	private double round(double num) {
		
		double ret = Math.round(num * 4f)/4f;
		
		return ret;
	}
	
	private double calculateSA(int sales, int num) {
		
		double percent = .006 * num;
		
		double tipOut = round(sales * percent);
		
		return tipOut;
	}
	
	private double calculateExpo(int meat, int other, int poultry, int seafood) {
		
		double tipOut = 0;
		
		double total = meat + other + poultry + seafood;
		if (total != 0) {
			tipOut = round(total * .01);
		}
		
		return tipOut;
	}
	
	private double calculateBar(int na, int beer, int wine, int bottle, int liquor) {
		
		double tipOut = 0;
		
		double total = na + beer + wine + liquor;
		if (total != 0) {
			tipOut = round(total * .09);
		}
		
		if (bottle != 0) {
			tipOut =  tipOut + round(bottle * .045);
		}
		
		
		return tipOut;
		
	}

}
