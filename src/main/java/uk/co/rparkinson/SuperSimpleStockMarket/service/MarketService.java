package uk.co.rparkinson.SuperSimpleStockMarket.service;

import uk.co.rparkinson.SuperSimpleStockMarket.model.*;

import java.util.Collection;

public interface MarketService {

  void loadData();
  Collection<share> findAll();
  // share find(int p_id);
  // share find(String p_Symbol);
  // share create(share p_share);
  // share update(share p_share);
  // void delete(int p_id);

}
