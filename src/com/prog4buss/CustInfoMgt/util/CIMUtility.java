package com.prog4buss.CustInfoMgt.util;

import java.util.*;


/* Project: CustInfoMgt
 * 
 * A simple project to learn Java basic, about Customer Information Management, 
 * main function is to add, modify, delete and display customer info.
 * The project is divided into 4 module on 4 packages imitating MVC model:
 * 
 * 1. CustInfoMgt.bean: Model/Data
 *      Customer: class to record customer info, name, age, ...
 *      
 * 2. CustInfoMgt.service: Controller(+Data?)
 *      CustomerList: Customer Array to keep customer info, providing CRUD method
 *      of customer.
 *      
 * 3. CustInfoMgt.view: View of UI (+Controller?)
 *      CustomerView: Display menu, accept user input, operate data using CustomerList.
 *      
 * 4. CustInfoMgt.util(CIMUtility): utils to read and check user input, provided by 
 *      Song Hongkang from atguigu.
 */

public class CIMUtility {
	
    private static Scanner scanner = new Scanner(System.in);
    // return only ’1’-’5’
	public static char readMenuSelection() {
		
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && 
                c != '3' && c != '4' && c != '5') {
                System.out.print("Erro, input again: ");
            } else break;
        }
        return c;
        
    }
	
	//return only one char
    public static char readChar() {
    	
        String str = readKeyBoard(1, false);
        return str.charAt(0);
        
    }
	
    // return a char, just press enter will return defaultValue;
    public static char readChar(char defaultValue) {
    	
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
        
    }

	//return int no more than 100
    public static int readInt() {
    	
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("error, input again: ");
            }
        }
        return n;
        
    }

	//return int no more than 100, 
	//just press enter will return defaultValue;
    public static int readInt(int defaultValue) {
    	
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("error, input again: ");
            }
        }
        return n;
        
    }
    
	
	// read string less than "limit"
    public static String readString(int limit) {
    	
        return readKeyBoard(limit, false);
        
    }
	
	// read string less than "limit"
    // just press enter will return defaultValue;
    public static String readString(int limit, String defaultValue) {
    	
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
        
    }

    // return only ‘Y’或’N’
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("error, input again: ");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("length （greater than " + limit + "）error, input again: ");
                continue;
            }
            break;
        }

        return line;
        
    }
    
}
