package Adapter;

public class MemoryBlock {
    private int startPosition;
    private int endPosition;
    private int curTag;
    private int curLength;

    public MemoryBlock() {
    }

    public MemoryBlock(int startPosition, int endPosition,int curTag) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.curTag = curTag;
        this.curLength = endPosition-startPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getCurTag() {
        return curTag;
    }

    public void setCurTag(int curTag) {
        this.curTag = curTag;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public int getCurLength() {
        return curLength;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public void setCurLength() {
        this.curLength = this.endPosition - this.startPosition;
    }
}
