package io.kimo.lib.faker.component.text;

import android.test.AndroidTestCase;
import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.kimo.lib.faker.R;
import io.kimo.lib.faker.component.text.LoremComponent;

public class LoremComponentTest extends AndroidTestCase {

    private LoremComponent loremComponent;
    private List<String> loremWords;
    private int positiveRandom;
    private String alphaNumericRegex = "^[a-zA-Z0-9]*$";

    @Before
    public void setUp() throws Exception {
        loremComponent = new LoremComponent(getContext());
        loremWords = Arrays.asList(getContext().getResources().getStringArray(R.array.lorem_words));
        positiveRandom = new Random().nextInt(31) + 1;
    }

    @Test
    public void testWord() throws Exception {
        assertTrue(loremWords.contains(loremComponent.word()));
    }

    @Test
    public void testWords() throws Exception {
        List<String> randomWords = Arrays.asList(loremComponent.words().split(" "));

        for(String word : randomWords) {
            assertTrue(loremWords.contains(word));
        }
    }

    @Test
    public void testWordsWithArguments() throws Exception {
        List<String> randomWords = Arrays.asList(loremComponent.words(positiveRandom).split(" "));

        assertTrue(randomWords.size() == positiveRandom);
    }

    @Test
    public void testWordsWithInvalidArguments() throws Exception {
        try {
            loremComponent.words(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSentence() throws Exception {
        String randomSentence = loremComponent.sentence();

        char firstCharacter = randomSentence.charAt(0);
        char lastCharacter = randomSentence.charAt(randomSentence.length()-1);

        assertTrue(Character.isUpperCase(firstCharacter));
        assertTrue(lastCharacter == '.');
    }

    @Test
    public void testSentences() throws Exception {
        String randomSentences = loremComponent.sentences();

        assertTrue(randomSentences.split("\\. ").length > 1);
    }

    @Test
    public void testSentencesWithArguments() throws Exception{
        List<String> randomSentences = Arrays.asList(loremComponent.sentences(positiveRandom).split("\\."));

        assertTrue(randomSentences.size() == positiveRandom);
    }

    @Test
    public void testSentencesWithInvalidArguments() throws Exception{
        try {
            loremComponent.sentences(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCharacter() throws Exception {
        String randomCharacter = loremComponent.character();

        assertTrue(randomCharacter.length() == 1);
        assertTrue(randomCharacter.matches(alphaNumericRegex));
    }

    @Test
    public void testCharacters() throws Exception {
        String randomCharacters = loremComponent.characters();

        assertTrue(randomCharacters.length() == 255);
        assertTrue(randomCharacters.matches(alphaNumericRegex));
    }

    @Test
    public void testCharactersWithArguments() throws Exception {
        String randomCharacters = loremComponent.characters(positiveRandom);
        assertTrue(randomCharacters.length() == positiveRandom);
    }

    @Test
    public void testCharactersInvalidArguments() throws Exception {
        try {
            loremComponent.characters(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testParagraph() throws Exception {
        String paragraph = loremComponent.paragraph();

        String [] numberOfSentences = paragraph.split("\\. ");

        assertTrue(numberOfSentences.length >= 3);
    }

    @Test
    public void testParagraphs() throws Exception {
        String paragraphs = loremComponent.paragraphs();

        assertTrue(paragraphs.contains("\n"));
    }

    @Test
    public void testParagraphsWithArguments() throws Exception {
        String paragraphs = loremComponent.paragraphs(positiveRandom);

        int numberOfWhiteLines = paragraphs.split("\n").length;

        assertTrue(numberOfWhiteLines == positiveRandom);
    }

    @Test
    public  void testParagraphsWithInvalidArguments() throws Exception {
        try {
            loremComponent.paragraphs(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testRandomText() throws Exception {
        assertTrue(!TextUtils.isEmpty(loremComponent.randomText()));
    }
}