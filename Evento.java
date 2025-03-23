
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;
    private LocalDate data;
    private int numeroPostiPrenotati;
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
    public int getPostiPrenotati() {
        return numeroPostiPrenotati;
    };

    // Getter data
    public String getData() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataFormattata = data.format(dateFormatter);
        return dataFormattata;
    }

    // Setter data
    public void setData(LocalDate data) {

        this.data = data;
    }

    // Metodi metodo per gestire le varie eccezioni
    private void eccezioniSpeciali(String errore) throws Exception {

        throw new Exception(errore);

    }

    // Metodi per la prenotazione e disdetta

    public void prenota(int postiRichiesti) throws Exception {
        if (LocalDate.now().isBefore(data) || LocalDate.now().isEqual(data)) {
            if (numeroPostiPrenotati + postiRichiesti <= numeroPostiTotali) {

                numeroPostiPrenotati += postiRichiesti;

                System.out.println(
                        "Prenotazione confermata. Posti prenotati: " + numeroPostiPrenotati + "/" + numeroPostiTotali);

            } else {

                eccezioniSpeciali("Non ci sono abbastanza posti disponibili. Posti rimasti: "
                        + (numeroPostiTotali - numeroPostiPrenotati));
            }
        } else {
            eccezioniSpeciali("Non puoi prenotare per questa prenotazione");
        }
    }

    public void disdici(int postiDaRimuovere) throws Exception {
        if (LocalDate.now().isBefore(data)) {

            if (numeroPostiPrenotati >= postiDaRimuovere) {

                numeroPostiPrenotati -= postiDaRimuovere;

                System.out.println("Cancellazione confermata. Posti prenotati rimanenti: " + numeroPostiPrenotati + "/"
                        + numeroPostiTotali);
                // forse devo inserire la conferma di quanti ne ha cancellati

            } else {
                eccezioniSpeciali("Non puoi cancellare più posti di quelli prenotati. Posti prenotati attuali: "
                        + numeroPostiPrenotati);
            }
        } else {
            eccezioniSpeciali("Non puoi disdire questa prenotazione");
        }
    }

    @Override
    public String toString() {

        return "Evento: " + titolo + " \nData: " + getData();

    }

}
