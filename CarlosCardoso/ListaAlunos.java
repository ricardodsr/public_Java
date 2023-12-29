package CarlosCardoso;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class ListaAlunos {

    private HashMap<String, Aluno> alunos;

    /**
     * Construtor vazio
     */
    public ListaAlunos() {
        alunos = new HashMap<>();
    }

    /**
     * Adiciona um aluno à lista
     *
     * @param aluno aluno a ser adicionado
     */
    public void adicionar(Aluno aluno) {
        alunos.put(aluno.getMatricula(), aluno);
    }

    /**
     * Remove um aluno da lista
     *
     * @param matricula matrícula do aluno a ser removido
     */
    public void remover(String matricula) {
        alunos.remove(matricula);
    }

    /**
     * Obtém um aluno da lista
     *
     * @param matricula matrícula do aluno a ser obtido
     * @return aluno com a matrícula informada
     */
    public Aluno get(String matricula) {
        return alunos.get(matricula);
    }

    /**
     * Verifica se um aluno existe na lista
     *
     * @param matricula matrícula do aluno a ser verificado
     * @return true se o aluno existir, false caso contrário
     */
    public boolean existe(String matricula) {
        return alunos.containsKey(matricula);
    }

    /**
     * Obtém a lista de alunos
     *
     * @return lista de alunos
     */
    public Collection<Aluno> getAlunos() {
        return alunos.values();
    }

    /**
     * Obtém o tamanho da lista
     *
     * @return tamanho da lista
     */
    public int size() {
        return alunos.size();
    }

    /**
     * Limpa a lista
     */
    public void limpar() {
        alunos.clear();
    }

    /**
     * Converte a lista para uma string
     *
     * @return string representando a lista
     */
    @Override
    public String toString() {
        return "ListaAlunos{" +
                "alunos=" + alunos +
                '}';
    }

    /**
     * Este método ordena a lista de alunos por um determinado critério. O critério é especificado por uma instância da interface Comparator.
     * @param comparator
     * 
     */
    public void ordenar(Comparator<Aluno> comparator) {
        List<Aluno> alunosOrdenados = new ArrayList<>(alunos.values());
        alunosOrdenados.sort(comparator);
        alunos = new HashMap<>();
        for (Aluno aluno : alunosOrdenados) {
            alunos.put(aluno.getMatricula(), aluno);
        }

    }
        /**
     * Este método filtra a lista de alunos com base em um determinado critério. O critério é especificado por uma instância da interface Predicate.
     *
     * @param predicate o critério de filtro
     * @return uma nova lista contendo apenas os alunos que atendem ao critério de filtro
     */
    public List<Aluno> filtrar(Predicate<Aluno> predicate) {
        List<Aluno> alunosFiltrados = new ArrayList<>();
        for (Aluno aluno : alunos.values()) {
            if (predicate.test(aluno)) {
                alunosFiltrados.add(aluno);
            }
        }
        return alunosFiltrados;
    }

    /**
     * Este método exporta a lista de alunos para um arquivo. O arquivo deve ser um arquivo binário.
     */
    public void exportar(String arquivo) throws IOException {
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(alunos);
        oos.close();
    }
    
    /**
 * Importar alunos
 */
public void importar(String arquivo) throws IOException, ClassNotFoundException {
    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(arquivo));
         ObjectInputStream ois = new ObjectInputStream(bis)) {
        alunos = (HashMap<String, Aluno>) ois.readObject();
    }
}
}
