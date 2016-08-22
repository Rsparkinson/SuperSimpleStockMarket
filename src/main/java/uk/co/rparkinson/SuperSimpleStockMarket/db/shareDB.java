package uk.co.rparkinson.SuperSimpleStockMarket.db;

import uk.co.rparkinson.SuperSimpleStockMarket.model.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class shareDB {

  private static final Logger logger
    = LoggerFactory.getLogger(shareDB.class);

  private static Integer nextId = 0;
  private static Map<Integer, share> shareMap;

  public static share save(share p_share) {
    if (shareMap == null) {
      shareMap = new HashMap<Integer, share>();
      nextId = 1;
    }
    share r_share = null;

    // update
    if (shareMap.containsKey(p_share.getId())) {
      shareMap.remove(p_share.getId());
      shareMap.put(p_share.getId(), p_share);
      r_share = p_share;
    } else {

      // create
      try {
        p_share.setId(nextId);
        nextId++;
        shareMap.put(p_share.getId(), p_share);
        r_share = p_share;
      } catch(Exception e) {
        logger.error("shareDB save " + e);
      }
    }
    return r_share;
  }

  public static boolean remove(int p_id) {
    boolean r_success = false;
    share t_share = shareMap.remove(p_id);
    if (t_share != null) {
      r_success = true;
    }
    return r_success;
  }

  public static void init() {
    shareMap = new HashMap<Integer, share>();
    nextId = 1;

    try {
      share s1 = new share();
      s1.setSymbol("TEA");
      s1.setType("Common");
      s1.setLastDividend(0f);
      s1.setFixedDividend(0f);
      s1.setParValue(100f);
      save(s1);
    } catch(Exception e) {
      logger.error("shareDB 1 init " + e);
    }

    try {
      share s2 = new share();
      s2.setSymbol("POP");
      s2.setType("Common");
      s2.setLastDividend(8f);
      s2.setFixedDividend(0f);
      s2.setParValue(100f);
      save(s2);
    } catch(Exception e) {
      logger.error("shareDB 2 init " + e);
    }

    try {
      share s3 = new share();
      s3.setSymbol("ALE");
      s3.setType("Common");
      s3.setLastDividend(23f);
      s3.setFixedDividend(0f);
      s3.setParValue(60f);
      save(s3);
    } catch(Exception e) {
      logger.error("shareDB 3 init " + e);
    }

    try {
      share s4 = new share();
      s4.setSymbol("GIN");
      s4.setType("Preferred");
      s4.setLastDividend(8f);
      s4.setFixedDividend(0.02f);
      s4.setParValue(100f);
      save(s4);
    } catch(Exception e) {
      logger.error("shareDB 4 init " + e);
    }

    try {
      share s5 = new share();
      s5.setSymbol("JOE");
      s5.setType("Common");
      s5.setLastDividend(13f);
      s5.setFixedDividend(0f);
      s5.setParValue(250f);
      save(s5);
    } catch(Exception e) {
      logger.error("shareDB 5 init " + e);
    }
  }

  public static Collection<share> findAll() {
    Collection<share> r_shares = shareMap.values();
    return r_shares;
  }

  public static share find(int p_id) {
    share r_share = shareMap.get(p_id);
    return r_share;
  }

  public static share find(String p_Symbol) {
    share r_share = null;

    for(int i=1;i<shareMap.size() + 1;i++) {
      try {
        if (shareMap.get(i).getSymbol().equals(p_Symbol)) {
          r_share = shareMap.get(i);
        }
      } catch(Exception e) {
        logger.error("ShareDB find symbol " + e);
      }
    }
    return r_share;
  }

  public static share create(share p_share) {
    return save(p_share);
  }

  public static share update(share p_share) {
    share r_share = null;
    share shareToUpdate = find(p_share.getId());
    if (shareToUpdate != null) {
      r_share = save(p_share);
    }

    return r_share;
  }

  public static void delete(int p_id) {
    remove(p_id);
  }

}
