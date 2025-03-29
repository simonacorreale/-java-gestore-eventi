
/* 
Step 2
Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.✅
Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli✅
Stampare a video il numero di posti prenotati e quelli disponibili✅
Chiedere all’utente se e quanti posti vuole disdire✅
Provare ad effettuare le disdette, implementando opportuni controlli✅
Stampare a video il numero di posti prenotati e quelli disponibili ✅
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UsoEvento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data attuale
        LocalDate date = LocalDate.now();

        // Formato desiderato
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Formattare la data nel formato "dd-MM-yyyy"
        String parsedDate = date.format(formatter);

        // List<Evento> eventi = new ArrayList<>();

        ProgrammaEventi programmaEventi = new ProgrammaEventi("Estivo");
        Evento evento1 = new Evento("evento 1", LocalDate.now(), 100);
        Evento evento2 = new Evento("evento 2", LocalDate.now(), 100);
        Evento evento3 = new Evento("evento 3", LocalDate.now(), 100);

        programmaEventi.aggiungiEvento(evento1);
        programmaEventi.aggiungiEvento(evento2);
        programmaEventi.aggiungiEvento(evento3);
        System.out.println("Lista di tutti gli eventi");

        System.out.println("Lista degli eventi del giorno 23 marzo 2025");
        programmaEventi.mostraEventi(parsedDate);

        programmaEventi.resetListaEventi();
        System.out.println("Lista di tutti gli eventi");

        scanner.close();

    }
}
