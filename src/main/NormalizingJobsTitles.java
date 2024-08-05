package main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NormalizingJobsTitles {
    private static final Map<String, Set<String>> jobsAndGenericTitles =
            Stream.of(
                    new AbstractMap.SimpleEntry<>("software engineer", new HashSet<>(Arrays.asList("java engineer", "c# engineer", "python engineer"))),
                    new AbstractMap.SimpleEntry<>("accountant",  new HashSet<>(Arrays.asList("assistant accountant", "chief accountant")))
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public String normalizedGenericTitle(final String genericTitle) {
        return jobsAndGenericTitles.entrySet().stream()
                .filter(normalizedJobTitle -> normalizedJobTitle.getKey().equals(genericTitle.toLowerCase(Locale.US))
                        || normalizedJobTitle.getValue().contains(genericTitle.toLowerCase(Locale.US)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found a normalizing job for " + genericTitle))
                .getKey();
    }

    public void addJobsAndGenericTitles(final String normalizedJobTitle, final Set<String> genericTitles) {
        toValidateJobKeyNotEmpty(normalizedJobTitle);
        jobsAndGenericTitles.put(normalizedJobTitle.toLowerCase(Locale.US), getGenericTitlesLowerCase(genericTitles));
    }

    private Set<String> getGenericTitlesLowerCase(Set<String> genericTitles) {
        return genericTitles.stream()
                .map(genericTitle -> genericTitle.toLowerCase(Locale.US))
                .peek(this::toValidateGenericTitle)
                .collect(Collectors.toSet());
    }

    public void addGenericJobTitle(final String normalizedJobTitle, final String genericTitle) {
        toValidateJobKey(normalizedJobTitle);
        toValidateGenericTitle(genericTitle);
        jobsAndGenericTitles.get(normalizedJobTitle.toLowerCase(Locale.US)).add(genericTitle.toLowerCase(Locale.US));
    }

    public void removeAllGenericTitles(final String normalizedJobTitle) {
        toValidateJobKey(normalizedJobTitle);
        jobsAndGenericTitles.get(normalizedJobTitle.toLowerCase(Locale.US)).clear();
    }

    public void removeGenericJobTitle(final String normalizedJobTitle, final String genericTitle) {
        toValidateJobKey(normalizedJobTitle);
        toValidateGenericTitle(genericTitle);
        jobsAndGenericTitles.get(normalizedJobTitle.toLowerCase(Locale.US)).remove(genericTitle.toLowerCase(Locale.US));
    }

    public void replaceAllGenericTitles(final String normalizedJobTitle, final Set<String> genericTitles) {
        toValidateJobKey(normalizedJobTitle);
        jobsAndGenericTitles.replace(normalizedJobTitle.toLowerCase(Locale.US), getGenericTitlesLowerCase(genericTitles));
    }

    private void toValidateJobKey(final String normalizedJobTitle) {
        toValidateJobKeyNotEmpty(normalizedJobTitle);
        if(!jobsAndGenericTitles.containsKey(normalizedJobTitle.toLowerCase(Locale.US))) {
            throw new IllegalArgumentException("The job: " + normalizedJobTitle + " does not exist in the dictionary");
        }
    }

    private void toValidateJobKeyNotEmpty(final String normalizedJobTitle) {
        if(Objects.isNull(normalizedJobTitle) || normalizedJobTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("The job normalized cannot to be empty");
        }
    }

    private void toValidateGenericTitle(final String genericTitle) {
        if(Objects.isNull(genericTitle) || genericTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("The generic title does not to be empty");
        }
    }

    public Map<String, Set<String>> getJobsAndGenericTitles() {
        return jobsAndGenericTitles;
    }
}
