

public class Ficha3_1 {
    /**
     * The main function is the entry point of the Java program.
     *
     * @param  args    an array of Strings representing command line arguments
     * @return         void
     */
    public static void main (String[] args) {
        Circulo cir2 = new Circulo(2, 3, 5);
        
        System.out.printf("%s", cir2.toString());
        cir2.alteraCentro(0, 0);
        System.out.printf("%s", cir2.toString());
        System.out.println("O perimetro é: " + cir2.calculaPerimetro());
        System.out.println("A área é: " + cir2.calculaArea());
    }
}
