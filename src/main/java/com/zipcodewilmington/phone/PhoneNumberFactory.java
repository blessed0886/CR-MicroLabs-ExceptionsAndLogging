package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.lang.reflect.Array;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] phoneNumberArray = new PhoneNumber[phoneNumberCount];
        for(int i = 0; i <= phoneNumberCount-1; i++){
            phoneNumberArray[i] = createRandomPhoneNumber();
        }

        return phoneNumberArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {
        int areaCode = RandomNumberFactory.createInteger(100, 999);
        int central = RandomNumberFactory.createInteger(100, 999);
        int lineCode = RandomNumberFactory.createInteger(1000, 9999);

        return createPhoneNumberSafely(areaCode, central, lineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phoneNumber = "(" + areaCode + ")-" +  centralOfficeCode + "-" + phoneLineCode;
        PhoneNumber phoneNumber1 = null;
        try {
           phoneNumber1 = createPhoneNumber(phoneNumber);
        } catch (InvalidPhoneNumberFormatException ipfe){
            logger.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumber);
        }

        return phoneNumber1;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        //PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);
        logger.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
        return new PhoneNumber(phoneNumberString);
    }
}
