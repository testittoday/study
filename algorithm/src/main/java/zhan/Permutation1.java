/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhan;

/**
 * 
 * @author zhan
 */
public class Permutation1<T> {

    public void printA(final T[] a) {
        StringBuilder b = new StringBuilder();

        for (T e : a) {
            b.append(String.valueOf(e));
        }
        System.out.println(b.toString());
    }

    public void swap(final T[] a, int x, int y) {
        T temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public void permute(final int i, final T[] array) {
        final int N = array.length - 1;
        if (i == N) {
            printA(array);
        } else {
            for (int j = i; j <= N; j++) {
                if (i != j) {
                    swap(array, i, j);
                }
                permute(i + 1, array);
                if (i != j) {
                    swap(array, i, j);
                }

            }
        }

    }

    public static void main(final String args[]) {
        // String[] A = {"a", "b", "c", "d"};
        // printA(A);
        // swap(A, 0, 3);
        // printA(A);
        Permutation1<String> permutation = new Permutation1<String>();
        String[] A = { "a", "b", "c" };
        permutation.permute(0, A);

    }

}
