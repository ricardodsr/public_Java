public class Circulo {
    // Variaveis de instancia
    private double x;
    private double y;
    private double raio;

    // Construtores
    // Construtor por omissão
    public Circulo() {
        this.x = 0;
        this.y = 0;
        this.raio = 5;
    }

    // Construtor parametrizado
    public Circulo(double x, double y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    // Construtor cópia
    public Circulo(Circulo outro) {
        this.x = outro.getX();
        this.y = outro.getY();
        this.raio = outro.getRaio();
    }

    // Metodos exercios
    public void alteraCentro(double a, double b) {
        this.setX(a);
        this.setY(b);
    }
    
    public double calculaArea() {
        double area = this.raio * this.raio * Math.PI;
        return area;
    }

    public double calculaPerimetro() {
        double perimetro = 2 * Math.PI * this.raio;
        return perimetro;
    }

    // Metodos default
    public double getX() {
        return this.x;
    }
    
    public void setX(double num) {
        this.x = num;
    }

    public boolean equals(Circulo outro) {
        return (this.x == outro.getX() &&
                this.y == outro.getY() &&
                this.raio == outro.getRaio());
    }

    public String toString() {
        String output;
        output = "x: " + this.x + "\n"
               + "y: " + this.y + "\n"
               + "raio: " + this.raio + "\n";
        return output;
    }

    public Circulo clone() {
        return (new Circulo(this));
    }

    /**
     * Get y.
     *
     * @return y as double.
     */
    public double getY() {
        return this.y;
    }

    /**
     * Set y.
     *
     * @param y the value to set.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Get raio.
     *
     * @return raio as double.
     */
    public double getRaio() {
        return this.raio;
    }

    /**
     * Set raio.
     *
     * @param raio the value to set.
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }
}
