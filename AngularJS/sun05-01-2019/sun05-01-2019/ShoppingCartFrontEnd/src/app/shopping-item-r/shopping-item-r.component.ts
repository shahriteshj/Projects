import { Component, OnInit } from '@angular/core';
import { ShoppingItem } from '../model/ShoppingItem';
import { DataService } from '../services/dataService.service';
import { CartService } from '../services/cart.service';
import { SharedDataService } from '../services/sharedData.service';

@Component({
    selector: "app-shopping-item-r",
    templateUrl: './shopping-item-r.component.html',
    styleUrls: ['./shopping-item-r.component.css']
})

export class ShoppingItemRComponent implements OnInit {

    shoppingItems: ShoppingItem[] = [];
    constructor(private dataService: DataService,
        private cartService: CartService,
        private sharedDataService: SharedDataService) {

    }

    ngOnInit() {
        this.getItems();
    }

    getItems() {
        this.dataService.getItems().subscribe(items => this.shoppingItems = items);
    }

    addToCart(item: ShoppingItem) {
        this.cartService.addToCart({
            itemName: item.itemName,
            itemBought: item.itemBought,
            price: item.price
        });
        this.sharedDataService.noOfCartItems += 1;
    }
}