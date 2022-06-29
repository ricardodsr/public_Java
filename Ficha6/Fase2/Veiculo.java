import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    // Variáveis de instância
    private String        codigo;
    private String        marca;
    private int           kilometros;
    private double        preco_kilometro;
    private List<Integer> ratings;

    // Construtores
    public Veiculo() {
        this.codigo = "invalid";
        this.marca = "invalid";
        this.kilometros = 0;
        this.preco_kilometro = 0;
        this.ratings = new ArrayList<>();
    }

    public Veiculo(String codigo, String marca) {
        this.codigo = codigo;
        this.marca = marca;
        this.kilometros = 0;
        this.preco_kilometro = 0;
        this.ratings = new ArrayList<>();
    }

    public Veiculo(String codigo, String marca, int kilometros) {
        this.codigo = codigo;
        this.marca = marca;
        this.kilometros = kilometros;
        this.ratings = new ArrayList<>();
    }

    public Veiculo(String codigo, String marca, int kilometros, double preco_kilometro) {
        this.codigo = codigo;
        this.marca = marca;
        this.kilometros = kilometros;
        this.preco_kilometro = preco_kilometro;
        this.ratings = new ArrayList<>();
    }

    public Veiculo(Veiculo outro) {
        this.codigo = outro.codigo;
        this.marca = outro.marca;
        this.kilometros = outro.kilometros;
        this.preco_kilometro = outro.preco_kilometro;
        this.ratings = new ArrayList<Integer>();
        this.ratings.addAll(outro.ratings);
    }

    // Métodos de instância
    public void addRating(int rate) {
        this.ratings.add(rate);
    }

    public void addKilometros(int numKms) {
        this.kilometros += numKms;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Veiculo outro = (Veiculo) o;
        return (this.codigo.equals(outro.codigo) &&
                this.marca.equals(outro.marca));
    }

    public Veiculo clone() {
        return new Veiculo(this);
    }

    public String toString() {
        return ( "Codigo: " + this.codigo
               + ", Marca: " + this.marca
               + ", Rating Medio: " + this.getClassificacaoMedia()
               + ", Kilometros: " + this.kilometros + "\n");
    }

    public int compareTo(Veiculo outro) {
        return this.codigo.compareTo(outro.codigo);
    }

    public double getClassificacaoMedia() {
        return this.ratings.stream()
                           .mapToDouble(i -> i)
                           .average()
                           .orElse(0);
    }

    // Getters
    public String getCodigo() {
        return this.codigo;
    }

    public String getMarca() {
        return this.marca;
    }

    public double getPreco_kilometro() {
        return this.preco_kilometro;
    }

    public int getKilometros() {
        return kilometros;
    }

    // Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
