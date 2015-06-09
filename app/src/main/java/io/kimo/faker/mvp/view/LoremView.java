package io.kimo.faker.mvp.view;

import io.kimo.faker.mvp.View;

public interface LoremView extends View {

    void updateCharacterExample(String value);
    void updateCharactersExample(String value);

    void updateWordExample(String value);
    void updateWordsExample(String value);

    void updateSentenceExample(String value);
    void updateSentencesExample(String value);

    void updateParagraphExample(String value);
    void updateParagraphsExample(String value);
}
