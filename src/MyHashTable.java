import java.util.NoSuchElementException;

public class MyHashTable<K, V> {

    private class HashNode<K, V> {

        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }


    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;


    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key) {

        if (key == null) {
            throw new IllegalArgumentException("hash null");
        }
        int hash = key.hashCode();
        int hashCode = Math.abs(hash % M);
        return hashCode;
    }

    private void put(K key, V value) {

        if (key == null || value == null) {
            throw new IllegalArgumentException("hash and value null");
        }

        int index = hash(key);

        HashNode<K, V> node = chainArray[index];

        while (node != null) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    public V get(K key) {

        if (key == null) {
            throw new IllegalArgumentException("hash null");
        }
        int index = hash(key);

        HashNode<K, V> node = chainArray[index];

        while (node != null) {
            if (key.equals(node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {

        if (key == null) {
            throw new IllegalArgumentException("hash null");
        }

        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prev = null;


        while (node != null) {
            if (key.equals(node.key)) {
                if (prev == null) {
                    chainArray[index] = node.next;
                }
                else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++){
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (value.equals(node.value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for (int i = 0; i < M; i++){
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (value.equals(node.value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    private void resize(int newSize) {

        HashNode<K, V>[] newChainArray = new HashNode[newSize];
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                int newIndex = Math.abs(node.key.hashCode()) % newSize;
                HashNode<K, V> nextNode = node.next;
                node.next = newChainArray[newIndex];
                newChainArray[newIndex] = node;
                node = nextNode;
            }
        }
        chainArray = newChainArray;
        M = newSize;
    }
}
