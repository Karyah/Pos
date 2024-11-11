package streams;

import java.util.stream.Stream;

public class AprendendoMinMax {
	public static void main(String[] args) {
		Double[] notas = {5.5, 7.5, 3.3, 7.2};
		
		Double max = Stream.of(notas).max((nota1, nota2)-> {
			if (nota1 < nota2) return -1;
			if (nota1 > nota2) return 1;
			return 0;				
		}).get();
		
		System.out.println("Maior nota: "+max);
		
		
		
		Double min = Stream.of(notas).min((nota1, nota2)-> {
			if (nota1 < nota2) return -1;
			if (nota1 > nota2) return 1;
			return 0;				
		}).get();
		
		System.out.println("Menor nota: "+min);
	}
}
