package uk.co.rparkinson.SuperSimpleStockMarket.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calc {

  private static final Logger logger
    = LoggerFactory.getLogger(Calc.class);

  public float dividendYieldCommon(float p_lastDividend, float p_price) {
    float r_dividendYield = p_lastDividend / p_price;

    return r_dividendYield;
  }

  public float dividendYieldPreferred(float p_fixedDividend, float p_parValue, float  p_price) {
    float r_dividendYield = (p_fixedDividend * p_parValue) / p_price;

    return r_dividendYield;
  }

  public float PERatio(float  p_price, float p_Dividend) {
    float r_PERatio = p_Dividend / p_price;

    return r_PERatio;
  }

  public float geometricMean(float[]  p_price) {
    float r_GeometricMean = 0f, t_product = 0f;

    if (p_price.length > 1) {
      t_product = p_price[0];
      for(int i=1;i<p_price.length; i++) {
        t_product = t_product * p_price[i];
      }
      r_GeometricMean = (float)Math.pow(t_product, 1.0 / p_price.length);
    }
    return r_GeometricMean;
  }

  public float volumeWeightStockPrice(float[]  p_price, int[] p_qty) {
    float r_volumeWeightStockPrice = 0, t_sumPriceQty = 0f, t_sumQty = 0f;

    if ((p_qty.length != p_price.length)&&(p_qty.length > 1)) {
      logger.error("CalcServiceBean volumeWeightStockPrice length of array qty exception!");
    } else {
      for(int i=0;i<p_price.length; i++) {
          t_sumPriceQty = t_sumPriceQty + (p_price[i] * p_qty[i]);
          t_sumQty = t_sumQty + p_qty[i];
      }
    }

    r_volumeWeightStockPrice = t_sumPriceQty / t_sumQty;

    return r_volumeWeightStockPrice;
  }

}
