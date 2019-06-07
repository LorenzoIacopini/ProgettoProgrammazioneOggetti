package service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import model.Metadati;

@Service
public class MetadatiService {
	ArrayList<Metadati> metadati=new ArrayList<Metadati>();
	public MetadatiService() {
		Metadati m=new Metadati();
		m.setAlias("CodAteco");
		m.setSourceField("Codice Ateco 2007");
		m.setType("string");
		metadati.add(0, m);
		
		m=new Metadati();
		m.setAlias("Descrizione");
		m.setSourceField("Descrizione Ateco 2007");
		m.setType("string");
		metadati.add(1,m);
		
		m=new Metadati();
		m.setAlias("Dim");
		m.setSourceField("Dimensione impresa [micro,piccola,media]");
		m.setType("string");
		metadati.add(2,m);
		
		
		m=new Metadati();
		m.setAlias("NumImp");
		m.setSourceField("Numero delle imprese");
		m.setType("integer");
		metadati.add(3,m);
		
		m=new Metadati();
		m.setAlias("TotInd");
		m.setSourceField("Totale personale indipendente");
		m.setType("integer");
		metadati.add(4,m);
		
		m=new Metadati();
		m.setAlias("TotDip");
		m.setSourceField("Totale personale dipendente");
		m.setType("integer");
		metadati.add(5,m);
		
		m=new Metadati();
		m.setAlias("TotExt");
		m.setSourceField("Totale personale esterno");
		m.setType("integer");
		metadati.add(6,m);
		
		m=new Metadati();
		m.setAlias("TotInt");
		m.setSourceField("Totale personale interno");
		m.setType("integer");
		metadati.add(7,m);
		
	}
	
	public ArrayList<Metadati> getMetadati() {
		return metadati;
	}
}
