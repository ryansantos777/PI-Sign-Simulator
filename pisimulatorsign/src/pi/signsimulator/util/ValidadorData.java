
package pi.signsimulator.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidadorData {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static boolean isDataValida(String data) {
        if (data == null || data.trim().isEmpty()) {
            return false;
        }
        
        try {
            LocalDate.parse(data, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public static LocalDate parseData(String data) throws DateTimeParseException {
        return LocalDate.parse(data, FORMATTER);
    }
    
    public static String formatarData(LocalDate data) {
        return data.format(FORMATTER);
    }
    
    public static boolean isDataFutura(LocalDate data) {
        return data.isAfter(LocalDate.now());
    }
    
    public static boolean isIdadeValida(LocalDate dataNascimento) {
        LocalDate agora = LocalDate.now();
        LocalDate limiteMinimo = agora.minusYears(120); // 120 anos atrás
        
        return !dataNascimento.isAfter(agora) && 
               !dataNascimento.isBefore(limiteMinimo);
    }
}
