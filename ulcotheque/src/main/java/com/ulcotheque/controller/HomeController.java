package com.ulcotheque.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ulcotheque.dto.AuteurDTO;
import com.ulcotheque.dto.GenreDTO;
import com.ulcotheque.dto.HomeDTO;
import com.ulcotheque.dto.IndicateurDTO;
import com.ulcotheque.dto.LivreDTO;
import com.ulcotheque.dto.LivresRequestDTO;
import com.ulcotheque.dto.PieChartDTO;
import com.ulcotheque.entity.LivreEntity;
import com.ulcotheque.enums.TypeEnum;
import com.ulcotheque.mapper.AuteurMapper;
import com.ulcotheque.mapper.LivreMapper;
import com.ulcotheque.service.LivreService;

import io.swagger.v3.oas.annotations.Operation;


@RestController 
@RequestMapping(value = "/rest/bd/") 
public class HomeController {
	
    @Autowired
    private LivreService service;
    
    @GetMapping("/livres/{id}")
    @Operation(summary ="Récupère le livre ayant comme clé primaire {id}")
    public LivreDTO findById(@PathVariable Integer id) {
        return LivreMapper.map(service.findLivreById(id));
    }

    @DeleteMapping("/livres/{id}")
    @Operation(summary ="Supprime le livre ayant comme clé primaire {id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }
    
    @PostMapping("/livres")
    @Operation(summary ="Insère le livre rempli via le formulaire en base.")
    public void save(@RequestBody LivresRequestDTO reqAddLivre) {
        LivreEntity livre = LivreMapper.addLivre(reqAddLivre);
        service.saveOrUpdateLivre(livre);
    }
    
    @PutMapping("/livres/{id}")
    @Operation(summary ="Modifie le livre ayant comme clé primaire {id}")
    public void modif(@PathVariable Integer id, @RequestBody LivresRequestDTO reqModifLivre) {
        service.saveOrUpdateLivre(LivreMapper.modifLivre(reqModifLivre, service.findLivreById(id)));
    }
    
    @GetMapping("livres")
    @Operation(summary ="Récupère une liste de livres ayant comme genre {param}")
	public List<LivreDTO> findByGenre(@RequestParam TypeEnum genre){
		return LivreMapper.map(service.findByGenre(genre));
	}
    
    
    @GetMapping("/auteurs/{id}")
    @Operation(summary ="Récupère l’auteur ayant comme clé primaire {id}")
    public AuteurDTO findAuteurById(@PathVariable Integer id) {
        return AuteurMapper.map(service.findAuteurById(id));
    }

	@GetMapping("/auteurs")
	@Operation(summary ="Affiche une liste d’auteurs")
	public List<AuteurDTO> findAllAuteurs(){
		return AuteurMapper.map(service.findAllAuteurs());
	}

	        
}