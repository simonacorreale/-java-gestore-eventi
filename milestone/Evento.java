import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* Step 1
Creare una classe Evento che abbia le seguenti proprietà:
titolo✅
data✅
numero di posti in totale ✅
numero di posti prenotati✅

Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore, tranne posti prenotati che va inizializzato a 0.✅
Inserire il controllo che la data non sia già passata✅ e che il numero di posti totali sia positivo.✅

In caso contrario il programma deve lanciare una eccezione.✅

Aggiungere metodi getter e setter in modo che:

titolo sia in lettura e in scrittura✅
data sia in lettura e scrittura✅
numero di posti totale sia solo in lettura✅
numero di posti prenotati sia solo in lettura✅

Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:✅
prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti disponibili deve restituire un’eccezione.✅
disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni restituisce un’eccezione.✅
l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo✅
Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.< pending comprensione possibile altro utilizzo
 */

public class Evento {

    private String titolo;
    private LocalDate data;
    private int numeroPostiPrenotati;
    private final int numeroPostiTotali;

    // Costruttore
    public Evento(String titolo, LocalDate data, int numeroPostiTotali) {

        // Verifica che la data non sia nel passato
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        
        // Verifica che il numero di posti totali sia positivo
        if (numeroPostiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = 0;

    }
    // Getter titolo
    public String getTitolo() {
        return titolo;
    }
    // Setter titolo
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    // Getter posti totali
    public int getPostiTotali() {
    return numeroPostiTotali;
    }

    // Getter posti prenotati
    public int getPostiPrenotati(){
        return numeroPostiPrenotati;
    };
    
    // Getter data
    public LocalDate getData() {
        return data;
    }
    // Setter data
    public void setData(LocalDate data) {

        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Non puoi impostare una data passata");
        }
        
        this.data = data;

    }

    // Metodi per la prenotazione e disdetta
    public void prenota() {

        if(data.isBefore(LocalDate.now())){
        // Messaggio di allert in caso contrario
        throw new IllegalArgumentException("La data dell'evento non può essere una data nel passato.");
        }

        // Messaggio di allert in caso di posti non disponibili
        if (numeroPostiPrenotati >= numeroPostiTotali) {
            throw new IllegalArgumentException("Non ci sono posti disponibili");
        } 

        // Aggiungo un posto
        numeroPostiPrenotati++;

    }

    public void disdici() {

        if(data.isBefore(LocalDate.now())){
            // messaggio di allert in caso contrario
            throw new IllegalArgumentException("La data dell'evento non può essere una data nel passato.");
            }

        if (numeroPostiPrenotati<=0){
            // Messaggio di allert in caso contrario
            throw new IllegalArgumentException("Non hai prenotazioni da disdire");    
        }
        // Rimuovo un posto
        numeroPostiPrenotati--; 
}
    
    @Override
    public String toString() {
    // Metodo java incorporato in java documentazione oracle https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html -> Formattatore DateTimeFormatter = DateTimeFormatter.ofPattern("aaaa MM gg");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Evento: " + titolo + ", Data: " + data.format(formatter);
    }

    
}
