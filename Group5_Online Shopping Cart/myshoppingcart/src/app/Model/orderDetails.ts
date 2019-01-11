export class OrderDetails{
    productId: number;
    productName: String;
    productQuantity: number;
    productPrice: number;
    constructor(pid,pn,pq,pp){
        this.productId = pid;
        this.productName= pn;
        this.productQuantity= pq;
        this.productPrice = pp;
    }
  }