import kotlin.jvm.internal.Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class News {
    public static void main(String[] args) {

        List<String> palavras = new ArrayList<String>();
        palavras.add("Teste");
        palavras.add("Teste1");
        palavras.add("Teste2");

        /*Default Metodos
        Lambda (Convertido para uma interface funcional)
        Maneiras diferentes de usar lambda */
        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length));
        Function<String, Integer> func = String::length;

        System.out.println(palavras);

        //Exemplos de method reference
        Consumer<String> sout = System.out::println;
        palavras.forEach(sout);

        /*Com Lambda
        Function<Usuario, String> funcao = u -> u.getNome();
        Com Reference
        Function<Usuario, String> funcao = Usuario::getNome; */

        /*Nova maneira de percorrer
        Lambda*/
        palavras.forEach(s -> System.out.println(s));

        /* Outra maneira de comparação
        palavras.sort(String.CASE_INSENSITIVE_ORDER);*/
        
        //Convertendo para Lambda
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Executando um Runnable");
            }

        }).start();
        //Lambda
        new Thread(() -> System.out.println("Executando um Runnable")).start();
    }
}
