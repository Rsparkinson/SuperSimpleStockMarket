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
  public Collection<share> findAll() {
    Collection<share> r_shares = shareDB.findAll();
    return r_shares;
  }

  // @Override
  // public share find(int p_id) {
  //   share r_share = shareMap.get(p_id);
  //   return r_share;
  // }
  //
  // @Override
  // public share find(String p_Symbol) {
  //   share r_share = null;
  //
  //   for(int i=1;i<shareMap.size() + 1;i++) {
  //     try {
  //       if (shareMap.get(i).getSymbol().equals(p_Symbol)) {
  //         r_share = shareMap.get(i);
  //       }
  //     } catch(Exception e) {
  //       logger.error("ShareServiceBean find symbol " + e);
  //     }
  //   }
  //
  //   return r_share;
  // }
  //
  // @Override
  // public share create(share p_share) {
  //   return save(p_share);
  // }
  //
  // @Override
  // public share update(share p_share) {
  //
  //   share shareToUpdate = find(p_share.getId());
  //   if (shareToUpdate == null) {
  //       logger.error(
  //               "Attempted to update a Share, but the entity does not exist.");
  //       throw new NoResultException("Requested entity not found.");
  //   }
  //
  //   return save(p_share);
  // }
  //
  // @Override
  // public void delete(int p_id) {
  //   remove(p_id);
  // }
}
