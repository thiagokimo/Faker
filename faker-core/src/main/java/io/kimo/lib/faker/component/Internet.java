package io.kimo.lib.faker.component;

import android.content.Context;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.kimo.lib.faker.CoreComponent;
import io.kimo.lib.faker.R;

public class Internet extends CoreComponent {

    private Name name;
    private List<String> domainSuffix;

    public Internet(Context context) {
        super(context);
        name = new Name(context);
        domainSuffix = Arrays.asList(context.getResources().getStringArray(R.array.domain_suffixes));
    }

    public String email() {
        return email(name.firstName(), domain(), domainSuffix());
    }

    public String email(String name, String domain, String domainSuffix) {
        return (name + "@" + domain + domainSuffix).toLowerCase();
    }

    public String domain() {
        return name.lastName().toLowerCase();
    }

    public String domainSuffix() {
        return domainSuffix(domainSuffix.get(new Random().nextInt(domainSuffix.size())));
    }

    public String domainSuffix(String suffix) {
        return "."+suffix;
    }

    public String url() {
        return url(name.lastName(), domainSuffix());
    }

    public String url(String domain, String domainSuffix) {
        return ("http://" + domain + domainSuffix).toLowerCase();
    }
}
