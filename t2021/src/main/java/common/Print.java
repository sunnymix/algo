package common;

public class Print {

    public static void arr(int[] arr) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                res.append(",");
            }
            res.append(arr[i]);
        }
        res.append("]");
        System.out.println(res);
    }

}
