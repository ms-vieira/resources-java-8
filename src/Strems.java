import java.util.*;
import java.util.stream.Collectors;

public class Strems {

    private String nome;
    private int id;

    public Strems(String nome, int id) {
        super();
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Example {
    public static void main(String[] args) {

        List<Strems> dados = new ArrayList<Strems>();
        dados.add(new Strems("Dado1", 1));
        dados.add(new Strems("Dado2", 2));
        dados.add(new Strems("Dado3", 3));

        //Method References
        dados.sort(Comparator.comparing(Strems::getId));

        //Stream - Filter
        dados.stream().
                //Filtrando os id maior ou igual a 2
                        filter(d -> d.getId() >= 2).
                //Transformamos stream no tipo do ID
                        map(d -> d.getId()).
                //Utilizando references
                        forEach(System.out::println);

        //For utilizando Lambda
        //dados.forEach(d -> System.out.println(d.getNome()));

            /* Declaramos um inteiro
               Pegamos todos os dados
               Filtramos os maiores que 1
               Transformamos Stream em Int
               E é feito a soma
             */
        int sum = dados.stream().
                filter(d -> d.getId() > 1).
                mapToInt(Strems::getId).
                sum();
        System.out.println(sum);

        dados.stream().filter(d -> d.getId() > 2).findAny();

            /* Collection Optional
               Se existir um id maior que 1
               Pega qualquer um deles
               Se existir um curso,
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
                forEach((id, nome) ->System.out.println(nome + " tem " + id));

    }
}

