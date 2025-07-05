package Utils;

import Decorators.ShippableDecorator;
import Model.Cart;
import Model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class ShipmentService {


    public static List<ShipmentDto> getShipmentNotice(Cart cart)
    {
        List<ShipmentDto> shipmentDtos = new ArrayList<ShipmentDto>();

        for (CartItem item : cart.getItems()) {

            if(item.getItem() instanceof ShippableDecorator)
            {
                ShipmentDto shipmentDto =
                        new ShipmentDto(item.getItem().getName(), item.getQuantity(),
                                ((ShippableDecorator)item.getItem()).getWeight() * item.getQuantity());
                shipmentDtos.add(shipmentDto);
            }

            else {
                ShipmentDto shipmentDto =
                        new ShipmentDto(item.getItem().getName(), item.getQuantity(),0);
                shipmentDtos.add(shipmentDto);
            }

        }

        return shipmentDtos;
    }
}
