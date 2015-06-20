package io.kimo.faker.mvp.view;

import io.kimo.faker.mvp.View;

public interface InternetView extends View {
    void updateEmailExample(String value);
    void updateURLExample(String value);
    void updateDomainExample(String value);
    void updateDomainSuffixExample(String value);
}
