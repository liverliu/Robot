package robot;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by shijianliu on 1/4/16.
 */
public class Robot {

    private static boolean finish = false;

    public synchronized static boolean isFinish() {
        return finish;
    }

    public synchronized static void setFinish(boolean finish) {
        Robot.finish = finish;
    }

    private static int n, m, mtx[][];

    private static void init() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        n = scanner.nextInt();
        m = scanner.nextInt();
        mtx = new int[n][m];
        String s = scanner.next();
        for(int i=0;i<s.length();i++) {
            mtx[i/m][i%m] = s.charAt(i)-'0';
        }
    }

    private static boolean checkStart(int x, int y) {
        if(mtx[x][y]==1) {
            return false;
        }
        int deg = 4, gx[]={0, 1, 0, -1}, gy[]={1, 0, -1, 0};
        for(int i=0;i<4;i++) {
            int tx = x+gx[i], ty = y+gy[i];
            if(tx<0 || tx>=n || ty<0 || ty>=m || mtx[tx][ty]==1) {
                deg--;
            }
        }
        return deg == 1;
    }

    public static void main(String args[]) {
        init();
        List<Integer> sx = new ArrayList<>();
        List<Integer> sy = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0;j<m;j++) {
                if(checkStart(i, j)) {
                    sx.add(i);
                    sy.add(j);
                }
            }
        }
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<sx.size();i++) {
            threads.add(new Thread(new Worker(sx.get(i), sy.get(i), mtx)));
        }
        threads.forEach(Thread::start);
        threads.forEach(t->{
            try {
                t.join();
            } catch (Exception ex) {
                System.out.println(t.getId() + " failed");
            }
        });
    }
}
