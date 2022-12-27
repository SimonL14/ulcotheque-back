package com.ulcotheque.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ulcotheque.entity.LivreEntity;
import com.ulcotheque.enums.TypeEnum;


@Repository
public interface LivreRepository extends JpaRepository<LivreEntity, Integer>{
	
	@Query(value="SELECT l FROM LivreEntity l where l.genre = :genre")
	List<LivreEntity> findLivresByGenre(@Param("genre") final TypeEnum genre);
	
	@Query(value="SELECT * FROM livres order by nom ASC", nativeQuery=true)
	public List<LivreEntity> findAllLivresRepo();
	
	@Query("SELECT genre as labels FROM LivreEntity l GROUP BY l.genre")
	ArrayList<String> findGenre();

	@Query("SELECT count(genre) as values FROM LivreEntity l GROUP BY l.genre")
	ArrayList<Integer> findGenreNb();
	
}
