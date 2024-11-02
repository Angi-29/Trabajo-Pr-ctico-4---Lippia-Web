package lippia.web.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;

public class MyDate {
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

    public static String invertirFecha(String originalDateStr) {
        try {
            // Define el formato original de la fecha
            SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = originalFormat.parse(originalDateStr);

            // Define el nuevo formato al que se quiere convertir
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
            String convertedDateStr = newFormat.format(date);

            System.out.println("Fecha convertida: " + convertedDateStr);
            return convertedDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
