package io.kimo.lib.faker.component;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.kimo.lib.faker.R;

public class NameTest extends AndroidTestCase {

    private Name name;
    private List<String> firstNames, lastNames, prefixes, suffixes, titleDescriptions, titleLevels, titleJobs;

    @Before
    public void setUp() throws Exception {
        name = new Name(getContext());
        firstNames = Arrays.asList(getContext().getResources().getStringArray(R.array.first_names));
        lastNames = Arrays.asList(getContext().getResources().getStringArray(R.array.last_names));
        prefixes = Arrays.asList(getContext().getResources().getStringArray(R.array.prefixes));
        suffixes = Arrays.asList(getContext().getResources().getStringArray(R.array.suffixes));
        titleDescriptions = Arrays.asList(getContext().getResources().getStringArray(R.array.title_descriptions));
        titleLevels = Arrays.asList(getContext().getResources().getStringArray(R.array.title_levels));
        titleJobs = Arrays.asList(getContext().getResources().getStringArray(R.array.title_jobs));
    }

    @Test
    public void testFirstName() throws Exception {
        for (int i = 0; i < 1000; i++) {
            assertTrue(firstNames.contains(name.firstName()));
        }
    }

    @Test
    public void testLastName() throws Exception {
        for (int i = 0; i < 1000; i++) {
            assertTrue(lastNames.contains(name.lastName()));
        }
    }

    @Test
    public void testFullName() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String [] fullName = name.fullName().split(" ");
            String firstName = fullName[0];
            String lastName = fullName[1];

            assertTrue(firstNames.contains(firstName));
            assertTrue(lastNames.contains(lastName));
        }
    }

    @Test
    public void testCompleteName() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String [] fullName = name.completeName().split(" ");
            String prefix = fullName[0];
            String firstName = fullName[1];
            String lastName = fullName[2];
            String suffix = fullName[3];

            assertTrue(prefixes.contains(prefix));
            assertTrue(firstNames.contains(firstName));
            assertTrue(lastNames.contains(lastName));
            assertTrue(suffixes.contains(suffix));
        }
    }

    @Test
    public void testPrefix() throws Exception {
        for (int i = 0 ; i < 1000; i++) {
            assertTrue(prefixes.contains(name.prefix()));
        }
    }

    @Test
    public void testSuffix() throws Exception {
        for (int i = 0 ; i < 1000; i++) {
            assertTrue(suffixes.contains(name.suffix()));
        }
    }

    @Test
    public void testTitle() throws Exception {
        for (int i = 0 ; i < 1000; i++) {
            String [] fullTitle = name.title().split(" ");
            String description = fullTitle[0];
            String level = fullTitle[1];
            String job = fullTitle[2];

            assertTrue(titleDescriptions.contains(description));
            assertTrue(titleLevels.contains(level));
            assertTrue(titleJobs.contains(job));
        }
    }
}