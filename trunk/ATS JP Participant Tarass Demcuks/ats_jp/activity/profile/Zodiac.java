/*
 * Created on Jul 28, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package ats_jp.activity.profile;

import java.util.Calendar;

/**
 * This class is a utility for determining the zodiac sign associated with a given Calendar
 * 
 * @author eugene.p.lozada
 */
public class Zodiac {
    
    
    private int startMonth, startDate;
    private int endMonth, endDate;
    private String toString;
    
    //The following variables are the possible return values of the method getZodiacSign()
    public static final Zodiac ARIES 
        = new Zodiac(Calendar.MARCH, 21, Calendar.APRIL, 19, "Aries");
    public static final Zodiac TAURUS
        = new Zodiac(Calendar.APRIL, 20, Calendar.MAY, 20, "Taurus");    
    public static final Zodiac GEMINI
        = new Zodiac(Calendar.MAY, 21, Calendar.JUNE, 20, "Gemini");
    public static final Zodiac CANCER
        = new Zodiac(Calendar.JUNE, 21, Calendar.JULY, 22, "Cancer");
    public static final Zodiac LEO
        = new Zodiac(Calendar.JULY, 23, Calendar.AUGUST, 22, "Leo");
    public static final Zodiac VIRGO
        = new Zodiac(Calendar.AUGUST, 23, Calendar.SEPTEMBER, 22, "Virgo");
    public static final Zodiac LIBRA 
        = new Zodiac(Calendar.SEPTEMBER, 23, Calendar.OCTOBER, 22, "Libra");
    public static final Zodiac SCORPIO
        = new Zodiac(Calendar.OCTOBER, 23, Calendar.NOVEMBER, 21, "Scorpio");
    public static final Zodiac SAGITTARIUS 
        = new Zodiac(Calendar.NOVEMBER, 22, Calendar.DECEMBER, 21, "Sagittarius");
    public static final Zodiac CAPRICORN
        = new Zodiac(Calendar.DECEMBER, 22, Calendar.JANUARY, 19, "Capricorn");
    public static final Zodiac AQUARIUS
        = new Zodiac(Calendar.JANUARY, 20, Calendar.FEBRUARY, 18, "Aquarius");
    public static final Zodiac PISCES
        = new Zodiac(Calendar.FEBRUARY, 19, Calendar.MARCH, 20, "Sagittarius");
    
 
    private Zodiac(int startMonth, int startDate, int endMonth, int endDate, String toString){

        this.startMonth = startMonth;
        this.startDate = startDate;
        this.endMonth = endMonth;
        this.endDate = endDate;
        this.toString = toString;
    }
    
    
    /**
     * Get the start date for this zodiac sign
     * 
     * @return the start date
     */
    public Calendar getStartDate(){
        Calendar now = Calendar.getInstance();
        now.set(0, this.startMonth, this.startDate);
        return now;
    }
    
    
    /**
     * Get the end date for this zodiac sign
     * 
     * @return the end date
     */
    public Calendar getEndDate(){
        Calendar now = Calendar.getInstance();
        now.set(0, this.endMonth, this.endDate);
        return now;
    }
    
    
    /**
     * Generates a Zodiac object based on the given calendar 
     * 
     * @param birthDate date used to determine the Zodiac object
     * @return Any of the static Zodiac objects (see the static fields)
     */
    public static Zodiac  getZodiacSign(Calendar birthDate){
        
        
        int month  = birthDate.get(Calendar.MONTH); 			//month of birth
        int day =  birthDate.get(Calendar.DAY_OF_MONTH);		//date of birth
        
        Zodiac tempZodiac = null;
        //TODO Activity 1.1
        //Given the current date, return the corresponding zodiac sign or null if the date does not have.
        //a corresponding zodiac sign Refer to the constants  above for the zodiac values.   You may declare 
        //additional local variables if necessary, but you are not allowed to use pre-built APIs to accomplish 
        // the activity.
        
        //HINT: Research the 'return' keyword
       
        	
        
        //start solution 1.1
        switch(month){
    	case 0: 
    		if (day >= 1 && day <= 19) tempZodiac = CAPRICORN;
    		else if (day >= 20 && day <= 31) tempZodiac = AQUARIUS;
    		break;
    	case 1:
    		if (day >= 1 && day <= 18) tempZodiac = AQUARIUS;
    		else if (day >= 19 && day <= 28) tempZodiac = PISCES;
    		break;
    	case 2:
    		if (day >= 1 && day <= 20) tempZodiac = PISCES;
    		else if (day >= 21 && day <= 31) tempZodiac = ARIES;
    		break;
    	case 3:
    		if (day >= 1 && day <= 19) tempZodiac = ARIES;
    		else if (day >= 20 && day <= 30) tempZodiac = TAURUS;
    		break;
    	case 4:
    		if (day >= 1 && day <= 20) tempZodiac = TAURUS;
    		else if (day >= 21 && day <= 31) tempZodiac = GEMINI;
    		break;
    	case 5:
    		if (day >= 1 && day <= 20) tempZodiac = GEMINI;
    		else if (day >= 21 && day <= 30) tempZodiac = CANCER;
    		break;
    	case 6:
    		if (day >= 1 && day <= 22) tempZodiac = CANCER;
    		else if (day >= 23 && day <= 31) tempZodiac = LEO;
    		break;
    	case 7:
    		if (day >= 1 && day <= 22) tempZodiac = LEO;
    		else if (day >= 23 && day <= 31) tempZodiac = VIRGO;
    		break;
    	case 8:
    		if (day >= 1 && day <= 22) tempZodiac = VIRGO;
    		else if (day >= 23 && day <= 30) tempZodiac = LIBRA;
    		break;
    	case 9:
    		if (day >= 1 && day <= 22) tempZodiac = LIBRA;
    		else if (day >= 23 && day <= 31) tempZodiac = LIBRA;
    		break;
    	case 10:
    		if (day >= 1 && day <= 21) tempZodiac = SCORPIO;
    		else if (day >= 22 && day <= 30) tempZodiac = LIBRA;
    		break;
    	case 11:
    		if (day >= 1 && day <= 21) tempZodiac = SAGITTARIUS;
    		else if (day >= 22 && day <= 31) tempZodiac = LIBRA;
    		break;
    }
        // end solution 1.1        
        return tempZodiac;
    }
    
    public String toString(){
        return toString;
    }
    
}
