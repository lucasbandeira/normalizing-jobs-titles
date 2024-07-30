package test;

import main.NormalizingJobsTitles;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.*;

public class NormalizingJobsTitlesTest {
    private NormalizingJobsTitles normalizer;

    @Before
    public void setup() {
        normalizer = new NormalizingJobsTitles();
    }

    @Test
    public void testNormalizedGenericTitle() {
        String normalizedTitle = "software engineer";
        String resultWithNormalizedTitle = normalizer.normalizedGenericTitle(normalizedTitle);
        assertEquals(normalizedTitle, resultWithNormalizedTitle);

        String genericTitle = "java engineer";
        String resultWithGenericTitle = normalizer.normalizedGenericTitle(genericTitle);
        assertEquals(normalizedTitle, resultWithGenericTitle);
    }

    @Test
    public void testAddJobsAndGenericTitles() {
        String normalizedJobTitle = "professor";
        Set<String> genericTitles = new HashSet<>(Arrays.asList("math professor", "english professor"));
        normalizer.addJobsAndGenericTitles(normalizedJobTitle, genericTitles);

        assertTrue(normalizer.getJobsAndGenericTitles().get(normalizedJobTitle)
                .containsAll(Arrays.asList("math professor", "english professor")));
    }

    @Test
    public void testRemoveAllGenericTitles() {
        String normalizedJobTitle = "professor";
        normalizer.removeAllGenericTitles(normalizedJobTitle);

        assertTrue(normalizer.getJobsAndGenericTitles().get(normalizedJobTitle).isEmpty());
    }

    @Test
    public void testRemoveTitleFromDictionary() {
        String normalizedJobTitle = "professor";
        String genericTitle = "math professor";
        normalizer.removeTitleFromDictionary(normalizedJobTitle, genericTitle);

        assertFalse(normalizer.getJobsAndGenericTitles().get(normalizedJobTitle)
                .contains(genericTitle));
    }

    @Test
    public void testAddGenericsJobTitleToDictionary() {
        String normalizedJobTitle = "professor";
        String genericTitle = "math professor";
        normalizer.addGenericsJobTitleToDictionary(normalizedJobTitle, genericTitle);

        assertTrue(normalizer.getJobsAndGenericTitles().get(normalizedJobTitle)
                .contains(genericTitle));
    }

    @Test
    public void testReplaceAllGenericTitles() {
        String normalizedJobTitle = "professor";
        Set<String> genericTitles = new HashSet<>(Arrays.asList("math professor", "portuguese professor"));
        normalizer.replaceAllGenericTitles(normalizedJobTitle, genericTitles);

        assertEquals(genericTitles, normalizer.getJobsAndGenericTitles().get(normalizedJobTitle));
    }

}
