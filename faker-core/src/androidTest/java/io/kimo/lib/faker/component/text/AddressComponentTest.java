package io.kimo.lib.faker.component.text;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.kimo.lib.faker.R;

public class AddressComponentTest extends AndroidTestCase {

    private AddressComponent addressComponent;
    private List<String> firstNames, lastNames, cityPrefixes, citySuffixes, streetSuffixes, secondaryAddressPrefixes, timezones, states, statesAbbrv, countries, countriesAbbrv;

    @Before
    public void setUp() throws Exception {
        addressComponent = new AddressComponent(getContext());

        firstNames = Arrays.asList(getContext().getResources().getStringArray(R.array.first_names));
        lastNames = Arrays.asList(getContext().getResources().getStringArray(R.array.last_names));
        cityPrefixes = Arrays.asList(getContext().getResources().getStringArray(R.array.city_prefixes));
        citySuffixes = Arrays.asList(getContext().getResources().getStringArray(R.array.city_suffixes));
        streetSuffixes = Arrays.asList(getContext().getResources().getStringArray(R.array.street_suffixes));
        secondaryAddressPrefixes = Arrays.asList(getContext().getResources().getStringArray(R.array.secondary_address_prefixes));
        timezones = Arrays.asList(getContext().getResources().getStringArray(R.array.timezone));
        states = Arrays.asList(getContext().getResources().getStringArray(R.array.states));
        statesAbbrv = Arrays.asList(getContext().getResources().getStringArray(R.array.states_abbrv));
        countries = Arrays.asList(getContext().getResources().getStringArray(R.array.countries));
        countriesAbbrv = Arrays.asList(getContext().getResources().getStringArray(R.array.countries_abbrv));
    }

    @Test
    public void testCity() throws Exception {

        String city = addressComponent.city();

        boolean containsFirstName = false;
        boolean containsLastName = false;

        for (String firstName : firstNames) {
            if (city.contains(firstName)) {
                containsFirstName = true;
            }
        }

        for (String lastName : lastNames) {
            if (city.contains(lastName)) {
                containsLastName = true;
            }
        }

        assertTrue(containsFirstName || containsLastName);
    }

    @Test
    public void testStreet() throws Exception {
        String streetName = addressComponent.street();

        boolean containsFirstName = false;
        boolean containsLastName = false;
        boolean containsStreetSuffix = false;

        for(String firstName : firstNames) {
            if(streetName.contains(firstName)) {
                containsFirstName = true;
            }
        }

        for(String lastName : lastNames) {
            if(streetName.contains(lastName)) {
                containsLastName = true;
            }
        }

        for(String streetSuffix : streetSuffixes) {
            if(streetName.contains(streetSuffix)) {
                containsStreetSuffix = true;
            }
        }

        assertTrue( containsFirstName || containsLastName );
        assertTrue( containsStreetSuffix );
    }

    @Test
    public void testStreetWithNumber() throws Exception {
        String streetNameWithNumber = addressComponent.streetWithNumber();

        assertTrue(streetNameWithNumber.matches("\\d+ .+"));
    }

    @Test
    public void testSecondaryAddress() throws Exception {
        String secondaryAddress = addressComponent.secondaryAddress();

        boolean containsSecondaryAddressPrefix = false;

        for(String secondaryAddressPrefix : secondaryAddressPrefixes) {
            if(secondaryAddress.contains(secondaryAddressPrefix)) {
                containsSecondaryAddressPrefix = true;
            }
        }

        assertTrue(containsSecondaryAddressPrefix);
    }

    @Test
    public void testBuildingNumber() throws Exception {
        String buildingNumber = addressComponent.buildingNumber();

        assertTrue(buildingNumber.matches("\\d+"));
    }

    @Test
    public void testZipCodeAndPostCode() throws Exception {
        String zipCode = addressComponent.zipCode();
        String postCode = addressComponent.postCode();

        assertTrue(zipCode.matches("\\d{5}") || zipCode.matches("\\d{5}-\\d{4}"));
        assertTrue(postCode.matches("\\d{5}") || postCode.matches("\\d{5}-\\d{4}"));
    }

    @Test
    public void testTimeZone() throws Exception {
        String randomTimezone = addressComponent.timeZone();

        boolean containsTimezone = false;

        for(String timezone : timezones) {
            if(randomTimezone.equals(timezone)) {
                containsTimezone = true;
            }
        }

        assertTrue(containsTimezone);
    }

    @Test
    public void testCitySuffix() throws Exception {
        for(int i = 0 ; i < 1000; i++) {
            assertTrue(citySuffixes.contains(addressComponent.citySuffix()));
        }
    }

    @Test
    public void testCityPrefix() throws Exception {
        for(int i = 0; i < 1000; i++) {
            assertTrue(cityPrefixes.contains(addressComponent.cityPrefix()));
        }
    }

    @Test
    public void testState() throws Exception {
        String randomState = addressComponent.state();

        boolean containsState = false;

        for(String state : states) {
            if(randomState.equals(state)) {
                containsState = true;
            }
        }

        assertTrue(containsState);
    }

    @Test
    public void testStateAbbreviation() throws Exception {
        String randomStateAbbrv = addressComponent.stateAbbreviation();

        boolean containsStateAbbrv = false;

        for(String abbrv : statesAbbrv) {
            if(randomStateAbbrv.equals(abbrv)) {
                containsStateAbbrv = true;
            }
        }

        assertTrue(containsStateAbbrv);
    }

    @Test
    public void testCountry() throws Exception {
        String randomCountry = addressComponent.country();

        boolean containsContry = false;

        for(String country : countries) {
            if(randomCountry.equals(country)) {
                containsContry = true;
            }
        }

        assertTrue(containsContry);
    }

    @Test
    public void testCountryAbbreviation() throws Exception {
        String randomCountryAbbrv = addressComponent.countryAbbreviation();

        boolean containsCountryAbbrv = false;

        for(String countryAbbrv : countriesAbbrv) {
            if(randomCountryAbbrv.equals(countryAbbrv)) {
                containsCountryAbbrv = true;
            }
        }

        assertTrue(containsCountryAbbrv);
    }

    @Test
    public void testLatitudeAndLongitude() throws Exception {
        try {
            Double.parseDouble(addressComponent.latitude());
            Double.parseDouble(addressComponent.longitude());
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void testRandomText() throws Exception {
        assertTrue(addressComponent.randomText() instanceof String);
    }
}