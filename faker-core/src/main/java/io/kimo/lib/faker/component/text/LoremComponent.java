package io.kimo.lib.faker.component.text;

import android.content.Context;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.kimo.lib.faker.R;
import io.kimo.lib.faker.api.LoremAPI;
import io.kimo.lib.faker.component.FakerTextComponent;

public class LoremComponent extends FakerTextComponent implements LoremAPI {

    public static final int [] DEFAULT_RANDOM_NUMBERS_POOL = {3,4,5,6,7};
    public static final int DEFAULT_NUMBER_OF_CHARACTERS = 255;
    public static final String ALPHA_NUMERIC_CHARACTERS = "0123456789abcdefghijklmnopqrstuwvxyz";

    public static final String INVALID_ARGUMENT_ERROR_MSG = "Argument should be bigger than 0";

    private List<String> loremWords;

    public LoremComponent(Context context) {
        super(context);
        loremWords = Arrays.asList(context.getResources().getStringArray(R.array.lorem_words));
    }

    @Override
    public String randomText() {

        int method = (int)(Math.random() * 10);

        switch (method % 4) {
            case 0:
                return characters();
            case 1:
                return words();
            case 2:
                return sentences();
            case 3:
                return paragraphs();
            default:
                return "";
        }
    }

    /**
     * Provides a random words from the words list
     * @return a String with the word
     */
    @Override
    public String word() {
        return loremWords.get(new Random().nextInt(loremWords.size()));
    }

    /**
     * Provies random words from the words list.
     * The amount of words varies from 3 to 7.
     * @return a String with the words
     */
    @Override
    public String words() {
        int numberOfWords = DEFAULT_RANDOM_NUMBERS_POOL[new Random().nextInt(DEFAULT_RANDOM_NUMBERS_POOL.length)];
        return words(numberOfWords);
    }

    /**
     * Provides the
     * @param numberOfWords
     * @return a String with the words
     */
    @Override
    public String words(int numberOfWords) {

        if (numberOfWords < 1) {
            throw new IllegalArgumentException(INVALID_ARGUMENT_ERROR_MSG);
        }

        List<String> loremWords = new ArrayList<>();

        for(int i = 0; i < numberOfWords; i++) {
            loremWords.add(word());
        }

        return TextUtils.join(" ", loremWords);
    }

    @Override
    public String sentence() {
        String randomWords = words();
        return randomWords.substring(0,1).toUpperCase() + randomWords.substring(1) + ".";
    }

    @Override
    public String sentences() {
        int randomNumberOfSentences = DEFAULT_RANDOM_NUMBERS_POOL[new Random().nextInt(DEFAULT_RANDOM_NUMBERS_POOL.length)];
        return sentences(randomNumberOfSentences);
    }

    @Override
    public String sentences(int numberOfSentences) {

        if (numberOfSentences < 1) {
            throw new IllegalArgumentException(INVALID_ARGUMENT_ERROR_MSG);
        }

        List<String> sentences = new ArrayList<>();

        for(int i = 0; i < numberOfSentences; i++) {
            sentences.add(sentence());
        }

        return TextUtils.join(" ", sentences);
    }

    @Override
    public String character() {
        return characters(1);
    }

    @Override
    public String characters() {
        return characters(DEFAULT_NUMBER_OF_CHARACTERS);
    }

    @Override
    public String characters(int numberOfCharacters) {

        if(numberOfCharacters < 1) {
            throw new IllegalArgumentException(INVALID_ARGUMENT_ERROR_MSG);
        }

        StringBuilder randomCharacters = new StringBuilder();

        for(int i = 0; i < numberOfCharacters; i++) {
            randomCharacters.append(ALPHA_NUMERIC_CHARACTERS.charAt(new Random().nextInt(ALPHA_NUMERIC_CHARACTERS.length())));
        }

        return randomCharacters.toString();
    }

    @Override
    public String paragraph() {
        return paragraphs(1);
    }

    @Override
    public String paragraphs() {
        int randomNumberOfParagraphs = DEFAULT_RANDOM_NUMBERS_POOL[new Random().nextInt(DEFAULT_RANDOM_NUMBERS_POOL.length)];
        return paragraphs(randomNumberOfParagraphs);
    }

    @Override
    public String paragraphs(int numberOfParagraphs) {

        if(numberOfParagraphs < 1) {
            throw new IllegalArgumentException(INVALID_ARGUMENT_ERROR_MSG);
        }

        StringBuilder paragraphs = new StringBuilder();

        for(int i = 0; i < numberOfParagraphs; i++) {
            paragraphs.append(sentences());

            if(i != numberOfParagraphs-1) {
                paragraphs.append("\n");
            }
        }

        return paragraphs.toString();
    }
}
