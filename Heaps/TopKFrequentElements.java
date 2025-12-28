class Pair implements Comparable<Pair>{
    int ele;
    int freq;
    Pair(int ele, int freq){
        this.ele=ele;
        this.freq=freq;
    } 

    @Override
    public int compareTo(Pair p){
        if(this.ele==p.ele) return this.ele-p.ele;
        return this.freq-p.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Map<Integer, Integer> map=new HashMap<>();
        int[] arr=new int[k];
        for(int ele:nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        } 

        for(int ele:map.keySet()){
            int freq=map.get(ele);
            pq.add(new Pair(ele, freq));
            if(pq.size()>k) pq.poll();
        }

        int idx=0;
        while(pq.size()>0){
            arr[idx++] = pq.poll().ele;
        }
        return arr;
    }
}
