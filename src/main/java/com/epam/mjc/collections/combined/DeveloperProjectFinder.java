package com.epam.mjc.collections.combined;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> developerProjects = new ArrayList<>();

        for (Map.Entry<String, Set<String>> entry : projects.entrySet()) {
            String projectName = entry.getKey();
            Set<String> developers = entry.getValue();

            if (developers.contains(developer)) {
                developerProjects.add(projectName);
            }
        }

        developerProjects.sort((p1, p2) -> {
            int result = Integer.compare(p2.length(), p1.length());
            if (result == 0) {
                return p2.compareTo(p1);
            }
            return result;
        });

        return developerProjects;
    }
}
