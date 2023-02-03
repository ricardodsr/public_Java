// Ficha1 class contains several methods to perform different operations
public class Ficha1 {
  
    // Converts temperature in Celsius to Fahrenheit
    public double celsiusParaFarenheit(double graus){
        double faren;
        // Fahrenheit = Celsius * 1.8 + 32
        faren = graus*1.8 + 32;
        return faren;
    }
    
    // Returns the maximum of two numbers
    public int maximoNumeros(int a, int b) {
        int max = a;
        // If b is greater than a, max is b
        if (b > a) {
            max = b;
        }
        return max;
    }
    
    // Creates a description for an account based on name and balance
    public String criaDescricaoConta(String nome, double saldo) {
        String desc;
        // Concatenates name and balance in a string
        desc = "Nome: " + nome + "\nSaldo: " + saldo + "€\n";
        return desc;
    }
    
    // Converts Euros to Pounds
    public double eurosParaLibras(double valor, double taxaConversao) {
        double libras = valor*taxaConversao;
        return 0;
    }
    
    // Returns the factorial of a given number
    public long factorial(int num) {
        // Factorial of 0 is 1
        if (num == 0) {
            return 1;
        } else {
            // Recursively calculates the factorial of a number
            return num * factorial (num -1);
        }
    }
    
    // Returns the time taken to calculate the factorial of 5000
    public long tempoGasto() {
        // Start time
        long start = System.currentTimeMillis();
        // Calculates the factorial of 5000
        factorial(5000);
        // End time
        long end = System.currentTimeMillis();
        // Returns the difference between end time and start time
        return (end - start);
    }
}
