import { OrderDetails } from "./orderDetails";

export class Order{
    email:String;
    shippingAddress: String;
    orderAmount: Number;
    //orderDetails: Array<[OrderDetails]>;
    orderDetails: OrderDetails[];
}
