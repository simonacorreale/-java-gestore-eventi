
import java.util.ArrayList;
import java.util.List;

/* Step 4 (Bonus opzionale)
Creare una classe ProgrammaEventi con i seguenti attributi: 
- titolo: String✅
- eventi: List<Evento>✅
Nel costruttore valorizzare il titolo, passato come parametro, e inizializzare la lista di eventi come una nuova ArrayList✅
Aggiungere i seguenti metodi :
un metodo che aggiunge alla lista un Evento, passato come parametro ✅
un metodo che restituisce una lista con tutti gli eventi presenti in una certa data ✅
un metodo che restituisce quanti eventi sono presenti nel programma
un metodo che svuota la lista di eventi
un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data nella forma: 
data1 - titolo1
data2 - titolo2 
… */

public class ProgrammaEventi {

    private final String titolo;
    private final List<Evento> eventi;

    // costruttore
    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    // Getter titolo
    public String getTitolo() {
        return titolo;
    }

    // creiamo un metodo che aggiunga un evento
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    // un metodo che restituisce una lista con tutti gli eventi presenti in una
    // certa data
    public void mostraEventi(String data) {

        for (Evento evento1 : eventi) {

            if (evento1.getData().equals(data)) {
                // il for each mi fa controllare

                System.out.println(evento1);

            } else {
                System.out.println("Non ci sono eventi nella lista corrispondenti a questa data");
            }

        }
    }

    // Metodo che restituisce il numero di eventi
    public int getNumeroEventi() {
        return eventi.size();
    }

    // Un metodo che svuota la lista di eventi

    public void resetListaEventi() {

        eventi.clear();
    }

}
