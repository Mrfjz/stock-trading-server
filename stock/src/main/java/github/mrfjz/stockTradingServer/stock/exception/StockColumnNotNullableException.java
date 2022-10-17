package github.mrfjz.stockTradingServer.stock.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StockColumnNotNullableException extends RuntimeException{
    private String message;
}
