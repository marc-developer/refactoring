package refactoring;


import java.util.Date;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle; //= new ArrayList<Vehicle>();
	
	
	public Lloguer(Date data, int i, Vehicle vehicle) {
		this.data = data;
		this.dies = i;
		this.vehicle = vehicle;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getDies() {
		return dies;
	}
	public void setDies(int dies) {
		this.dies = dies;
	}
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	//MOVIMENT DE METODE A CLIENT A LLOGUER
	public double quantitat() {
    	double quantitat = 0;
        switch (this.getVehicle().getCategoria()) {
            case Vehicle.BASIC:
                quantitat += 3;
                if (this.getDies() > 3) {
                    quantitat += (this.getDies() - 3) * 1.5;
                }
                break;
            case Vehicle.GENERAL:
                quantitat += 4;
                if (this.getDies() > 2) {
                    quantitat += (this.getDies() - 2) * 2.5;
                }
                break;
            case Vehicle.LUXE:
                quantitat += this.getDies() * 6;
                break;
        }return quantitat;
    }
	public int bonificacions() {
    	int bonificacions = 0;
    	bonificacions ++;
        if (this.getVehicle().getCategoria() == Vehicle.LUXE &&
                this.getDies()>1 ) {
            bonificacions ++;
        }
        return bonificacions;
    }
}
