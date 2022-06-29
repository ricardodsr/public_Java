import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DriveItTesting {
    public static void main (String[] args) {
        DriveIt test = new DriveIt();

        Veiculo v1 = new Veiculo       ("49129", "volvo");
        Veiculo v2 = new Veiculo       ("20024", "volvo", 7000, 0.15);
        Veiculo v3 = new VeiculoOcasiao("89696", "seat", false);
        Veiculo v4 = new Veiculo       ("98922", "ferrari");
        Veiculo v5 = new VeiculoOcasiao("61304", "volvo", false);
        Veiculo v6 = new Veiculo       ("29746", "seat", 2000, 0.20);
        Veiculo v7 = new Veiculo       ("49219", "volvo");
        Veiculo v8 = new Veiculo       ("27722", "volvo");
        Veiculo v9 = new VeiculoOcasiao("14034", "seat", false);

        Set<Veiculo> encomenda = Stream.of(v1, v2, v3, v4, v5, v6, v7, v8, v9)
                                       .collect(Collectors.toSet());
        test.adiciona(encomenda);

        test.classificarVeiculo("14034", 7);
        test.classificarVeiculo("14034", 6);
        test.classificarVeiculo("49129", 2);

        test.registarAluguer("49129", 500);

        System.out.println(test);

        // Teste custoRealKm (Fase 1)
        System.out.printf("(Expected: 0.20) Custo por km do veiculo 29746: %.2f\n", v6.getPreco_kilometro());
        System.out.printf("(Expected: 0.22) Custo por km do veiculo 29746 ajustado: %.2f\n", test.custoRealKm(v6.getCodigo()));

        // Teste custoRealKm (Fase2)
        Veiculo v10 = new VeiculoOcasiao("aaaaa", "spiiiid", 1, 10, false);
        test.adiciona(v10);
        System.out.printf("(Expected: 10) Custo por km do veiculo aaaaa: %.2f\n", v10.getPreco_kilometro());
        System.out.printf("(Expected: 11) Custo por km do veiculo aaaaa ajustado (sem desconto): %.2f\n", test.custoRealKm(v10.getCodigo()));
        test.registaPromocao("aaaaa", true);
        System.out.printf("(Expected: 8.25) Custo por km do veiculo aaaaa ajustado (com desconto): %.2f\n", test.custoRealKm(v10.getCodigo()));


        // Fase3
        Veiculo v11 = new VeiculoPremium("bb", "volvo", 96500, 3, 25);
        test.adiciona(v11);

        // Teste quantosT
        System.out.println("(Expected: 4) Numero VeiculoOcasiao: " + test.quantosT("VO"));
        System.out.println("(Expected: 6) Numero Veiculo: " + test.quantosT("V"));
        System.out.println("(Expected: 1) Numero VeiculoPremium: " + test.quantosT("VP"));

        test = null;
        System.out.println("DriveIt deleted");
        test = new DriveIt();
        test.adiciona(new Veiculo("aa", "seat", 171000, 0.36));
        test.adiciona(new Veiculo("bb", "fiat", 150000, 0.36));
        test.adiciona(new Veiculo("cc", "fiat", 274000, 0.47));
        test.adiciona(new Veiculo("dd", "volvo", 95000, 0.40));
        test.adiciona(new Veiculo("ee", "volvo", 850500, 0.37));

        System.out.println(test.veiculosOrdenadosCusto());
        System.out.println("Veiculo mais barato: " + test.veiculoMaisBarato());
        System.out.println("Veiculo menos utilizado: " + test.veiculoMenosUtilizado());
    }
}
