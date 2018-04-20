import java.util.Random;

public class Calculator implements Runnable {
	String buffer = null;
	String IP;
	String calcName;
	String message;
	Jeton jet=new Jeton();
		public Calculator(String buffer, String iP1) {
		super();
		this.buffer = buffer;
		IP = iP1;
	}
		public Calculator() {};
		public Calculator(String name) {
			this.calcName=name;
		}
		public String getObjName() {
		    return calcName;
		}

		public int generateIPnumbers() {
		Random random = new Random();
		int ip;
		ip = random.nextInt(192);
		return ip;
	}
	public String generateIP() {
		IP=generateIPnumbers()+"."+generateIPnumbers()+"."+generateIPnumbers()+"."+generateIPnumbers();
		return IP;
	}
	public Calculator nextCalculator;
	public void checkAndSendJet(Jeton jet) {
		System.out.println(calcName+"("+this.IP+")"+":"+"Muta jetonul");
		if(jet.successSent!="OK" &&jet.destinationIP!=IP) {
			
			System.out.println(jet.message);
			jet.message=nextCalculator.message;
			jet.occupied="occupied";
			System.out.println(jet.occupied);
			nextCalculator.checkAndSendJet(jet);
		}
		else {
			if(jet.destinationIP==IP) {
				
				buffer= jet.message;
				jet.successSent="OK";
				System.out.println("Jetonul a ajuns la destinatie!!!");
				jet.occupied="free";
				System.out.println(jet.occupied);				
				System.out.println("Jetonul a fost ocupat de calculatorul destinatie!");
				jet.occupied="occupied";
				System.out.println(jet.occupied);
			}
			if(jet.sourceIP!=IP) {				
				System.out.println(jet.message);
				jet.message=nextCalculator.message;
				jet.occupied="occupied";
				System.out.println(jet.occupied);
				nextCalculator.checkAndSendJet(jet);
			}
			else {
				
				System.out.println(jet.occupied);
				jet.message="";
				System.out.println("Jetonul a ajuns la sursa!!!");
				jet.occupied="free";
				System.out.println(jet.occupied);
			}
		}
	}
	
	public String returningIPs() {
		return this.IP;
	}
	@Override
	public void run() {		
		if(jet.occupied=="occupied") {
			System.out.println("Jeton inaccesibil!");
			try {
				this.wait(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			if(jet.occupied=="free") {
				System.out.println("Jeton liber");
				this.notify();
			}
		}
	}
	
}
