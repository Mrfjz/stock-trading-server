package github.mrfjz.stockTradingServer.stock.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class NoSuchStockExistsException extends RuntimeException{
    private String message;
}
