
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

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---------------------------------------------------");
            System.out.println("Inserisci il titolo dell'evento: ");
            String titolo = scanner.nextLine();

            System.out.println("---------------------------------------------------");
            System.out.println("Inserisci la data dell'evento (formato YYYY-MM-DD): ");

            // Devo ragionare come far inserire la data all'italiana

            System.out.println("---------------------------------------------------");
            System.out.println("Inserisci il numero totale di posti disponibili: ");

            // Devo ragionare su questa parte

            // Parametri inseriti
            Evento concertoMetal = new Evento(titolo, data, 0);
            System.out.println("---------------------------------------------------");
            System.out.println(concertoMetal);
            System.out.println("---------------------------------------------------");

        } catch (Exception e) {
            // Devo ragionare su questa parte
        } finally {
            scanner.close();
        }

    }
}
