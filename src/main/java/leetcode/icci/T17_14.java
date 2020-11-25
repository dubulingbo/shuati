package leetcode.icci;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-03 22:46
 * i believe i can i do
 */
public class T17_14 {
    public int[] smallestK_heapSort(int[] arr, int k) {
        if(arr.length == 0 || k == 0) return new int[0];
//        int[] res = new int[k];
        Arrays.sort(arr);

//        for(int i=0;i<k;i++){
//            res[i] = arr[i];
//        }
        return Arrays.copyOfRange(arr,0,k);
    }


    public int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int pos = partition(arr, low, high);
            if (pos == k - 1) {
                break;
            } else if (pos < k - 1) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        int[] dest = new int[k];
        System.arraycopy(arr, 0, dest, 0, k);
        return dest;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }

            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
