package java_problems;

import org.json.JSONArray;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

@DisplayName("Solution Test Template")
public abstract class SolutionTestBase {

    protected static String PATH = "";

    private static void initPATH() {
        Class<?> clazz = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(frames -> Objects.requireNonNull(frames
                        .skip(2)
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

    protected static String[] readStringArray(String path) throws IOException {
        String content = Files.readString(Paths.get(getFullPath(path)));
        JSONArray jsonArray = new JSONArray(content);
        String[] array = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++)
            array[i] = jsonArray.getString(i);
        return array;
    }

    protected static Integer[][] readIntegerGrid(String path) throws IOException {
        String content = Files.readString(Paths.get(getFullPath(path))).trim();
        String[] rows = content.substring(2, content.length() - 2).split("],\\[");
        Integer[][] grid = new Integer[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            grid[i] = Arrays.stream(rows[i].split(",", -1))
                    .map(s -> s.isBlank() || s.equals("null") ? null : Integer.parseInt(s.trim()))
                    .toArray(Integer[]::new);
        }
        return grid;
    }

    protected static int[][] readIntGrid(String path) throws IOException {
        String content = Files.readString(Paths.get(getFullPath(path))).trim();
        String[] rows = content.substring(2, content.length() - 2).split("],\\[");
        int[][] grid = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            grid[i] = Arrays.stream(rows[i].split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return grid;
    }

    protected static int[] readIntArray(String path) throws IOException {
        String content = Files.readString(Paths.get(getFullPath(path))).trim();
        String raw = content.substring(1, content.length() - 1);
        String[] parts = raw.split(",");

        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String val = parts[i].trim();
            result[i] = Integer.parseInt(val);
        }
        return result;
    }

    protected static Integer[] readIntegerArray(String path) throws IOException {
        String content = Files.readString(Paths.get(getFullPath(path))).trim();
        String raw = content.substring(1, content.length() - 1);
        String[] parts = raw.split(",");

        Integer[] result = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String val = parts[i].trim();
            result[i] = val.equals("null") ? null : Integer.parseInt(val);
        }
        return result;
    }

}