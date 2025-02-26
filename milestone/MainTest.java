
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Step 2
Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.✅

Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli✅

Stampare a video il numero di posti prenotati e quelli disponibili✅

Chiedere all’utente se e quanti posti vuole disdire

Provare ad effettuare le disdette, implementando opportuni controlli

Stampare a video il numero di posti prenotati e quelli disponibili 

*/

public class MainTest {

    public static void main(String[] args) {

        // Implemento un try catch per effettuare i controlli necessari
        // titolo data e visualizza numero posti totali
        // 1 titolo
        // 2 data

        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------------------------");
        System.out.println("Inserisci il titolo dell'evento: ");
        String titolo = scanner.nextLine();

        System.out.println("---------------------------------------------------");
        System.out.println("Inserisci la data dell'evento (formato dd-MM-yyyy): ");

        String dateString = scanner.nextLine();

        // Regex per il formato "dd-MM-yyyy"
        String regex = "^([0-2][0-9]|(3)[0-1])-(0[1-9]|1[0-2])-(\\d{4})$";

        // Compilazione della regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateString);

        if (matcher.matches()) {
            try {
                // Converte la stringa in LocalDate con il formato "dd-MM-yyyy"
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate data = LocalDate.parse(dateString, formatter);

                // Creazione evento con 100 posti disponibili
                Evento concertoMetal = new Evento(titolo, data, 100);

                // Visualizza l'evento
                System.out.println("---------------------------------------------------");
                System.out.println(concertoMetal);
                System.out.println("---------------------------------------------------");

                boolean continua = true;

                while (continua) {

                    // Scelta opzione

                    System.out.println("Cosa vuoi fare?");
                    System.out.println("1. Prenotare posti");
                    System.out.println("2. Disdire prenotazioni");
                    System.out.println("3. Uscire");

                    // Conferma prenotazione

                    System.out.print("Scelta: ");
                    String scelta = scanner.nextLine();

                    switch (scelta) {

                        case "1" -> {

                            // Posti da prenotare

                            System.out.print("Quanti posti vuoi prenotare? ");
                            int postiRichiesti = scanner.nextInt();

                            scanner.nextLine();

                            try {

                                // suppondo si debba trovare una condizione per salvare i dati nella variabile e
                                // aggiungerli se vuota
                                concertoMetal.prenota(postiRichiesti);

                                System.out.println("Posti prenotati con successo! Posti attuali: "
                                        + concertoMetal.getPostiPrenotati());

                            } catch (Exception e) {
                                System.out.println("Errore: " + e.getMessage()); // controllare bug su questo elemento
                            }
                        }
                        case "2" -> {

                            // Cancellazione posti

                            System.out.print("Quanti posti vuoi disdire? ");
                            int postiDaRimuovere = scanner.nextInt();
                            scanner.nextLine();

                            try {

                                // suppondo si debba trovare una condizione per salvare i dati nella variabile e
                                // rimuoverli se piena

                                concertoMetal.disdici(postiDaRimuovere);
                                // Rimozione
                                System.out.println(
                                        "Prenotazioni annullate! Posti rimanenti: "
                                                + concertoMetal.getPostiPrenotati());

                            } catch (Exception e) {
                                System.out.println("Errore: " + e.getMessage());
                            }
                        }
                        case "3" -> {

                            // Uscita

                            System.out.println("Grazie e buona giornata!");
                            continua = false;
                        }
                        default -> System.out.println("Scelta non valida. Riprova.");
                    }
                }

            } catch (Exception e) {
                System.out.println("Errore: Non è possibile gestire l'evento. " + e.getMessage());
            }
        } else {
            System.out.println("Errore: Formato data non valido. Usa il formato dd-MM-yyyy.");
        }
        scanner.close();

    }
}
