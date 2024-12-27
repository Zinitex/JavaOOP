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
public class formatter {

    public static String currency(int number) {
        Locale indonesianLocale = new Locale("id", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indonesianLocale);
        String formattedPrice = currencyFormatter.format(number);

        return formattedPrice;
    }

    public static String capitalText(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}
