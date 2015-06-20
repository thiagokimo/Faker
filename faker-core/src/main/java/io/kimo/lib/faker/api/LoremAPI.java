package io.kimo.lib.faker.api;

public interface LoremAPI {

    String character();
    String characters();
    String characters(int numberOfCharacters);

    String word();
    String words();
    String words(int numberOfWords);

    String sentence();
    String sentences();
    String sentences(int numberOfSentences);

    String paragraph();
    String paragraphs();
    String paragraphs(int numberOfParagraphs);
}
