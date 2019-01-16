import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadas = LocalDate.of(2020, 02, 20);

        //Diferença entre as datas
        int anos = olimpiadas.getYear() - hoje.getYear();
        System.out.println(anos);

        //Diferenças
        Period periodo = Period.between(hoje, olimpiadas);

        //Data daqui 4 anos
        LocalDate proxOlimpiadas = olimpiadas.plusYears(4);
        System.out.println(proxOlimpiadas);

        // Formartar Data
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = proxOlimpiadas.format(formatador);
        System.out.println(valorFormatado);

        //Caso queira horas também
        DateTimeFormatter formatadorHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorHoras));

        //Intervalo entre horas
        LocalTime intervalo = LocalTime.of(12, 30);
        System.out.println(intervalo);
    }
}
