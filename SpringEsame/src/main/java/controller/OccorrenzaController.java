/*
package controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import model.OccDimensione;
import service.ImpresaService;
import statistics.Occorrenza;

@RestController
@RequestMapping("/occorrenze")		
public class OccorrenzaController {
			@Autowired
			ImpresaService impserv;
			
			@GetMapping
			public HashMap<String,Occorrenza> getOcc() {
				return impserv.getOcc();
			}
			
			@GetMapping("/")
			public String CalcoloOccorrenzeDimensione(@RequestParam(name="dim") String field) {
				OccDimensione x=new OccDimensione();
				x.setDimensione(field);
				x.setOccorrenza(impserv.getOccField(field));
		        Gson gson=new Gson();			
				/*JsonParser jsonParser = new JsonParser();
		        JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();*/
		   // return gson.toJson(x);
		//	}
//}

