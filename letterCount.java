import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class letterCount {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        Map<Character, Integer> occurrences = letterCount(path);

        // Output the counts for each letter in descending order
        occurrences.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue() + " occurrences"));
    }

    public static Map<Character, Integer> letterCount(String directoryPath) {
        Map<Character, Integer> occurrences = new HashMap<>();

        // Initialize the map with letters a-z
        for (char c = 'a'; c <= 'z'; c++) {
            occurrences.put(c, 0);
        }

        // Get all JavaScript/TypeScript files in the directory
        try (Stream<Path> filePathStream = Files.walk(Paths.get(directoryPath))) {
            List<Path> jsTsFiles = filePathStream
                    .filter(Files::isRegularFile)
                    .filter(file -> file.toString().endsWith(".js") || file.toString().endsWith(".ts"))
                    .collect(Collectors.toList());

            for (Path file : jsTsFiles) {
                try {
                    String text = new String(Files.readAllBytes(file));

                    // Count the occurrences of each letter
                    for (char c : text.toCharArray()) {
                        char lowerChar = Character.toLowerCase(c);
                        if (occurrences.containsKey(lowerChar)) {
                            occurrences.put(lowerChar, occurrences.get(lowerChar) + 1);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error: The file could not be read.");
                    System.out.println("Exception Message: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Directory traversal failed.");
            System.out.println("Exception Message: " + e.getMessage());
        }

        return occurrences;
    }
}