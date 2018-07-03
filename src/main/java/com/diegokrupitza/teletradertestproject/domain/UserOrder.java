package com.diegokrupitza.teletradertestproject.domain;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Project: teletrader-test-project
 * Document: UserOrder.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOrder extends BaseModel<UserOrder> {

    @DecimalMin(value = "0.001")
    @NotNull
    @NonNull
    private double price;

    @Min(value = 1L)
    @NotNull
    @NonNull
    private int amount;

    @NotNull
    @NonNull
    @Enumerated(EnumType.STRING)
    private OrderTyp orderTyp;

    @Nullable
    private LocalDateTime persistenceTimeStamp;

    @PrePersist
    private void setPersistenceTimeStamp() {
        this.persistenceTimeStamp = LocalDateTime.now();
    }

}
