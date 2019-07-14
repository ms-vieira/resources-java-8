package dates;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Dates {
    public static void main(String[] args) {

        //Data de hoje
        LocalDate hoje = LocalDate.now();
        System.out.println("Data de hoje: " + hoje);

        LocalDate olimpiadas = LocalDate.of(2020, 02, 20);

        //Diferença entre as datas
        int anos = olimpiadas.getYear() - hoje.getYear();
        System.out.println("Diferenca entre duas datas - olimpiadas: "
                + olimpiadas + " hoje: " + hoje + " Quantidade de anos: " + anos);

        //Periodo entre datas
        Period periodo = Period.between(hoje, olimpiadas);
        System.out.println("Periodo entre hoje e olimpiadas - " + periodo);

        //Data daqui 4 anos
        LocalDate proxOlimpiadas = olimpiadas.plusYears(4);
        System.out.println("Proxima olimpiadas: " + proxOlimpiadas);

        // Formartar Data
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = proxOlimpiadas.format(formatador);
        System.out.println("Data formatada da prox olimpiadas: " + valorFormatado);

        //Caso queira horas também
        DateTimeFormatter formatadorHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("Data formatada com as horas: " +  agora.format(formatadorHoras));

        //Intervalo entre horas
        LocalTime intervalo = LocalTime.of(12, 30);
        System.out.println("Intervalo entre horas: " + intervalo);
    }
}
