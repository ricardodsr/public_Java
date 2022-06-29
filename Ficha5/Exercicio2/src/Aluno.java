public class Aluno {
    private String nome;
    private String codigo;

    public Aluno() {
        this.nome = "invalid";
        this.codigo = "invalid";
    }

    public Aluno(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public Aluno(Aluno outro) {
        this.nome = outro.nome;
        this.codigo = outro.codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(String nome) {
        this.nome = nome;
    }

    public Aluno clone() {
        return new Aluno(this);
    }

    public String toString() {
        String ret = "Nome: " + this.nome + ", Numero: " + this.codigo + "\n";
        return ret;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Aluno a = (Aluno) o;
        return this.codigo.equals(a.getCodigo()) && this.codigo.equals(a.getNome());
    }

    public int compareTo(Aluno aluno) {
        return this.nome.compareTo(aluno.nome);
    }
}
