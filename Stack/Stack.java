package Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	
	private List<String> stack	= new ArrayList<String>();
	
	public Stack(){
		this.stack = new ArrayList<>();
	}
	
	public Stack(String s){
		this.stack.add(s);
	}
	
	public Stack(Stack s){
		this.stack = s.getStack();
	}

	public List<String> getStack() {
		List<String> aux = new ArrayList<String>();
		for(String x:stack){
			aux.add(x);
		}
		return aux;
	}

	public void setStack(List<String> stack) {
		List<String> aux = new ArrayList<String>();
		for(String x : stack) aux.add(x);
		this.stack = aux;
	}
	
	//METODOS
	
	//String top(): que determina o elemento no topo da stack;
	
	public String top(){
		int aux = this.stack.size();
		if(this.stack!= null)
		return this.stack.get(aux-1);
		else return "";
	}
	
	//void push(String s): insere no topo;
	
	public void push(String s){
		this.stack.add(s);
	}
	
	//void pop(): remove o elemento do topo da stack, se esta não estiver vazia;
	
	public void pop(){
		int aux = this.stack.size();
		if(this.stack!=null) this.stack.remove(aux-1);
	}
	
	//boolean empty(): determina se a stack está vazia;
	
	public boolean empty(){
		boolean resultado = false;
		if(this.stack.size()==0) resultado = true;
		return resultado;
	}
	
	//int length(): determina o comprimento da stack;
	
	public int length(){
		return this.stack.size();
	}
	
	
	//Clone
	
	public Stack clone(){
		return new Stack(this);
	}
	
	//equals
	
	public boolean equals(Object o) {
    	if (this == o) return true;
    	if ((o==null)||(this.getClass() != o.getClass()))
    		return false;
    	else{ Stack s = (Stack) o;
    		  Boolean eq = true;
    		  if(s.stack.size() != this.stack.size()) return false;
    		  else{ for(int i = 0 ; i< s.stack.size(); i++)
    			  if(s.stack.get(i).equals(this.stack.get(i))) eq = false;
    		  		return eq;
    		  }
    	}
	}
	
	//toString
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(this.getStack() + ";\n");
		return s.toString();
	}
}
