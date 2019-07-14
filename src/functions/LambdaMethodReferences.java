package functions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaMethodReferences {
    public static void main(String[] args) {

        List<String> palavras = new ArrayList<String>();
        palavras.add("Teste");
        palavras.add("Teste1");
        palavras.add("Teste2");

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("Comparando usando lambda: " + palavras);

        palavras.sort(Comparator.comparing(s -> s.length()));
        System.out.println("Comparando usando comparator: " + palavras);

        palavras.sort(Comparator.comparing(String::length));
        System.out.println("Comparando usando method references: " + palavras);

        Function<String, Integer> func = String::length;
        System.out.println("Comparando usando function: " + palavras);

        //Exemplos de method reference
        Consumer<Integer> sout = System.out::println;
        numeros.forEach(sout);

        //Com Lambda
        Function<Usuario, String> lambda = u -> u.getNome();

        //Com Reference
        Function<Usuario, String> reference = Usuario::getNome;

        /*Nova maneira de percorrer
        Lambda*/
        palavras.forEach(s -> System.out.println("Percorrendo usando Lambda - " + s));

        //Outra maneira de comparação
        palavras.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Comparando case sensitive: - " + palavras);

        /* Antes
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executando um Runnable sem Lambda");
            }
        }).start();
        */

        //Depois - Lambda
        new Thread(() -> System.out.println("Executando um Runnable usando Lambda")).start();
    }
}
