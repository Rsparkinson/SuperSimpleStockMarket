package uk.co.rparkinson.SuperSimpleStockMarket.service;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import uk.co.rparkinson.SuperSimpleStockMarket.AbstractTest;
import uk.co.rparkinson.SuperSimpleStockMarket.model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MarketServiceTest extends AbstractTest {

    @Autowired
    private MarketService service;

    @Before
    public void setUp() {
      service.loadData();
    }

    @After
    public void tearDown() {
      service.loadData();
    }

    @Test
    public void testFindAllshares() {
        Collection<share> list = service.findAllshares();
        Assert.assertNotNull("failure - expected not null", list);
    }

    @Test
    public void testFindOneShare() {
        int t_id = 1;

        share entity = service.findShare(t_id);
        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected id attribute match", t_id,
                entity.getId());
    }

    @Test
    public void testNotFindOneShare() {
        int t_id = Integer.MAX_VALUE;

        share entity = service.findShare(t_id);
        Assert.assertNull("failure - expected null", entity);
    }

    @Test
    public void testFindSymbol() {
        String t_symbol = "ALE";

        share entity = service.findShare(t_symbol);
        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected symbol attribute match", t_symbol,
                entity.getSymbol());
    }

    @Test
    public void testNotFindSymbol() {
        String t_symbol = "---";

        share entity = service.findShare(t_symbol);
        Assert.assertNull("failure - expected null", entity);
    }

    @Test
    public void testCreateShare() {

        share entity = new share();
        entity.setSymbol("JOE");
        entity.setType("Common");
        entity.setLastDividend(13f);
        entity.setFixedDividend(0f);
        entity.setParValue(250f);

        share createdEntity = service.createShare(entity);

        Assert.assertNotNull("failure - expected not null", createdEntity);
        Assert.assertNotNull("failure - expected id attribute not null",
                createdEntity.getId());
        Assert.assertEquals("failure - expected symbol attribute match", "JOE",
                createdEntity.getSymbol());
    }

    @Test
    public void testCreateShareWithId() {

        share entity = new share();
        entity.setId(Integer.MAX_VALUE);
        entity.setSymbol("JOE");
        entity.setType("Common");
        entity.setLastDividend(13f);
        entity.setFixedDividend(0f);
        entity.setParValue(250f);

        share createdEntity = service.createShare(entity);

        Assert.assertNotNull("failure - expected not null", createdEntity);
        Assert.assertNotNull("failure - expected id attribute not null",
                createdEntity.getId());
        Assert.assertEquals("failure - expected symbol attribute match", "JOE",
                createdEntity.getSymbol());
    }

    @Test
    public void testUpdateShare() {

        int t_id = 1;
        String t_symbol = "CCC";

        share entity = service.findShare(t_id);
        Assert.assertNotNull("failure - expected not null", entity);

        entity.setSymbol(t_symbol);
        share updatedEntity = service.updateShare(entity);
        Assert.assertNotNull("failure - expected not null", updatedEntity);

        share findEntity = service.findShare(t_symbol);
        Assert.assertNotNull("failure - expected not null", findEntity);
        Assert.assertEquals("failure - expected symbol attribute match", t_symbol,
            findEntity.getSymbol());
        Assert.assertEquals("failure - expected id attribute match", t_id,
            findEntity.getId());
    }

    @Test
    public void testUpdateShareNotFound() {

        int t_id = Integer.MAX_VALUE;
        Exception t_exception = null;

        share entity = new share();
        entity.setId(Integer.MAX_VALUE);
        entity.setSymbol("XXX");
        entity.setType("Common");
        entity.setLastDividend(999f);
        entity.setFixedDividend(999f);
        entity.setParValue(999f);

        try {
          share updatedEntity = service.updateShare(entity);
        } catch(Exception e) {
          t_exception = e;
        }

        Assert.assertNotNull("failure - expected exception", t_exception);
        Assert.assertTrue("failure - expected NoResultException",
                t_exception instanceof NoResultException);
    }

    @Test
    public void testDelete() {
      int t_id = 2;

      share entity = service.findShare(t_id);
      Assert.assertNotNull("failure - expected not null", entity);

      service.deleteShare(t_id);
      share delEntity = service.findShare(t_id);
      Assert.assertNull("failure - expected null", delEntity);
    }

    @Test
    public void testCreateTrade() {

        trade entity = new trade();
        entity.setSymbol("POP");
        entity.setQty(10);
        entity.setType("Buy");
        entity.setTradePrice(12.12f);

        trade createdEntity = service.createTrade(entity);

        Assert.assertNotNull("failure - expected not null", createdEntity);
        Assert.assertNotNull("failure - expected id attribute not null",
                createdEntity.getId());
        Assert.assertEquals("failure - expected qty attribute match", 10,
                createdEntity.getQty());
    }

    @Test
    public void testFindAllTrades() {
        Collection<trade> list = service.findAlltrades();
        Assert.assertNotNull("failure - expected not null", list);
    }

    @Test
    public void testFindOneTrade() {
        int t_id = 2;

        trade entity = service.findTrade(t_id);
        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected id attribute match", t_id,
                entity.getId());
    }

    @Test
    public void testNotFindOneTrade() {
        int t_id = Integer.MAX_VALUE;

        trade entity = service.findTrade(t_id);
        Assert.assertNull("failure - expected null", entity);
    }

    @Test
    public void testFindLast15mins() {
        Collection<trade> list = service.findLast15minsTrades();
        Assert.assertNotNull("failure - expected not null", list);
    }

}
