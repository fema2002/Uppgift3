/**
 * Created by: Felix Marcusson
 * Date: 2020-11-11
 * Project: Inlämningsuppgift 3
 * Copyright: MIT
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Customers {
    private String name;
    private String phoneNr;

    private final String firstQuestion = "Kunds namn? (tryck enter utan att skriva in något för att avbryta boking)";
    private final String secondQuestion = "Kunds telefonnummer? (tryck enter utan"+
            " att skriva in något för att avbryta boking)";

    /**
     * Metod låter användaren ange kunds namn och telefonnr.
     */
    public void createCustomer (){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        try {
            System.out.println(firstQuestion);
            this.name = input.readLine();
            if (this.name.isBlank()||this.name.isEmpty()){
                break;
            }
            System.out.println(secondQuestion);
            this.phoneNr = input.readLine();
            if (this.phoneNr.isBlank()||this.phoneNr.isEmpty()) {
                break;
            }
            break;
        }catch (IOException a) {
            System.out.println(a.getMessage());
        }catch(NullPointerException a){
            System.out.println("Hejdå!");
            System.exit(1);
        }
    }

    /**
     * Metod returnerar kundens namn.
     * @return
     */
    public String getName(){return name;}

    /**
     * Metod returnerar kundens telefonnr.
     * @return
     */
    public String getPhoneNr(){return phoneNr;}
}
