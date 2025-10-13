package Absyn;

public class TypeAugments {
    public int pointerLevels;  
    public BracketsList brackets;

    // pointer_list
    public TypeAugments(int pointerLevels) {
        if (pointerLevels < 1)
            throw new IllegalArgumentException("TypeAugments.pointerLevels < 1");
        this.pointerLevels = pointerLevels;
        this.brackets = null;
    }

    // brackets_list
    public TypeAugments(BracketsList b) {
        if (b == null) throw new IllegalArgumentException("TypeAugments.brackets null");
        this.pointerLevels = 0;
        this.brackets = b;
    }

    // pointer_list brackets_list
    public TypeAugments(int pointerLevels, BracketsList b) {
        if (pointerLevels < 1)
            throw new IllegalArgumentException("TypeAugments.pointerLevels < 1");
        if (b == null) throw new IllegalArgumentException("TypeAugments.brackets null");
        this.pointerLevels = pointerLevels;
        this.brackets = b;
    }

    public boolean hasPointers() { return pointerLevels > 0; }
    public boolean hasBrackets() { return brackets != null; }
}
