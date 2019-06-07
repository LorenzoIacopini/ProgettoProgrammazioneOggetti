package controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Impresa;
import model.Metadati;
import service.ImpresaService;
import service.MetadatiService;
@RestController
@RequestMapping()
public class MetadatiController {
		
			@Autowired
			MetadatiService metserv;
			
			@RequestMapping("/metadata")
			public ArrayList<Metadati> getMetadati() {
				return metserv.getMetadati();
			}

	}

