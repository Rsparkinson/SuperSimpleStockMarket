package uk.co.rparkinson.SuperSimpleStockMarket.model;

public class trade {
    public enum tradetype {
        buy, sell;
    };

    private int c_id;
    private long c_timeStamp;
    private String c_symbol;
    private int c_qty;
    private tradetype c_type;
    private float c_tradePrice;

    public trade() {
    }

    public int getId() {
      return c_id;
    }

    public void setId(int p_id) {
      c_id = p_id;
    }

    public long getTimeStamp() {
      return c_timeStamp;
    }

    public void setTimeStamp(long p_timeStamp) {
      c_timeStamp = p_timeStamp;
    }

    public String getSymbol() {
      return c_symbol;
    }

    public void setSymbol(String p_symbol) {
      c_symbol = p_symbol;
    }

    public int getQty() {
      return c_qty;
    }

    public void setQty(int p_qty) {
      c_qty = p_qty;
    }

    public tradetype getType() {
      return c_type;
    }

    public void setType(tradetype p_type) {
        c_type = p_type;
    }

    public Float getTradePrice() {
      return c_tradePrice;
    }

    public void setTradePrice(float p_tradePrice) {
      c_tradePrice = p_tradePrice;
    }

    public String toString() {
      return "id:" + c_id + " symbol:" + c_symbol + " timeStamp:" + c_timeStamp + " qty:" + c_qty
        + " type:" + c_type.toString() + " tradePrice:" + c_tradePrice;
    }
}
