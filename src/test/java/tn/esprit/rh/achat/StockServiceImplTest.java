package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.List;

@SpringBootTest
public class StockServiceImplTest {
    @Autowired
    private StockServiceImpl stockServiceImpl;
    @Autowired
    private StockRepository stockRepository;
    @Test
    public void retrieveAllStocks() {
       List<Stock> stockList = stockServiceImpl.retrieveAllStocks();
        Assertions.assertEquals(0,stockList.size());
    }

    @Test
    public void addStock() {
        Stock stock=new Stock();
        stock.setLibelleStock("ADDStock");
        stock.setQte(150);
        stock.setQteMin(50);
        Stock s = stockServiceImpl.addStock(stock);
        Assertions.assertEquals(stock.getLibelleStock(), s.getLibelleStock());
    }

    @Test
    public void updateStock() {

        Stock stock=stockServiceImpl.retrieveStock(1L);
        stock.setLibelleStock("UPDATEStock");
        Stock s = stockServiceImpl.updateStock(stock);
        Assertions.assertEquals(stock.getLibelleStock(), s.getLibelleStock());
    }

    @Test
    public void retrieveStock(){
        Stock stock=stockServiceImpl.retrieveStock(1L);
        Assertions.assertEquals(1L,stock.getIdStock());
    }
}
