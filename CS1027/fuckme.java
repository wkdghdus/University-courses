public class fuckme {
    
    private int var1;
    private int i;
    
    public fuckme() {
        var1 = 7;
        i = 10;
    }
    private void algo1 (int j) {
        i = j;
        j = 14;
    }
    private void algo2 (int i) {
        i = 20;
        var1 = 100;
    }

    public void algo3() {
        int var1 = 2;
        int j = 4;
        for (int i = 1; i < 3; ++i)
            var1 = var1 + i;
        {
            int k = i;
            algo2(5);
        }
        System.out.println(i);
        algo1(j);
        System.out.println(j+","+i+","+var1);
    }

    public static void main (String[] args) {
        fuckme t = new fuckme();
        t.algo3();
    }
}
