package robot;

/**
 * Created by shijianliu on 1/4/16.
 */
public class Status {

    public String step;
    public int x, y, res, dir, mtx[][];

    public Status(int x, int y, int res, int mtx[][]) {
        this.step = "";
        this.x = x;
        this.y = y;
        this.res = res;
        this.dir = 0;
        this.mtx = mtx;
    }

    public boolean goUp() {
        return false;
    }
    public boolean goDown() {
        return false;
    }
    public boolean goLeft() {
        return false;
    }
    public boolean goRight() {
        return false;
    }
}
