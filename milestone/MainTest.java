
import java.time.LocalDate;
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

            Evento tirtySecondsToMarse = new Evento("Tirty Seconds to mars on toru", LocalDate.now(), 200);

            System.out.println(tirtySecondsToMarse);

            // da ragionare

            scanner.close();

        } catch (Exception e) {

        }

    }
}
