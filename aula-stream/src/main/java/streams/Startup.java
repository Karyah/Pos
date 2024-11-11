package streams;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Startup {
	public static void main(String[] args) {
		List<String> estudantes = Arrays.asList("Gustavo","Luciano", "Ana Luisa", "Isabela");
		
		System.out.println("Usando For Each");		
		for (String nome : estudantes) {
			System.out.println("Estudante: "+nome);
		}
		
		System.out.println("\nUsando Iterator");
		
		Iterator<String> iterator = estudantes.iterator();
		while(iterator.hasNext()) {
			System.out.println("Estudante: "+ iterator.next());
		}
		
		System.out.println("\nUsando Stream");
		
		Stream<String> stream = estudantes.stream();
		stream.forEach( System.out::println );
	}
}
