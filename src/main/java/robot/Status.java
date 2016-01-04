package robot;

/**
 * Created by shijianliu on 1/4/16.
 */
public class Status {

    private StringBuilder step;
    private int x, y, res;

    public Status() {
        step = new StringBuilder();
        x = y = res = 0;
    }

    public StringBuilder getStep() {
        return step;
    }

    public void setStep(StringBuilder step) {
        this.step = step;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public void addRes(int add) {
        this.res += add;
    }
}
