package Paises;

import java.util.ArrayList;

public class ListaPaises {
	private ArrayList<FichaPais> lista = new ArrayList<FichaPais>();
	
	public ListaPaises(){
		this.lista = new ArrayList<FichaPais>();
	}
	
	public ListaPaises(ArrayList<FichaPais> lista){
		this.lista=lista;
	}
	
	public ListaPaises(ListaPaises l){
		for(FichaPais f : l.getLista()){
			this.lista.add(f.clone());
		}
	}

		
	//GETS E SETS
	public ArrayList<FichaPais> getLista() {
		return lista;
	}

	public void setLista(ArrayList<FichaPais> lista) {
		this.lista = lista;
	}
	
	//Determinar o n�mero total de pa�ses;
	
	public int totalPaises(){
		return this.lista.size();
	}
	
	//Determinar o n�mero de pa�ses de um continente dado;
	
	public int numPaisesContinenteDado(String s){
		int resultado = 0;
		for(FichaPais f : lista){
			if(this.lista.contains(f.getContinente())) resultado++;
		}
		return resultado;
	}
	
	//Dado o nome de um pa�s, devolver a sua ficha completa, caso exista;
	
	public FichaPais retornaFicha(String s){
		FichaPais resultado = new FichaPais();
		for(FichaPais f : lista){
			if(this.lista.contains(f.getNomePais().equals(s))) resultado = f.clone(); 
		}
		
		return resultado;
		
	}
	
	//Criar uma lista com os nomes dos pa�ses com uma popula��o superior a um valor dado;
	
	public ArrayList<String> listaPaisesComPopSup(double v){
		ArrayList<String> resultado = new ArrayList<String>();
		for(FichaPais f : lista){
			if(f.getPopulacao()>v) resultado.add(f.getNomePais());
		}
		return resultado;
	}
	
	/**Determinar a lista com os nomes dos continentes dos pa�ses com popula��o superior a
	dado valor;*/
	
	public ArrayList<String> listaContinentesComPopSup(double v){
		ArrayList<String> resultado = new ArrayList<String>();
		for(FichaPais f : lista){
			if(f.getPopulacao()>v && !resultado.contains(f.getContinente())) resultado.add(f.getContinente());
		}
		return resultado;
	}
	
	// Determinar o somat�rio das popula��es de dado continente;
	
	public double somatorioPopDeContinente(String s){
		double resultado = 0;
		for(FichaPais f:lista){
			if(this.lista.contains(f.getContinente().equals(s))) resultado+=f.getPopulacao();
		}
		return resultado;
	}
	
	/**Dada uma lista de FichaDePais, para cada pa�s que exista na lista de pa�ses alterar a sua
	popula��o com o valor na ficha; caso n�o exista inserir a ficha na lista;*/
	
	public void alteraFichas(ListaPaises l){
		FichaPais aux = new FichaPais();
		for(FichaPais f:l.getLista()){
			if(this.lista.contains(f.getNomePais())){
				aux = retornaFicha(f.getNomePais());
				aux.setPopulacao(f.getPopulacao());
				int indAux =lista.indexOf(f);
				lista.set(indAux, aux);
			}
			else lista.add(f.clone());	
		}
	}
}
