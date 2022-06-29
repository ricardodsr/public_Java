import java.util.*;

public class DriveItTesting {
    public static void main (String[] args) {
        DriveIt test = new DriveIt();
        Veiculo v1 = new Veiculo("49129", "volvo");
        Veiculo v3 = new Veiculo("89696", "seat");
        Veiculo v2 = new Veiculo("20024", "volvo", 7000, 0.15);
        Veiculo v4 = new Veiculo("98922", "ferrari");
        Veiculo v5 = new Veiculo("61304", "volvo");
        Veiculo v6 = new Veiculo("29746", "seat", 2000, 0.20);
        Veiculo v7 = new Veiculo("49219", "volvo");
        Veiculo v8 = new Veiculo("27722", "volvo");
        Veiculo v9 = new Veiculo("14034", "seat");

        test.adiciona(v1);
        test.adiciona(v2);
        test.adiciona(v3);
        test.adiciona(v4);

        Set<Veiculo> encomenda = new HashSet<Veiculo>();
        encomenda.add(v5);
        encomenda.add(v6);
        encomenda.add(v7);
        encomenda.add(v8);
        encomenda.add(v9);

        // Teste adiciona(Veiculo v + toString())
        System.out.printf("%s\n", test.toString());

        // Teste quantos()
        System.out.printf("(Expected: 4) Carros no DriveIt: %d\n", test.quantos());

        // Teste quantos(String marca)
        System.out.printf("(Expected: 2) Carros da volvo: %d\n", test.quantos("volvo"));

        // Teste getVeiculos()
        System.out.printf("%s\n", test.getVeiculos().toString());

        // Teste adiciona(Set<Veiculo>) + classificarVeiculo()
        //                              + registarAluguer()
        test.adiciona(encomenda);
        test.classificarVeiculo("14034", 7);
        test.classificarVeiculo("14034", 6);
        test.classificarVeiculo("49129", 2);
        test.registarAluguer("49129", 500);
        System.out.printf("%s\n", test.toString());

        // Teste custoRealKm
        System.out.printf("(Expected: 0.20) Custo por km do veiculo 29746: %.2f\n", v6.getPrecoKilometro());
        System.out.printf("Custo por km do veiculo 29746 ajustado: %.2f\n", test.custoRealKm(v6.getCodigo()));
    }
}
