public class condition {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        int c=15; 
       // int l = a>b&&a>c ? a : b>c&&b>a ? b :c;
        int l = a>b&&a>c ? a : b>c ? b :c;
        System.out.println("The largest value is: " + l);
    }
}
