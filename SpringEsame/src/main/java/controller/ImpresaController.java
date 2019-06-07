package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import eccezioni.ErrorRequestException;
import model.Impresa;
import model.OccDimensione;
import service.ImpresaService;
import statistics.Occorrenza;
import statistics.Statistiche;

@RestController
@RequestMapping()
public class ImpresaController {
	
		@Autowired
		ImpresaService impserv;
		
		@GetMapping("/data")
		public ArrayList<Impresa> getData() {
			return impserv.getData();
		}
		/*
		@GetMapping("/data/{field}")
		public ArrayList<Impresa> getField(@PathVariable("field") @RequestParam(value="Micro") String name) {
			return impserv.getField(name);
		}*/
		
		@GetMapping("/stats")
		public Statistiche getStats(@RequestParam(name="field") String field,
									@RequestParam(name="min",required=false, defaultValue="0") int min,
									@RequestParam(name="max",required=false, defaultValue="130000")int max) throws ErrorRequestException {
		if(min==-1 && max==130000) return impserv.getStats(field);
		else if(min>0 || max<130000) return impserv.getSpecificStats(field, min, max);
				else if (min>=0) return impserv.getSpecificStats(field,min,max);
				else if(max<130000) return impserv.getSpecificStats(field, min, max);
					else  throw new ErrorRequestException();
		}
		/*
		@GetMapping("/occorrenze")
		public HashMap<String,Occorrenza> getOcc() {
			return impserv.getOcc();
		}
		
		@GetMapping("/Occorrenze")
		public String CalcoloOccorrenzeDimensione(@RequestParam(name="dim") String field) {
			OccDimensione x=new OccDimensione();
			x.setDimensione(field);
			x.setOccorrenza(impserv.getOccField(field));
	        Gson gson=new Gson();			
			JsonParser jsonParser = new JsonParser();
	        JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();
	    return gson.toJson(x);
		}
	*/
		@GetMapping("/occorrenze")
		public HashMap<String,Occorrenza> getOccorrenza() {
			return impserv.getOccorrenza();
		}
		
		@GetMapping("/occ")
		public ArrayList<Occorrenza> getAllOcc(@RequestParam(name="field") String field) {
			return impserv.getAllOcc(field);
		}
}

