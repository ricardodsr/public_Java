import java.util.Scanner;

public class Ficha2_2 {
    public static void main (String[] args) {
        // Needed to print an array
        ArrayUtils au = new ArrayUtils();

        // Handling inputChars
        Scanner scan = new Scanner(System.in);
        char inputChar = '0';
        int inputInt;

        // Generating a random Turma (size 5x5)
        Turma turmaA = new Turma();
        System.out.println("A random Turma object was genereted (Size 5x5)");

        while (inputChar != 'x') {
            inputChar = scan.next().charAt(0);
            switch (inputChar) {
                case 'a':
                    System.out.println("Current Turma:");
                    System.out.printf("%s", turmaA.toString());
                    System.out.println("setNota is not currently defined");
                    break;
                case 'b':
                    System.out.println("Escolha uma unidade curricular (int [0..4])");
                    inputInt = scan.nextInt();
                    System.out.printf("A soma das notas da disciplina %d é %d\n",
                                      inputInt, turmaA.somaNotasDisciplina(inputInt));
                    break;
                case 'c':
                    System.out.println("Escolha um aluno (int [0..4])");
                    inputInt = scan.nextInt();
                    System.out.printf("A média do aluno %d é %f\n",
                                      inputInt, turmaA.calculaMediaAluno(inputInt));
                    break;
                case 'd':
                    System.out.println("Escolha uma unidade curricular (int [0..4])");
                    inputInt = scan.nextInt();
                    System.out.printf("A média da disciplina %d é %f\n",
                                      inputInt, turmaA.calculaMediaDisciplina(inputInt));
                    break;
                case 'e':
                    System.out.printf("A nota mais alta é: %d\n", turmaA.getNotaMax());
                    break;
                case 'f':
                    System.out.printf("A nota mais baixa é: %d\n", turmaA.getNotaMin());
                    break;
                case 'g':
                    System.out.println("Escolha uma nota, serão imprimidas as notas superiores:");
                    inputInt = scan.nextInt();
                    System.out.printf("%s", au.toString(turmaA.getNotasAcimaDe(inputInt)));
                    break;
                case 'h':
                    System.out.println("Current Turma:");
                    System.out.printf("%s", turmaA.toString());
                    break;
                case 'i':
                    int indMediaMax = turmaA.getDisciplinaMediaMax();
                    System.out.printf("A disciplina com maior média é %d (%f)", 
                                      indMediaMax,
                                      turmaA.calculaMediaDisciplina(indMediaMax));
                    break;
                case 'x':
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid inputChar, if you wanna leave choose 'x'");
                    break;
            }
        }
    }
}
