package Hibernate.Bank_Management_System.util;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class Validator {

    private static ValidatorFactory validatorFactory;

    // Method to initialize ValidatorFactory
    public static ValidatorFactory getValidatorFactory() {
        if (validatorFactory == null) {
            validatorFactory = Validation.buildDefaultValidatorFactory();
        }
        return validatorFactory;
    }

    // Method to get Validator instance
    public static Validator getValidator() {
        return (Validator) getValidatorFactory().getValidator();
    }

    // Optional: shutdown logic (cleanup resources)
    public static void shutdown() {
        if (validatorFactory != null) {
            validatorFactory.close();
        }
    }
}
