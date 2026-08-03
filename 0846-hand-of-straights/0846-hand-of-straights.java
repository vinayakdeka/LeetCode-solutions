class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0)
        return false;

        HashMap<Integer,Integer> f = new HashMap<>();

        for(int card: hand) {
        f.put(card,f.getOrDefault(card,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int card: f.keySet())
        {
           pq.offer(card);

        }

        while(!pq.isEmpty())
        {
            int start = pq.peek();
            for(int i = 0; i<groupSize ;i++)
            {
                int card = start + i; 
                if(!f.containsKey(card))
                {
                    return false;
                }
                f.put(card,f.get(card) - 1);

                if(f.get(card) == 0)
                {
                    if(pq.peek()!=card)
                    {
                        return false;
                    }
                    pq.poll();
                    f.remove(card);
                } 
            }
        }

      return true;

    }
}