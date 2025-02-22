/* Step 1
Creare una classe Evento che abbia le seguenti proprietà:
titolo
data
numero di posti in totale
numero di posti prenotati
Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore, tranne posti prenotati che va inizializzato a 0.
Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. In caso contrario il programma deve lanciare una eccezione.
Aggiungere metodi getter e setter in modo che:
titolo sia in lettura e in scrittura
data sia in lettura e scrittura
numero di posti totale sia solo in lettura
numero di posti prenotati sia solo in lettura

Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti disponibili deve restituire un’eccezione.
disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni restituisce un’eccezione.
l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo
Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.
 */

public class Evento {

    private String titolo;
    private LocalDate data;
    private final int numeroPostiTotali;
    private int numeroPostiPrenotati;

    // costruttore
    public Evento() {
        
    }
    
}