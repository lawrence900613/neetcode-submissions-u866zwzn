class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int size = position.length;
        double[] times = new double[size];
        for (int i = 0; i < size; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        for (int i=0; i < size; i++) {
             times[i] = (target - position[i]) * 1.0 / (map.get(position[i]));            
        }
        Stack<Double> stack = new Stack<Double>();
        stack.push(times[size-1]);
        // System.out.println(times[size-1]);
        for (int i = size - 2; i >= 0 ; i--) {
            System.out.println(times[i]);
            if (times[i] > stack.peek()) {
                stack.push(times[i]);
                // System.out.println(times[i]);
            }
        }
        return stack.size();
    }
}