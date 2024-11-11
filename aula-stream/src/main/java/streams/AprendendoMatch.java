package streams;

import java.util.stream.Stream;

public class AprendendoMatch {
	public static void main(String[] args) {
		Double[] notas = {5.5, 7.5, 3.3, 7.2};
		
		/*Tirar do comentário para testar todos os métodos.*/
		//boolean aprovado_aprovada = Stream.of(notas).noneMatch(nota -> nota >=7);
		//boolean aprovado_aprovada = Stream.of(notas).anyMatch(nota -> nota >=7);
		boolean aprovado_aprovada = Stream.of(notas).allMatch(nota -> nota >=7);
		
		/*Para o none, nenhum dos valores pode condizer com nossa condição. Para o any match, caso um dos valores 
		 *  se enquadre na nossa condição, retornará true. Para o allMatch, todas os valores devem condizer com nossa
		 *  condição.*/
		
		Double[] notasAprovadas = {7.2, 8.5, 9.9, 8.};
		boolean todos_aprovados = Stream.of(notasAprovadas).allMatch(nota -> nota >=7);
		
		
		System.out.println("Teve aprovação: " + ((aprovado_aprovada ? "Sim":"Não")));
		
		System.out.println("Verificando allMatch: " + (todos_aprovados ? "Sim": "Não"));
	}
}
