package io.kimo.lib.faker.component.text;

import android.content.Context;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.kimo.lib.faker.R;
import io.kimo.lib.faker.component.FakerTextComponent;

public class InternetComponent extends FakerTextComponent {

    private NameComponent nameComponent;
    private List<String> domainSuffix;

    public InternetComponent(Context context) {
        super(context);
        nameComponent = new NameComponent(context);
        domainSuffix = Arrays.asList(context.getResources().getStringArray(R.array.domain_suffixes));
    }

    @Override
    public String randomText() {
        int method = (int)(Math.random() * 10);

        switch (method % 4) {
            case 0:
                return email();
            case 1:
                return domain();
            case 2:
                return domainSuffix();
            case 3:
                return url();
            default:
                return "";
        }
    }

    public String email() {
        return email(nameComponent.firstName(), domain(), domainSuffix());
    }

    public String email(String name, String domain, String domainSuffix) {
        return (name + "@" + domain + domainSuffix).toLowerCase();
    }

    public String domain() {
        return nameComponent.lastName().toLowerCase();
    }

    public String domainSuffix() {
        return domainSuffix(domainSuffix.get(new Random().nextInt(domainSuffix.size())));
    }

    public String domainSuffix(String suffix) {
        return "."+suffix;
    }

    public String url() {
        return url(nameComponent.lastName(), domainSuffix());
    }

    public String url(String domain, String domainSuffix) {
        return ("http://" + domain + domainSuffix).toLowerCase();
    }
}
