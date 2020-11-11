/**
 * Created by: Felix Marcusson
 * Date: 2020-11-11
 * Project: Inlämningsuppgift 3
 * Copyright: MIT
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Appointments {
    private Customers customers = new Customers();
    private Array array = new Array();

    private String firstAnswer;
    private String secondAnswer;
    private int firstChoice;
    private int secondChoice;


    private final String firstQuestion = "Vilken dag?\n1. Måndag\n2. Tisdag\n3. Onsdag\n4. Torsdag" +
            "\n5. Fredag\n6. Lördag\n\n7. Avbryt";
    private final String secondQuestion = "Vilken tid?\n1. 9:00\n2. 9:30\n3. 10:00\n4. 10:30\n5. 11:00" +
            "\n6. 11:30\n7. 12:00\n8. 12:30\n9. 13:00\n10. 13:30\n11. 14:00\n12. 14:30\n13. 15:00\n14. 15:30" +
            "\n15. 16:00\n16. 16:30\n17. 17:00\n18. 17:30\n\n19. Avbryt";
    private final String secondQuestionSaturday = "Vilken tid?\n1. 9:00\n2. 9:30\n3. 10:00\n4. 10:30\n5. 11:00" +
            "\n6. 11:30\n7. 12:00\n8. 12:30\n9. 13:00\n10. 13:30\n\n11. Avbryt";
    private final String firstErrorMessage = "Felaktig inmatning.\n\n1. Måndag\n2. Tisdag\n3. Onsdag\n4. Torsdag" +
            "\n5. Fredag\n6. Lördag\n\n7. Avbryt";
    private final String secondErrorMessage = "Felaktig inmatning.\n\n1. 9:00\n2. 9:30\n3. 10:00\n4. 10:30\n5. 11:00" +
            "\n6. 11:30\n7. 12:00\n8. 12:30\n9. 13:00\n10. 13:30\n11. 14:00\n12. 14:30\n13. 15:00\n14. 15:30" +
            "\n15. 16:00\n16. 16:30\n17. 17:00\n18. 17:30\n\n19. Avbryt";
    private final String secondErrorMessageSaturday = "Felaktig inmatning.\n\n1. 9:00\n2. 9:30\n3. 10:00\n4. 10:30\n5. 11:00" +
            "\n6. 11:30\n7. 12:00\n8. 12:30\n9. 13:00\n10. 13:30\n\n11. Avbryt";

    /**
     * Metod skapar information till inbokat möte som den skickar vidare till annan metod för att lägga in i
     * array. Hämtar information från två andra metoder.
     */
    public void createAppointment() {
        while (true){
            setChoice();
            if (firstChoice<=0||secondChoice<=0)
                break;
            this.secondChoice--;
            this.firstChoice--;
            customers.createCustomer();
            if (customers.getName().isEmpty()||customers.getName().isBlank()||customers.getPhoneNr().isBlank()||
            customers.getPhoneNr().isEmpty())
                break;
            array.fillArray(this.secondChoice,this.firstChoice,customers.getName(),customers.getPhoneNr());
            break;
        }

    }

    /**
     * Presenterar lista över dagar och tider i dessa dagar där användare kan boka in kund. Från
     * måndag-fredag finns tider 9-18, på lördag 9-14. Går att avbryta bokning och återgå till huvudmeny.
     */
    public void setChoice() {
        while (true) {
            firstChoice = 0;
            secondChoice = 0;
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println(firstQuestion);
                while(true) {
                    this.firstAnswer = input.readLine();
                    if (firstAnswer.equals("1")||firstAnswer.equals("2")||firstAnswer.equals("3")
                            ||firstAnswer.equals("4")||firstAnswer.equals("5")||firstAnswer.equals("6")) {
                        this.firstChoice = Integer.parseInt(this.firstAnswer);
                        break;
                    }
                    else if (firstAnswer.equals("7")) {
                        break;
                    } else
                        System.out.println(firstErrorMessage);
                }
                if (firstChoice <= 0)
                    break;
                else if (firstChoice == 6){
                    System.out.println(secondQuestionSaturday);
                    while(true){
                        this.secondAnswer = input.readLine();
                        if (secondAnswer.equals("1") || secondAnswer.equals("2") || secondAnswer.equals("3") ||
                                secondAnswer.equals("4") || secondAnswer.equals("5") || secondAnswer.equals("6")
                                || secondAnswer.equals("7") || secondAnswer.equals("8") || secondAnswer.equals("9")
                                || secondAnswer.equals("10")){
                        this.secondChoice = Integer.parseInt(secondAnswer);
                        break;
                        } else if (secondAnswer.equals("11"))
                            break;
                        else
                            System.out.println(secondErrorMessageSaturday);
                    }
                }
                else {
                    System.out.println(secondQuestion);
                    while(true) {
                        this.secondAnswer = input.readLine();
                        if (secondAnswer.equals("1") || secondAnswer.equals("2") || secondAnswer.equals("3") ||
                                secondAnswer.equals("4") || secondAnswer.equals("5") || secondAnswer.equals("6")
                                || secondAnswer.equals("7") || secondAnswer.equals("8") || secondAnswer.equals("9")
                                || secondAnswer.equals("10") || secondAnswer.equals("11") || secondAnswer.equals("12")
                                || secondAnswer.equals("13") || secondAnswer.equals("14") || secondAnswer.equals("15")
                                || secondAnswer.equals("16") || secondAnswer.equals("17")|| secondAnswer.equals("18")) {
                            this.secondChoice = Integer.parseInt(secondAnswer);
                            break;
                        } else if (secondAnswer.equals("19"))
                            break;
                        else
                            System.out.println(secondErrorMessage);
                    }
                }
                break;
            } catch (IOException a) {
                System.out.println(a.getMessage());
                }catch(NullPointerException a){
                System.out.println("Hejdå!");
                System.exit(1);
            }
        }
    }
}