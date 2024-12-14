import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date;
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique la fecha: "); // 12/31/2024
        String fecha = sc.nextLine();

        System.out.println("Indique el numero: ");
        int in_num = sc.nextInt();
        date = LocalDate.parse(fecha, formatter);
        // mes
        String mes = fecha.substring(0, 2);
        int mes_n = Integer.parseInt(mes);

        // year
        String year = fecha.substring(6, 10);
        int year_n = Integer.parseInt(year);

        // dia
        String dia = fecha.substring(3, 5);
        int dia_n = Integer.parseInt(dia);
        boolean hayError = false;

        if (year_n < 1 || year_n > 2100)
            System.out.println("El año es incorrecto, trate de nuevo.");
        hayError = true;

        if (mes_n > 12) {
            System.out.println("El mes es incorrecto, trade de nuevo");
            hayError = true;

        }

        if (mes_n == 04 || mes_n == 6 || mes_n == 9 || mes_n == 11 && dia_n == 31) {
            System.out.println("El día es incorrecto para el mes indicado, trate de nuevo.");
            hayError = true;

        }

        if (mes_n == 02 && dia_n > 28 && (year_n & 3) != 0 && ((year_n % 25) != 0 || (year_n & 15) != 0)) {
            System.out.println("El día es incorrecto para el a~o indicado, trate de nuevo.");
            hayError = true;

        }

        if (mes_n == 02 && dia_n > 29) {
            System.out.println("El dia es incorrecto para este mes");
            hayError = true;

        }

        if (!hayError) {
            LocalDate fechaFutura = date.plusDays(in_num);
            System.out.println("La fecha " + in_num + " días en el futuro es " + fechaFutura.format(formatter));
        }
    }

}
