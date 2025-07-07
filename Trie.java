import java.util.ArrayList;
public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public ArrayList<String> getWordsWithPrefix(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toLowerCase().toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return new ArrayList<>();
            }
            current = current.children.get(ch);
        }

        ArrayList<String> results = new ArrayList<>();
        collectWords(current, prefix, results);
        return results;
    }

    private void collectWords(TrieNode node, String prefix, ArrayList<String> result) {
        if (node.isEndOfWord) result.add(prefix);

        for (char ch : node.children.keySet()) {
            collectWords(node.children.get(ch), prefix + ch, result);
        }
    }
}
