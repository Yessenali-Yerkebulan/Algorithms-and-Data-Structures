import java.awt.image.BandCombineOp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.*;

class ArrayBub{
    private long[] a;
    private int nElems;

    public ArrayBub(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public void display(){
        for(int i = 0;i<nElems;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    // bubble sort
    public void bubbleSort(){
        int out, in;
        for(out=nElems-1;out>1;out--){
            for(in=0;in<out;in++){
                if(a[in]>a[in+1]){
                    swap(in, in+1);
                }
            }
        }
    }

    //selection sort
    public void selectionSort(){
        int out, in, min;
        for (out = 0;out<nElems-1;out++){
            min = out;
            for(in = out+1;in<nElems;in++){
                if(a[in]<a[min]){
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    public void insertionSort(){
        int in, out;
        for(out=1;out<nElems;out++){
            long temp = a[out];
            in = out;
            while(in>0 && a[in-1]>=temp){
                a[in]=a[in-1];
                --in;
            }
            a[in] = temp;
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one]=a[two];
        a[two]=temp;
    }

    //binary search
    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while(true){
            curIn = (lowerBound+upperBound)/2;
            if(a[curIn]==searchKey){
                return curIn;
            }else if(lowerBound>upperBound){
                return nElems;
            }else{
                if(a[curIn]>searchKey){
                    lowerBound=curIn-1;
                }else{
                    upperBound = curIn+1;
                }
            }
        }
    }

    public boolean delete(long searchKey){
        int j;
        for(j = 0;j<nElems;j++){
            if(a[j]==searchKey){
                break;
            }
        }

        if(j==nElems){
            return false;
        }else{
            for(int k = j;k<nElems;k++){
                a[k]=a[k+1];
            }
            nElems--;
            return true;
        }
    }
}

public class Main{

    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();
        arr.selectionSort();
        arr.display();
    }

}



