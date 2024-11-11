package streams;

import java.util.stream.Stream;

public class AprendendoReduce {
	public static void main(String[] args) {
		/*Carrinho de compras: mostrar valor total de carrinho, somando elementos*/
		Double[] notas = {5.5, 7.5, 3.3, 7.2};
		
		boolean aprovado_aprovada = Stream.of(notas).reduce((acumulador, nota) -> acumulador + nota)
				.map(somaDasNotas -> somaDasNotas/4)
				.filter(nota -> nota >= 5).isPresent();
		
		System.out.println("Você foi aprovado: " + (aprovado_aprovada ? "Sim" : "Não"  ));
		
		
	}
}
	