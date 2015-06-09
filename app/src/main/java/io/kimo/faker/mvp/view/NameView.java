package io.kimo.faker.mvp.view;

import io.kimo.faker.mvp.View;

public interface NameView extends View {
    void updateCompleteNameExample(String value);
    void updateFullNameExample(String value);
    void updateFirstNameExample(String value);
    void updateLastNameExample(String value);
    void updatePrefixExample(String value);
    void updateSuffixExample(String value);
    void updateTitleExample(String value);
}
