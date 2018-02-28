package DS;

import java.util.*;

public class _1764 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int listen = scan.nextInt();
        int see = scan.nextInt();
        HashSet<String> listenSet = new HashSet<>();
        HashSet<String> seeSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (listen > 0) {
            listen--;
            listenSet.add(scan.next());
        }

        while (see > 0) {
            see--;
            String temp = scan.next();
            if (listenSet.contains(temp)) {
                seeSet.add(temp);
            }
        }

        List<String> list = new ArrayList<>(seeSet);
        Collections.sort(list);
        for (String s : list) {
            sb.append(s + "\n");
        }
        System.out.printf("%d\n%s", list.size(), sb.toString());

    }
}
