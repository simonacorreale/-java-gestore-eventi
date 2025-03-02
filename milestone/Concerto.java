
/* 
Step 3
Creare una classe Concerto che estende Evento, che ha anche gli attributi :
ora (LocalTime)
prezzo
Aggiungere questi attributi nel costruttore e implementarne getter e setter.
Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€) Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - prezzo formattato

 */

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

    private final LocalTime ora;
    private double prezzo = 230;
    private double prezzototale = 0;

    // Costruttore per Concerto
    public Concerto(String titolo, LocalDate data, int numeroPostiTotali, double prezzo, LocalTime ora,
            double prezzototale) {
        super(titolo, data, numeroPostiTotali);
        this.ora = ora;
        this.prezzototale = prezzototale * prezzo;
        this.prezzo = prezzo;

    }

    public String getDataOraFormattata() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return getData().format(dateFormatter) + " " + ora.format(timeFormatter);
    }

    public String getPrezzoFormattato() {
        return String.format("%.2f€", getPrezzoTotale());
    }

    @Override
    public String toString() {
        return "Ora prenotazione " + ora + ", prezzo totale" + prezzo + "";
    }

    public double getPrezzoTotale() {
        return prezzototale;
    }

}
