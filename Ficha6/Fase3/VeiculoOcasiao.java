public class VeiculoOcasiao extends Veiculo {
    private boolean onSale;

    // Construtores
    public VeiculoOcasiao(boolean onSale) {
        super();
        this.onSale = onSale;
    }

    public VeiculoOcasiao(String codigo, String marca, boolean onSale) {
        super(codigo, marca);
        this.onSale = onSale;
    }

    public VeiculoOcasiao(String codigo, String marca, int kilometros, boolean onSale) {
        super(codigo, marca, kilometros);
        this.onSale = onSale;
    }

    public VeiculoOcasiao(String codigo, String marca, int kilometros, double preco_kilometro, boolean onSale) {
        super(codigo, marca, kilometros, preco_kilometro);
        this.onSale = onSale;
    }

    public VeiculoOcasiao(Veiculo outro, boolean onSale) {
        super(outro);
        this.onSale = onSale;
    }

    public VeiculoOcasiao(VeiculoOcasiao outro) {
        super(outro);
        this.onSale = outro.onSale;
    }

    // Metodos de Instancia
    @Override
    public String toString() {
        return ( "Codigo: " + this.getCodigo()
                + ", Marca: " + this.getMarca()
                + ", Rating Medio: " + this.getClassificacaoMedia()
                + ", Kilometros: " + this.getPreco_kilometro()
                + ", onSale: " + this.onSale + "\n");
    }

    @Override
    public VeiculoOcasiao clone() {
        return new VeiculoOcasiao(this);
    }



    // Getters + Setters
    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }
}
