package DS;

import java.util.*;

public class _7785 {
    public static void main(String args[]) {
        HashSet<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        while(count>0){
            count--;
            String name = scanner.next();
            String cmd= scanner.next();
            if(cmd.trim().equals("enter")){
                set.add(name);
            }else{
                set.remove(name);
            }
        }
        List<String> list = new ArrayList(set);
        Collections.sort(list, Comparator.reverseOrder());
        for(String s:list){
            System.out.println(s);
        }
    }
}
