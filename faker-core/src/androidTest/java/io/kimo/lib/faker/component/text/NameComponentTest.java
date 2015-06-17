package io.kimo.lib.faker.component.text;

import android.test.AndroidTestCase;
import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.kimo.lib.faker.R;
import io.kimo.lib.faker.component.text.NameComponent;

public class NameComponentTest extends AndroidTestCase {

    private NameComponent nameComponent;
    private List<String> firstNames, lastNames, prefixes, suffixes, titleDescriptions, titleLevels, titleJobs;

    @Before
    public void setUp() throws Exception {
        nameComponent = new NameComponent(getContext());
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
            assertTrue(firstNames.contains(nameComponent.firstName()));
        }
    }

    @Test
    public void testLastName() throws Exception {
        for (int i = 0; i < 1000; i++) {
            assertTrue(lastNames.contains(nameComponent.lastName()));
        }
    }

    @Test
    public void testFullName() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String [] fullName = nameComponent.fullName().split(" ");
            String firstName = fullName[0];
            String lastName = fullName[1];

            assertTrue(firstNames.contains(firstName));
            assertTrue(lastNames.contains(lastName));
        }
    }

    @Test
    public void testCompleteName() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String [] fullName = nameComponent.completeName().split(" ");
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
            assertTrue(prefixes.contains(nameComponent.prefix()));
        }
    }

    @Test
    public void testSuffix() throws Exception {
        for (int i = 0 ; i < 1000; i++) {
            assertTrue(suffixes.contains(nameComponent.suffix()));
        }
    }

    @Test
    public void testTitle() throws Exception {
        for (int i = 0 ; i < 1000; i++) {
            String [] fullTitle = nameComponent.title().split(" ");
            String description = fullTitle[0];
            String level = fullTitle[1];
            String job = fullTitle[2];

            assertTrue(titleDescriptions.contains(description));
            assertTrue(titleLevels.contains(level));
            assertTrue(titleJobs.contains(job));
        }
    }

    @Test
    public void testRandomText() throws Exception {
        assertTrue(!TextUtils.isEmpty(nameComponent.randomText()));
    }
}