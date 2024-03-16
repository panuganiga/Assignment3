import java.util.*;

public class SearchIndex {
    private Map<String, List<String>> index;

    public SearchIndex() {
        this.index = new HashMap<>();
    }

    public void index(String word) {
        // Index the word
        String key = word.toLowerCase();
        index.putIfAbsent(key, new ArrayList<>());
        index.get(key).add(word);
    }

    public List<String> search(String keyword) {
        // Search for matching words
        return index.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }
}
