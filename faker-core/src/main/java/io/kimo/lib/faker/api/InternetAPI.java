package io.kimo.lib.faker.api;

public interface InternetAPI {

    String email();
    String email(String name, String domain, String suffix);

    String domain();
    String domainSuffix();
    String domainSuffix(String suffix);

    String url();
    String url(String domain, String suffix);
}
