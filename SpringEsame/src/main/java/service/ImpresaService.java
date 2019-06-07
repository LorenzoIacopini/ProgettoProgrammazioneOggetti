package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import model.Impresa;
import statistics.Converter;
import statistics.DefineOccorrenza;
import statistics.Occorrenza;
import statistics.Operazione;
import statistics.Statistiche;

@Service
public class ImpresaService {
	String FileToParse="ProgettoEsame.csv";
	final String DELIMITER=";";
	ArrayList<Impresa> impresa=new ArrayList<Impresa>();
	public ImpresaService() {
		try {
			Scanner fileinput=new Scanner(new BufferedReader(new FileReader(FileToParse)));
			fileinput.nextLine();//ignora la prima riga
			while(fileinput.hasNextLine()) {
				String line=fileinput.nextLine();//legge l'intera riga
				String[] token=line.split(DELIMITER);
				Impresa appoggio=new Impresa();
				appoggio.setCodAteco(token[0]);
				appoggio.setDescrizione(token[1]);
				appoggio.setDim(token[2]);
				appoggio.setNumImp(Integer.parseInt(token[3]));
				appoggio.setTotDip(Integer.parseInt(token[5]));
				appoggio.setTotInd(Integer.parseInt(token[6]));
				appoggio.setTotExt(Integer.parseInt(token[7]));
				appoggio.setTotInt(Integer.parseInt(token[8]));			
				impresa.add(appoggio);
				}
		
			fileinput.close();
		}	catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	/*public ImpresaService(ArrayList<Impresa> impresa) {
		try {
			Scanner fileinput=new Scanner(new BufferedReader(new FileReader(FileToParse)));
			fileinput.nextLine();//ignora la prima riga
			while(fileinput.hasNextLine()) {
				String line=fileinput.nextLine();//legge l'intera riga
				String[] token=line.split(DELIMITER);
				Impresa appoggio=new Impresa();
				appoggio.setCodAteco(token[0]);
				appoggio.setDescrizione(token[1]);
				appoggio.setDim(token[2]);
				appoggio.setNumImp(Integer.parseInt(token[3]));
				appoggio.setTotDip(Integer.parseInt(token[4]));
				appoggio.setTotInd(Integer.parseInt(token[5]));
				appoggio.setTotExt(Integer.parseInt(token[6]));
				appoggio.setTotInt(Integer.parseInt(token[6]));			
				impresa.add(appoggio);
				}
		
			fileinput.close();
		}	catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}*/
	
	public ArrayList<Impresa> getData() {
		return impresa;
		
	}
	/*
	public ArrayList<Impresa> getField(String name) {
		ArrayList<Impresa> appoggio=new ArrayList<Impresa>();
		//Converter converter=new Converter();
		//int index=converter.converter(field);
		for(int i=0;i<impresa.size();i++) {
			if(impresa.get(i).getCodAteco().equals(name)) appoggio.add(impresa.get(i));
		}
		return appoggio;
	}*/
	
	public Statistiche getStats(String field) {
		Converter conv=new Converter();
		Statistiche stats=new Statistiche();
		Operazione operation=new Operazione();
		Integer somma=0;
		double avg=0;
		Integer max=0;
		Integer min=2147483647;
		Double diffquad=0.0;
		double std=0;
		int count=0;
		for(int i=0; i<impresa.size();i++) {
			somma=operation.Somma(conv.converter(field, impresa.get(i)), somma);
			count++;
			max=operation.Max(conv.converter(field, impresa.get(i)),max);
			min=operation.Min(conv.converter(field, impresa.get(i)), min);
		}
		avg=(double)somma/count;
		stats.setSum(somma);
		double appoggio=0.0;
		for(int i=0; i<impresa.size();i++) {
			diffquad=operation.Diff_al_quadrato(avg, conv.converter(field, impresa.get(i)));
			appoggio+=diffquad;
		}
		std=Math.sqrt(appoggio);;
		stats.setField(field);
		stats.setAvg(avg);
		stats.setMax(max);
		stats.setMin(min);
		stats.setStd(std);
		stats.setCount(count);
		return stats;
	}
	
	public HashMap<String,Occorrenza> getOcc() {
		DefineOccorrenza x=new DefineOccorrenza();
		return x.setOccorrenza(impresa);
	}
	
	public int getOccField(String field) {
		DefineOccorrenza x=new DefineOccorrenza();
		return x.OccorrenzeDimensione(impresa,field);
	}
	
	public Statistiche getSpecificStats(String field, int val_min,int val_max) {
		Converter conv=new Converter();
		Statistiche stats=new Statistiche();
		Operazione operation=new Operazione();
		Integer somma=0;
		double avg=0;
		Integer max=0;
		Integer min=2147483647;
		Double diffquad=0.0;
		double std=0;
		int count=0;
		for(int i=0;i<impresa.size();i++) {
			if(conv.converter(field, impresa.get(i))>=val_min && conv.converter(field, impresa.get(i))<=val_max) {
				somma=operation.Somma(conv.converter(field, impresa.get(i)), somma);
				count++;
				max=operation.Max(conv.converter(field, impresa.get(i)),max);
				min=operation.Min(conv.converter(field, impresa.get(i)), min);
			}
		}
		avg=(double)somma/count;
		stats.setSum(somma);
		double appoggio=0.0;
		for(int i=0; i<impresa.size();i++) {
			if(conv.converter(field, impresa.get(i))>=val_min && conv.converter(field, impresa.get(i))<=val_max) {
			diffquad=operation.Diff_al_quadrato(avg, conv.converter(field, impresa.get(i)));
			appoggio+=diffquad;
			}
		}
		std=Math.sqrt(appoggio);;
		stats.setField(field);
		stats.setAvg(avg);
		stats.setMax(max);
		stats.setMin(min);
		stats.setStd(std);
		stats.setCount(count);
		return stats;
	}
		
		
		/*
		Statistiche stats=new Statistiche();
		Operazione operation=new Operazione();
		int somma=operation.Somma(impresa, field,min,max);
		double avg=operation.Avg(impresa, field,min,max);
		int massimo=operation.Max(impresa, field,min,max);
		int minimo=operation.Min(impresa, field,min,max);
		double std=operation.Std(impresa, field,min,max);
		int count=operation.Count(impresa, field,min,max);
		stats.setField(field);
		stats.setSum(somma);
		stats.setAvg(avg);
		stats.setMax(massimo);
		stats.setMin(minimo);
		stats.setStd(std);
		stats.setCount(count);
		return stats;
		*/
       	
		public ArrayList<Occorrenza> getAllOcc(String field) {
			Occorrenza x=new Occorrenza();
			return x.calcoloOccorrenza(impresa, field);
		}
	
		public HashMap<String,Occorrenza> getOccorrenza() {
			Occorrenza x=new Occorrenza();
			return x.setOccorrenza(impresa);
		}
}

