import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
//		Bar bar1 = new Bar(1);
//		bar1.setCashSales(400);
//		bar1.setChange(45);
//		bar1.setFoodSales(380);
//		bar1.setHoursWorked(25);
//		bar1.setNumExpo(1);
//		bar1.setNumSA(1);
//		bar1.setTips(250);
//		
//		String tips = bar1.calculateServerTips("Kenzie", 8);
//		
//		System.out.println(tips);
		Servers server = new Servers();
		Scanner scan = new Scanner(System.in);
		String serverName = "";
		boolean done = true;
//		while (done) {
			System.out.println("Please enter server name: ");
			serverName = scan.next();
			System.out.println("Please enter tips: ");
			server.setTips(scan.nextDouble());
			System.out.println("Please enter sales: ");
			server.setSales(scan.nextDouble());
			System.out.println("Please enter food sales: ");
			server.setFoodSales(scan.nextDouble());
			System.out.println("Please enter alcohol sales: ");
			server.setAlcSales(scan.nextDouble());
			System.out.println("Please enter bottled wine sales: ");
			server.setBottledWine(scan.nextDouble());
			System.out.println("Please enter cash sales: ");
			server.setCash(scan.nextDouble());
			System.out.println("Please enter cc refund: ");
			server.setCcRef(scan.nextDouble());
			System.out.println("Please enter gift card tips: ");
			server.setGiftCardTips(scan.nextDouble());
//			done = false;
//			}
		
		
		double tipOut = server.calculateTipOut(1, 1);
		double tips = server.calculateTotalTips(1, 1);
		
		System.out.println(serverName + " made a total of " + tips + " dollars after tipping out " + tipOut + " dollars.");
		

	}

}
