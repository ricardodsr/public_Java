import java.util.ArrayList;

public class Ficha4_2 {
    public static void main (String[] args) {
        // "ref", "desc", prec, quant, imposto, desconto
        LinhaEncomenda enc0 = new LinhaEncomenda("24", "7", 2, 1, 0.23, 0.24);
        LinhaEncomenda enc1 = new LinhaEncomenda("17", "0", 4, 3, 0.23, 0.22);
        LinhaEncomenda enc2 = new LinhaEncomenda("8", "1", 7, 3, 0.31, 0.15);
        LinhaEncomenda enc3 = new LinhaEncomenda("46", "5", 14, 11, 0.36, 0.16);
        LinhaEncomenda enc4 = new LinhaEncomenda("5", "10", 1, 3, 0.23, 0.24);

        ArrayList<LinhaEncomenda> test = new ArrayList<>();

        test.add(enc1);
        test.add(enc2);
        test.add(enc3);
        test.add(enc4);

        EncEficiente shipment = new EncEficiente("joao", 19, "n/a", "b21", "hoje", test);

        // Teste valorTotal
        double valorTotal = shipment.calculaValorTotal();
        System.out.printf("Preço final: %f\n", valorTotal);

        // Teste descontoTotal
        double descontoTotal = shipment.calculaDescontoTotal();
        System.out.printf("Desconto final: %f\n", descontoTotal);

        // Teste totalProdutos
        int totalProdutos = shipment.numeroTotalProdutos();
        System.out.printf("Número total de produtos: %d\n", totalProdutos);

        // Teste existeProduto
        LinhaEncomenda enc5 = new LinhaEncomenda(enc4);
        System.out.printf("should print true: %b\n", shipment.existeProdutoEncomenda(enc5));
        System.out.printf("should print false: %b\n", shipment.existeProdutoEncomenda(enc0));

        // Teste adicionaLinha
        shipment.adicionaLinha(enc0);
        System.out.printf("should print true: %b\n", shipment.existeProdutoEncomenda(enc0));

        // Teste removeProduto
        shipment.removeProduto("17");
        System.out.printf("should print false: %b", shipment.existeProdutoEncomenda(enc1));

        // Clear console (for blueJ)
        System.out.printf("\n\n\n");
    }
}
