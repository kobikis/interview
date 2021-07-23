package org.interview;

import org.interview.score.TextScore;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.logging.Logger;


public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        TextScore textScore = new TextScore();
//        SimpleImmutableEntry<String, Integer> match = textScore.score("engine", "raven", "ginkgo");
        SimpleImmutableEntry<String, Integer> match = textScore.score("nothing", "bruno", "ingenious");
//        SimpleImmutableEntry<String, Integer> match = textScore.score("ab", "b", "a");

        logger.info("matched string: " + match.getKey() + ", score: " + match.getValue() );
    }

}
