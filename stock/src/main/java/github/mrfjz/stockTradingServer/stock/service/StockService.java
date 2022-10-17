package github.mrfjz.stockTradingServer.stock.service;

import github.mrfjz.stockTradingServer.stock.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getStocks();
    Stock getStock(Long id);
    Stock addNewStock(Stock newStock);
    Stock updateStock(Long id, Stock newStock);
    void deleteStock(Long id);
}
