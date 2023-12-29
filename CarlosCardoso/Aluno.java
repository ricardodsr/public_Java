/**
 * 
This class definition represents a student. Here's a summary of what each class method does:

Aluno(): Empty constructor.
Aluno(int id, String nome, String matricula, String curso, int ano): Constructor that initializes all attributes.
Aluno(Aluno al): Copy constructor that creates a new instance of Aluno by copying the attributes of another Aluno object.
getId(): Returns the student's id.
setId(int id): Sets the student's id.
getNome(): Returns the student's name.
setNome(String nome): Sets the student's name.
getMatricula(): Returns the student's enrollment number.
setMatricula(String matricula): Sets the student's enrollment number.
getCurso(): Returns the student's course.
setCurso(String curso): Sets the student's course.
getAno(): Returns the student's year.
setAno(int ano): Sets the student's year.
clone(): Creates and returns a clone of the student object.
equals(Object obj): Checks if the student object is equal to another object.
toString(): Returns a string representation of the student object.
*/

package CarlosCardoso;

// Estas são as variaveis de classe, ou seja, todas as informações que o teu "Aluno ira conter"
 
public class Aluno {

    private int id; // Int = Numero inteiro
    private String nome; //String é uma lista de caracteres (texto)
    private String matricula; //String é uma lista de caracteres (texto)
    private String curso; //String é uma lista de caracteres (texto)
    private int ano; // Int = Numero inteiro

    /**
     * Construtor vazio
     * Cria o objecto aluno vazio
     */
    public Aluno() {
    }

    /**
     * Construtor com todos os atributos
     * Cria o aluno com os valores padrao de inicialização
     *
     * @param id        identificador do aluno
     * @param nome      nome do aluno
     * @param matricula matrícula do aluno
     * @param curso     curso do aluno
     * @param ano       ano do aluno
     */
    public Aluno(int id, String nome, String matricula, String curso, int ano) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.ano = ano;
    }

    /**
     * Contructor por copia
     * @param al   object al
     * @return
     */
    public Aluno (Aluno al){
        this.id = al.getId();
        this.nome = al.getNome();
        this.matricula = al.getMatricula();
        this.curso = al.getCurso();
        this.ano = al.getAno();
    }

    /**
     * Obtém o identificador do aluno
     *
     * @return identificador do aluno
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do aluno
     *
     * @param id identificador do aluno
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do aluno
     *
     * @return nome do aluno
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno
     *
     * @param nome nome do aluno
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a matrícula do aluno
     *
     * @return matrícula do aluno
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Define a matrícula do aluno
     *
     * @param matricula matrícula do aluno
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtém o curso do aluno
     *
     * @return curso do aluno
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Define o curso do aluno
     *
     * @param curso curso do aluno
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Obtém o ano do aluno
     *
     * @return ano do aluno
     */
    public int getAno() {
        return ano;
    }

    /**
     * Define o ano do aluno
     *
     * @param ano ano do aluno
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Clona o aluno
     *
     * @return clone do aluno
     */
    public Aluno clone() {
        try {
            return (Aluno) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Verifica se o objeto é igual a outro
     *
     * @param obj objeto a comparar
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Aluno) {
            Aluno aluno = (Aluno) obj;
            return id == aluno.id && nome.equals(aluno.nome) && matricula.equals(aluno.matricula) && curso.equals(aluno.curso) && ano == aluno.ano;
        }
        return false;
    }
    /**
     * toString
     */
    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", curso='" + curso + '\'' +
                ", ano=" + ano +
                '}';
    }
}