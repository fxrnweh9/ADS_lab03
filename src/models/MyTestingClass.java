package models;

public class MyTestingClass {

    private String id;
    private int number;

    public MyTestingClass(String id, int number) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        this.id = id;
        this.number = number;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyTestingClass)) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return this.id.equals(other.id) && this.number == other.number;
    }


    @Override
    public int hashCode() {
        int hash = 17;
        for (int i = 0; i < id.length(); i++) {
            hash = 31 * hash + id.charAt(i);
        }
        hash = 31 * hash + number;
        return hash;
    }
}
