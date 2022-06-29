package Paises;


public class FichaPais {
	
	private String nomePais;
	private String continente;
	double populacao;
	
	public FichaPais(){
		this.nomePais="";
		this.continente="";
		this.populacao=0.0;
	}
	
	public FichaPais(String nomePais,String continente, double populacao){
		this.nomePais= nomePais;
		this.continente=continente;
		this.populacao= populacao;
	}
	
	public FichaPais(FichaPais f){
		this.nomePais = f.getNomePais();
		this.continente = f.getContinente();
		this.populacao = f.getPopulacao();
	}

		
	//GETS E SETS
	
	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public double getPopulacao() {
		return populacao;
	}

	public void setPopulacao(double populacao) {
		this.populacao = populacao;
	}
	
	//EQUALS toString CLONE
	
	public boolean equals(Object o) {
    	if (this == o) return true;
    	if ((o==null)||(this.getClass() != o.getClass()))
    		return false;
    	else{ FichaPais f = (FichaPais)o;
    			return (this.nomePais.equals(f.getNomePais()));
    		}
    }
	
	  /**
     * toString
     */
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	s.append(this.nomePais + ";\n");
    	s.append(this.continente + ";\n");
  	    s.append(this.populacao + ";\n");
    	
    	return s.toString();
    }

    public FichaPais clone(){
    	return new FichaPais(this);
    }
	
}
