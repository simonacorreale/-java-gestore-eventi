
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
import java.util.Scanner;

public class UsoEvento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProgrammaEventi programmaEventi = new ProgrammaEventi("Culo Estivo");
        Evento evento = new Evento("evento 1", LocalDate.now(), 100);

        System.out.println(evento);
        programmaEventi.aggiungiEvento(evento);
        programmaEventi.mostraEventi(LocalDate.now());
        System.out.println(evento.getData());
        System.out.println(LocalDate.now());

        scanner.close();

    }
}
