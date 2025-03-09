
/* 
Step 3
Creare una classe Concerto che estende Evento, che ha anche gli attributi :
ora (LocalTime)
prezzo
Aggiungere questi attributi nel costruttore e implementarne getter e setter.
Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€) Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - prezzo formattato

 */

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {

    private LocalTime ora;
    private double prezzo;

    // prezzo totale

    // Costruttore per Concerto
    public Concerto(String titolo, LocalDate data, int numeroPostiTotali, LocalTime ora, double prezzo) {
        super(titolo, data, numeroPostiTotali);
        this.ora = ora;
        this.prezzo = prezzo;

    }

    @Override
    public String toString() {
        // Formatter per l'ora
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        // Formatter per il prezzo
        NumberFormat priceFormatter = NumberFormat.getCurrencyInstance(Locale.ITALY);

        return "Titolo evento: " + getTitolo() + "\nData evento: " + getData() + "\nOra evento: "
                + ora.format(timeFormatter)
                + "\nPosti totali: " + getPostiTotali() + "\nPrezzo: " + priceFormatter.format(prezzo);

    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

}
