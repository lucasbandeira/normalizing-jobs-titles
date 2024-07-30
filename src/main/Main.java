package main;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        NormalizingJobsTitles normalizingJobsTitles = new NormalizingJobsTitles();

        System.out.println(normalizingJobsTitles.normalizedGenericTitle("Java engineer"));
        normalizingJobsTitles.addGenericsJobTitleToDictionary("software engineer", "kotlin engineer");
        normalizingJobsTitles.addJobsAndGenericTitles("professor", Set.of("math professor", "english professor"));
        normalizingJobsTitles.removeAllGenericTitles("accountant");
        normalizingJobsTitles.removeTitleFromDictionary("software engineer", "python engineer");
        normalizingJobsTitles.replaceAllGenericTitles("professor", Set.of("portuguese professor"));
        System.out.println(normalizingJobsTitles.getJobsAndGenericTitles());
    }

}
