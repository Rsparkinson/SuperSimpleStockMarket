package uk.co.rparkinson.SuperSimpleStockMarket.model;

public class share {
    public enum sharetype {
        Common, Preferred;
    };

    private int c_id;
    private String c_symbol;
    private sharetype c_type;
    private float c_lastDividend;
    private float c_fixedDividend;
    private float c_parValue;

    public share() {
    }

    public int getId() {
      return c_id;
    }

    public void setId(int p_id) {
      c_id = p_id;
    }

    public String getSymbol() {
      return c_symbol;
    }

    public void setSymbol(String p_symbol) {
      c_symbol = p_symbol;
    }

    public sharetype getType() {
      return c_type;
    }

    public void setType(sharetype p_type) {
        c_type = p_type;
    }

    public Float getLastDividend() {
      return c_lastDividend;
    }

    public void setLastDividend(float p_lastDividend) {
      c_lastDividend = p_lastDividend;
    }

    public Float getFixedDividend() {
      return c_fixedDividend;
    }

    public void setFixedDividend(float p_fixedDividend) {
      c_fixedDividend = p_fixedDividend;
    }

    public Float getParValue() {
      return c_parValue;
    }

    public void setParValue(float p_parValue) {
      c_parValue = p_parValue;
    }

    public String toString() {
      return "id:" + c_id + " symbol:" + c_symbol + " type:" + c_type.toString()
        + " lastDividend:" + c_lastDividend + " fixedDividend:"
        + c_fixedDividend + " parValue:" + c_parValue;
    }
}
