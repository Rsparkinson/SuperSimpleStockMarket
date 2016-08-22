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

  float dividendYieldCommon(float p_lastDividend, float p_price);
  float dividendYieldPreferred(float p_fixedDividend, float p_parValue, float  p_price);
  float PERatio(float  p_price, float p_Dividend);
  float geometricMean(float[]  p_price);
  float volumeWeightStockPrice(float[]  p_price, int[] p_qty);

}
