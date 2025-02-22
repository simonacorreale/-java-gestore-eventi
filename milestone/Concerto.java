package milestone;
/* 
Step 3
Creare una classe Concerto che estende Evento, che ha anche gli attributi :
ora (LocalTime)
prezzo
Aggiungere questi attributi nel costruttore e implementarne getter e setter.
Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€) Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - prezzo formattato

 */

 
import java.time.LocalDate;

public class Concerto extends Evento {

    public Concerto(String titolo, LocalDate data, int postiTotali) {
        super(titolo, data, postiTotali);
        
    }
    
}
