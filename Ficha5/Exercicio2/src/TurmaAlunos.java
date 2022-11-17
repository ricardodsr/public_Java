import java.util.*;
import java.util.stream.Collectors;

public class TurmaAlunos {
    Set<Aluno> alunos;

    // Construtores
    public TurmaAlunos() {
        this.alunos = new HashSet<>();
    }

    public TurmaAlunos(Set<Aluno> alunos) {
        this.alunos = new HashSet<>();
        for (Aluno aluno : alunos)
            this.alunos.add(aluno.clone());
    }

    public TurmaAlunos(TurmaAlunos other) {
        this.alunos = new HashSet<>();
        for (Aluno aluno : alunos)
            this.alunos.add(aluno.clone());
    }

    // Metodos de Instancia
    public void insereAluno(Aluno aluno) {
        this.alunos.add(aluno.clone());
    }

    public Aluno getAluno(String codAluno) {
        Iterator<Aluno> it = this.alunos.iterator();
        Aluno tmp;
        while (it.hasNext()){
            tmp = it.next();
            if (tmp.getCodigo().equals(codAluno)) return tmp.clone();
        }
        return null;
    }

    public void removeAluno(String codAluno) {
        Iterator<Aluno> it = this.alunos.iterator();
        while (it.hasNext()) {
            if (it.next().getCodigo().equals(codAluno))
                it.remove();
        }
    }

    public Set<String> todosOsCodigos() {
        Set<String> ret = new HashSet<>();
        for (Aluno aluno: this.alunos)
            ret.add(aluno.getCodigo());
        return ret;
    }

    public int qtsAlunos() {
        return this.alunos.size();
    }

    public Set<Aluno> alunosOrdemAlfabetica() {
        return this.alunos.stream()
                          .sorted(Comparator.comparing(Aluno::getNome))
                          .map(Aluno::clone)
                          .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Aluno> alunosOrdemDecrescenteNumero() {
        return this.alunos.stream()
                          .sorted(Comparator.comparing(Aluno::getCodigo))
                          .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // Overrides
    @Override
    public String toString() {
        return "TurmaAlunos{" +
                "alunos=" + this.alunos +
                '}';
    }

    // Testing only
    public static void main(String[] args) {
        Aluno a0 = new Aluno("Gilbert", "2841");
        Aluno a1 = new Aluno("Lorenza", "8605");
        Aluno a2 = new Aluno("Clemencia", "7046");
        Aluno a3 = new Aluno("Cecily", "8180");
        Aluno a4 = new Aluno("Lakita", "6358");
        Aluno a5 = new Aluno("Vince", "8733");
        Aluno a6 = new Aluno("Ira", "3523");
        Aluno a7 = new Aluno("Vernita", "9088");
        Aluno a8 = new Aluno("Ernestina", "9815");
        Aluno a9 = new Aluno("Chester", "6177");
        TurmaAlunos teste = new TurmaAlunos();
        teste.insereAluno(a0);
        teste.insereAluno(a1);
        teste.insereAluno(a2);
        teste.insereAluno(a3);
        teste.insereAluno(a4);
        teste.insereAluno(a5);
        teste.insereAluno(a6);
        teste.insereAluno(a7);
        teste.insereAluno(a8);
        teste.insereAluno(a9);

        // Teste toString
        System.out.println(teste);

        // Teste getAluno
        System.out.println("Should print Gilbert: " + teste.getAluno("2841").getNome());

        // Teste removeAluno
        teste.removeAluno("6177");
        teste.removeAluno("9815");
        teste.removeAluno("9088");
        teste.removeAluno("6358");
        System.out.println(teste);

        // Teste todosOsCodigos
        System.out.println(teste.todosOsCodigos());

        // Teste qtsAlunos
        System.out.println("Should print 6: " + teste.qtsAlunos());

        // Teste AlunosOrdemAlfabetica
        System.out.println(teste.alunosOrdemAlfabetica());

        // Teste ordemDecrescenteNumero
        System.out.println(teste.alunosOrdemDecrescenteNumero());
    }
}
