public class LinhaEncomenda {
    private String ref;
    private String desc;
    private double preco;
    private int quantidade;
    private double tax; // do tipo 0.13 (= 13% imposto)
    private double discount; // same as tax

    public LinhaEncomenda() {
        this.ref = "?";
        this.desc = "?";
        this.preco = 0;
        this.quantidade = 0;
        this.tax = 0;
        this.discount = 0;
    }
    
    public LinhaEncomenda(String ref, String desc) {
        this.ref = ref;
        this.desc = desc;
        this.preco = 0;
        this.quantidade = 0;
        this.tax = 0;
        this.discount = 0;
    }

    public LinhaEncomenda(LinhaEncomenda outra) {
        this.ref = outra.getRef();
        this.desc = outra.getDesc();
        this.preco = outra.getPreco();
        this.quantidade = outra.getQuantidade();
        this.tax = outra.getTax();
        this.discount = outra.getDiscount();
    }

    // Metodooos
    public double calculaValorLinhaEnc() {
        double valor;
        valor = this.quantidade * this.preco;  // Valor sem impostos
        valor = valor + valor * this.tax;      // Valor apos imposto
        valor = valor - valor * this.discount; // Valor apos desconto
        return valor;
    }

    public double calculaValorDesconto() {
        double valor;
        valor = this.quantidade * this.preco; // Valor sem impostos
        valor = valor + valor * this.tax;     // Valor apos imposto
        valor = valor - this.calculaValorLinhaEnc();
        return valor;
    }

    // Getters + Setters

    /**
     * Get ref.
     *
     * @return ref as String.
     */
    public String getRef() {
        return ref;
    }

    /**
     * Set ref.
     *
     * @param ref the value to set.
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * Get desc.
     *
     * @return desc as String.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Set desc.
     *
     * @param desc the value to set.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Get preco.
     *
     * @return preco as double.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Set preco.
     *
     * @param preco the value to set.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Get quantidade.
     *
     * @return quantidade as int.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Set quantidade.
     *
     * @param quantidade the value to set.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Get tax.
     *
     * @return tax as double.
     */
    public double getTax() {
        return tax;
    }

    /**
     * Set tax.
     *
     * @param tax the value to set.
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * Get discount.
     *
     * @return discount as double.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Set discount.
     *
     * @param discount the value to set.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
