public class Prime {
    public static void main(String[] args) {
        int i,r;
        for(i = 2;i<100;i++){
            for(r = 2;r<=i/2;r++){
                if(i%r == 0)
                    break;
            }
            if(r>i/2){
                System.out.println(i);
            }
        }

    }
}
