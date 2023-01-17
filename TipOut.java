
public class TipOut {
	
	public double calculateHourly(double totalHoursWorked, double totalTips) {
		
		double hourly = totalTips / totalHoursWorked;
		return hourly;
	}
	
	public double calculateTipOut(double hours, double hourly) {
		
		double tips = hours * hourly;
		return tips;
	}	

}
