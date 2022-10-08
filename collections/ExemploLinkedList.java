import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/*
	LinkedList pode ser usado para implementar uma fila.
*/

public class ExemploLinkedList {

	public static void main(String[] args) {

		Queue<String> filaBanco = new LinkedList<>();

		filaBanco.add("Zenaide");
		filaBanco.add("Roberto");
		filaBanco.add("Alanis");
		filaBanco.add("Antonio");
		filaBanco.add("Pedro");
		filaBanco.add("Paulo");

		// peek: retorna próximo da fila sem removê-lo
		String primeiroCliente = filaBanco.peek();
		System.out.println("\nPrimeiro cliente: " + primeiroCliente);
		System.out.println(filaBanco);

		// poll: retorna e remove o próximo da fila
		String proximoCliente = filaBanco.poll();
		System.out.println("\nAtendimento: " + proximoCliente);
		System.out.println(filaBanco);

		String proximoClienteOuErro = filaBanco.element();
		System.out.println("\nQuem é o próximo: " + proximoClienteOuErro);
		System.out.println(filaBanco);

		System.out.println("\nFor Each:");

		for (String cliente : filaBanco)
			System.out.println(cliente);

		Iterator<String> iteratorFilaBanco = filaBanco.iterator();

		System.out.println("\nIterator:");

		while (iteratorFilaBanco.hasNext()) {
			String cliente = iteratorFilaBanco.next();
			System.out.println(cliente);
		}


		System.out.println("\nFila com " + filaBanco.size() + " clientes");
		System.out.println("Fila está vazia? " + filaBanco.isEmpty());

		filaBanco.clear();	// zera a fila


		try {
			proximoClienteOuErro = filaBanco.element();
			System.out.println(proximoClienteOuErro);
				
		} catch (NoSuchElementException e) {
			System.out.println();
			System.out.println("*".repeat(41));
			System.out.println("MÉTODO ELEMENT EM FILA VAZIA GERA EXCEÇÃO");
			System.out.println("*".repeat(41));
		}
		
	}

}