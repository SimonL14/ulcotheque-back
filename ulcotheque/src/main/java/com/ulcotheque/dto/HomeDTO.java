package com.ulcotheque.dto;

import java.util.List;
import java.util.Map;

public class HomeDTO {
	private List<LivreDTO> livre;
	private IndicateurDTO indicateurs;
    private Map<String,Integer> genres;
	private PieChartDTO datasGraph;
		    
	    
	    public List<LivreDTO> getLivres() {
	        return livre;
	    }
	    public void setLivres(List<LivreDTO> livre) {
	        this.livre = livre;
	    }
	    
		public IndicateurDTO getIndicateurs() {
			return indicateurs;
		}
		public void setIndicateurs(IndicateurDTO indicateurs) {
			this.indicateurs = indicateurs;
		}
		public List<LivreDTO> getLivre() {
			return livre;
		}
		public void setLivre(List<LivreDTO> livre) {
			this.livre = livre;
		}
		public Map<String, Integer> getGenres() {
			return genres;
		}
		public void setGenres(Map<String, Integer> genres) {
			this.genres = genres;
		}
		public PieChartDTO getDatasGraph() {
			return datasGraph;
		}
		public void setDatasGraph(PieChartDTO datasGraph) {
			this.datasGraph = datasGraph;
		}
}
