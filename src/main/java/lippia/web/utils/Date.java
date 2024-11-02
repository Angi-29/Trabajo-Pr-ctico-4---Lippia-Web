package lippia.web.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Date {
    public static String formatDate(String fechaOriginal) {
        // Definir el formateador de la fecha de entrada
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Parsear la fecha original a un objeto LocalDate
        LocalDate fecha = LocalDate.parse(fechaOriginal, formatoEntrada);

        // Definir el formateador para la fecha de salida en inglés
        DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("EEE, MMM dd", Locale.ENGLISH);

        // Formatear la fecha al nuevo formato
        String fechaFormateada = fecha.format(formatoSalida);
        return fechaFormateada;
    }
}
