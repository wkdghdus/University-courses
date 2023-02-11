public class asdf {

    public static void main(String[] args){
        int[] arr = new int[3];
        int[] arr2 = new int[5];

        for (int i = 0; i < 3; i++){

        arr[i] = i;

        }

        for (int i = 0; i < 5; i++){

            arr2[i] = i;
    
        }

        arr = arr2;

        System.out.println(arr.length);

        for (int i = 0; i < 5; i++){

            System.out.println(arr[i]);
    
        }
    } 
    

    

}
