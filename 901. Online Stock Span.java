class StockSpanner {
    Stack<Integer> prices;
    Stack<Integer> times;
    
    public StockSpanner() {
        prices = new Stack<>();
        times = new Stack<>();
    }
    
    public int next(int price) {
        int t = 1;
        while(!prices.isEmpty() && prices.peek() <= price){
            prices.pop();
            t += times.pop();
        }
        prices.push(price);
        times.push(t);
        return t;
    }
}
