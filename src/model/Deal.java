package model;

public class Deal {

    private long dealId;
    private String item;
    private double price;
    private long startTimeStamp;
    private long duration;
    private long quantity;
    private boolean hasEnded;

    public Deal(
                long dealId,
                String item,
                double price,
                long startTimeStamp,
                long duration,
                long quantity) {
        this.dealId = dealId;
        this.item = item;
        this.price = price;
        this.startTimeStamp = startTimeStamp;
        this.duration = duration;
        this.quantity = quantity;
    }


    public long getDealId() {
        return dealId;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public long getStartTimeStamp() {
        return startTimeStamp;
    }

    public long getDuration() {
        return duration;
    }

    public long getQuantity() {
        return quantity;
    }

    public boolean hasEnded() {
        return hasEnded;
    }

    public void updateQuantity() {
        this.quantity--;
        if(quantity<=0)
        {
            hasEnded=true;
        }
    }

    public void setStatus(boolean hasEnded) {
        this.hasEnded=hasEnded;
    }
}
