package models;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;


public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node<K, V>> {

    private Node<K, V> root;
    private int size;


    public class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public void put(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
            size++;
            return;
        }


        Node<K, V> current = root;

        while (current != null) {

            int cmp = key.compareTo(current.key);

            if (cmp == 0) { current.value = value; return;}

            if (cmp < 0) {
                if (current.left == null) {
                    current.left = new Node<>(key, value);
                    size++;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node<>(key, value);
                    size++;
                    return;
                }

                current = current.right;

            }
        }
    }


    public V get(K key) {
        Node<K, V> current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else
                return current.value;
        }
        return null;
    }


    public void delete(K key) {

        Node<K, V> parent = null;
        Node<K, V> current = root;


        while (current != null && !key.equals(current.key)) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) return;



        if (current.left == null || current.right == null) {
            Node<K, V> child = (current.left != null) ? current.left : current.right;

            if (parent == null) { root = child;}
            else if (parent.left == current) {
                parent.left = child;
            }
            else { parent.right = child;}
        } else {
            Node<K, V> successorParent = current;
            Node<K, V> successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.key = successor.key;
            current.value = successor.value;  // Исправить 'val' на 'value'

            if (successorParent.left == successor)
                successorParent.left = successor.right;
            else
                successorParent.right = successor.right;
        }

        size--;
    }


    public int size() {
        return size;
    }


    @Override
    public Iterator<Node<K, V>> iterator() {

        List<Node<K, V>> list = new ArrayList<>();
        Stack<Node<K, V>> stack = new Stack<>();
        Node<K, V> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current);
            current = current.right;
        }

        return list.iterator();
    }
}
