package statistics;

import java.util.ArrayList;
import java.math.*;
import model.Impresa;

public class Operazione {
	Converter temp=new Converter();
	public int Somma(int valore,Integer sum) {
		return sum.intValue()+valore;
		/*for(int i=0; i<impresa.size();i++) {
			somma+=temp.converter(field, impresa.get(i));
		}
		return somma;*/
	}
	
	/*public int Somma(ArrayList<Impresa> impresa, String field, int min,int max) {
		Converter temp=new Converter();
		int somma=0;
		for(int i=0; i<impresa.size();i++) {
			if(temp.converter(field, impresa.get(i))>min && temp.converter(field, impresa.get(i))<max) {
			somma+=temp.converter(field, impresa.get(i));
			}
		}
		return somma;
	}*/
	
	public int Count(int conteggio) {
		return conteggio++;
	}
	/*
	public int Count(ArrayList<Impresa> impresa, String field,int min, int max) {
		Converter temp=new Converter();
		int cont=0;
		for(int i=0;i<impresa.size();i++) {
			if(temp.converter(field, impresa.get(i))>min && temp.converter(field, impresa.get(i))<max) {
			cont++;
			}
		}
		return cont;
	}*/
	public int Max(int valore,Integer massimo) {
		if (valore>massimo) massimo=valore;
		return massimo;
	}
	/*
	public int Max(ArrayList<Impresa> impresa, String field,int min, int max) {
		int massimo=0;
		Converter temp=new Converter();
		for(int i=0; i<impresa.size();i++) {
			if(temp.converter(field, impresa.get(i))>min && temp.converter(field, impresa.get(i))<max) {
				if(temp.converter(field, impresa.get(i))>massimo) massimo=temp.converter(field, impresa.get(i));
			}
		}
		return massimo;
	}*/
	
	public int Min(int valore, Integer minimo) {
		/*int min=2147483647;
		Converter temp=new Converter();
		for(int i=0; i<impresa.size();i++) {
			if(temp.converter(field, impresa.get(i))<min) min=temp.converter(field, impresa.get(i));
		}
		return min;*/
		if (valore<minimo) minimo=valore;
		return minimo;
	}
	/*
	public int Min(ArrayList<Impresa> impresa, String field,int min, int max) {
		int minimo=2147483647;
		Converter temp=new Converter();
		for(int i=0; i<impresa.size();i++) {
			if(temp.converter(field, impresa.get(i))>min && temp.converter(field, impresa.get(i))<max) {
				if(temp.converter(field, impresa.get(i))<minimo) minimo=temp.converter(field, impresa.get(i));
			}
		}	
		return minimo;
	}*/
	/*
	public double Avg(ArrayList<Impresa> impresa, String field) {
		int somma=Somma(impresa,field);
		int numero=Count(impresa,field);
		return (double)somma/numero;
	}*/
	/*
	public double Avg(ArrayList<Impresa> impresa, String field,int min, int max) {
		int somma=Somma(impresa,field,min,max);
		int numero=Count(impresa,field,min,max);
		return (double)somma/numero;
	}*/
	//Questo metodo calcola la deviazione standard dei valori in base al campo che si passa nella richiesta
	public double Diff_al_quadrato(double avg,int valore) {
		/*double avg=Avg(impresa,field);
		double diffquad;
		double sommaquad=0;
		int numero=Count(impresa,field);
		Converter temp=new Converter();
		for(int i=0; i<impresa.size();i++) {
			diffquad=Math.pow(temp.converter(field, impresa.get(i))-avg, 2);
			sommaquad+=diffquad;
		}
		return Math.sqrt(sommaquad/numero);*/
		return Math.pow(valore-avg, 2);
	}
	/*
	public double Std(ArrayList<Impresa> impresa, String field,int min, int max) {
		double avg=Avg(impresa,field,min,max);
		double diffquad;
		double sommaquad=0;
		int numero=Count(impresa,field,min,max);
		Converter temp=new Converter();
		for(int i=0; i<impresa.size();i++) {
			if(temp.converter(field, impresa.get(i))>min && temp.converter(field, impresa.get(i))<max) {
				diffquad=Math.pow(temp.converter(field, impresa.get(i))-avg, 2);
				sommaquad+=diffquad;
			}
		}
		return Math.sqrt(sommaquad/numero);
	}*/
}
