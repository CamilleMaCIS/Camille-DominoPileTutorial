public class Domino {
    //properties
    private int top;
    private int bottom;

    //constructors
    //default constructor
    public Domino(){
        this.top = 0;
        this.bottom = 0;
    }

    //overloading constructor
    public Domino(int top, int bottom){
        this.top = top;
        this.bottom = bottom;
    }

    //methods
    //getters
    public int getTop() {
        return top;
    }
    public int getBottom() {
        return bottom;
    }
    //setters
    public void setTop(int top) {
        this.top = top;
    }
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
    //toString
    public String toString(){
        return "" + this.top + "/" + this.bottom;
    }

    public void flip(){
        int temp = this.top;
        this.top = this.bottom;
        this.bottom = temp;
    }
    public void settle(){
        if (this.top > this.bottom){
            flip();
        }
    }
    public int compareTo(Domino other){
        int thisMin;
        int thisMax;
        if (this.top < this.bottom){
            thisMin = this.top;
            thisMax = this.bottom;
        }
        else{
            thisMin = this.bottom;
            thisMax = this.top;
        }

        int otherMin;
        int otherMax;
        if (other.top < other.bottom){
            otherMin = other.top;
            otherMax = other.bottom;
        }
        else{
            otherMin = other.bottom;
            otherMax = other.top;
        }

        //comparing smallest
        if (thisMin < otherMin){
            return -1;
        }
        else if (thisMin > otherMin){
            return 1;
        }
        //comparing largest
        else{
            if (thisMax < otherMax){
                return -1;
            }
            else if (thisMax > otherMax){
                return 1;
            }
        }
        //if all equal and doesn't meet any if statements above
        return 0;
    }
    public int compareToWeight(Domino other){
        int thisTotal = this.top + this.bottom;
        int otherTotal = other.top + other.bottom;
        if (thisTotal < otherTotal){
            return -1;
        }
        else if (thisTotal > otherTotal){
            return 1;
        }

        return 0;
    }
    public boolean canConnect(Domino other){
        if (this.top == other.top || this.top == other.bottom){
            return true;
        }
        if (this.bottom == other.top || this.bottom == other.bottom){
            return true;
        }
        return false;
    }
}
