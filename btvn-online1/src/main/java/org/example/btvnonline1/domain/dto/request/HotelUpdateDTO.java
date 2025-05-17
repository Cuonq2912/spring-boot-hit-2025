package org.example.btvnonline1.domain.dto.request;

import lombok.*;
import org.example.btvnonline1.constant.ErrorMessage;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelUpdateDTO {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String name;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String location;
    @DecimalMin(value = "0.0", inclusive = false, message = ErrorMessage.Hotel.ERR_PRICE_MUST_GREATER_THAN_ZERO)
    Double price;

}
