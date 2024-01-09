public class ReversibleArray<T> {
    
    T[] array;
    int count;

    public ReversibleArray(T[] arr){

        this.array = arr;
        this.count = arr.length;

    }

    public String toString(){

        String temp = "";

        for (int i = 0; i < this.count; i++){

            if (i == this.count-1){
                temp += this.array[i];
            }
            else{

                temp += this.array[i] + ", ";
            
            }

        }

        return temp;

    }

    public void reverse() { 

        T temp;

        for (int i =0; i < (int)(this.count/2); i++){

            temp = this.array[i];

            this.array[i] = this.array[this.count-i-1];
            this.array[this.count-i-1] = temp; 

        }

    }

}
