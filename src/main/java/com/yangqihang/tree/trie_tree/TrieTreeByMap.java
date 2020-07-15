package com.yangqihang.tree.trie_tree;

import java.util.HashMap;

/**
 * 前缀树,使用 HashMap
 */
public class TrieTreeByMap {
    public static class Node {
        int pass;
        int end;
        HashMap<Integer, Node> nexts;

        public Node() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    public static class TrieTree {
        private Node root;

        public TrieTree() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null)
                return;
            char[] chars = word.toCharArray();
            Node node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (!node.nexts.containsKey(path))
                    node.nexts.put(path, new Node());
                node = node.nexts.get(path);
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                Node node = root;
                node.pass--;
                int path;
                for (int i = 0; i < chars.length; i++) {
                    path = chars[i] - 'a';
                    if (--node.nexts.get(path).pass == 0) {
                        node.nexts.remove(path);
                        return;
                    }
                    node = node.nexts.get(path);
                }
                node.end--;
            }
        }

        public int search(String word) {
            if (word == null)
                return 0;
            char[] chars = word.toCharArray();
            Node node = root;
            int path;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (!node.nexts.containsKey(path))
                    return 0;
                node = node.nexts.get(path);
            }
            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null)
                return 0;
            char[] chars = pre.toCharArray();
            Node node = root;
            int path;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (!node.nexts.containsKey(path))
                    return 0;
                node = node.nexts.get(path);
            }
            return node.pass;
        }
    }

    /**
     * 暴力方法的正确类
     */
    public static class Right {

        private HashMap<String, Integer> box;

        public Right() {
            box = new HashMap<>();
        }

        public void insert(String word) {
            if (!box.containsKey(word)) {
                box.put(word, 1);
            } else {
                box.put(word, box.get(word) + 1);
            }
        }

        public void delete(String word) {
            if (box.containsKey(word)) {
                if (box.get(word) == 1) {
                    box.remove(word);
                } else {
                    box.put(word, box.get(word) - 1);
                }
            }
        }

        public int search(String word) {
            if (!box.containsKey(word)) {
                return 0;
            } else {
                return box.get(word);
            }
        }

        public int prefixNumber(String pre) {
            int count = 0;
            for (String cur : box.keySet()) {
                if (cur.startsWith(pre)) {
                    count += box.get(cur);
                }
            }
            return count;
        }
    }

    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    // 测试
    public static void main(String[] args) {
        int arrLen = 100;
        int strLen = 20;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = generateRandomStringArray(arrLen, strLen);
            TrieTree trie1 = new TrieTree();
            com.yangqihang.tree.trie_tree.TrieTree trie2 = new com.yangqihang.tree.trie_tree.TrieTree();
            Right right = new Right();
            for (int j = 0; j < arr.length; j++) {
                double decide = Math.random();
                if (decide < 0.25) {
                    trie1.insert(arr[j]);
                    trie2.insert(arr[j]);
                    right.insert(arr[j]);
                } else if (decide < 0.5) {
                    trie1.delete(arr[j]);
                    trie2.delete(arr[j]);
                    right.delete(arr[j]);
                } else if (decide < 0.75) {
                    int ans1 = trie1.search(arr[j]);
                    int ans2 = trie2.search(arr[j]);
                    int ans3 = right.search(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println("Oops!");
                    }
                } else {
                    int ans1 = trie1.prefixNumber(arr[j]);
                    int ans2 = trie2.prefixNumber(arr[j]);
                    int ans3 = right.prefixNumber(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        System.out.println("finish!");

    }
}
