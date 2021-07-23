package org.interview.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.logging.Logger;

public class Utils {
    static Logger logger = Logger.getLogger(Utils.class.getSimpleName());



    public static  void validate(String text, String prefix, String suffix){
        String errorMsg = "String must contains lowercase English alphabetic letters ascii [a-z] only";
        if(!validateLowerCase(text) || !validateLowerCase(prefix) || !validateLowerCase(suffix)) {
            logger.severe(errorMsg);
            System.exit(1);
        }

        String errorSizeMsg = "String size should be between 1 and 50";
        if(!validateStringSize(text) || !validateStringSize(prefix) || !validateStringSize(suffix)) {
            logger.severe(errorSizeMsg);
            System.exit(1);
        }
    }

    public static boolean validateLowerCase(String str){
        return StringUtils.isAlpha(str) && StringUtils.isAllLowerCase(str);
    }

    public static boolean validateStringSize(String str){
        return  str.length() >= 1 && str.length() <= 50;
    }
}
