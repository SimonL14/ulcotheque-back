package com.ulcotheque.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ulcotheque.dto.AuteurDTO;
import com.ulcotheque.entity.AuteurEntity;

public class AuteurMapper {
	
	public static AuteurDTO map(AuteurEntity entity) {
		AuteurDTO auteur = new AuteurDTO();
		  
		  
		auteur.setId(entity.getId()); 
		auteur.setNom(entity.getNom());
		auteur.setPrenom(entity.getPrenom());
		auteur.setDatedenaissance(entity.getDatedenaissance());

		  return auteur;
		 
	}
	
	public static List<AuteurDTO> map(List<AuteurEntity> AuteurEntity){
		if(null == AuteurEntity) {
			return null;
		}
		List<AuteurDTO> result = new ArrayList<AuteurDTO>();
		for(final AuteurEntity auteur : AuteurEntity) {
			result.add(AuteurMapper.map(auteur));
		}
		
		return result;
	}

}
