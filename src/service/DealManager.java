package service;

import model.Deal;
import java.util.HashMap;
import java.util.HashSet;

public class DealManager {

    private HashMap<Long, HashSet<Long>> claimedDeal;
    private HashMap<Long, Deal> deals;

    public static DealManager instance = new DealManager();

    private DealManager() {
        this.claimedDeal = new HashMap();
        this.deals = new HashMap();
    }

    public HashSet<Long> getClaimedDealByUser(long userId)
    {
            if(!claimedDeal.containsKey(userId))
                claimedDeal.put(userId, new HashSet());
            return claimedDeal.get(userId);
    }

    public HashMap<Long, Deal> getDeals() {
        return deals;
    }

    public static DealManager getDealManagerObject() {
        if (instance != null) {
            return instance;
        } else {
            instance = new DealManager();
        }
        return instance;
    }

}
