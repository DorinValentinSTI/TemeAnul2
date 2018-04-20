
public class Jeton  {

	public Jeton(String sourceIP, String destinationIP, String message, String occupied, String successSent) {
		super();
		this.sourceIP = sourceIP;
		this.destinationIP = destinationIP;
		this.message = message;
		this.occupied = occupied;
		this.successSent = successSent;
	}
	public Jeton() {};
	String sourceIP;
	String destinationIP;
	String message=null;
	String occupied;
	String successSent;
	
}
