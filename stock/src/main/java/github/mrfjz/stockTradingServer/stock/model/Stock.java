package github.mrfjz.stockTradingServer.stock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"code", "market"})
})
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String code;
    private String name;
    private String description;
    private Integer precision;
    private Integer lotSize;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Market market;
}
