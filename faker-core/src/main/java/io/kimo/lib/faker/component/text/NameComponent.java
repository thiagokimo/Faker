package io.kimo.lib.faker.component.text;

import android.content.Context;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.kimo.lib.faker.R;
import io.kimo.lib.faker.component.FakerTextComponent;

public class NameComponent extends FakerTextComponent {

    private List<String> firstNames, lastNames, prefixes, suffixes, titleDescriptons, titleLevels, titleJobs;

    public NameComponent(Context context) {
        super(context);
        firstNames = Arrays.asList(context.getResources().getStringArray(R.array.first_names));
        lastNames = Arrays.asList(context.getResources().getStringArray(R.array.last_names));
        prefixes = Arrays.asList(context.getResources().getStringArray(R.array.prefixes));
        suffixes = Arrays.asList(context.getResources().getStringArray(R.array.suffixes));
        titleDescriptons = Arrays.asList(context.getResources().getStringArray(R.array.title_descriptions));
        titleLevels = Arrays.asList(context.getResources().getStringArray(R.array.title_levels));
        titleJobs = Arrays.asList(context.getResources().getStringArray(R.array.title_jobs));
    }

    @Override
    public String randomText() {
        int method = (int)(Math.random() * 10);

        switch (method % 7) {
            case 0:
                return firstName();
            case 1:
                return lastName();
            case 2:
                return fullName();
            case 3:
                return completeName();
            case 4:
                return prefix();
            case 5:
                return suffix();
            case 6:
                return title();
            default:
                return "";
        }


    }

    public String firstName() {
        return firstNames.get(new Random().nextInt(firstNames.size()));
    }

    public String lastName() {
        return lastNames.get(new Random().nextInt(lastNames.size()));
    }

    public String fullName() {
        return firstName() + " " + lastName();
    }

    public String completeName() {
        return prefix() + " " + firstName() + " " + lastName() + " " + suffix();
    }

    public String prefix() {
        return prefixes.get(new Random().nextInt(prefixes.size()));
    }

    public String suffix() {
        return suffixes.get(new Random().nextInt(suffixes.size()));
    }

    public String title() {
        return titleDescriptons.get(new Random().nextInt(titleDescriptons.size())) +
                " " +
                titleLevels.get(new Random().nextInt(titleLevels.size())) +
                " " +
                titleJobs.get(new Random().nextInt(titleJobs.size()));
    }
}
