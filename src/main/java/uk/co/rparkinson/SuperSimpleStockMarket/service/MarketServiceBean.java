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

  @Override
  public void loadData() {
    shareDB.init();
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
    shareDB.delete(p_id);
  }
}
