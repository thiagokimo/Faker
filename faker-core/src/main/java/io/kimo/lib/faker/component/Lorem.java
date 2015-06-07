package io.kimo.lib.faker.component;

import android.content.Context;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.kimo.lib.faker.FakerComponent;
import io.kimo.lib.faker.R;

public class Lorem extends FakerComponent {

    public int [] DEFAULT_RANDOM_NUMBERS_POOL = {3,4,5,6,7};

    private List<String> loremWords;

    public Lorem(Context context) {
        super(context);
        loremWords = Arrays.asList(context.getResources().getStringArray(R.array.lorem_words));
    }

    public String word() {
        return loremWords.get(new Random().nextInt(31));
    }

    public String words() {
        int numberOfWords = DEFAULT_RANDOM_NUMBERS_POOL[new Random().nextInt(DEFAULT_RANDOM_NUMBERS_POOL.length)];
        return words(numberOfWords);
    }

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
}
