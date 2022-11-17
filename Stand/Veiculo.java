package Stand;

public class Veiculo {
	
	private double maxLitros;
	private double litragem;
	private String matricula;
	private int viagens;
	private double consumo;
	private double km;
	
	public  Veiculo() {
		this.maxLitros=0.0;
		this.litragem=0.0;
		this.matricula="";
		this.viagens=0;
		this.consumo=0.0;
		this.km=0.0;
	}
	
	public Veiculo( String matricula,double maxLitros, double litragem,  int viagens, double consumo, double km){
		this.maxLitros=maxLitros;
		this.litragem=litragem;
		this.matricula=matricula;
		this.viagens=viagens;
		this.consumo=consumo;
		this.km=km;
	}
	
	public Veiculo(Veiculo v){
		this.maxLitros=v.getMaxLitros();
		this.litragem=v.getLitragem();
		this.matricula=v.getMatricula();
		this.viagens=v.getViagens();
		this.consumo=v.getConsumo();
		this.km=v.getKm();
	}

	public double getMaxLitros() {
		return maxLitros;
	}

	public void setMaxLitros(double maxLitros) {
		this.maxLitros = maxLitros;
	}

	public double getLitragem() {
		return litragem;
	}

	public void setLitragem(double litragem) {
		this.litragem = litragem;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getViagens() {
		return viagens;
	}

	public void setViagens(int viagens) {
		this.viagens = viagens;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}
	
	public double autonomia(){
		return (litragem/consumo)*100;
	}
	
	public void registaViagem(double km){
		this.km+=km;
		this.viagens++;
	}
	
	public boolean reserva(){
		if (this.litragem <= 10.0)return true;
		else return false;
	}
	
	public double totalGasto(double preco){
		return this.litragem*preco;
	}
	
	public double custoKm(double preco){
		return ((this.consumo/100)*preco);
	}
	
	public void meterGota(double x){
		if ((this.litragem+x)<=this.maxLitros)
			this.litragem = this.litragem+x;
		else this.litragem=this.maxLitros;
	}
	
	public boolean equals(Object o) {
    	
    	if (this == o) return true;
    	if ((o==null)||(this.getClass() != o.getClass()))
    		return false;
    	else{ Veiculo v = (Veiculo)o;
    		return ( this.matricula.equals(v.getMatricula()));
    	}
    }
	
	public String toString(){
		return new String("Veiculo: matricula " + this.matricula + " ,litragem " + this.litragem + " ,km " + this.km
				+ " ,consumo " + this.consumo + " ,viagens " + this.consumo + " ,maxLitros" + this.maxLitros);
	}
	
	public Veiculo clone(){
		return new Veiculo(this);
	}
	
	
}
