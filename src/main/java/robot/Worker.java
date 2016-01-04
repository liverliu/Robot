package robot;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shijianliu on 1/4/16.
 */
public class Worker implements Runnable {

    private int x, y;
    private int mtx[][];
    private List<Status> queue;

    public Worker(int x, int y, int mtx[][]) {
        this.x = x;
        this.y = y;
        this.mtx = new int[mtx.length][mtx[0].length];
        for(int i=0;i<mtx.length;i++) {
            for(int j=0;j<mtx[0].length;j++) {
                this.mtx[i][j] = mtx[i][j];
            }
        }
        this.queue = new LinkedList<>();
    }

    private String gao() throws Exception {
        String ans = "";
        Status start = new Status();
        start.setX(x); start.setY(y);
        start.setRes(0);
        for(int i=0; i<mtx.length; i++) {
            for(int j=0;j<mtx[0].length;j++) {
                if(mtx[i][j]==0) {
                    start.addRes(1);
                }
            }
        }
        queue.add(start);
        while(queue.size() > 0) {

        }
        return ans;
    }

    @Override
    public void run() {
        try {
            System.out.println(gao());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
