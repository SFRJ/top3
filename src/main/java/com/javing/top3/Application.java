package com.javing.top3;

import java.util.*;

import static java.lang.System.lineSeparator;
import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class Application {

    public static String[] top3(final String input) {

        final String BLANK = " ";
        final String whitelist = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz'";

        if (input == null || input.equals(""))
            return new String[0];

        return stream(input
                .replace(lineSeparator(), BLANK)
                .replace("\r", BLANK)
                .toLowerCase().split(BLANK))
                .map(word -> stream(word.trim().split(""))
                        .filter(whitelist::contains).collect(joining()))
                .filter(word -> !word.isEmpty())
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .sorted(comparingByValue(reverseOrder()))
                .map(Map.Entry::getKey).limit(3).toArray(String[]::new);
    }

}
