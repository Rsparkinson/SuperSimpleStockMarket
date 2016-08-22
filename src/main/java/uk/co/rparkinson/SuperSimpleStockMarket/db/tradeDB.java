package uk.co.rparkinson.SuperSimpleStockMarket.db;

import uk.co.rparkinson.SuperSimpleStockMarket.model.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class tradeDB {

  private static final Logger logger
    = LoggerFactory.getLogger(tradeDB.class);

  private static Integer nextId = 0;
  private static Map<Integer, trade> tradeMap;

  public static trade save(trade i_trade) {
    if (tradeMap == null) {
      tradeMap = new HashMap<Integer, trade>();
      nextId = 1;
    }
    try {
      Date d = new Date();
      long t_timeStamp = d.getTime();

      i_trade.setId(nextId);
      i_trade.setTimeStamp(t_timeStamp);
      nextId++;
      tradeMap.put(i_trade.getId(), i_trade);
    } catch(Exception e) {
      logger.error("TradeServiceBean save " + e);
    }
    return i_trade;
  }

  public static void init() {
    tradeMap = new HashMap<Integer, trade>();
    nextId = 1;

    try {
      trade entity = new trade();
      entity.setSymbol("TEA");
      entity.setQty(10);
      entity.setType("Buy");
      entity.setTradePrice(12.12f);
      save(entity);
    } catch(Exception e) {
      logger.error("TradeServiceBean 1 init " + e);
    }

    try {
      trade entity = new trade();
      entity.setSymbol("GIN");
      entity.setQty(107);
      entity.setType("Buy");
      entity.setTradePrice(1762.12f);
      save(entity);
    } catch(Exception e) {
      logger.error("TradeServiceBean 2 init " + e);
    }

    try {
      trade entity = new trade();
      entity.setSymbol("JOE");
      entity.setQty(140);
      entity.setType("Buy");
      entity.setTradePrice(12.45f);
      save(entity);
    } catch(Exception e) {
      logger.error("TradeServiceBean 3 init " + e);
    }

    try {
      trade entity = new trade();
      entity.setSymbol("ALE");
      entity.setQty(100);
      entity.setType("Sell");
      entity.setTradePrice(132.12f);
      save(entity);
    } catch(Exception e) {
      logger.error("TradeServiceBean 4 init " + e);
    }
  }

  public static Collection<trade> findLast15mins() {
    Collection<trade> r_trades = new HashSet<trade>();
    Date d = new Date();
    long t_cutOffTime = d.getTime() - (15 * 60);

    for (int i=1;i<tradeMap.size();i++) {
        trade t_trade = tradeMap.get(i);
        if (tradeMap.get(i).getTimeStamp() > t_cutOffTime) {
          r_trades.add(tradeMap.get(i));
        }
    }
    return r_trades;
  }

  public static Collection<trade> findAll() {
    Collection<trade> r_trades = tradeMap.values();
    return r_trades;
  }

  public static trade find(int p_id) {
    trade r_trade = tradeMap.get(p_id);
    return r_trade;
  }

  public static trade create(trade p_trade) {
    return save(p_trade);
  }

}
