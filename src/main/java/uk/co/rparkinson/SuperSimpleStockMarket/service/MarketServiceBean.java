package uk.co.rparkinson.SuperSimpleStockMarket.service;

import uk.co.rparkinson.SuperSimpleStockMarket.model.*;
import uk.co.rparkinson.SuperSimpleStockMarket.db.*;

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
}
