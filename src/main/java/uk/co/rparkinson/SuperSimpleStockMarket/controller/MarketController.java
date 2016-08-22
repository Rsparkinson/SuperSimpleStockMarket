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

@Controller
public class MarketController {

  private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

  @Autowired
  private MarketService MarketService;

  @ResponseBody
  @RequestMapping("/")
  String home() {

      //MarketService.loadData();

      //Collection<share> r_shares = MarketService.findAll();

    // //i. Given any price as input, calculate the dividend yield
    //     String t_symbol = "TEA";
    //     float t_price = 123.65f;
    //     float t_result = 0f;
    //
    //     share t_share = c_ShareService.find(t_symbol);
    //
    //     if (t_share.getType().equals("Common")) {
    //       float t_lastDividend = t_share.getLastDividend();
    //       t_result = c_CalcService.dividendYieldCommon(t_lastDividend, t_price);
    //     }
    //
    //     if (t_share.getType().equals("Preferred")) {
    //       float t_fixedDividend = t_share.getFixedDividend();
    //       float t_parValue = t_share.getParValue();
    //       t_result = c_CalcService.dividendYieldPreferred(t_fixedDividend, t_parValue, t_price);
    //     }
    //
    //     t_HTMLresults = "Result = " + t_result;
      return "SuperSimpleStockMarket";
  }

}
