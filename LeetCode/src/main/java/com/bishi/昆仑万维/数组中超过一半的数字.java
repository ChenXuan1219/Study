package com.bishi.昆仑万维;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 数组中超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<array.length;i++){

            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                int count = map.get(array[i]);
                map.put(array[i],++count);
            }
        }
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Integer key =(Integer)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(val>array.length/2){
                return key;
            }
        }
        return 0;
    }

}
