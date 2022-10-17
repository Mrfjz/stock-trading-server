package github.mrfjz.stockTradingServer.stock.service;

import github.mrfjz.stockTradingServer.stock.exception.NoSuchStockExistsException;
import github.mrfjz.stockTradingServer.stock.exception.StockAlreadyExistsException;
import github.mrfjz.stockTradingServer.stock.exception.StockColumnNotNullableException;
import github.mrfjz.stockTradingServer.stock.model.Stock;
import github.mrfjz.stockTradingServer.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStock(Long id) {
        return stockRepository.findById(id).orElseThrow(
                ()
                        -> new NoSuchStockExistsException(
                                "NO STOCK PRESENT WITH ID "  + id));
    }

    @Override
    public Stock addNewStock(Stock newStock) {
        var code = newStock.getCode();
        var market = newStock.getMarket();
        if (code == null || market == null) {
            throw new StockColumnNotNullableException("'code' and 'market' must not be null");
        }

        var stock = stockRepository.findStockByCodeAndMarket(
                code,
                market
        );
        if(stock == null){
            return stockRepository.save(newStock);
        }else{
            throw new StockAlreadyExistsException("Stock already exists!");
        }
    }

    @Override
    public Stock updateStock(Long id, Stock newStock) {
        var stock = this.getStock(id);
        var code = newStock.getCode();
        var market = newStock.getMarket();
        if (code == null || market == null) {
            throw new StockColumnNotNullableException("require fields 'code' and 'market'");
        }
        stock.setCode(newStock.getCode());
        stock.setName(newStock.getName());
        stock.setDescription(newStock.getDescription());
        stock.setMarket(newStock.getMarket());
        stock.setPrecision(newStock.getPrecision());
        stock.setLotSize(newStock.getLotSize());
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        this.getStock(id);
        stockRepository.deleteById(id);
    }
}
