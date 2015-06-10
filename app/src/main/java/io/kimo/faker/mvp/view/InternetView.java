package io.kimo.faker.mvp.view;

import io.kimo.faker.mvp.View;

public interface InternetView extends View {
    void updateEmail(String value);
    void updateURL(String value);
    void updateDomain(String value);
    void updateDomainSuffix(String value);
}
