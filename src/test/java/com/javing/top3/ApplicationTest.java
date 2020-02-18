package com.javing.top3;

import org.junit.Test;

import static com.javing.top3.Application.top3;
import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    @Test
    public void anArrayOfThreeWords() {

        String[] result = top3("A B C");

        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("b");
        assertThat(result[2]).isEqualTo("c");
    }

    @Test
    public void onlyMostRepeatedWords() {

        String[] result = top3("A A A A B B B C D D");
        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("b");
        assertThat(result[2]).isEqualTo("d");

    }

    @Test
    public void sortedDescending() {
        String[] result = top3("A B B B C C D D D D");
        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("d");
        assertThat(result[1]).isEqualTo("b");
        assertThat(result[2]).isEqualTo("c");
    }

    @Test
    public void shortsAlphabeticallyForEqualCount() {
        String[] result = top3("A A B B D D C C");
        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("b");
        assertThat(result[2]).isEqualTo("c");
    }

    @Test
    public void ignoresFancyPunctuation() {
        String[] result = top3("A A A ; , , , , B C C");
        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("c");
        assertThat(result[2]).isEqualTo("b");

    }

    @Test
    public void respectsAppendedPunctuation() {
        String[] result = top3("A B C,");

        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("b");
        assertThat(result[2]).isEqualTo("c");
    }

    @Test
    public void ignoreNumbers() {
        String[] result = top3("A A A 1 2 2 B C C");
        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("c");
        assertThat(result[2]).isEqualTo("b");
    }

    @Test
    public void appostrophesAllowed() {
        String[] result = top3("' ; 1 2 2 , B C C");
        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("c");
        assertThat(result[1]).isEqualTo("b");
        assertThat(result[2]).isEqualTo("'");
    }

    @Test
    public void textTwoWords() {
        String[] result = top3("A B");

        assertThat(result.length).isEqualTo(2);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("b");
    }

    @Test
    public void textOneWords() {
        String[] result = top3("A");

        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualTo("a");
    }

    @Test
    public void textNoWords() {
        String[] result = top3(null);

        assertThat(result.length).isEqualTo(0);
    }

    @Test
    public void supportsNewLines() {
        String[] result = top3("A B" + lineSeparator() + "C C C D D A A A");
        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("c");
        assertThat(result[2]).isEqualTo("d");

    }

    @Test
    public void largeText() {
        String[] result = top3("In a village of La Mancha, the name of which I have no desire to call to" +
                "mind, there lived not long since one of those gentlemen that keep a lance" +
        "in the lance-rack, an old buckler, a lean hack, and a greyhound for" +
        "coursing. An olla of rather more beef than mutton, a salad on most" +
        "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra" +
        "on Sundays, made away with three-quarters of his income.");

        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("of");
        assertThat(result[2]).isEqualTo("on");
    }

    @Test
    public void ignoreAppendedFancyPunctuation() {
        String[] result = top3("/a /a b b c c c d");

        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("c");
        assertThat(result[1]).isEqualTo("a");
        assertThat(result[2]).isEqualTo("b");
    }

    @Test
    public void inputWithMixedCaseAndPunctuation() {
        String[] result = top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e");

        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("e");
        assertThat(result[1]).isEqualTo("ddd");
        assertThat(result[2]).isEqualTo("aa");
    }

    @Test
    public void edgeCaseWithApostropheAndBlanksAtBeggining() {
        String[] result = top3("  //wont won't won't");

        assertThat(result.length).isEqualTo(2);
        assertThat(result[0]).isEqualTo("won't");
        assertThat(result[1]).isEqualTo("wont");
    }

    @Test
    public void supportsSystemLineBreaks() {
        String[] result = top3("A A A" + lineSeparator() + "B B" + lineSeparator() + "C");

        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("b");
        assertThat(result[2]).isEqualTo("c");
    }

    @Test
    public void supportsRegexLineBreaks() {
        String[] result = top3("A A A\nB B\nC");

        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("b");
        assertThat(result[2]).isEqualTo("c");
    }

    @Test
    public void supportsRegexCarridgeReturn() {
        String[] result = top3("A A A\rB B\rC");

        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo("a");
        assertThat(result[1]).isEqualTo("b");
        assertThat(result[2]).isEqualTo("c");
    }
}
