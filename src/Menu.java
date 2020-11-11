/**
 * Created by: Felix Marcusson
 * Date: 2020-11-11
 * Project: Inlämningsuppgift 3
 * Copyright: MIT
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    Array array = new Array();
    Appointments appointments = new Appointments();

    private final String firstMessage = "Hej och välkommen till Riddarfrisörens bokningssystem! Vad vill du göra?"+
            "\n1. Boka in tid åt kund.\n2. Kolla redan inbokade tider.\n3. Avsluta programmet.";
    private final String errorMessage = "Felaktig inmatning. Ange siffrorna 1, 2, eller 3." +
            "\n1. Boka in tid åt kund.\n2. Kolla redan inbokade tider.\n3. Avsluta programmet.";


    private final int INTFIRSTSELECTION = 1;
    private final String STRINGFIRSTSELECTION = "1";
    private final int INTSECONDSELECTION = 2;
    private final String STRINGSECONDSELECTION = "2";
    private final int INTTHIRDSELECTION = 3;
    private final String STRINGTHIRDSELECTION = "3";

    private String answer;
    private int choice;

    /**
     * Metod ger användare 3 alternativ att välja mellan och går sedan vidare till annan metod där användare
     * kan göra valet. Får tillbaka svar från tredje metod, och agerar på detta.
     */
    public void handleMenu(){
        while (true) {
            setChoice();
            int choice = getChoice();
            if (choice == INTTHIRDSELECTION) {
                System.out.println("Hejdå!");
                break;
            } else if (choice == INTSECONDSELECTION) {
                array.showArray();
            }
            else if (choice == INTFIRSTSELECTION) {
                appointments.createAppointment();
            }
        }
    }

    /**
     * Låter användaren mata in i siffror vilket av tre alternativ han/hon vill välja.
     */
    public void setChoice(){
        System.out.println(firstMessage);
        while (true) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            try {
                this.answer = input.readLine();
                if (answer.equals(STRINGFIRSTSELECTION)){
                    this.choice = Integer.parseInt(this.answer);
                    break;
                }
                else if (answer.equals(STRINGSECONDSELECTION)){
                    this.choice = Integer.parseInt(this.answer);
                    break;
                }
                else if (answer.equals(STRINGTHIRDSELECTION)){
                    this.choice = Integer.parseInt(this.answer);
                    break;
                }
                else
                    System.out.println(errorMessage);
                }catch (IOException a){
                System.out.println(a.getMessage());

            }catch(NullPointerException a){
                System.out.println("Hejdå!");
                System.exit(1);
            }
        }
    }

    /**
     * Metod returnerar val.
     * @return
     */
    public int getChoice(){return choice;}

}
