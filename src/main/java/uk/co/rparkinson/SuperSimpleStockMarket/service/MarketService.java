package uk.co.rparkinson.SuperSimpleStockMarket.service;

import uk.co.rparkinson.SuperSimpleStockMarket.model.*;

import java.util.Collection;

public interface MarketService {

  void loadData();
  Collection<share> findAllshares();
  share findShare(int p_id);
  share findShare(String p_Symbol);
  Collection<trade> findLast15minsTrades();
  Collection<trade> findAlltrades();
  trade findTrade(int p_id);
  trade createTrade(trade p_trade);
  share createShare(share p_share);
  share updateShare(share p_share);
  void deleteShare(int p_id);
}
