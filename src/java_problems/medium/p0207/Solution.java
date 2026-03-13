package java_problems.medium.p0207;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 207
 * Title: Course Schedule
 * Language: Java
 * Topic: Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort
 */
class Solution {

    private static class Course {
        private final List<Course> requirements;
        private boolean isOk;

        public Course() {
            requirements = new ArrayList<>();
            isOk = false;
        }

        void addRequirement(Course course) {
            requirements.add(course);
        }

        boolean check(List<Course> courses) {
            if (courses.contains(this)) return false;
            if (isOk) return true;
            courses.add(this);
            for (Course requirement : requirements) {
                if (!requirement.check(courses)) return false;
            }
            courses.remove(this);
            isOk = true;
            return true;
        }

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < courses.length; i++)
            courses[i] = new Course();
        for (int[] p : prerequisites)
            courses[p[0]].addRequirement(courses[p[1]]);
        for (Course course : courses)
            if (!course.check(new ArrayList<>())) return false;
        return true;
    }

}
