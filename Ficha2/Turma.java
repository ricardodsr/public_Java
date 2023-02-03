import java.util.Random;

public class Turma {
    // two dimensional array to store grades of students for multiple subjects
    private int[][] notas;

    // number of students in the class
    private int aluno;

    // number of subjects in the class
    private int disciplina;

    // static variable to store the maximum grade a student can receive
    static int maxNota = 20;

    // constructor method to initialize the grades of all students for all subjects
    public Turma() {
        // creates a Random object seeded by the current time
        Random rand = new Random(System.currentTimeMillis());

        // initialize the 2D array with 5 rows (students) and 5 columns (subjects)
        this.notas = new int[5][5];
        this.aluno = 5;
        this.disciplina = 5;

        // fill the array with random grades ranging from 0 to 20
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.notas[i][j] = rand.nextInt(maxNota + 1);
            }
        }
    }

    // TODO: method to set a grade for a student in a particular subject
    public void setNota() {
        // TODO: Implement this function
    }

    // overrides the toString method to return a string representation of the grades of all students in the class
    public String toString() {
        String output = new String();
        for (int i = 0; i < aluno; i++) {
            // add the student's number
            output += "Aluno ";
            output += i;
            output += ": ";
            for (int j = 0; j < disciplina; j++) {
                // add the grade of the student in a particular subject
                output += this.notas[i][j];
                // add a space if not the last subject
                if (j + 1 < disciplina) {
                    output += " ";
                }
            }
            // add a newline character
            output += "\n";
        }
        // return the final string
        return output;
    }

    // method to calculate the sum of grades of all students in a particular subject
    public int somaNotasDisciplina(int disciplina) {
        // check if the input subject number is valid
        if (disciplina < 0 || disciplina >= this.disciplina) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < aluno; i++) {
            // add the grade of a student in a particular subject to the sum
            sum += this.notas[i][disciplina];
        }

        // return the final sum
        return sum;
    }

    // method to calculate the average grade of a particular student
    public float calculaMediaAluno(int aluno) {
        // check if the input student number is valid
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
        // Check if the input disciplina is within the range of the number of disciplines 
        if (disciplina < 0 || disciplina >= this.disciplina) {
            // Return -1 if the input is out of range
            return -1;
        }

        // Initialize the variable to store the average grade
        float media = 0;
        // Loop through each student
        for (int i = 0; i < aluno; i++) {
            // Add up the grades of the current student in the current discipline
            media += (float) this.notas[i][disciplina];
        }
        // Calculate the average grade by dividing the total grade by the number of students
        media /= this.aluno;

        // Return the average grade
        return media;
    }

public int getNotaMax() {
        // Initialize the variable to store the maximum grade
        int max = Integer.MIN_VALUE;
        // Loop through each student
        for (int i = 0; i < aluno; i++) {
            // Loop through each discipline
            for (int j = 0; j < disciplina; j++) {
                // Update the maximum grade if the current grade is greater than the current maximum grade
                if (this.notas[i][j] > max) {
                    max = this.notas[i][j];
                }
            }
        }
        // Return the maximum grade
        return max;
    }

public int getNotaMin() {
        // Initialize the variable to store the minimum grade
        int min = Integer.MAX_VALUE;
        // Loop through each student
        for (int i = 0; i < aluno; i++) {
            // Loop through each discipline
            for (int j = 0; j < disciplina; j++) {
                // Update the minimum grade if the current grade is less than the current minimum grade
                if (this.notas[i][j] < min) {
                    min = this.notas[i][j];
                }
            }
        }
        // Return the minimum grade
        return min;
    }

// getNotasAcimaDe method returns an array of integers representing the grades above a specified minimum value.
public int[] getNotasAcimaDe(int min) {
    // sizeArr counts the number of grades above the minimum value.
    int sizeArr = 0;
    // iterate over the students and subjects to count the number of grades above the minimum value.
    for (int i = 0; i < aluno; i++) {
        for (int j = 0; j < disciplina; j++) {
            if (this.notas[i][j] > min) {
                sizeArr++;
            }
        }
    }

    // if there are no grades above the minimum value, return null.
    if (sizeArr == 0) {
        return null;
    }

    // create a new array with size sizeArr to store the grades above the minimum value.
    int[] arr = new int[sizeArr];
    // keep track of the position in the new array where the next grade above the minimum value will be stored.
    int pos = 0;
    // iterate over the students and subjects to store the grades above the minimum value in the new array.
    for (int i = 0; i < aluno; i++) {
        for (int j = 0; j < disciplina; j++) {
            if (this.notas[i][j] > min) {
                arr[pos] = this.notas[i][j];
                pos++;
            }
        }
    }
    // return the array of grades above the minimum value.
    return arr;
}

// getDisciplinaMediaMax method returns the index of the subject with the highest average grade.
public int getDisciplinaMediaMax() {
    // initialize indMediaMax to 0, the index of the first subject.
    int indMediaMax = 0;
    // mediaCurrent stores the average grade for the current subject.
    float mediaCurrent;
    // mediaMax stores the highest average grade found so far.
    float mediaMax = this.calculaMediaDisciplina(0);
    // iterate over all subjects to find the subject with the highest average grade.
    for (int i = 0; i < this.disciplina; i++) {
        // calculate the average grade for the current subject.
        mediaCurrent = this.calculaMediaDisciplina(i);
        // if the average grade for the current subject is higher than the current highest average grade,
        // update mediaMax and indMediaMax.
        if (mediaCurrent > mediaMax) {
            mediaMax = mediaCurrent;
            indMediaMax = i;
        }
    }
    // return the index of the subject with the highest average grade.
    return indMediaMax;
}
}
