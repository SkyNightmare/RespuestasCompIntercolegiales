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
        date = LocalDate.parse(fecha, formatter);
        System.out.println("Indique el numero: ");
        int in_num = sc.nextInt();
        boolean hayError = false;

        if (!isValidYear(date)) {
            System.out.println("El año es incorrecto, trate de nuevo.");
            hayError = true;
        }

        if (!isValidMonth(date)) {
            System.out.println("El mes es incorrecto, trate de nuevo.");
            hayError = true;
        }

        if (!isCorrectMonth(date)) {
            System.out.println("El día es incorrecto para el mes indicado, trate de nuevo.");
            hayError = true;
        }

        if (!isFebValid(date)) {
            System.out.println("El día es incorrecto para este mes.");
            hayError = true;
        }

        if (!hayError) {
            LocalDate fechaFutura = date.plusDays(in_num);
            System.out.println("La fecha " + in_num + " días en el futuro es " + fechaFutura.format(formatter));
        }
    }

    public static boolean isValidYear(LocalDate date) {
        int year = date.getYear();
        return year >= 1 && year <= 2100;
    }

    public static boolean isValidMonth(LocalDate date) {
        int mes = date.getMonthValue();
        return mes <= 12;
    }

    public static boolean isCorrectMonth(LocalDate date) {
        int mes = date.getMonthValue();
        int dia = date.getDayOfMonth();
        return !((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31);
    }

    public static boolean isLeapYear(LocalDate date) {
        int year = date.getYear();
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static boolean isFebValid(LocalDate date) {
        int mes = date.getMonthValue();
        int dia = date.getDayOfMonth();
        return !(mes == 2 && (dia > 29 || (dia == 29 && !isLeapYear(date))));
    }
}
