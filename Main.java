package refactoring;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

		Vehicle vehicle1 = new Vehicle("Tata", "Vista", Vehicle.BASIC);
		Date date = dateFormat.parse("2/8/2013");
		Lloguer lloguer1 = new Lloguer(date, 2, vehicle1);
		
		Vehicle vehicle2 = new Vehicle("Citroen", "Saxo", Vehicle.GENERAL);
		date = dateFormat.parse("5/10/2015");
		Lloguer lloguer2 = new Lloguer(date, 5, vehicle2);

		Vehicle vehicle3 = new Vehicle("Tesla", "Roaster", Vehicle.LUXE);
		date = dateFormat.parse("4/12/201");
		Lloguer lloguer3 = new Lloguer(date, 5, vehicle3);
		
		Client miclient = new Client("111111Z", "Marc", "123456789");
		   miclient.afegeix(lloguer1);
	       miclient.afegeix(lloguer2);
	       miclient.afegeix(lloguer3);
	        
	        System.out.print(GestorLloguersLite(miclient));
	 
	   }
	    
	    public static String GestorLloguersLite (Client client) {
	        return client.informe();
	        
	    }
}