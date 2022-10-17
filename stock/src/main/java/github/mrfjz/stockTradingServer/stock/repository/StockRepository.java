package github.mrfjz.stockTradingServer.stock.repository;

import github.mrfjz.stockTradingServer.stock.model.Market;
import github.mrfjz.stockTradingServer.stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findStockByCodeAndMarket(String code, Market market);
}
