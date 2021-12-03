import model.Deal;
import model.User;
import service.DealManager;
import service.DealService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class DealSystem {

    public static void main(String[] args){

        System.out.println("Hello");
        DealManager dealManager = DealManager.getDealManagerObject();
        DealService dealService = new DealService();

        User user1 = new User(1);
        User user2 = new User(2);

        dealService.addDeal(new Deal(1, "table", 400, System.currentTimeMillis(), 2, 10));
        dealService.addDeal(new Deal(2, "chair", 500, System.currentTimeMillis(), 1, 20));
        dealService.updateDeal(new Deal(1, "table", 400, System.currentTimeMillis(), 2, 30));

        dealService.claimDeal(1, 1);
        System.out.println("After claim by user1: "+dealManager.getDeals().get(1l).getQuantity());
        dealService.claimDeal(1, 1);
        System.out.println("After claim again by user1: " + dealManager.getDeals().get(1l).getQuantity());
        dealService.claimDeal(2, 1);
        System.out.println("After claim by user2: " + dealManager.getDeals().get(1l).getQuantity());
    }


}
