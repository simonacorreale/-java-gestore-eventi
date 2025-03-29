
/* 
Step 3
Creare una classe Concerto che estende Evento, che ha anche gli attributi :
ora (LocalTime)
prezzo
Aggiungere questi attributi nel costruttore e implementarne getter e setter.
Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€) Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - prezzo formattato

 */

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {

    private LocalTime ora;
    private BigDecimal prezzo;

    // prezzo totale

    // Costruttore per Concerto
    public Concerto(String titolo, LocalDate data, int numeroPostiTotali, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, numeroPostiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public String getOra() {

        // Formatter per l'ora
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String oraFormattata = ora.format(timeFormatter);
        return oraFormattata;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public String getPrezzo() {
        NumberFormat priceFormatter = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return priceFormatter.format(prezzo);
    }

    // Nuovo metodo per ottenere il prezzo come BigDecimal
    public BigDecimal getPrezzoBigDecimal() {
        return this.prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {

        return "Titolo evento: " + getTitolo() + "\nData evento: " + getData() + "\nOra evento: "
                + getOra()
                + "\nPosti totali: " + getPostiTotali() + "\nPrezzo: " + getPrezzo();

    }

}
