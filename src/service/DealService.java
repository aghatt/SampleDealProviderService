package service;

import model.Deal;

public class DealService {

    DealManager dealManager;
    public DealService() {
        dealManager = DealManager.getDealManagerObject();
    }

    public void addDeal(Deal deal)
    {
        dealManager.getDeals().put(deal.getDealId(), deal);
    }

    public void endDeal(long dealId)
    {
        dealManager.getDeals().remove(dealId);
    }

    public void updateDeal(Deal deal)
    {
        dealManager.getDeals().put(deal.getDealId(), deal);
    }

    public void claimDeal(long userId, long dealId)
    {

        if(!dealManager.getClaimedDealByUser(userId).contains(dealId) && checkIfDealIsValid(dealId))
        {
            dealManager.getClaimedDealByUser(userId).add(dealId);
            dealManager.getDeals().get(dealId).updateQuantity();
        }
        else
        {
            System.out.println("The deal has already been claimed by user: "+userId);
        }
    }

    private boolean checkIfDealIsValid(long dealId)
    {
        Deal deal = dealManager.getDeals().get(dealId);
        long allowedTime = deal.getStartTimeStamp()+(deal.getDuration()*3600*1000);
        if(deal.hasEnded() || allowedTime < System.currentTimeMillis())
        {
            dealManager.getDeals().get(dealId).setStatus(false);
            return false;
        }
        return true;
    }

}
