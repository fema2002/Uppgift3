/**
 * Created by: Felix Marcusson
 * Date: 2020-11-11
 * Project: Inlämningsuppgift 3
 * Copyright: MIT
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array {

    private String answer;
    private final String message = "\nSer du ingen inbokad tid så finns inga inbokade möten.\n\nTryck ENTER för att "
    +"återgå till huvudmenyn.";
    private final String finalMessage ="\nTryck ENTER för att återgå till huvudmenyn.";

    private final String[] weekDays = {"Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag"};
    private final String[] serviceHours = {"9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00",
    "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30"};

    private static String[][] array = new String[6][18];

    /**
     * Metoden tar emot bokningsdatum och kundinformation och placerar i array.
     * @param secondChoice
     * @param firstChoice
     * @param name
     * @param phoneNr
     */
    public void fillArray(int secondChoice, int firstChoice, String name, String phoneNr){
        array[firstChoice][secondChoice] = weekDays[firstChoice]+" kl: "+serviceHours[secondChoice]+" - "+ name+" - "
                +phoneNr;
        System.out.println(array[firstChoice][secondChoice]);}

    /**
     * Metod visar alla ifyllda rader av arrayen, och väntar sedan på att användaren ska trycka enter
     * för att återgå till huvudmenyn.
     */
    public void showArray() {
        System.out.println();
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 18; j++)
                if (array[i][j].equals("-"))
                    ;
                else
                    System.out.println(array[i][j]);

        System.out.println(message);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true){
            answer = input.readLine();
            if (answer.isEmpty()||answer.isBlank())
                break;
            else
                System.out.println(finalMessage);}
        }catch (IOException a) {
            System.out.println(a.getMessage());
        }catch(NullPointerException a){
            System.out.println("Hejdå!");
            System.exit(1);
        }
    }

    /**
     * Första metoden som körs i programmet - fyller arrayen med strängar för att undvika error om
     * användare vill kolla lista över bokade tider utan att ha lagt till något bokat möte i array.
     */
    public void setUpArray(){
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 18; j++)
                array[i][j] = "-";
    }
}
