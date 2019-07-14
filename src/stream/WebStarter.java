package stream;

import stream.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WebStarter {

    public static void main(String[] args) {

        List<Stream> dados = new ArrayList<Stream>();
        dados.add(new Stream("Dado1", 1));
        dados.add(new Stream("Dado2", 2));
        dados.add(new Stream("Dado3", 3));

        //Method References
        dados.sort(Comparator.comparing(Stream::getId));

        //Stream - Filter
        dados.stream().
                //Filtrando os id maior ou igual a 2
                        filter(d -> d.getId() >= 2).
                //Transformamos stream no tipo do ID
                        map(d -> d.getId()).
                //Utilizando references
                        forEach(System.out::println);

        //For utilizando Lambda
        dados.forEach(d -> System.out.println("Imprimindo utilizando Lambda - " + d.getNome()));

            /* Declaramos um inteiro
               Pegamos todos os dados
               Filtramos os maiores que 1
               Transformamos Stream em Int
               E é feito a soma
             */
        int sum = dados.stream().
                filter(d -> d.getId() > 1).
                mapToInt(Stream::getId).
                sum();
        System.out.println("Imprimindo a soma - " + sum);

        dados.stream().filter(d -> d.getId() > 2).findAny();

            /* Collection Optional
               Se existir um id maior que 1
               Pega qualquer um deles
               Imprima ele. */
        dados.stream().
                filter(d -> d.getId() > 1).
                findAny().
                ifPresent(d -> System.out.println(d.getNome()));

        /* Após filtrar os dados menor que 3 e manipular
           podemos converter para collections
         */
        dados.stream().
                filter(d -> d.getId() < 3).
                collect(Collectors.toMap(d -> d.getNome(), d -> d.getId())).
                forEach((id, nome) -> System.out.println(nome + " tem " + id));

    }
}

