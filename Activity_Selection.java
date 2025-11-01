import java.util.*;
class ac {
    int start, finish, pro;
    String name;
    ac(String name, int start, int finish, int pro) {
        this.name = name;
        this.start = start;
        this.finish = finish;
        this.pro = pro;
    }
}
public class Activity_Selection {
    public static void main(String[] args) {
        ac[] jobs = {
                new ac("A1", 1, 4, 10),
                new ac("A2", 3, 5, 15),
                new ac("A3", 0, 6, 14),
                new ac("A4", 5, 7, 12),
                new ac("A5", 3, 9, 20),
                new ac("A6", 5, 9, 30),
                new ac("A7", 6, 10, 32),
                new ac("A8", 8, 11, 28),
                new ac("A9", 8, 12, 30),
                new ac("A10", 2, 14, 40),
                new ac("A11", 12, 16, 45)
        };
        Arrays.sort(jobs, new Comparator<ac>() {
            public int compare(ac a, ac b) {

                return a.finish - b.finish;
            }
        });
        int Total_pro = 0;
        int last_finish = -1;
        System.out.println("Selected Activities:");
        for (ac job : jobs) {
            if (job.start >= last_finish) {
                Total_pro += job.pro;
                last_finish = job.finish;
                System.out.println(job.name + " (" + job.start + " - " +
                        job.finish + ") Profit: " + job.pro);
            }
        }
        System.out.println("Total Profit = " + Total_pro);
    }
}