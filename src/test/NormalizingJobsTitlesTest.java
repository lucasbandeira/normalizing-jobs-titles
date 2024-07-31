package test;

import main.NormalizingJobsTitles;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

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

    @Test(expected = IllegalArgumentException.class)
    public void testNormalizedGenericTitleThrowsException() {
        String invalidTitle = "invalid title";
        normalizer.normalizedGenericTitle(invalidTitle);
    }

    @Test
    public void testAddJobsAndGenericTitles() {
        String normalizedJobTitle = "professor";
        Set<String> genericTitles = new HashSet<>(Arrays.asList("math professor", "english professor"));
        normalizer.addJobsAndGenericTitles(normalizedJobTitle, genericTitles);

        assertTrue(normalizer.getJobsAndGenericTitles().get(normalizedJobTitle)
                .containsAll(Arrays.asList("math professor", "english professor")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddJobsAndGenericTitlesWithInvalidNormalizedJobTitle() {
        String invalidNormalizedJobTitle = "";
        Set<String> genericTitles = new HashSet<>(Arrays.asList("math professor", "english professor"));
        normalizer.addJobsAndGenericTitles(invalidNormalizedJobTitle, genericTitles);
    }

    @Test
    public void testRemoveAllGenericTitles() {
        String normalizedJobTitle = "professor";
        normalizer.removeAllGenericTitles(normalizedJobTitle);

        assertTrue(normalizer.getJobsAndGenericTitles().get(normalizedJobTitle).isEmpty());
    }

    @Test
    public void testRemoveGenericJobTitle() {
        String normalizedJobTitle = "professor";
        String genericTitle = "math professor";
        normalizer.removeGenericJobTitle(normalizedJobTitle, genericTitle);

        assertFalse(normalizer.getJobsAndGenericTitles().get(normalizedJobTitle)
                .contains(genericTitle));
    }

    @Test
    public void testAddGenericJobTitle() {
        String normalizedJobTitle = "professor";
        String genericTitle = "math professor";
        normalizer.addGenericJobTitle(normalizedJobTitle, genericTitle);

        assertTrue(normalizer.getJobsAndGenericTitles().get(normalizedJobTitle)
                .contains(genericTitle));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGenericJobTitleWithInvalidGenericJobTitle() {
        String normalizedJobTitle = "professor";
        String genericTitle = "";
        normalizer.addGenericJobTitle(normalizedJobTitle, genericTitle);
    }

    @Test
    public void testReplaceAllGenericTitlesWithInvalidGenericJob() {
        String normalizedJobTitle = "professor";
        Set<String> genericTitles = new HashSet<>(Arrays.asList("math professor", "portuguese professor"));
        normalizer.replaceAllGenericTitles(normalizedJobTitle, genericTitles);

        assertEquals(genericTitles, normalizer.getJobsAndGenericTitles().get(normalizedJobTitle));
    }

}
