/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewars;

import static java.awt.SystemColor.text;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author red rackhir
 */
public class PhoneDir {

    /*
        "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
        " 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
        "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n"
     */
    public static String getPhoneContact(String agend, String findPhone) {
        for (String contact : agend.split("\n")) {
            int phoneStart = contact.indexOf("+") + 1;
            int phoneEnds = contact.lastIndexOf("-") + 5;
            int nameStart = contact.indexOf("<");
            int nameEnds = contact.indexOf(">");

            String phone = contact.substring(phoneStart - 1, phoneEnds).replace("+", "");
            String name = contact.substring(nameStart - 1, nameEnds + 1);//.replace("<", "").replace(">", "");

            contact = contact.replace(phone, "***");
            contact = contact.replace(name, "***");
            if (contact.matches("[\\w]{2,3}-[\\d]{5}")) {
                String country = contact.substring(contact.indexOf("-") - 3, contact.indexOf("-") + 5);
            }
            String address = contact.replaceAll("[(a-zA-z0-9.,)]", "&");
            address = contact.substring(address.indexOf("&"), address.lastIndexOf("&"));

            name = name.replace("<", "").replace(">", "");

            if (phone.equalsIgnoreCase(findPhone)) {
                return String.format("Phone => %s, Name => %s, Address => %s", phone, name, address);
            }
        }
        return "";
    }

    public static String phone(String agend, String findPhone) {
        Pattern pCountry = Pattern.compile("[\\w]{2,3}-[\\d]{5}");
        Pattern pPhone = Pattern.compile("[\\d]+-[\\d]{3}-[\\d]{3}-[\\d]{4}");
        Pattern pAddress = Pattern.compile("( [\\w\\s,.]+)");
        Pattern pName = Pattern.compile("\\<[\\w\\s]+\\>");
        Matcher mt;
        boolean found = false;
        String name = "", phone = "", address = "", country = "";

        for (String contact : agend.split("\n")) {
            mt = pName.matcher(contact);
            name = mt.find() ? contact.substring(mt.start(), mt.end()) : "not found";
            mt = pPhone.matcher(contact);
            phone = mt.find() ? contact.substring(mt.start(), mt.end()) : "not found";
            mt = pAddress.matcher(contact);
            address = mt.find() ? contact.substring(mt.start(), mt.end()) : "not found";
            mt = pCountry.matcher(contact);
            contact.replace(name, "").replace(phone, "").replace(country, "");
            country = mt.find() ? contact.substring(mt.start(), mt.end()) : "not found";
            if (phone.equalsIgnoreCase(findPhone)) {
                found = true;
                name = name.replace("<", "").replace(">", "");
            }
            if (found) {
                return String.format("Phone => %s, Name => %s, Address => %s", phone, name, address.trim());
            }
        }
        return "Error => Not found: " + findPhone;
    }
}
