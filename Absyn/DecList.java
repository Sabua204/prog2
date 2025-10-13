package Absyn;

public class DecList {
    public Dec head;  
    public DecList tail; 

    public DecList(Dec h) {
        if (h == null) throw new IllegalArgumentException("DecList.head null");
        head = h; tail = null;}

    public DecList(Dec h, DecList t) {
        if (h == null) throw new IllegalArgumentException("DecList.head null");
        head = h; tail = t;}

    public boolean hasTail() {return tail != null;}
}
