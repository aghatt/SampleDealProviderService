package Test;

import model.Deal;
import service.DealManager;
import service.DealService;

public class DealSystemTest {

    DealManager dealManager;
    DealService dealService;

    public DealSystemTest()
    {
        dealManager = DealManager.getDealManagerObject();
        dealService = new DealService();
    }

    public void testAddDeal()
    {
        Deal deal1 = new Deal(1, "table", 400, System.currentTimeMillis(), 2, 10);
        Deal deal2 = new Deal(2, "chair", 500, System.currentTimeMillis(), 1, 20);

        System.out.println("Size of deal store before addDeal: "+ dealManager.getDeals().size());
        dealService.addDeal(deal1);
        dealService.addDeal(deal2);
        System.out.println("Size of deal store after addDeal: "+ dealManager.getDeals().size());
    }

    public void testUpdateDeal()
    {
        Deal deal1 = new Deal(3, "table", 400, System.currentTimeMillis(), 2, 10);
        Deal deal2 = new Deal(3, "table", 400, System.currentTimeMillis(), 2, 20);

        dealService.addDeal(deal1);
        System.out.println("Quantity of deal before update: "+ dealManager.getDeals().get(3l).getQuantity());
        dealService.updateDeal(deal2);
        System.out.println("Quantity of deal after update: "+ dealManager.getDeals().get(3l).getQuantity());
    }

    public void testEndDeal()
    {
        Deal deal = new Deal(4, "table", 400, System.currentTimeMillis(), 2, 10);
        dealService.addDeal(deal);
        System.out.println("Deal store size before endDeal: "+ dealManager.getDeals().size());
        dealService.endDeal(4l);
        System.out.println("Deal store size after endDeal: "+ dealManager.getDeals().size());
    }

    public void test()
    {
        testAddDeal();
        testUpdateDeal();
        testEndDeal();
    }
}
