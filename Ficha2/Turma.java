import java.util.Random;

public class Turma {
    private int[][] notas;
    private int aluno;
    private int disciplina;
    static int maxNota = 20;

    public Turma() {
        Random rand = new Random(System.currentTimeMillis());
        this.notas = new int[5][5];
        this.aluno = 5;
        this.disciplina = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.notas[i][j] = rand.nextInt(maxNota + 1);
            }
        }
    }

    public void setNota() {
        // TODO: Implement this function
    }

    public String toString() {
        String output = new String();
        for (int i = 0; i < aluno; i++) {
            output += "Aluno ";
            output += i;
            output += ": ";
            for (int j = 0; j < disciplina; j++) {
                output += this.notas[i][j];
                if (j + 1 < disciplina) {
                    output += " ";
                }
            }
            output += "\n";
        }
        return output;
    }

    public int somaNotasDisciplina(int disciplina) {
        if (disciplina < 0 || disciplina >= this.disciplina) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < aluno; i++) {
            sum += this.notas[i][disciplina];
        }
        
        return sum;
    }

    public float calculaMediaAluno(int aluno) {
        if (aluno < 0 || aluno >= this.aluno) {
            return -1;
        }

        float media = 0;
        for (int i = 0; i < this.disciplina; i++) {
            media += (float) this.notas[aluno][i];
        }
        media/= this.disciplina;

        return media;
    }

    public float calculaMediaDisciplina(int disciplina) {
        if (disciplina < 0 || disciplina >= this.disciplina) {
            return -1;
        }

        float media = 0;
        for (int i = 0; i < aluno; i++) {
            media += (float) this.notas[i][disciplina];
        }
        media /= this.aluno;

        return media;
    }

    public int getNotaMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < aluno; i++) {
            for (int j = 0; j < disciplina; j++) {
                if (this.notas[i][j] > max) {
                    max = this.notas[i][j];
                }
            }
        }
        return max;
    }

    public int getNotaMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < aluno; i++) {
            for (int j = 0; j < disciplina; j++) {
                if (this.notas[i][j] < min) {
                    min = this.notas[i][j];
                }
            }
        }
        return min;
    }

    public int[] getNotasAcimaDe(int min) {
        int sizeArr = 0;
        for (int i = 0; i < aluno; i++) {
            for (int j = 0; j < disciplina; j++) {
                if (this.notas[i][j] > min) {
                    sizeArr++;
                }
            }
        }

        if (sizeArr == 0) {
            return null;
        }

        int[] arr = new int[sizeArr];
        int pos = 0;
        for (int i = 0; i < aluno; i++) {
            for (int j = 0; j < disciplina; j++) {
                if (this.notas[i][j] > min) {
                    arr[pos] = this.notas[i][j];
                    pos++;
                }
            }
        }
        return arr;
    }

    public int getDisciplinaMediaMax() {
        int indMediaMax = 0;
        float mediaCurrent;
        float mediaMax = this.calculaMediaDisciplina(0);
        for (int i = 0; i < this.disciplina; i++) {
            mediaCurrent = this.calculaMediaDisciplina(i);
            if (mediaCurrent > mediaMax) {
                mediaMax = mediaCurrent;
                indMediaMax = i;
            }
        }
        return indMediaMax;
    }
}
