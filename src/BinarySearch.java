public class BinarySearch {
    public static void main(String[] args) {
//        정렬되어 있어야 이분탐색 가능
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int start = 0;
        int end = arr.length-1;
        int find = 15;
        int answer = -1;

        while(start <= end) { // start > end면 종료(find가 배열에 존재하지 않을 경우)
            int middle = (start+end)/2;
            if(arr[middle] == find) { // 찾는 값의 인덱스에 도달
                answer = middle;
                break;
            }else if(arr[middle] > find) {
                end = middle - 1; // end를 middle 앞으로
            }else{
                start = middle + 1; // start를 middle 뒤로
            }
        }
        System.out.println(answer);
    }
}
