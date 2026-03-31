class MedianFinder {
    Queue<Integer> smallQueue;
    Queue<Integer> largeQueue;
    public MedianFinder() {
        smallQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        largeQueue = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        smallQueue.offer(num);

        if (largeQueue.size() == 0 && smallQueue.size() == 1) {
            return;
        }
        if (largeQueue.size() == 0 && smallQueue.size() == 2) {
            largeQueue.offer(smallQueue.poll());
            return;
        } 
        
        if (smallQueue.peek() > largeQueue.peek()) {
            largeQueue.offer(smallQueue.poll());
        }

        if ((largeQueue.size() - smallQueue.size()) >= 2) {
            smallQueue.offer(largeQueue.poll());
        }

        if ((smallQueue.size() - largeQueue.size()) >= 2) {
            largeQueue.offer(smallQueue.poll());
        }
    } 
    
    public double findMedian() {
        if (smallQueue.size() == largeQueue.size()) {
            double value = 0;
            value += smallQueue.peek();
            value += largeQueue.peek();
            return value/2;
        } else if (largeQueue.size() > smallQueue.size()) {
            return 0.0 + largeQueue.peek();
        } else {
            return 0.0 + smallQueue.peek();
        }
    }
}
