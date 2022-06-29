public class Ficha1 {
    public double celsiusParaFarenheit(double graus){
        double faren;
        faren = graus*1.8 + 32;
        return faren;
    }
    public int maximoNumeros(int a, int b) {
        int max = a;
        if (b > a) {
            max = b;
        }
        return max;
    }
    public String criaDescricaoConta(String nome, double saldo) {
        String desc;
        desc = "Nome: " + nome + "\nSaldo: " + saldo + "€\n";
        return desc;
    }
    public double eurosParaLibras(double valor, double taxaConversao) {
        double libras = valor*taxaConversao;
        return 0;
    }
    public long factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial (num -1);
        }
    }
    public long tempoGasto() {
        long start = System.currentTimeMillis();
        factorial(5000);
        long end = System.currentTimeMillis();
        return (end - start);
    }
}
