import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 7};
        int n = arr.length;

//        최초 힙구성 : n/2번 만큼 heapify 수행
        for(int i=n/2-1; i>=0; i--) {
            heapify(arr, n, i);
        }

//        힙정렬 : 최초 힙구성 이후에 root노드와 마지막 노드 change
        for(int i=n-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }

        System.out.println(Arrays.toString(arr));
    }

    static void heapify(int[] arr, int n, int root){
//        xx조건의 경우에 change로직 : left와 right비교해서 자리 change
        int max_index = root;
        int left = root*2 + 1;
        int right = root*2 + 2;
        if(left<n && arr[max_index] < arr[left]){
            max_index = left;
        }
        if(right<n && arr[max_index] < arr[right]){
            max_index = right;
        }
        if(max_index != root){
            int temp = arr[root];
            arr[root] = arr[max_index];
            arr[max_index] = temp;
            heapify(arr, n, max_index);
        }
    }

//        static void heapify(int[] arr, int n, int root) { // 부모노드(root)와 자식 비교
////        최대힙에 어긋나면 change : left와 right 비교해서 큰것과 자리 change
//            int left = root * 2 + 1;
//            int right = root * 2 + 2;
//            if(root < n/2) {
//                int max = arr[right] > arr[left] ? right : left;
//                if(arr[root] < arr[max]){
//                    int temp = arr[root];
//                    arr[root] = arr[max];
//                    arr[max] = temp;
//                    heapify(arr, n, max); // change가 발생한 인덱스(하향식이 되도록)
//                }
//            }
//        }

//    static void heapify(int[] arr, int n, int root) { // 부모노드(root)와 자식 비교
////        최대힙에 어긋나면 change : left와 right 비교해서 큰것과 자리 change
////        arr.length-1을 넘어가면 끝나야함
//        boolean change = false;
//        int i;
//        while (root < n / 2 && (arr[root] < arr[root * 2 + 1] || arr[root] < arr[root * 2 + 2])) {
//            if (arr[root * 2 + 1] > arr[root * 2 + 2]) {
//                int temp = arr[root];
//                arr[root] = arr[root * 2 + 1];
//                arr[root * 2 + 1] = temp;
//                change = true;
//                i = root * 2 + 1;
//            } else {
//                int temp = arr[root];
//                arr[root] = arr[root * 2 + 2];
//                arr[root * 2 + 2] = temp;
//                change = true;
//                i = root * 2 + 2;
//            }
//
//            if (change == true) {
//                heapify(arr, n, i); // change가 발생한 인덱스(하향식이 되도록)
//            }
//        }
//    }
}