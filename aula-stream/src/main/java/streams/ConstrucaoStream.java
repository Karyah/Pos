package streams;

import java.util.stream.Stream;

public class ConstrucaoStream {
	public static void main(String[] args) {
		System.out.println("Passando valores\n");
		Stream<Number> notas = Stream.of(1,8.2,5,9,5);
		notas.forEach(System.out::println);
		
		
		System.out.println("Criando a partir de uma lista existente\n");
		Number[] maisNotas = { 7, 6, 9.2, 3, 7, 5 };
		Stream.of(maisNotas).forEach(System.out::println);;
		
		System.out.println("Usando parallel:");
		Stream.of(maisNotas).parallel().forEach(System.out::println);
	}
}
