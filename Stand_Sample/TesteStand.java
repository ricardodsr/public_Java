package Stand;


/**
 * Classe de teste das classes Stand e Veículo.
 * 
 * Neste exercício faça:
 * 
 * 1a) forneça o código necessário (nas classes Stand e TesteStand) para que 
 *    código funcione correctamente
 * 1b) compile, execute e coloque mais testes no método main
 * 
 * 2) Crie, no método main, um sistema de menus, por forma a que seja
 *    o utilizador a inserir os dados que pretende testar.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TesteStand {

  public static void main(String[] args) {
    Veiculo v1, v2, v3, v4, v5;
    Veiculo d1, d2, d3, d4, d5;
    Stand veiculos_utilitarios;
    Stand veiculos_desportivos;
    
    //chamar os construtores (completar!)
    v1 = new Veiculo("01-01-AA",80, 30,  2, 8.2, 50000);
    v2 = new Veiculo("05-05-ZZ",67,35,  6,4.2,8502);
    v3 = new Veiculo("06-06-BB",70, 50, 20, 6.7, 15245);
    v4 = new Veiculo("06-06-CC",70, 42, 15, 6, 25000);
    v5 = new Veiculo("06-08-FF",105, 89, 100, 9, 1524598);
    
    d1 = new Veiculo("01-01-RR",75, 43, 13, 6.3, 89855);
    d2 = new Veiculo("10-08-CG",65, 54, 16, 4.2, 23446);
    d3 = new Veiculo("14-14-BH",80, 67, 40, 10.6, 11234);
    d4 = new Veiculo("16-16-TG",90, 56, 23, 15.9, 150000);
    d5 = new Veiculo("18-67-BA",85, 32, 12, 20.1, 10972);
    
    veiculos_utilitarios = new Stand("Garagem Veiculos Baratos", 10);
    
    veiculos_utilitarios.insereVeiculo(v1);
    veiculos_utilitarios.insereVeiculo(v2);
    veiculos_utilitarios.insereVeiculo(v3);
    veiculos_utilitarios.insereVeiculo(v4);
    veiculos_utilitarios.insereVeiculo(v5);
    
    veiculos_desportivos = new Stand("Garagem Auto Luxo", 10);
    
    veiculos_desportivos.insereVeiculo(d1);
    veiculos_desportivos.insereVeiculo(d2);
    veiculos_desportivos.insereVeiculo(d3);
    veiculos_desportivos.insereVeiculo(d4);
    veiculos_desportivos.insereVeiculo(d5);

    
    System.out.println("Informações do Stand " + veiculos_utilitarios.getNomeStand());
    System.out.println("--------------------------");
    System.out.println("Número de veículos: " + veiculos_utilitarios.getNveiculos());
    System.out.println("Veículos: ");
    System.out.println(veiculos_utilitarios.toString());
    
    System.out.println("Informações do Stand " + veiculos_desportivos.getNomeStand());
    System.out.println("--------------------------");
    System.out.println("Número de veículos: " + veiculos_desportivos.getNveiculos());
    System.out.println("Veículos: ");
    System.out.println(veiculos_desportivos.toString());

    
    //o v1 está no stand?
    
    System.out.println("v1 está no stand? " + veiculos_utilitarios.existeVeiculo(v1));
    
    System.out.print("Veículo com mais kms: ");
    Veiculo vx = veiculos_utilitarios.veiculoComMaisKms();
    System.out.println(vx.toString());
    
    
    //....
    // mais operações
      
    
    
  }    
    
    
}
