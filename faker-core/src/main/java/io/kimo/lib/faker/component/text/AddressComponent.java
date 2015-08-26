package io.kimo.lib.faker.component.text;

import android.content.Context;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.kimo.lib.faker.R;
import io.kimo.lib.faker.api.AddressAPI;
import io.kimo.lib.faker.component.FakerTextComponent;
import io.kimo.lib.faker.component.number.NumberComponent;

public class AddressComponent extends FakerTextComponent implements AddressAPI {

    private NameComponent nameComponent;
    private NumberComponent numberComponent;
    private List<String> cityPrefixes, citySuffixes, streetSuffixes, secondaryAddressPrefixes, zipCodeMasks, timezones, states, statesAbbrv, countries, countriesAbbrv;

    public AddressComponent(Context context) {
        super(context);
        nameComponent = new NameComponent(context);
        numberComponent = new NumberComponent(context);
        cityPrefixes = Arrays.asList(context.getResources().getStringArray(R.array.city_prefixes));
        citySuffixes = Arrays.asList(context.getResources().getStringArray(R.array.city_suffixes));
        streetSuffixes = Arrays.asList(context.getResources().getStringArray(R.array.street_suffixes));
        secondaryAddressPrefixes = Arrays.asList(context.getResources().getStringArray(R.array.secondary_address_prefixes));
        zipCodeMasks = Arrays.asList(context.getResources().getStringArray(R.array.zipcode_masks));
        timezones = Arrays.asList(context.getResources().getStringArray(R.array.timezone));
        states = Arrays.asList(context.getResources().getStringArray(R.array.states));
        statesAbbrv = Arrays.asList(context.getResources().getStringArray(R.array.states_abbrv));
        countries = Arrays.asList(context.getResources().getStringArray(R.array.countries));
        countriesAbbrv = Arrays.asList(context.getResources().getStringArray(R.array.countries_abbrv));
    }

    private String numbersInMask(String mask, char maskPlaceholder) {

        StringBuilder phoneInMask = new StringBuilder();
        for(int i = 0; i < mask.length(); i++) {

            char currentChar = mask.charAt(i);

            if(currentChar == maskPlaceholder) {
                phoneInMask.append(numberComponent.positiveDigit());
            } else {
                phoneInMask.append(currentChar);
            }
        }

        return phoneInMask.toString();
    }

    @Override
    public String city() {

        Random random = new Random();
        StringBuilder cityName = new StringBuilder();

        boolean withPrefix = random.nextBoolean();
        boolean withSuffix = random.nextBoolean();
        boolean withFirstName = random.nextBoolean();

        if(withPrefix) {
            cityName.append(cityPrefix());
        }

        cityName.append(" ");

        if(withFirstName) {
            cityName.append(nameComponent.firstName());
        } else {
            cityName.append(nameComponent.lastName());
        }

        if(withSuffix) {
            cityName.append(" ");
            cityName.append(citySuffix());
        }

        return cityName.toString();
    }

    @Override
    public String street() {
        boolean firstName = new Random().nextBoolean();

        if(firstName) {
            return nameComponent.firstName() + " " + streetSuffixes.get(new Random().nextInt(streetSuffixes.size()));
        } else {
            return nameComponent.lastName() + " " + streetSuffixes.get(new Random().nextInt(streetSuffixes.size()));
        }
    }

    @Override
    public String streetWithNumber() {
        return buildingNumber() + " " + street();
    }

    @Override
    public String secondaryAddress() {
        return secondaryAddressPrefixes.get(new Random().nextInt(secondaryAddressPrefixes.size())) + " " + buildingNumber();
    }

    @Override
    public String buildingNumber() {
        return numberComponent.positiveNumber()+"";
    }

    @Override
    public String zipCode() {
        String mask = zipCodeMasks.get(new Random().nextInt(zipCodeMasks.size()));
        return numbersInMask(mask, '#');
    }

    @Override
    public String postCode() {
        return zipCode();
    }

    @Override
    public String timeZone() {
        return timezones.get(new Random().nextInt(timezones.size()));
    }

    @Override
    public String citySuffix() {
        return citySuffixes.get(new Random().nextInt(citySuffixes.size()));
    }

    @Override
    public String cityPrefix() {
        return cityPrefixes.get(new Random().nextInt(cityPrefixes.size()));
    }

    @Override
    public String state() {
        return states.get(new Random().nextInt(states.size()));
    }

    @Override
    public String stateAbbreviation() {
        return statesAbbrv.get(new Random().nextInt(statesAbbrv.size()));
    }

    @Override
    public String country() {
        return countries.get(new Random().nextInt(countries.size()));
    }

    @Override
    public String countryAbbreviation() {
        return countriesAbbrv.get(new Random().nextInt(countriesAbbrv.size()));
    }

    @Override
    public String latitude() {
        return String.valueOf((Math.random() * 180) - 90);
    }

    @Override
    public String longitude() {
        return String.valueOf((Math.random() * 360) - 90);
    }

    @Override
    public String randomText() {

        int method = (int) Math.random() * 10;

        switch (method % 15) {
            case 0:
                return city();
            case 1:
                return street();
            case 2:
                return streetWithNumber();
            case 3:
                return secondaryAddress();
            case 4:
                return buildingNumber();
            case 5:
                return zipCode();
            case 6:
                return postCode();
            case 7:
                return citySuffix();
            case 8:
                return cityPrefix();
            case 9:
                return state();
            case 10:
                return stateAbbreviation();
            case 11:
                return country();
            case 12:
                return countryAbbreviation();
            case 13:
                return latitude();
            case 14:
                return longitude();
            default:
                return "";
        }

    }
}
