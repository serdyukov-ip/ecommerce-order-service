package ru.serdyukovip.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.serdyukovip.orderservice.model.OrderLinteItems;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLinteItemsDto> orderLinteItemsDtoList;
}
