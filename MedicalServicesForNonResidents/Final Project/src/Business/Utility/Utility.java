/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utility;

import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rupam Tiwari
 */
public class Utility {
    
    private static int serialAppointment=1000;
    
    public static boolean charValidation(String arg){
        String pattern= "^[^-\\s][a-zA-Z ]*$";
        return arg.matches(pattern);
    }
    public static boolean alphaNumericValidation(String arg){
       
        String pattern= "^[^-\\s][a-zA-Z0-9 ]*$";
        return arg.matches(pattern);
        
    }
    public static boolean AddressValidation(String arg){
       
        String pattern= "^[^-\\s][a-zA-Z0-9,# ]*$";
        return arg.matches(pattern);
        
    }
    public static boolean intValidation(String arg){
       String pattern= "^[0-9.]+$";
        return arg.matches(pattern); 
    }
    public static boolean passwordValidation(String pwd){
        String pattern="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";
        return pwd.matches(pattern);
    }
    
    /*public static String getUniqueID(){
        int min = 1000;
        Random random = new Random();
        int randomID = random.nextInt(min+5000);
        
        return String.valueOf(randomID)
       // return null;
       serial++;
       return String.valueOf(serial);
    } */
    public static boolean emailValidation(String arg){
        
        Pattern pattern=Pattern.compile("^[A-Za-z0-9.]+@[A-Za-z0-9.-]+(\\.)[A-Za-z]{3,6}$");
        Matcher matcher = pattern .matcher(arg);
        return matcher.find();

    }
    
    public static String[] getAllCountries() {
    String[] countries = new String[Locale.getISOCountries().length];
    String[] countryCodes = Locale.getISOCountries();
    for (int i = 0; i < countryCodes.length; i++) {
        Locale obj = new Locale("", countryCodes[i]);
        countries[i] = obj.getDisplayCountry();
    }
    return countries;
 }

  }
