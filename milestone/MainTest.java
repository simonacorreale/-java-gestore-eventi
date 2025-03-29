
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Step 2
Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.✅
Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli✅
Stampare a video il numero di posti prenotati e quelli disponibili✅
Chiedere all’utente se e quanti posti vuole disdire✅
Provare ad effettuare le disdette, implementando opportuni controlli✅
Stampare a video il numero di posti prenotati e quelli disponibili ✅
*/

public class MainTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Inserimento titolo
        System.out.println("---------------------------------------------------");
        System.out.println("Inserisci il titolo dell'evento: ");
        String titolo = scanner.nextLine();

        // Inserimento data
        System.out.println("---------------------------------------------------");
        System.out.println("Inserisci la data dell'evento (formato dd-MM-yyyy): ");
        String dateString = scanner.nextLine();

        // Regex per il formato data "dd-MM-yyyy"
        String regex = "^([0-2][0-9]|(3)[0-1])-(0[1-9]|1[0-2])-(\\d{4})$";

        // Compilazione della regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherData = pattern.matcher(dateString);

        // Inserimento ora concerto
        System.out.println("---------------------------------------------------");
        System.out.println("Inserisci l'ora dell'evento (formato HH:mm): ");
        String hourString = scanner.nextLine();

        // Regex per il formato dell'ora.
        String regexOra = "^([01]?[0-9]|2[0-3]):([0-5]?[0-9])$";
        Pattern patternOra = Pattern.compile(regexOra);
        Matcher matcherOra = patternOra.matcher(hourString);

        // Inserimento prezzo concerto
        System.out.println("---------------------------------------------------");
        System.out.println("Inserisci il prezzo dell'evento (formato 000,00): ");
        String priceString = scanner.nextLine();

        // Regex per il formato prezzo
        String regexPrezzo = "^\\d{1,3}(?:\\.\\d{3})*(?:,\\d{2})$";
        Pattern patternPrezzo = Pattern.compile(regexPrezzo);
        Matcher matcherPrezzo = patternPrezzo.matcher(priceString);

        // Verifica che tutte le regex siano valide
        boolean validData = matcherData.matches();
        boolean validOra = matcherOra.matches();
        boolean validPrezzo = matcherPrezzo.matches();

        if (!validData) {
            System.out.println("Errore: Formato data non valido. Usa il formato dd-MM-yyyy.");
        }
        if (!validOra) {
            System.out.println("Errore: Formato ora non valido. Usa il formato HH:mm");
        }
        if (!validPrezzo) {
            System.out.println("Errore: Formato prezzo non valido. Usa il formato 000,00.");
        }

        if (validData && validOra && validPrezzo) {
            try {

                // Converte la stringa dateString in LocalDate con il formato "dd-MM-yyyy"

                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate data = LocalDate.parse(dateString, dateFormatter);

                // Converte la stringa hourString in LocalTime con il formato "HH:mm:ss"
                LocalTime ora = LocalTime.parse(hourString);

                // Converte la stringa priceString in double con il formato "000,00"
                // Sostituzione da double ad implementazione della classe BigDecimal per gestire
                // i numeri con cifre superiori.
                BigDecimal prezzo = new BigDecimal(priceString.replace(",", "."));

                // Creazione concerto
                Concerto concerto = new Concerto(titolo, data, 100, ora, prezzo);

                // Visualizza l'evento
                System.out.println("---------------------------------------------------");
                System.out.println(concerto);

                System.out.println("---------------------------------------------------");
                // Visualizza il concerto

                /* System.out.println(concerto); */

                boolean continua = true;

                while (continua) {

                    // Scelta opzione
                    System.out.println("---------------------------------------------------");
                    System.out.println(concerto);
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
                                // Condizione 1
                                concerto.prenota(postiRichiesti);

                                System.out.println("Posti prenotati con successo! Posti attuali: "
                                        + concerto.getPostiPrenotati());
                                /* Casting string prova */
                                BigDecimal totale = concerto.getPrezzoBigDecimal()
                                        .multiply(BigDecimal.valueOf(concerto.getPostiPrenotati()));
                                System.out.println("Costo totale: " + totale);

                            } catch (Exception e) {
                                System.out.println("Errore: " + e.getMessage());
                            }
                        }
                        case "2" -> {

                            // Cancellazione posti
                            System.out.println("---------------------------------------------------");
                            System.out.print("Quanti posti vuoi disdire? ");
                            int postiDaRimuovere = scanner.nextInt();
                            scanner.nextLine();

                            try {

                                concerto.disdici(postiDaRimuovere);
                                // Rimozione
                                System.out.println("---------------------------------------------------");
                                System.out.println(
                                        "Prenotazioni annullate! Posti rimanenti: "
                                                + concerto.getPostiPrenotati());

                            } catch (Exception e) {
                                System.out.println("Errore: " + e.getMessage());
                            }
                        }
                        case "3" -> {

                            // Uscita
                            System.out.println("---------------------------------------------------");
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
