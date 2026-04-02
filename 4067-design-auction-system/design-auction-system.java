class AuctionSystem {
    Map<Integer, Map<Integer, Integer>> map;
    Map<Integer, TreeMap<Integer, TreeSet<Integer>>> itemIndex;
    public AuctionSystem() {
        map = new HashMap<>();
        itemIndex = new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        map.putIfAbsent(userId, new HashMap<>());

        // ✅ If user already has a bid on this item, remove it from itemIndex first
        if (map.get(userId).containsKey(itemId)) {
            int oldAmount = map.get(userId).get(itemId);
            TreeMap<Integer, TreeSet<Integer>> bidMap = itemIndex.get(itemId);
            TreeSet<Integer> users = bidMap.get(oldAmount);
            users.remove(userId);
            if (users.isEmpty()) bidMap.remove(oldAmount);
        }

        map.get(userId).put(itemId, bidAmount);

        itemIndex.putIfAbsent(itemId, new TreeMap<>());
        itemIndex.get(itemId)
                .computeIfAbsent(bidAmount, k -> new TreeSet<>())
                .add(userId);
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        if (!map.containsKey(userId) ||  !map.get(userId).containsKey(itemId)) return; 
        int oldAmount = map.get(userId).get(itemId);

        TreeMap<Integer, TreeSet<Integer>> bidMap = itemIndex.get(itemId);
        TreeSet<Integer> users = bidMap.get(oldAmount);
        users.remove(userId);
        if (users.isEmpty()) bidMap.remove(oldAmount);

        map.get(userId).put(itemId, newAmount);

        bidMap.computeIfAbsent(newAmount, k -> new TreeSet<>()).add(userId);
    }
    
    public void removeBid(int userId, int itemId) {
        if (!map.containsKey(userId) || 
            !map.get(userId).containsKey(itemId)) return;

        int amount = map.get(userId).get(itemId);

        map.get(userId).remove(itemId);

        TreeMap<Integer, TreeSet<Integer>> bidMap = itemIndex.get(itemId);
        TreeSet<Integer> users = bidMap.get(amount);
        users.remove(userId);
        if (users.isEmpty()) {
            bidMap.remove(amount);
            if (bidMap.isEmpty()) itemIndex.remove(itemId);
        }
    }
    
    public int getHighestBidder(int itemId) {
        if (!itemIndex.containsKey(itemId) || itemIndex.get(itemId).isEmpty()) 
            return -1;

        TreeSet<Integer> topBidders = itemIndex.get(itemId).lastEntry().getValue();
        return topBidders.last();
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */