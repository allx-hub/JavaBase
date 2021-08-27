package ink.allx.sort;

public class HeapSort {
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType[] a, int i, int n) {
        int child;
        AnyType tmp;

        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }

            if (tmp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            }
            a[i] = tmp;
        }
    }

    public static <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            percDown(a,i,a.length);
        }
        for(int i=a.length;i>0;i--){
//            swarpRefferences(a,0,i);
            percDown(a,0,i);
        }

    }

    public static void main(String[] args) {

    }
}
