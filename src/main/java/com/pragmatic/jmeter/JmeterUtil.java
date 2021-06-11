package com.pragmatic.jmeter;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class JmeterUtil {
    private final Faker faker;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String guardianFirstName;
    private String guardianLastName;
    private String childFirstName;
    private String childLastName;


    public JmeterUtil() {
        faker = new Faker();
    }

    public String getFirstName() {
        this.firstName = faker.name().firstName();
        return this.firstName;
    }

    public String getLastName() {
        this.lastName = faker.name().lastName();
        return lastName;
    }

    public String getMiddleName() {
        return faker.name().lastName();
    }


    public String getEmail() {
        if (this.firstName == null) {
            this.firstName = getFirstName();
        }

        if (this.lastName == null) {
            this.lastName = getLastName();
        }

        this.email = String.format("%s.%s@pragmatictesters.lk", firstName, lastName);
        return email;
    }

    public String getMobile() {
        this.mobile = "04" + faker.number().digits(8);

        return mobile;
    }

    public String getGuardianFirstName() {
        this.guardianFirstName = getFirstName();
        return this.guardianFirstName;
    }

    public String getGuardianLastName() {
        this.guardianLastName = getLastName();
        return this.guardianLastName;
    }

    public String getChildFirstName() {
        this.childFirstName = getFirstName();
        return this.childFirstName;
    }

    public String getChildLastName() {
        this.childLastName = getLastName();
        return this.childLastName;
    }

    public String getFamilyName() {
        return String.format("Xap-PTL-%s%s", this.firstName, this.lastName);
    }

    public String getChildCRN() {
        return getCRN();
    }

    private String getCRN() {
        String crnPrefix = faker.number().digits(9);
        char crnSuffix = getRandomChar();
        return String.format("%s%s", crnPrefix, crnSuffix);
    }

    private char getRandomChar() {
        Random r = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.charAt(r.nextInt(alphabet.length()));
    }

    public String getParentCRN() {
        return getCRN();
    }

    public String getPaymentAccountName() {

        if (this.firstName == null) {
            this.firstName = getFirstName();
        }

        if (this.lastName == null) {
            this.lastName = getLastName();
        }

        return String.format("%s %s", this.firstName, this.lastName);
    }

    public String getGuardianDOB() {
        int minAge = 25;
        int maxAge = 70;
        return getBirthday(minAge, maxAge);
    }

    private String getBirthday(int minAge, int maxAge) {
        Date date = faker.date().birthday(minAge, maxAge);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return dateFormat.format(date);
    }

    public String getChildDOB() {
        int minAge = 1;
        int maxAge = 5;
        return getBirthday(minAge, maxAge);
    }

    public String getGuardianCRN() {
        return getCRN();
    }

    public String getCurrentDate() {
        Date dateToday = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateToday);
    }

    public String getPastDate(int atMost, int minimum) {
        String strPastDate;
        Date datePastDate = faker.date().past(atMost, minimum, TimeUnit.DAYS);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        strPastDate = dateFormat.format(datePastDate);
        return strPastDate;
    }

    public String getBookingFromDate() {
        Date dateBookingFromDate = faker.date().past(30, TimeUnit.DAYS);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateBookingFromDate);

    }

    public String getBookingToDate() {
        Date dateToday = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateToday);
    }

    public String getStreetAddress() {
        return faker.address().streetAddress();
    }

    public String getSuburb() {
        return faker.address().cityName();
    }

    /**
     * Generate a valid postal code for a given state code
     * @param stateCode
     * @return Australian Postal code
     */
    public String getPostcode(String stateCode)  {
        int postalCode =0;

        if (stateCode.equalsIgnoreCase("nsw")){
            postalCode = faker.number().numberBetween(1000,1999);
        } else if (stateCode.equalsIgnoreCase("act")){
            postalCode = faker.number().numberBetween(2600,2618);
        }else if (stateCode.equalsIgnoreCase("vic")){
            postalCode = faker.number().numberBetween(3000,3999);
        }else if (stateCode.equalsIgnoreCase("qld")){
            postalCode = faker.number().numberBetween(4000,4999);
        }else if (stateCode.equalsIgnoreCase("sa")){
            postalCode = faker.number().numberBetween(5000,5799);
        }else if (stateCode.equalsIgnoreCase("wa")){
            postalCode = faker.number().numberBetween(6000,6797);
        }else if (stateCode.equalsIgnoreCase("tas")){
            postalCode = faker.number().numberBetween(7000,7999);
        }else if (stateCode.equalsIgnoreCase("nt")){
            postalCode = faker.number().numberBetween(800,899);
        } else {
            System.out.println("Invalid state code " + stateCode);
        }
        return  String.format("%04d",postalCode);
    }

    public String getTagName() {
        String tagName = "TPtl ";
        tagName += faker.funnyName().name();
        tagName += faker.number().randomDigit();
        return tagName;
    }
}
