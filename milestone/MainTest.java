
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Step 2
Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.✅

Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli

Stampare a video il numero di posti prenotati e quelli disponibili

Chiedere all’utente se e quanti posti vuole disdire

Provare ad effettuare le disdette, implementando opportuni controlli

Stampare a video il numero di posti prenotati e quelli disponibili 

*/

public class MainTest {

    public static void main(String[] args) {

        // Implemento un try catch per effettuare i controlli necessari
        // titolo data e visualizza numero posti totali
        // 1 titolo
        // 2 data

        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------------------------");
        System.out.println("Inserisci il titolo dell'evento: ");
        String titolo = scanner.nextLine();

        System.out.println("---------------------------------------------------");
        System.out.println("Inserisci la data dell'evento (formato dd-MM-yyyy): ");

        String dateString = scanner.nextLine();

        // Regex per il formato "dd-MM-yyyy"
        String regex = "^([0-2][0-9]|(3)[0-1])-(0[1-9]|1[0-2])-(\\d{4})$";

        // Compilazione della regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateString);

        if (matcher.matches()) {

            try {

                // Converte la stringa in LocalDate con il formato "dd-MM-yyyy"
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate data = LocalDate.parse(dateString, formatter);

                System.out.println("Data valida: " + data);
                Evento concertoMetal = new Evento(titolo, data, 100);

                // Visualizza l'evento
                System.out.println("---------------------------------------------------");
                System.out.println(concertoMetal);
                System.out.println("---------------------------------------------------");

                System.out.println("Vuoi prenotare questo evento?(si/no)");

                String rispostaCorrente = scanner.nextLine();

                // Debug per il numero di posti prima
                System.out.println(concertoMetal.getPostiPrenotati());
                if ("si".equals(rispostaCorrente)) {

                    // Commento per domani - Risolvere questa condizione

                    concertoMetal.prenota();

                    // Debug per il numero di posti dopo
                    System.out.println(concertoMetal.getPostiPrenotati());

                } else {
                    // casistica del no
                    System.out.println(" grazie e buona giornata");
                }

            } catch (Exception e) {
                System.out.println("Data non valida. Assicurati che la data esista veramente.");
            }
        } else {
            System.out.println("Errore: Formato data non valido. Usa il formato dd-MM-yyyy.");
        }

        scanner.close();

    }
}
