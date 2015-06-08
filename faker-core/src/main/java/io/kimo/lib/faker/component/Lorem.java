package io.kimo.lib.faker.component;

import android.content.Context;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.kimo.lib.faker.FakerCoreComponent;
import io.kimo.lib.faker.R;

public class Lorem extends FakerCoreComponent {

    public static final int [] DEFAULT_RANDOM_NUMBERS_POOL = {3,4,5,6,7};
    public static final int DEFAULT_NUMBER_OF_CHARACTERS = 255;
    public static final String ALPHA_NUMERIC_CHARACTERS = "0123456789abcdefghijklmnopqrstuwvxyz";

    private List<String> loremWords;

    public Lorem(Context context) {
        super(context);
        loremWords = Arrays.asList(context.getResources().getStringArray(R.array.lorem_words));
    }

    /**
     * Provides a random words from the words list
     * @return a String with the word
     */
    public String word() {
        return loremWords.get(new Random().nextInt(31));
    }

    /**
     * Provies random words from the words list.
     * The amount of words varies from 3 to 7.
     * @return a String with the words
     */
    public String words() {
        int numberOfWords = DEFAULT_RANDOM_NUMBERS_POOL[new Random().nextInt(DEFAULT_RANDOM_NUMBERS_POOL.length)];
        return words(numberOfWords);
    }

    /**
     * Provides the
     * @param numberOfWords
     * @return a String with the words
     */
    public String words(int numberOfWords) {

        if (numberOfWords < 1) {
            throw new IllegalArgumentException("Number of words must be bigger than 0.");
        }

        List<String> loremWords = new ArrayList<>();

        for(int i = 0; i < numberOfWords; i++) {
            loremWords.add(word());
        }

        return TextUtils.join(" ", loremWords);
    }

    public String sentence() {
        String randomWords = words();
        return randomWords.substring(0,1).toUpperCase() + randomWords.substring(1) + ".";
    }

    public String sentences() {
        int randomNumberOfSentences = DEFAULT_RANDOM_NUMBERS_POOL[new Random().nextInt(DEFAULT_RANDOM_NUMBERS_POOL.length)];
        return sentences(randomNumberOfSentences);
    }

    public String sentences(int numberOfSentences) {

        if (numberOfSentences < 1) {
            throw new IllegalArgumentException("Number of sentences must be bigger than 0.");
        }

        List<String> sentences = new ArrayList<>();

        for(int i = 0; i < numberOfSentences; i++) {
            sentences.add(sentence());
        }

        return TextUtils.join(" ", sentences);
    }

    public String character() {
        return characters(1);
    }

    public String characters() {
        return characters(DEFAULT_NUMBER_OF_CHARACTERS);
    }

    public String characters(int numberOfCharacters) {

        if(numberOfCharacters < 1) {
            throw new IllegalArgumentException("Number of characters must be higher than 0");
        }

        StringBuilder randomCharacters = new StringBuilder();

        for(int i = 0; i < numberOfCharacters; i++) {
            randomCharacters.append(ALPHA_NUMERIC_CHARACTERS.charAt(new Random().nextInt(ALPHA_NUMERIC_CHARACTERS.length())));
        }

        return randomCharacters.toString();
    }
}
