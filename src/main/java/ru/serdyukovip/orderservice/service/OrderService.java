package ru.serdyukovip.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.serdyukovip.orderservice.dto.OrderLinteItemsDto;
import ru.serdyukovip.orderservice.dto.OrderRequest;
import ru.serdyukovip.orderservice.model.Order;
import ru.serdyukovip.orderservice.model.OrderLinteItems;
import ru.serdyukovip.orderservice.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLinteItems> orderLineItems = orderRequest.getOrderLinteItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLinteItemsList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLinteItems mapToDto(OrderLinteItemsDto orderLineItemsDto) {
        OrderLinteItems orderLinteItems = new OrderLinteItems();
        orderLinteItems.setPrice(orderLineItemsDto.getPrice());
        orderLinteItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLinteItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLinteItems;
    }
}
