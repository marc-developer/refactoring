package refactoring;



import java.util.Vector;

public class Client {
	private String nif;
	private String nom;
	private String telefon;
	private Vector<Lloguer> lloguers;
	
	public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public String informe() {
    	 return  composaCapcelera() + 
    			 composaDetall() + 
    			 composaPeu();
        
    }
    public int bonificacionsTotals() {	
    	 int bonificacions = 0;
    	 for (Lloguer lloguer: lloguers) 
             bonificacions += lloguer.bonificacions();
    		 return bonificacions;
    }
    public double importTotal() {
    	double total = 0;
    	for(Lloguer lloguer : lloguers)
    		total += lloguer.quantitat() * 30;
    	return total;
    }
    public String composaCapcelera() {
    	 String resultat = "Informe de lloguers del client " + getNom() + " (" + getNif() + ")\n";
    	 return resultat;
    }
    public String composaDetall() {
    	String resultat = "";
    	for (Lloguer lloguer: lloguers) 
    		resultat += "\t" + lloguer.getVehicle().getMarca() + " " + lloguer.getVehicle().getModel() + ": " + (lloguer.quantitat() * 30) + "€" + "\n";
    	return resultat;
    }
    public String composaPeu() {
    	String resultat = "";
    	resultat += "Import a pagar: " + importTotal() + "€\n" + "Punts guanyats: " + bonificacionsTotals() + "\n";
        return resultat;
    }
    
    
    public String informeHtml() {
   	 return  composaCapceleraHtml() + 
   			 composaDetallHtml() + 
   			 composaPeuHtml();
       
   }
   public int bonificacionsTotalsHtml() {	
   	 int bonificacions = 0;
   	 for (Lloguer lloguer: lloguers) 
            bonificacions += lloguer.bonificacions();
   		 return bonificacions;
   }
   public double importTotalHtml() {
   	double total = 0;
   	for(Lloguer lloguer : lloguers)
   		total += lloguer.quantitat() * 30;
   	return total;
   }
   public String composaCapceleraHtml() {
   	 return "<h1>Informe de lloguers</h1>\n" + "<p>Informe de lloguers client <em>" + getNom() + "</em> (<strong>" + getNif() + "</strong>)</p>\n";
   }
   public String composaDetallHtml() {
   	String resultat = "<table><tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>";
   	for (Lloguer lloguer: lloguers) 
   		resultat += "\t" +"<tr><td>" + lloguer.getVehicle().getMarca() + "</td><td>" + lloguer.getVehicle().getModel() +"</td><td>" + (lloguer.quantitat() * 30) + "€" + "</td></tr>\n";
   	return resultat;
   }
   public String composaPeuHtml() {
       return "<p>Import a pagar: <em>" + importTotal() + "</em></p>\n" + "\t" + "<p>Punts guanyats: <em>" + bonificacionsTotals() + "</em></p>";
   }
}

