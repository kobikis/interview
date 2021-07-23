package org.interview.score;

import org.interview.utils.Utils;


import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class TextScore {
    private static Logger logger = Logger.getLogger(TextScore.class.getSimpleName());

    public SimpleImmutableEntry<String, Integer> score(String text, String prefixString, String suffixString) {

        Utils.validate(text, prefixString, suffixString);

        logger.info("text: " + text + ", prefixString: " + prefixString + ", suffixString: " + suffixString);

        int textLen = text.length();
        int suffixLen = suffixString.length();
        int prefixLen = prefixString.length();

        Map<String, Integer> scores = new HashMap<>();

        for(int i = 0; i < textLen; i++) {
            for(int j = i+1; j <= textLen; j++) {

                int prefixSum = 0;
                int suffixSum = 0;
                String sub = text.substring(i,j);
                int subLength = sub.length();

                logger.info("---------------------------------------------------------------");
                for(int k = 0; k < subLength; k++) {
                    if(k < prefixLen) {
                        logger.info("prefixString: " + sub + ", " + sub.substring(0,k+1) + " ? " + prefixString.substring(prefixLen-k-1, prefixLen));
                        if(sub.substring(0,k+1).equals(prefixString.substring(prefixLen-k-1, prefixLen))) {
                            prefixSum = Math.max(k+1,prefixSum);
                        }
                    }
                }
                logger.info("####################################################################");
                for(int k = 0; k < subLength; k++) {
                    if(subLength - k <= suffixLen) {
                        logger.info("suffixString: " + sub + ", " + sub.substring(k) + " ? " + suffixString.substring(0, subLength-k));
                        if(sub.substring(k).equals(suffixString.substring(0, subLength-k))) {
                            suffixSum = Math.max(subLength-k, suffixSum);
                        }
                    }
                }

                if(scores.containsKey(sub)) {
                    scores.put(sub, Math.max(scores.get(sub), prefixSum + suffixSum));
                } else {
                    scores.put(sub, prefixSum + suffixSum);
                }
            }
        }

        final LinkedHashMap<String, Integer> results = scores.entrySet().stream()
                .sorted(Collections
                        .reverseOrder(
                                Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));


        logger.info(String.valueOf(results));

        return new SimpleImmutableEntry<>(results.entrySet().stream().iterator().next());
    }


}
