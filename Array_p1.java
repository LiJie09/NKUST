import java.util.*;
import java.util.Scanner;

public class Array_p1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number: ");
        String str = scn.nextLine();

        HashMap<Character,Integer> num = new HashMap<>();
        ArrayList<String> arrStr = new ArrayList<>();

        int num_f = 0;
        for (int i = 0; i <str.length();i++){
            char get = str.charAt(i);
            if (!num.containsKey(get)){
                arrStr.add(String.valueOf(get));
                num_f = num_f + 1;
            }
            else{
                arrStr.add("_");
            }
            num .put(get,i);
        }
        Collections.sort(arrStr);
        System.out.println("Number: "+arrStr);
        System.out.println("Output: "+num_f);

    }
    }

