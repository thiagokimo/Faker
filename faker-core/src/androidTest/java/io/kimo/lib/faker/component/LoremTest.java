package io.kimo.lib.faker.component;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.kimo.lib.faker.R;

public class LoremTest extends AndroidTestCase {

    private Lorem lorem;
    private List<String> loremWords;
    private int positiveRandom = new Random().nextInt(31);
    private String alphaNumericRegex = "^[a-zA-Z0-9]*$";

    @Before
    public void setUp() throws Exception {
        lorem = new Lorem(getContext());
        loremWords = Arrays.asList(getContext().getResources().getStringArray(R.array.lorem_words));
    }

    @Test
    public void testWord() throws Exception {
        assertTrue(loremWords.contains(lorem.word()));
    }

    @Test
    public void testWords() throws Exception {
        List<String> randomWords = Arrays.asList(lorem.words().split(" "));

        for(String word : randomWords) {
            assertTrue(loremWords.contains(word));
        }
    }

    @Test
    public void testWordsWithArguments() throws Exception {
        List<String> randomWords = Arrays.asList(lorem.words(positiveRandom).split(" "));

        assertTrue(randomWords.size() == positiveRandom);
    }

    @Test
    public void testWordsWithInvalidArguments() throws Exception {
        try {
            lorem.words(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSentence() throws Exception {
        String randomSentence = lorem.sentence();

        char firstCharacter = randomSentence.charAt(0);
        char lastCharacter = randomSentence.charAt(randomSentence.length()-1);

        assertTrue(Character.isUpperCase(firstCharacter));
        assertTrue(lastCharacter == '.');
    }

    @Test
    public void testSentences() throws Exception {
        String randomSentences = lorem.sentences();

        assertTrue(randomSentences.split("\\. ").length > 1);
    }

    @Test
    public void testSentencesWithArguments() throws Exception{
        List<String> randomSentences = Arrays.asList(lorem.sentences(positiveRandom).split("\\."));

        assertTrue(randomSentences.size() == positiveRandom);
    }

    @Test
    public void testSentencesWithInvalidArguments() throws Exception{
        try {
            lorem.sentences(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCharacter() throws Exception {
        String randomCharacter = lorem.character();

        assertTrue(randomCharacter.length() == 1);
        assertTrue(randomCharacter.matches(alphaNumericRegex));
    }

    @Test
    public void testCharacters() throws Exception {
        String randomCharacters = lorem.characters();

        assertTrue(randomCharacters.length() == 255);
        assertTrue(randomCharacters.matches(alphaNumericRegex));
    }

    @Test
    public void testCharactersWithArguments() throws Exception {
        String randomCharacters = lorem.characters(positiveRandom);
        assertTrue(randomCharacters.length() == positiveRandom);
    }

    @Test
    public void testCharactersInvalidArguments() throws Exception {
        try {
            lorem.characters(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}