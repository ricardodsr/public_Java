import java.util.ArrayList;
import java.util.Iterator;

public class EncEficiente {
    String nome;
    int nif;
    String adress;
    String numero;
    String data;
    int exemplo;
    ArrayList<LinhaEncomenda> encomendas;

    public EncEficiente() {
        this.nome = "Joao";
        this.nif = 284201213;
        this.adress = "Rua da Liberdade";
        this.numero = "A42932";
        this.data = "10/10/1995";
        this.encomendas = new ArrayList<LinhaEncomenda>();
    }

    public EncEficiente(String nome,
                        int nif,
                        String adress,
                        String numero,
                        String data) {
        this.nome = nome;
        this.nif = nif;
        this.adress = adress;
        this.numero = numero;
        this.data = data;
        this.encomendas = new ArrayList<LinhaEncomenda>();
    }

    public EncEficiente(String nome,
                        int nif,
                        String adress,
                        String numero,
                        String data,
                        ArrayList<LinhaEncomenda> encomendas) {
        this.nome = nome;
        this.nif = nif;
        this.adress = adress;
        this.numero = numero;
        this.data = data;
        this.encomendas = encomendas;
    }

    /**
     * Set nome.
     *
     * @param nome the value to set.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Set nif.
     *
     * @param nif the value to set.
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Set adress.
     *
     * @param adress the value to set.
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Set numero.
     *
     * @param numero the value to set.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Set data.
     *
     * @param data the value to set.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Set encomendas.
     *
     * @param encomendas the value to set.
     */
    public void setEncomendas(ArrayList<LinhaEncomenda> encomendas) {
        this.encomendas = encomendas;
    }

    /**
     * Get nome.
     *
     * @return nome as String.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Get nif.
     *
     * @return nif as int.
     */
    public int getNif() {
        return nif;
    }

    /**
     * Get adress.
     *
     * @return adress as String.
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Get numero.
     *
     * @return numero as String.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Get data.
     *
     * @return data as String.
     */
    public String getData() {
        return data;
    }

    /**
     * Get encomendas.
     *
     * @return encomendas as ArrayList<LinhaEncomenda>.
     */
    public ArrayList<LinhaEncomenda> getEncomendas() {
        return encomendas;
    }

    /**
     * Adds a new LinhaEncomenda to the encomendas list.
     *
     * @param  enc  the LinhaEncomenda to be added
     */
    public void addLinhaEncomenda(LinhaEncomenda enc) {
        this.encomendas.add(enc);
    }

    /**
     * Calculates the total value of the order.
     *
     * @return the total value of the order
     */
    public double calculaValorTotal(){
        double precoTotal = 0;
        Iterator<LinhaEncomenda> ite = this.encomendas.iterator();
        while (ite.hasNext()) {
            precoTotal += ite.next().calculaValorLinhaEnc();
        }
        return precoTotal;
    }

    /**
     * Calculates the total discount for the given function.
     *
     * @return the total discount value
     */
    public double calculaDescontoTotal() {
        double descontoTotal = 0;
        Iterator<LinhaEncomenda> ite = this.encomendas.iterator();
        while (ite.hasNext()) {
            descontoTotal += ite.next().calculaValorDesconto();
        }
        return descontoTotal;
    }

    /**
     * Calculates the total number of products in the given collection of orders.
     *
     * @return         	the total number of products
     */
    public int numeroTotalProdutos() {
        int totalProdutos = 0;
        Iterator<LinhaEncomenda> ite = this.encomendas.iterator();
        while (ite.hasNext()) {
            totalProdutos += ite.next().getQuantidade();
        }
        return totalProdutos;
    }

    /**
     * Checks if a given product exists in the order.
     *
     * @param  linha  the product to be checked
     * @return        true if the product exists, false otherwise
     */
    public boolean existeProdutoEncomenda(LinhaEncomenda linha) {
        boolean existence = false;
        Iterator<LinhaEncomenda> ite = this.encomendas.iterator();
        while (ite.hasNext() && !existence) {
            if (ite.next().equals(linha)) {
                existence = true;
            }
        }
        return existence;
    }

    /**
     * Adds a line to the list of orders.
     *
     * @param  linha  the line to be added
     */
    public void adicionaLinha(LinhaEncomenda linha) {
        this.encomendas.add(linha);
    }

    /**
     * Removes a product from the list of orders.
     *
     * @param  codProd  the code of the product to be removed
     */
    public void removeProduto(String codProd) {
        boolean wasRemoved = false;
        Iterator<LinhaEncomenda> ite = this.encomendas.iterator();
        while (ite.hasNext() && !wasRemoved) {
            if (ite.next().getReferencia().equals(codProd)) {
                ite.remove();
                wasRemoved = true;
            }
        }
    }
}
