package com.yangqihang.tree.trie_tree;

/**
 * 前缀树,实现26个小写字母的快速操作功能
 * 1.单个字符中,字符从前到后的加到一颗多叉树上
 * 2.字符放在路上,节点上有专属的数据项(常见的是pass和end值)
 * 3.所有样本都这样添加,如果没有路就新建,如果有路就复用
 * 4.沿途节点的pass值增加 1,每个字符串结束时来到的节点end值增加 1
 */
public class TrieTree {

    public static class Node {
        // 经过该节点的值
        int pass;
        // 在该节点结束的值
        int end;
        // 指向下个节点集的路径
        Node[] nexts;

        public Node() {
            pass = 0;
            end = 0;
            nexts = new Node[26];
        }
    }

    private Node root;

    public TrieTree() {
        root = new Node();
    }

    /**
     * 添加字符串
     *
     * @param word 字符串
     */
    public void insert(String word) {
        if (word == null)
            return;
        // 将字符串转换成字节数组
        char[] chars = word.toCharArray();
        // node指针指向root节点
        Node node = root;
        // 通过根节点的次数+1
        node.pass++;
        // 记录路径变量
        int path;
        for (int i = 0; i < chars.length; i++) {
            // 以字符'a'作为起始路径 0
            path = chars[i] - 'a';
            if (node.nexts[path] == null)
                // 如果路径不存在,创建路径
                node.nexts[path] = new Node();
            // 指针指针路径到达的下一个节点
            node = node.nexts[path];
            node.pass++;
        }
        // 字符串最后个字符,到达终点的节点end+1
        node.end++;
    }

    /**
     * 删除字符串
     *
     * @param word
     */
    public void delete(String word) {
        if (search(word) != 0) {
            // 该字符串存在
            char[] chars = word.toCharArray();
            Node node = root;
            // 经过节点次数-1
            node.pass--;
            int path;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (--node.nexts[path].pass == 0) {
                    // 路径下的下一个节点经过值-1为0,表示就是需要删除的字符串经过下一个节点,可以直接删除,置为null
                    node.nexts[path] = null;
                    return;
                }
                node = node.nexts[path];
            }
            // 找到字符串,此节点的结束值-1
            node.end--;
        }
    }

    /**
     * 查找指定字符串之前出现的次数
     *
     * @param word 指定字符串
     * @return 之前出现的次数
     */
    public int search(String word) {
        if (word == null)
            return 0;
        // 将字符串转换成字符数组
        char[] chars = word.toCharArray();
        // 指针指向根节点
        Node node = root;
        // 路径变量
        int path;
        for (int i = 0; i < chars.length; i++) {
            // 获得当前字符相对于'a'的路径
            path = chars[i] - 'a';
            if (node.nexts[path] == null)
                // 路径不存在,表明字符串没出现过
                return 0;
            node = node.nexts[path];
        }
        // 返回最好到达node的end值
        return node.end;
    }

    /**
     * 查找所有加入的字符串中,有几个是以pre这个字符串作为前缀的
     *
     * @param pre 前缀字符串
     * @return
     */
    public int prefixNumber(String pre) {
        if (pre == null)
            return 0;
        char[] chars = pre.toCharArray();
        Node node = root;
        int path;
        for (int i = 0; i < chars.length; i++) {
            path = chars[i] - 'a';
            if (node.nexts[path] == null)
                return 0;
            node = node.nexts[path];
        }
        // 返回经过这个节点的次数
        return node.pass;
    }
}
