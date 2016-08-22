package uk.co.rparkinson.SuperSimpleStockMarket.service;

import uk.co.rparkinson.SuperSimpleStockMarket.model.*;
import uk.co.rparkinson.SuperSimpleStockMarket.db.*;
import uk.co.rparkinson.SuperSimpleStockMarket.utils.*;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MarketServiceBean implements MarketService {

  private static final Logger logger
    = LoggerFactory.getLogger(MarketServiceBean.class);

    private shareDB shareDB;
    private tradeDB tradeDB;
    private Calc Clac;

  @Override
  public void loadData() {
    shareDB.init();
    tradeDB.init();
  }

  @Override
  public Collection<share> findAllshares() {
    Collection<share> r_shares = shareDB.findAll();
    return r_shares;
  }

  @Override
  public share findShare(int p_id) {
    share r_share = shareDB.find(p_id);
    return r_share;
  }

  @Override
  public share findShare(String p_Symbol) {
    share r_share = shareDB.find(p_Symbol);
    return r_share;
  }

  @Override
  public Collection<trade> findLast15minsTrades() {
    Collection<trade> r_trades = tradeDB.findLast15mins();
    return r_trades;
  }

  @Override
  public Collection<trade> findAlltrades() {
    Collection<trade> r_trades = tradeDB.findAll();
    return r_trades;
  }

  @Override
  public trade findTrade(int p_id) {
    trade r_trade = tradeDB.find(p_id);
    return r_trade;
  }

  @Override
  public trade createTrade(trade p_trade) {
    return tradeDB.create(p_trade);
  }

  @Override
  public share createShare(share p_share) {
    return shareDB.create(p_share);
  }

  @Override
  public share updateShare(share p_share) {
    share r_share = shareDB.update(p_share);
    if (r_share == null) {
        logger.error(
                "Attempted to update a Share, but the entity does not exist.");
        throw new NoResultException("Requested entity not found.");
    }

    return r_share;
  }

  @Override
  public void deleteShare(int p_id) {
    shareDB.remove(p_id);
  }

  @Override
  public float dividendYieldCommon(float p_lastDividend, float p_price) {
      float r_dividendYield = Calc.dividendYieldCommon(p_lastDividend, p_price);
      return r_dividendYield;
  }

  @Override
  public float dividendYieldPreferred(float p_fixedDividend, float p_parValue, float  p_price) {
    float r_dividendYield = Calc.dividendYieldPreferred(p_fixedDividend, p_parValue, p_price);
    return r_dividendYield;
  }

  @Override
  public float PERatio(float  p_price, float p_Dividend) {
    float r_PERatio = Calc.PERatio(p_price, p_Dividend);
    return r_PERatio;
  }

  @Override
  public float geometricMean(float[]  p_price) {
    float r_GeometricMean = Calc.geometricMean(p_price);
    return r_GeometricMean;
  }

  @Override
  public float volumeWeightStockPrice(float[]  p_price, int[] p_qty) {
    float r_volumeWeightStockPrice = Calc.volumeWeightStockPrice(p_price, p_qty);
    return r_volumeWeightStockPrice;
  }

}
