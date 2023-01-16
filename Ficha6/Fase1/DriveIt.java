import java.util.*;
import java.util.stream.*;

public class DriveIt {
    // Variáveis de Instância
    private List<Veiculo> veiculos;

    // Construtores
    public DriveIt() {
        this.veiculos = new ArrayList<Veiculo>();
    }

    public DriveIt(List<Veiculo> veiculos) {
        this.veiculos = new ArrayList<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            this.veiculos.add(veiculo.clone());
        }
    }

    public DriveIt(DriveIt outro) {
        this.veiculos = new ArrayList<Veiculo>();
        for (Veiculo veiculo : outro.veiculos) {
            this.veiculos.add(veiculo.clone());
        }
    }

    // Métodos de instância
    public boolean existeVeiculo(String cod) {
        return this.veiculos.stream()
                            .anyMatch(veiculo -> veiculo.getCodigo().equals(cod));
    }

    public int quantos() {
        return (int) this.veiculos.stream().count();
    }

    public int quantos(String marca) {
        return (int) this.veiculos.stream()
                                  .filter(veiculo -> veiculo.getMarca().equals(marca))
                                  .count();
    }

    public Veiculo getVeiculo(String cod) {
        ArrayList<Veiculo> stand = this.veiculos.stream()
                                  .filter(v -> v.getCodigo().equals(cod))
                                  .collect(Collectors.toCollection(ArrayList::new));
        return stand.get(0).clone();
    }

    public void adiciona(Veiculo v) {
        this.veiculos.add(v);
    }

    public void adiciona(Set<Veiculo> vs) {
        for (Veiculo v : vs)
            this.veiculos.add(v.clone());
    }

    public void classificarVeiculo(String cod, int classificacao) {
        this.veiculos.stream().filter(v -> v.getCodigo().equals(cod))
                              .forEach(v -> v.addRating(classificacao));
    }

    public void registarAluguer(String codVeiculo, int numKms) {
        this.veiculos.stream().filter(v -> v.getCodigo().equals(codVeiculo))
                              .forEach(v -> v.addKilometros(numKms));
    }

    public double custoRealKm(String cod) {
        double custoReal = this.veiculos.stream().filter(v -> v.getCodigo().equals(cod))
                                                 .mapToDouble(v -> v.getPrecoKilometro())
                                                 .sum();
        custoReal *= 1.1;
        return custoReal;
    }

    public String toString() {
        return this.veiculos.toString();
    }

    // Getters
    public List<Veiculo> getVeiculos() {
        return this.veiculos.stream().collect(Collectors.toList());
    }

    // Setters
    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos.stream().collect(Collectors.toList());
    }
}
