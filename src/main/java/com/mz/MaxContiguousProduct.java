package com.mz;

import java.util.Scanner;

/**
 * Created by mingzhu7 on 2017/10/11.
 * Count the subarrays having product less than k
 */
public class MaxContiguousProduct {
//    public static long getContinuousNumber(int[] number,long K){
//        long[] tmp=new long[number.length];
//        long count=0;
//        for(int i=0;i<number.length;i++){
//            if(number[i]<K){
//                count++;
//                tmp[i]=number[i];
//            }else{
//                tmp[i]=-1;
//            }
//        }
//
//        for(int i=2;i<=number.length;i++){
//            for(int j=0;j<=(number.length-i);j++){
//                if(tmp[j]!=-1 && number[j+i-1]<=(K/tmp[j]) && number[j+i-1]*tmp[j]<K){
//                    count++;
//                    tmp[j]=tmp[j]*number[j+i-1];
//                }else{
//                    tmp[j]=-1;
//                }
//            }
//        }
//        return count;
//    }
//    public static long getContinuousNumber(int[] number,long K){
//        int count=0;
//        int start=0;
//        int end=0;
//        long tmp=1;
//        while(end<number.length){
//            if(number[end]<=K/tmp && number[end]*tmp<K){
//                count+=end-start+1;
//                tmp=number[end]*tmp;
//                end++;
//            }else if(end>start){
//                tmp=tmp/number[start];
//                start++;
//            }else{
//                end=start=start+1;
//                tmp=1;
//            }
//        }
//        return count;
//    }

    public static long getContinuousNumber(int[] number,long K){
        int start=0;
        long tmp=1;
        int count=0;
        for(int end=0;end<number.length;end++){
            while(start<=end && number[end]>=(K+tmp-1)/tmp){
                start++;
            }
            count+=end-start+1;
        }
        return count;
    }
    public static void main(String[] args){
        int testNum;
        Scanner scanner=new Scanner(System.in);
        testNum=scanner.nextInt();
        long[] result=new long[testNum];
        for(int i=0;i<testNum;i++){
            int N=scanner.nextInt();
            long K=scanner.nextBigInteger().longValue();
            int[] number=new int[N];
            for(int j=0;j<N;j++){
                number[j]=scanner.nextInt();
            }
            result[i] = getContinuousNumber(number, K);
        }
        for(int i=0;i<testNum;i++){
            System.out.println(result[i]);
        }
    }
}
