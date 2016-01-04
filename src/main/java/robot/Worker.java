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
        this.mtx = mtx;
        this.queue = new LinkedList<>();
    }

    private String gao() throws Exception {
        int res = 0;
        for(int i=0; i<mtx.length; i++) {
            for(int j=0;j<mtx[0].length;j++) {
                if(mtx[i][j]==0) {
                    res++;
                }
            }
        }
        Status start = new Status(x, y, res, mtx);
        queue.add(start);
        while(queue.size() > 0) {
            Status now = queue.get(0);
            queue.remove(0);
            if(now.res == 0) {
                return now.step.toString();
            }
            if(now.goUp()) {
                int xMtx[][] = new int[]
            }
        }
        return "";
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
