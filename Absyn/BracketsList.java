package Absyn;

public class BracketsList {
    public int emptyDimsCount; 
    public ExpList sizedDims;

    public BracketsList(int emptyDimsCount) {
        if (emptyDimsCount < 1)
            throw new IllegalArgumentException("BracketsList.emptyDimsCount < 1");
        this.emptyDimsCount = emptyDimsCount; this.sizedDims = null;
    }

    public BracketsList(ExpList sizedDims) {
        if (sizedDims == null)
            throw new IllegalArgumentException("BracketsList.sizedDims null");
        this.emptyDimsCount = 0; this.sizedDims = sizedDims;
    }

   public boolean isSizedDims() { return sizedDims != null; }
}
