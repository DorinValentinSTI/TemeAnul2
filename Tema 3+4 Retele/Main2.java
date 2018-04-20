import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2 {
	//plimba jetonul prin reteaua de calculatoare
	public static void sendJeton(List<Calculator> calc, int source, int destination) {
		Jeton jet = new Jeton();

		jet.destinationIP = calc.get(destination).IP;
		jet.sourceIP = calc.get(source).IP;

		calc.get(source).checkAndSendJet(jet);

	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		List<String> ipAdresses = new ArrayList<String>();
		List<Calculator> computers = new ArrayList<Calculator>();
		Jeton jet = new Jeton();
		Random rand = new Random();
		Calculator calc1 = new Calculator("calc1");
		calc1.message="Calculator 1";
		Calculator calc2 = new Calculator("calc2");
		Calculator calc3 = new Calculator("calc3");
		calc3.message="Calculatorul 3";
		Calculator calc4 = new Calculator("calc4");
		Calculator calc5 = new Calculator("calc5");
		calc5.message="Calculatorul 5";
		Calculator calc6 = new Calculator("calc6");
		Calculator calc7 = new Calculator("calc7");
		calc7.message="Calculatorul 7";
		Calculator calc8 = new Calculator("calc8");
		Calculator calc9 = new Calculator("calc9");
		calc9.message="Calculatorul 9";
		Calculator calc10 = new Calculator("calc10");
		ipAdresses.add(calc1.generateIP());
		ipAdresses.add(calc2.generateIP());
		ipAdresses.add(calc3.generateIP());
		ipAdresses.add(calc4.generateIP());
		ipAdresses.add(calc5.generateIP());
		ipAdresses.add(calc6.generateIP());
		ipAdresses.add(calc7.generateIP());
		ipAdresses.add(calc8.generateIP());
		ipAdresses.add(calc9.generateIP());
		ipAdresses.add(calc10.generateIP());
		computers.add(calc1);
		computers.add(calc2);
		computers.add(calc3);
		computers.add(calc4);
		computers.add(calc5);
		computers.add(calc6);
		computers.add(calc7);
		computers.add(calc8);
		computers.add(calc9);
		computers.add(calc10);
		for (int i = 0; i < computers.size() - 1; i++) {
			computers.get(i).nextCalculator = computers.get(i + 1);
		}
		computers.get(computers.size() - 1).nextCalculator = computers.get(0);

		int randomValueSource = rand.nextInt(computers.size());
		int randomValueDestination = rand.nextInt(computers.size());
		// jet.occupied = "free";
		// jet.successSent = "Not OK";
		for (int i = 0; i < computers.size(); i++)
			System.out.println(computers.get(i).getObjName() + "(" + ipAdresses.get(i) + ")" + "->" + jet.message);
		System.out.println("Calculator sursa:" + computers.get(randomValueSource).getObjName() + " "
				+ "Calculator destinatie:" + computers.get(randomValueDestination).getObjName());
		
		sendJeton(computers, computers.indexOf(computers.get(randomValueSource)),
				computers.indexOf(computers.get(randomValueDestination)));

		// System.out.println(ipAdresses);
		System.out.println(calc5.returningIPs());
	}

}
