package Stack;

public class TesteStack {
	
	public static void main(String args[]){
		Stack s1 = new Stack();
		
		String x1 =("um");
		String x2 =("dois");
		String x3 =("tres");
		
		s1.push(x1);
		s1.push(x2);
		s1.push(x3);
		
		System.out.println("Informações da Stack " + s1.getStack());
		System.out.println("Verifica se a Stack está vazia: " + s1.empty());
		System.out.println("Remove o ultimo elemento: " );
		s1.pop();
		System.out.println("Informações da Stack " + s1.getStack());
		
	}

}
