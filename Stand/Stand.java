package Stand;


/**
 * Classe que representa um Stand de automóveis
 */
public class Stand {
  //variáveis de instância
  private String nomeStand;
  private Veiculo[] carros;
  private int nveiculos;   //número veículos no stand
  
  //capacidade do stand (em número de veículos)
  private int capacidade;
  
  //capacidade inicial do Stand: valor por omissão
  public static final int capacidade_inicial = 10;
  
  //construtores
  public Stand() {
    this.nomeStand = new String();
    this.carros = new Veiculo[capacidade_inicial];
    this.capacidade = capacidade_inicial;
    this.nveiculos = 0;
  }
  
  public Stand(String nome, int capacidade) {
    this.nomeStand = nome;
    this.carros = new Veiculo[capacidade];
    this.capacidade = capacidade;
    this.nveiculos = 0;
  }
  
  public Stand(Stand umStand) {
    this.nomeStand  = umStand.getNomeStand();
    this.carros     = umStand.getCarros();
    this.capacidade = umStand.getCapacidade();
    this.nveiculos  = umStand.getNveiculos();
  }
  
  //métodos de instância
  
  //gets e sets: fazer!
  
  //outros métodos

  public String getNomeStand() {
	return nomeStand;
}

public void setNomeStand(String nomeStand) {
	this.nomeStand = nomeStand;
}

public Veiculo[] getCarros() {
	return carros;
}

public void setCarros(Veiculo[] carros) {
	this.carros = carros;
}

public int getNveiculos() {
	return nveiculos;
}

public void setNveiculos(int nveiculos) {
	this.nveiculos = nveiculos;
}

public int getCapacidade() {
	return capacidade;
}

public void setCapacidade(int capacidade) {
	this.capacidade = capacidade;
}

public static int getCapacidadeInicial() {
	return capacidade_inicial;
}
  
  
  /**
   * Método que insere um veículo no stand
   * 
   */
   public void insereVeiculo(Veiculo v) {
	   if(this.nveiculos<capacidade_inicial) this.carros[this.nveiculos]=v;
	   this.nveiculos++;
   }
   		
   


/**
    * Método que verifica se um determinado veículo está no
    * stand.
    */
    public boolean existeVeiculo(Veiculo v) {
    	int i;
    	boolean res= false;
    	for(i=0;i<this.nveiculos;i++)
    		if (this.carros[i]==v) res = true;
    	return res;
    }
    
    
    /**
     * Método que verifica se um veículo, cuja matrícula é conhecida, 
     * está no stand.
     */
    public boolean existeVeiculoPorMatricula(String matricula) {
    	int i;
    	boolean res=false;
    	for(i=0;i<this.nveiculos && !res;i++){
    		if (this.carros[i].getMatricula()==matricula)res=true;
    	}
    	return res;
    	
    }
    
    
    /** 
     * Método que devolve o veículo com mais kms.
     * 
     */
    public Veiculo veiculoComMaisKms() {
    	int i;
    	double km=Double.MIN_VALUE;
    	int res=0;
    	for(i=0;i<this.nveiculos;i++){
    		if(this.carros[i].getKm()>km){
    			km=this.carros[i].getKm(); 
    			res = i;}
    		
    	}
    	return this.carros[res];
    }
    
    /**
     * Método que devolve o veículo mais gastador (em termos de
     * combustível).
     */
    public Veiculo veiculoMaisGastador() {
    	int i;
    	double consumo = 0.0;
    	int res=0;
    	for(i=0;i<this.nveiculos;i++){
    		if(this.carros[i].getConsumo()>consumo){
    			res=i;
    			consumo = this.carros[i].getConsumo();
    		}
    	}
    	return this.carros[res];
    }
    
    /**
     * Método que determina o número de kms de todos os veículos
     * da garagem.
     * 
     */
    public double totalKmsTodosVeiculos() {
    	int i;
    	double res=0.0;
    	for(i=0;i<this.nveiculos;i++)
    		res+=this.carros[i].getKm();
    	return res;
    }
    	
    
/**
 * equals
 */
public boolean equals(Object o) {
	if (this == o) {
		return true;
	}

	if (o == null || getClass() != o.getClass()) {
		return false;
	}

	Stand s = (Stand) o;
	return this.nomeStand.equals(s.getNomeStand());
}
    
/**
 * Returns a string representation of the object.
 *
 * @return          a string representation of the object
 */
public String toString() {
	StringBuilder s = new StringBuilder();
	s.append(this.nomeStand).append(";\n");
	s.append(this.nveiculos).append(";\n");
	s.append(this.capacidade).append(";\n");
	for (int i = 0; i < this.nveiculos; i++) {
		s.append(this.carros[i].toString()).append(";\n");
	}
	return s.toString();
}
    
    /**
     * clone
     */
    public Stand clone() {
    	return new Stand(this);
    }
    
}
