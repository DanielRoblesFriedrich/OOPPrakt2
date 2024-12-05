package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import factory.Creator;
import factory.Product;

import factory.ConcreteCsvCreator;
import factory.ConcreteTxtCreator;
public class CafeModel {

	public Cafe cafe;
	
	public void schreibeCafeInCsvDatei() throws IOException{
		
		
		if (this.cafe == null) {
	        throw new IllegalStateException("Cafe nicht verfügbar");
	    }
			BufferedWriter aus = new BufferedWriter(new FileWriter("Cafe.csv", true));
			aus.write(this.getCafe().gibCafeZuruck(';'));
			aus.close();
		
	}
	public void leseCafeAusCsvDatei() throws IOException {
		
		Creator  readerCreator = new ConcreteCsvCreator();
		Product reader = readerCreator.factoryMethod();
		
        String[] zeile = reader.leseAusDatei();
        
        this.setCafe(new Cafe(zeile[0], 
            zeile[1], 
            zeile[2], 
            zeile[3], 
            zeile[4].split("_"))); 
        reader.schliesseDatei();
	}
	
	public void leseCafeAusTxtDatei() throws IOException {
			
			Creator  readerCreator = new ConcreteTxtCreator();
			Product reader = readerCreator.factoryMethod();
			
	        String[] zeile = reader.leseAusDatei();
	        
	        this.setCafe(new Cafe(zeile[0], 
	            zeile[1], 
	            zeile[2], 
	            zeile[3], 
	            zeile[4].split("_"))); 
	        reader.schliesseDatei();
		}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
}
