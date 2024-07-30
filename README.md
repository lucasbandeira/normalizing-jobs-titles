# Normalizing Jobs Titles Project

This project is responsible for making job titles more consistent by normalizing them and managing their generic representation.

## Class Overview

### NormalizingJobsTitles

Here's a quick overview of the `NormalizingJobsTitles` class:

#### Method Summary:

- `public String normalizedGenericTitle(final String genericTitle)`: Normalizes a given job title into its common form.
- `public void addJobsAndGenericTitles(final String normalizedJobTitle, final Set<String> genericTitles)`: Adds a new set of generic job titles for the given normalized job title.
- `public void addGenericsJobTitleToDictionary(final String normalizedJobTitle, final String genericTitle)`: Adds a single generic title to the set for the given normalized job title.
- `public void removeAllGenericTitles(final String normalizedJobTitle)`: Removes all generic job titles associated with a given normalized job title.
- `public void removeTitleFromDictionary(final String normalizedJobTitle, final String genericTitle)`: Removes a specific generic title from the set for the given normalized job title.
- `public void replaceAllGenericTitles(final String normalizedJobTitle, final Set<String> genericTitles)`: Replaces all existing generic titles for a given normalized job title with a new set of titles.
- `public Map<String, Set<String>> getJobsAndGenericTitles()`: Returns a Map of all normalized job titles and their associated sets of generic titles.

## Test
![image](https://github.com/user-attachments/assets/a406d1b2-8a74-48ba-8e68-78de9a919419)
