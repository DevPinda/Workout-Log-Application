package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;


public class Main {
    public static void main(String[] args){
        /**
         * Variables initialization
        */
        int choice;
        final String cardio = "cardio";
        final String weights = "weights";
        final String prompt = "Input 'Y' to confirm or 'N' to deny";
        final String confirm = "y";
        final String deny = "n";
        final String selected = "Successfully selected!";
        final String retry = "Invalid Input, Try Again!";
        final String retry2 = "Succesfully Cancelled, returning to beginning!";
        final String cdName = "Cardiovascular Exercise:";
        final String cdDuration = "Duration:";
        final String wtName = "Weightlifting Name:";
        final String wtSets = "Sets:";
        final String wtReps = "Repetitions:";
        final String nl = "\n";
        final String nl2 = "\n"+"\n";
        final String path = System.getProperty("user.dir")+"output.json";
        final String lnSep = "----------------------------------------------------------------------";
        final String lnSep2 = "------------------------------------------------------------------";
        final String lnSep3 = "-----------------------";
        final String lnSep4 = "------------------------------------------";
        String inpYN = "";
        String inpMenu = "";
        String inp = "";
        String inp2 = "";
        String inp3 = "";
        String inp4 = "";
        
        /**
         * Input Scanner initialization
         */
        Scanner reader = new Scanner(System.in);
        
        /**
         * Hash Map initialization
         */
        HashMap<String, String> strHm = new HashMap<>();
        
        /**
         * GSON Initialization
         */
        Gson gson = new GsonBuilder().create();
        
        /**
         * Welcome screen and asking user to make a choice
         */
        System.out.println(lnSep+nl+"Welcome to the Workout Logging software!, Developed by Parminder Singh"+nl+lnSep);
        
        do{
            System.out.println(nl2+"Would you like to Add an Exercise, View stored exercises or Exit the program?"+nl);
            
            /**
             *  Menu which asks for user choice
             * */
             do{
                 System.out.println(nl+"Enter '1' to Add, '2' to View, '3' to Delete Data and '4' to Exit!"+nl);
                 inpMenu = reader.nextLine();
                 if (inpMenu.equals("1")||inpMenu.equals("2")||inpMenu.equals("3")||inpMenu.equals("4")){
                     System.out.println(nl+selected+nl);
                    } else { System.out.println(nl+retry);}
                } while(!(inpMenu.equals("1"))&&!(inpMenu.equals("2"))&&!(inpMenu.equals("3"))&&!(inpMenu.equals("4")));
                

                /**
                 * Sets choice variable for Switch case to User input
                 * */
                choice = Integer.valueOf(inpMenu);
                
                
                /**
                 * Switch statement which has 3 cases to reflect user choice
                 * */
                switch(choice){
                    /**
                     * First case that adds entry
                     * */
                    default: case 1:
                    do{
                        System.out.println(lnSep2+nl+"Would you like to Log a Weight Lifting or Cardiovascular Exercise?"+nl
                        +lnSep2+nl2+lnSep3+nl+"Input Weights or Cardio"+nl+lnSep3+nl);
                        inp = reader.nextLine().toLowerCase();
                        if(inp.equals(weights)||inp.equals(cardio)){
                            System.out.println(nl+lnSep3+nl+selected+nl+lnSep3+nl);
                        } else { System.out.println(nl+retry+nl); }
                    } while (!inp.equals(weights)&&!inp.equals(cardio));
                    
                    if(inp.equals(cardio)){
                        do{
                            System.out.println(lnSep4+nl+"Please Enter Cardiovascular Exercise Name"+nl+lnSep4+nl);
                            inp2 = reader.nextLine();
                            System.out.println(nl+prompt+nl);
                            inpYN = reader.nextLine().toLowerCase();
                            if(inpYN.equals(confirm)){
                            System.out.println(nl+lnSep3+nl+selected);
                        } else if(inpYN.equals(deny)){ System.out.println(nl+retry2); }
                    else { System.out.println(retry); }
                } while(!inpYN.equals(confirm));
                
                do{
                    System.out.println(nl+"Please enter Duration"+nl);
                    inp3 = reader.nextLine();
                    System.out.println(nl+prompt+nl);
                    inpYN = reader.nextLine().toLowerCase();
                    if(inpYN.equals(confirm)){
                        System.out.println(nl+selected);
                    } else if(inpYN.equals(deny)){ System.out.println(nl+retry2); }
                    else { System.out.println(retry); }
                } while(!inpYN.equals(confirm));
            }

            if(inp.equals(weights)){
                do{
                    System.out.println(lnSep4+nl+"Please Enter Weightlifting Exercise Name"+nl+lnSep4+nl);
                    inp2 = reader.nextLine();
                    System.out.println(nl+prompt+nl);
                    inpYN = reader.nextLine().toLowerCase();
                    if(inpYN.equals(confirm)){
                        System.out.println(nl2+lnSep3+nl+selected);
                    } else if(inpYN.equals(deny)){ System.out.println(nl+retry2); }
                    else { System.out.println(retry); }
                } while(!inpYN.equals(confirm));
                
                do{
                    System.out.println(nl+"Please enter Sets"+nl);
                    inp3 = reader.nextLine();
                    System.out.println(nl+prompt+nl);
                    inpYN = reader.nextLine().toLowerCase();
                    if(inpYN.equals(confirm)){
                        System.out.println(nl+selected);
                    } else if(inpYN.equals(deny)){ System.out.println(nl+retry2); }
                    else { System.out.println(retry); }
                } while(!inpYN.equals(confirm));
                
                do{
                    System.out.println(nl+"Please enter Repetitions"+nl);
                    inp4 = reader.nextLine();
                    System.out.println(nl+prompt+nl);
                    inpYN = reader.nextLine().toLowerCase();
                    if(inpYN.equals(confirm)){
                        System.out.println(nl+selected);
                    } else if(inpYN.equals(deny)){ System.out.println(nl+retry2); }
                    else { System.out.println(retry); }
                } while(!inpYN.equals(confirm));
            }
            
            /**
             * Adding user input to HashMap
             * */
            if(inp.equals(cardio)){
                StringJoin strJoinCd = new StringJoin(cdName,inp2,cdDuration,inp3);
                strHm.put(inp,strJoinCd.getStrings());
            }
            
            if(inp.equals(weights)){ 
                StringJoin strJoinWt = new StringJoin(wtName,inp2,wtSets,inp3,wtReps,inp4);
                strHm.put(inp,strJoinWt.getStrings());
            }
            
            /**
             * GSON reading from HashMap and writing to JSON
             * */
            String jsonString = gson.toJson(strHm);
            
            /**
             * File Writer
             * */
            try(FileWriter file = new FileWriter(path,true);){
                file.append(jsonString);
                file.flush();
            } catch (IOException e) {
                System.out.println("Error while creating JSON File!, Details below:");
                e.printStackTrace();
            }
            break;
            
            /**
             * Second case to view all entries added by the user
             */
            case 2:
            try{
                File file = new File(path);
                if(file.exists()){
                    System.out.println(nl+"File Exists, Continuing Successfully!"+nl2);
                } else { System.out.println(nl+"Error: file doesn't exist!"+nl); }
                InputStream is = new FileInputStream(file);
                Reader r = new InputStreamReader(is, "UTF-8");
                JsonStreamParser p = new JsonStreamParser(r);
                
                while (p.hasNext()) {
                    JsonElement e = p.next();
                    if (e.isJsonObject()) {
                        Map m = gson.fromJson(e, Map.class);
                        String rawStr = m.toString();
                        System.out.println(rawStr.replace("{","").replace("}","").replace("cardio=","").replace("weights=",""));
                    }
                }
            } catch(IOException e){ 
                System.out.println(nl+"Error while reading JSON File!, Details below:"+nl);
                e.printStackTrace();
            }
            break;
            
            /**
             * Third case deletes the file
             */
            case 3:
            try{File file = new File(path);
                file.delete();
                if(file.exists()){
                    System.out.println(nl+"Error while Deleting file");
                } else { System.out.println(nl+"File Deleted successfully"); }
            } catch(Exception e){
                e.printStackTrace();
            } 
            break;
            
            /**
             * Fourth case exits program
             */
            case 4:
            reader.close();
            System.exit(0);
            break;
        }
    } while(!(inpMenu.equals("4")));
}
}