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
    private int numeroPostiPrenotati = 0;
    private int numeroPostiTotali;

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
    public int getPostiPrenotati() {
        return numeroPostiPrenotati;
    };

    // Getter data
    public LocalDate getData() {
        return data;
    }

    // Setter data
    public void setData(LocalDate data) {

        this.data = data;
    }

    // Metodi per la prenotazione e disdetta

    public void prenota() {

        if (LocalDate.now().isBefore(data) || LocalDate.now().isEqual(data)) {

            if (numeroPostiPrenotati < numeroPostiTotali) {

                // Aggiungo un posto
                numeroPostiPrenotati++;

            } else {
                // Messaggio di alert in caso di posti non disponibili
                throw new IllegalArgumentException("Non ci sono posti disponibili");
            }

        } else {

            // Messaggio di alert in caso contrario
            throw new IllegalArgumentException("Non puoi prenotare per eventi passati.");
        }

    }

    public void disdici() {

        if (LocalDate.now().isAfter(data)) {

            if (numeroPostiPrenotati != 0) {
                // Rimuovi un posto
                numeroPostiPrenotati--;

            } else {
                // Messaggio di alert prenotazione non effettuata
                throw new IllegalArgumentException("Devi prima aver effettuanto una prenotazione");

            }

        } else {

            // Messaggio di alert eventi passati
            throw new IllegalArgumentException("Non puoi prenotare per eventi passati.");

        }

    }

    @Override
    public String toString() {
        // Metodo java incorporato in java documentazione oracle
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Evento: " + titolo + ", Data: " + data.format(formatter);
    }

}
