public class VeiculoPremium extends Veiculo {
    private              double taxa_luxo_percentagem; // percentagem
    private static final double DEFAULT_TAXA_LUXO_PERCENTAGEM = 23;

    // Construtores
    public VeiculoPremium() {
        super();
        this.taxa_luxo_percentagem = VeiculoPremium.DEFAULT_TAXA_LUXO_PERCENTAGEM;
    }

    public VeiculoPremium(String codigo, String marca) {
        super(codigo, marca);
        this.taxa_luxo_percentagem = VeiculoPremium.DEFAULT_TAXA_LUXO_PERCENTAGEM;
    }

    public VeiculoPremium(String codigo, String marca, int kilometros, double preco_kilometro, double taxa_luxo_percentagem) {
        super(codigo, marca, kilometros, preco_kilometro);
        this.taxa_luxo_percentagem = taxa_luxo_percentagem;
    }

    public VeiculoPremium(VeiculoPremium outro) {
        super(outro);
        this.taxa_luxo_percentagem = outro.taxa_luxo_percentagem;
    }

    // Metodos de Instancia
    @Override
    public String toString() {
        return ( "Codigo: " + this.getCodigo()
                + ", Marca: " + this.getMarca()
                + ", Rating Medio: " + this.getClassificacaoMedia()
                + ", Kilometros: " + this.getPreco_kilometro()
                + ", onSale: " + "\n");
    }

    @Override
    public VeiculoPremium clone() {
        return new VeiculoPremium(this);
    }
    
    // Getters + Setters
    public double getTaxa_luxo() {
        return taxa_luxo_percentagem;
    }

    public void setTaxa_luxo(double taxa_luxo_percentagem) {
        this.taxa_luxo_percentagem = taxa_luxo_percentagem;
    }
}
