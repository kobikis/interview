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

        int textLength = text.length();
        int suffixLength = suffixString.length();
        int prefixLength = prefixString.length();

        Map<String, Integer> scores = new HashMap<>();

        for(int i = 0; i < textLength; i++) {
            for(int j = i+1; j <= textLength; j++) {

                int prefixSum = 0;
                int suffixSum = 0;
                String sub = text.substring(i,j);
                int subLength = sub.length();

                for(int k = 0; k < subLength; k++) {
                    if(k < prefixLength) {
                        logger.finest("prefixString: " + sub + ", " + sub.substring(0,k+1) + " ? " + prefixString.substring(prefixLength-k-1, prefixLength));
                        if(sub.substring(0,k+1).equals(prefixString.substring(prefixLength-k-1, prefixLength))) {
                            prefixSum = Math.max(k+1,prefixSum);
                        }
                    }
                    if(subLength - k <= suffixLength) {
                        logger.finest("suffixString: " + sub + ", " + sub.substring(k) + " ? " + suffixString.substring(0, subLength-k));
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


        logger.finest(String.valueOf(results));

        return new SimpleImmutableEntry<>(results.entrySet().stream().iterator().next());
    }


}
