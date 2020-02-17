package project1;

public final class StringUtilities {
    public static String capitalizeWords(String string) {
        String[] words = string.replaceAll("_", " ").toLowerCase().split("\\s");
        StringBuilder capitalizeWord = new StringBuilder();
        for (String word : words) {
            String first = word.substring(0, 1);
            String afterFirst = word.substring(1);
            capitalizeWord.append(first.toUpperCase()).append(afterFirst).append(" ");
        }
        return capitalizeWord.toString().trim();
    }
}
