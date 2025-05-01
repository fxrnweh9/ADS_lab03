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


    public MyHashTable() {}

    public MyHashTable(int M) {}

    private int hash(K key) {

        if (key == null) {
            throw new IllegalArgumentException("hash null");
        }
        int hash = key.hashCode();
        int hashCode = Math.abs(hash % M);
        return hashCode;
    }

    private void put(K key, V value) {

        if (key == null) {
            throw new IllegalArgumentException("hash null");
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

    public V remove(K key) {}

    public boolean contains(V value) {}

    public K getKey(V value){}


}
