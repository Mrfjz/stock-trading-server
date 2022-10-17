package github.mrfjz.stockTradingServer.stock.controller;

import github.mrfjz.stockTradingServer.stock.model.Stock;
import github.mrfjz.stockTradingServer.stock.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getStocks(){
        var stocks = stockService.getStocks();
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStock(@PathVariable Long id){
        return ResponseEntity.ok(stockService.getStock(id));
    }

    @PostMapping
    public ResponseEntity<Stock> addNewStock(@RequestBody Stock newStock) {
            return ResponseEntity.ok(stockService.addNewStock(newStock));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock newStock){
        return ResponseEntity.ok(stockService.updateStock(id, newStock));
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id){
        stockService.deleteStock(id);
    }

}
