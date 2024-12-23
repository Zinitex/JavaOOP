/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author nanda
 */
public class formatCurrency {
    public static String format(int number){
        Locale indonesianLocale = new Locale("id", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indonesianLocale);
        String formattedPrice = currencyFormatter.format(number);
        
        return formattedPrice;
    }
}
