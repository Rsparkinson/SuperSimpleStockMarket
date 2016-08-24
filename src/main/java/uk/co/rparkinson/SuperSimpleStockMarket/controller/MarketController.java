package uk.co.rparkinson.SuperSimpleStockMarket.controller;

import uk.co.rparkinson.SuperSimpleStockMarket.model.*;
import uk.co.rparkinson.SuperSimpleStockMarket.service.*;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class MarketController {

  private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

  @Autowired
  private MarketService MarketService;

  @ResponseBody
  @RequestMapping("/")
  String home() {
      String t_text = "<p> <b><u>SuperSimpleStockMarket </u></b></p>";
      MarketService.loadData();

      t_text = t_text + "<p><b>Example Assignment – Super Simple Stock Market </b></p>";
      t_text = t_text + "<p><b>Requirements </b></p>";
      t_text = t_text + "<p><b>  1. Provide working source code that will :- </b></p>";
      t_text = t_text + "<p><b>    i. Given any price as input, calculate the dividend yield </b></p>";

        String t_symbol = "GIN";
        float t_price = 123.65f;
        float t_dividend = 0f;

        share t_share = MarketService.findShare(t_symbol);

        if (t_share.getType().equals("Common")) {
          float t_lastDividend = t_share.getLastDividend();
          t_dividend = MarketService.dividendYieldCommon(t_lastDividend, t_price);
        }

        if (t_share.getType().equals("Preferred")) {
          float t_fixedDividend = t_share.getFixedDividend();
          float t_parValue = t_share.getParValue();
          t_dividend = MarketService.dividendYieldPreferred(t_fixedDividend, t_parValue, t_price);
        }
        t_text = t_text + "<p>    Share " + t_symbol + " Price " + t_price + " dividend yield " + t_dividend + " </p>";

        t_text = t_text + "<p>     </p>";
        t_text = t_text + "<p><b>ii. Given any price as input, calculate the P/E Ratio     </b></p>";

        t_symbol = "GIN";
        t_price = 123.65f;
        float t_PEratio = 0f;

        t_PEratio = MarketService.dividendYieldCommon(t_price, t_dividend);

        t_text = t_text + "<p>    Share " + t_symbol + " Price " + t_price + " dividend yield " + t_dividend + " P/E Ratio " + t_PEratio + " </p>";

        t_text = t_text + "<p>     </p>";
        t_text = t_text + "<p> <b>   iii. Record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price </b></p>";

        trade t_trade = new trade();
        t_trade.setSymbol("POP");
        t_trade.setQty(120);
        t_trade.setType(trade.tradetype.buy);
        t_trade.setTradePrice(888.88f);

        trade t_returnTrade = MarketService.createTrade(t_trade);

        Date t_date_TimeStamp = new Date(t_returnTrade.getTimeStamp());
        SimpleDateFormat dateformatter = new SimpleDateFormat("dd/mm/yyyy HH:mm");

        t_text = t_text + "<p>    Trade records at " + dateformatter.format(t_date_TimeStamp) + " Share " + t_trade.getSymbol() + " Qty " + t_trade.getQty() + "  Type " + t_trade.getType() + " Price " +t_trade.getTradePrice()+ "</p>";

        t_text = t_text + "<p>     </p>";
        t_text = t_text + "<p><b>   iv. Calculate Volume Weighted Stock Price based on trades in past 15 minutes</b></p>";

        Collection<trade> t_15minTrades = MarketService.findLast15minsTrades();

        int t_sampleSize = t_15minTrades.size();
        int[] t_15minQty = new int[t_sampleSize];
        float[] t_15minPrices = new float[t_sampleSize];

        t_text = t_text + "<p>     </p>";
        int i = 0;
        for (trade t_15minTrade : t_15minTrades) {
          t_text = t_text + "<p>     " + t_15minTrade.toString() + "</p>";
          t_15minQty[i] = t_15minTrade.getQty();
          t_15minPrices[i] = t_15minTrade.getTradePrice();
          i++;
        }

        float t_volumeWeightStockPrice = MarketService.volumeWeightStockPrice(t_15minPrices, t_15minQty);

        t_text = t_text + "<p>    Volume Weight Stock Price  " + t_volumeWeightStockPrice + "</p>";

        t_text = t_text + "<p>     </p>";
        t_text = t_text + "<p><b>   b. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks </b></p>";

        Collection<trade> t_allTrade = MarketService.findAlltrades();

        t_sampleSize = t_allTrade.size();
        float[] t_allPrices = new float[t_sampleSize];
        i = 0;
        for(trade t_atrade : t_allTrade) {
            t_text = t_text + "<p>" + t_atrade.toString() + "</p>";
            t_allPrices[i] = t_atrade.getTradePrice();
            i++;
        }

        float t_GBCE = MarketService.geometricMean(t_allPrices);

        t_text = t_text + "<p>   GBCE All Share Index " + t_GBCE + "  </p>";
        t_text = t_text + "<p>     </p>";

      return t_text;
  }

}
