import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DriveIt {
    // Variáveis de Instância
    private List<Veiculo> veiculos;

    // Construtores
    public DriveIt() {
        this.veiculos = new ArrayList<>();
    }

    public DriveIt(List<Veiculo> veiculos) {
        this.veiculos = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            this.veiculos.add(veiculo.clone());
        }
    }

    public DriveIt(DriveIt outro) {
        this.veiculos = new ArrayList<>();
        for (Veiculo veiculo : outro.veiculos) {
            this.veiculos.add(veiculo.clone());
        }
    }

    // Métodos de instância
    // a)
    public boolean existeVeiculo(String cod) {
        return this.veiculos.stream()
                            .anyMatch(veiculo -> veiculo.getCodigo().equals(cod));
    }

    // b)
    public int quantos() {
        return this.veiculos.size();
    }

    // c) (antigo)
    public int quantos(String marca) {
        return (int) this.veiculos.stream()
                                  .filter(veiculo -> veiculo.getMarca().equals(marca))
                                  .count();
    }

    // c) Fase3
    public int quantosT(String tipo) {
        String t;

        switch (tipo) {
            case "V":
            case "Veiculo":
                t = "class Veiculo";
                break;
            case "VO":
            case "VeiculoOcasiao":
                t = "class VeiculoOcasiao";
                break;
            case "VP":
            case "VeiculoPremium":
                t = "class VeiculoPremium";
                break;
            default:
                t = "invalid";
        }

        return (int) this.veiculos.stream()
                                  .filter(a -> a.getClass().toString().equals(t))
                                  .count();
    }

    // d)
    public Veiculo getVeiculo(String cod) {
        return this.veiculos.stream()
                            .filter(v -> v.getCodigo().equals(cod))
                            .findFirst()
                            .orElse(null);
    }

    // e)
    public void adiciona(Veiculo v) {
        this.veiculos.add(v);
    }

    // g)
    public void adiciona(Set<Veiculo> vs) {
        for (Veiculo v : vs)
            this.veiculos.add(v.clone());
    }

    // g)
    public void classificarVeiculo(String cod, int classificacao) {
        this.veiculos.stream().filter(v -> v.getCodigo().equals(cod))
                              .forEach(v -> v.addRating(classificacao));
    }


    public void registarAluguer(String codVeiculo, int numKms) {
        this.veiculos.stream().filter(v -> v.getCodigo().equals(codVeiculo))
                              .forEach(v -> v.addKilometros(numKms));
    }

    public double custoRealKm(String cod) {
        Veiculo v = this.veiculos.stream()
                                 .filter(a -> a.getCodigo().equals(cod))
                                 .findFirst()
                                 .orElseThrow();

        double custoReal = v.getPreco_kilometro();
        custoReal *= 1.1;

        if (v instanceof VeiculoOcasiao) {
            VeiculoOcasiao a = (VeiculoOcasiao) v;
            if (a.isOnSale()) custoReal *= 0.75;
        }

        if (v instanceof VeiculoPremium) {
            VeiculoPremium b = (VeiculoPremium) v;
            custoReal *= 1 + (b.getTaxa_luxo() * 0.01);
        }
        return custoReal;
    }

    // g)
    public List<Veiculo> veiculosOrdenadosCusto() {
        return this.veiculos.stream()
                            .sorted(Comparator.comparingDouble(Veiculo::getPreco_kilometro))
                            .collect(Collectors.toList());
    }

    // h)
    public Veiculo veiculoMaisBarato() {
        return this.veiculos.stream()
                            .sorted(Comparator.comparingDouble(Veiculo::getPreco_kilometro))
                            .limit(1)
                            .findFirst()
                            .orElse(null);
    }

    // i)
    public Veiculo veiculoMenosUtilizado() {
        return this.veiculos.stream()
                            .sorted(Comparator.comparingInt(Veiculo::getKilometros))
                            .limit(1)
                            .map(Veiculo::clone)
                            .findFirst()
                            .orElse(null);
    }

    // Regista um valor para promoção (true or false) caso o veiculo com codigo codVeiculo seja um Veiculo Ocasiao
    public void registaPromocao(String codVeiculo, boolean promo) {
        this.veiculos.stream()
                     .filter(v -> v.getCodigo().equals(codVeiculo))
                     .filter(v -> v instanceof VeiculoOcasiao)
                     .map(v -> (VeiculoOcasiao) v)
                     .findFirst()
                     .ifPresent(a -> a.setOnSale(true));
    }

    public String toString() {
        return this.veiculos.toString();
    }

    // Getters
    public List<Veiculo> getVeiculos() {
        return this.veiculos.stream()
                            .map(Veiculo::clone)
                            .collect(Collectors.toList());
    }

    // Setters
    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos.stream()
                                .map(Veiculo::clone)
                                .collect(Collectors.toList());
    }
}
