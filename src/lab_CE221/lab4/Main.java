package lab_CE221.lab4;

public class Main {
    public static void main(String[] args) throws Exception{
        Integer[] unsorted = {15, 20, 7, 9, 30};
        BinaryMaxHeap<Integer> heapMax = new BinaryMaxHeap<>(unsorted);
        heapMax.printHeap();
        System.out.println("--------");
        heapMax.heapSort();
        //heapMax.insert(50);
        //heapMax.insert(45);
        //heapMax.insert(35);
        //heapMax.insert(33);
       // heapMax.insert(16);
       // heapMax.insert(25);
       // heapMax.insert(34);
        //heapMax.insert(12);
        //heapMax.insert(10);

        //heapMax.printHeap();
        //System.out.println();
        //heapMax.deleteMax();
        //System.out.println();
        //heapMax.printHeap();


    }
}
