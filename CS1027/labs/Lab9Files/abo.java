public class abo {
    
    
    public static int rabo(int n){
        if(n < 1){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else{
            if((n%2)== 0){
                return 1+rabo(n/2);
            }
            else{
                return 2+rabo((n+1)/2);
            }
        }
    }


    public static int iabo(int n){
        if (n < 1) {
            return 0;
        } 
        else if (n == 1) {
            return 1;
        } 
        else {
            int count = 0;
            while (n > 1) {
                if (n % 2 == 0) {
                    n = (n / 2);
                } else {
                    n = ((n + 1) / 2);
                    count++;
                }
                count++;
            }
            return count;
        }

    }

    public static void main(String[] args){
        for(int i = 0; i<20; i++){
            System.out.print(iabo(i)+", ");
        }
        
    }


}
