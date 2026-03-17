package java_problems;

import org.json.JSONArray;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@DisplayName("Solution Test Template")
public abstract class SolutionTestBase {

    protected static String PATH = "";

    private static void initPATH() {
        Class<?> clazz = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(frames -> Objects.requireNonNull(frames
                        .skip(3)
                        .filter(f -> !f.getDeclaringClass().equals(SolutionTestBase.class))
                        .findFirst()
                        .map(StackWalker.StackFrame::getDeclaringClass)
                        .orElse(null))
                );
        String s = clazz.getPackageName();
        String pathPart = (!s.contains("java_problems") ? "drafts/" : "") + "test/";
        pathPart += s.replace(".", "/") + "/";
        PATH = pathPart;
    }

    protected static String getFullPath(String path) {
        if (PATH.isEmpty()) initPATH();
        return PATH + path;
    }

    protected static String readFileAsString(String path) throws IOException {
        return Files.readString(Paths.get(getFullPath(path))).trim();
    }

    protected static String[] readStringArray(String path) throws IOException {
        String content = readFileAsString(path);
        JSONArray jsonArray = new JSONArray(content);
        String[] array = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++)
            array[i] = jsonArray.getString(i);
        return array;
    }

    protected static Integer[][] readIntegerGrid(String path) throws IOException {
        String content = readFileAsString(path);
        JSONArray jsonArray = new JSONArray(content);
        Integer[][] grid = new Integer[jsonArray.length()][];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray array = jsonArray.getJSONArray(i);
            Integer[] row = new Integer[array.length()];
            for (int j = 0; j < array.length(); j++)
                row[j] = array.optIntegerObject(j, null);
            grid[i] = row;
        }
        return grid;
    }

    protected static int[][] readIntGrid(String path) throws IOException {
        String content = readFileAsString(path);
        JSONArray jsonArray = new JSONArray(content);
        int[][] grid = new int[jsonArray.length()][];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray array = jsonArray.getJSONArray(i);
            int[] row = new int[array.length()];
            for (int j = 0; j < array.length(); j++)
                row[j] = array.getInt(j);
            grid[i] = row;
        }
        return grid;
    }

    protected static int[] readIntArray(String path) throws IOException {
        String content = readFileAsString(path);
        JSONArray jsonArray = new JSONArray(content);
        int[] result = new int[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++)
            result[i] = jsonArray.getInt(i);
        return result;
    }

    protected static Integer[] readIntegerArray(String path) throws IOException {
        String content = readFileAsString(path);
        JSONArray jsonArray = new JSONArray(content);
        Integer[] result = new Integer[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++)
            result[i] = jsonArray.optIntegerObject(i, null);
        return result;
    }

}