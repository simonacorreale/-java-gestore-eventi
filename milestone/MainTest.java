
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate data = LocalDate.parse(dateString, formatter);

        // Parametri inseriti
        Evento concertoMetal = new Evento(titolo, data, 100);

        System.out.println("---------------------------------------------------");
        System.out.println(concertoMetal);
        System.out.println("---------------------------------------------------");

        System.out.println("Vuoi prenotare questo evento?");

        String rispostaCorrente = scanner.nextLine();

        if ("Si".equals(rispostaCorrente)) {

            // Commento per domani - Risolvere questa condizione

            // Debug per il numero di posti prima
            /* System.out.println(concertoMetal.getPostiPrenotati()); */

            try {

                concertoMetal.prenota();

                // Debug per il numero di posti dopo
                /* System.out.println(concertoMetal.getPostiPrenotati()); */

            } catch (Exception e) {

                System.out.println(e);

            }

        } else {

            System.out.println(" grazie e buona giornata");

        }

        /*
         * 1) Voglio chiedere all'utente se vuole prenotare
         * 
         * 2) SE l'utente da risposta positiva
         * - accedi alla prenotazione del posto
         * 
         * 3) SE l'utente da risposta negativa
         * - gestisci un errore
         */

        scanner.close();

    }
}
