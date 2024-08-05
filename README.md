# Normalizing Jobs Titles Project

This project is responsible for making job titles more consistent by normalizing them and managing their generic representation.

## Class Overview

### NormalizingJobsTitles

Here's a quick overview of the `NormalizingJobsTitles` class:

#### Method Summary:

- `public String normalizedGenericTitle(final String genericTitle)`: Normalizes a given job title into its common form.
- `public void addJobsAndGenericTitles(final String normalizedJobTitle, final Set<String> genericTitles)`: Adds a new set of generic job titles for the given normalized job title.
- `public void addGenericsJobTitle(final String normalizedJobTitle, final String genericTitle)`: Adds a single generic title to the set for the given normalized job title.
- `public void removeAllGenericTitles(final String normalizedJobTitle)`: Removes all generic job titles associated with a given normalized job title.
- `public void removeGenericJobTitle(final String normalizedJobTitle, final String genericTitle)`: Removes a specific generic title from the set for the given normalized job title.
- `public void replaceAllGenericTitles(final String normalizedJobTitle, final Set<String> genericTitles)`: Replaces all existing generic titles with a new set of titles.
- `public Map<String, Set<String>> getJobsAndGenericTitles()`: Returns a Map of all normalized job titles and their associated sets of generic titles.
- There's a static map with some jobs and his generic titles to make the test easier. `"software engineer" -> ["java engineer", "c# engineer", "python engineer"]` and `"accountant" -> ["assistant accountant", "chief accountant"]`


## Test
![image](https://github.com/user-attachments/assets/8022579e-47dc-4af3-964a-02fc896a3108)

