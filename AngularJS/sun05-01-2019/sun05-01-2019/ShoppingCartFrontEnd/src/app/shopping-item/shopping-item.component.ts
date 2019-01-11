import { Component,OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DataService } from '../services/dataService.service';
import { ShoppingItem } from '../model/shoppingItem';
import { debug } from 'util';

@Component({
    selector:'app-shopping-item',
    templateUrl:'./shopping-item.component.html',
    styleUrls:['./shopping-item.component.css']
}) 

export class ShoppingItemComponent implements OnInit{
    isAdd: boolean = true;
    shoppingItem: ShoppingItem = {
        _id:null,
        itemName:null,
        itemQuantity:null,
        price:null
    };
    shoppingItems: ShoppingItem[]=[];
    constructor (private dataService: DataService){
        
    }
    ngOnInit(){
        this.getItems();
    }
 
    getItems(){
        this.dataService.getItems().subscribe(items=> this.shoppingItems = items);
    }

    addUpdateItem(shoppingItem: ShoppingItem){
        if(this.isAdd){
            this.dataService.addNewItem(shoppingItem).subscribe(res =>
            {
                this.getItems();
                this.clearForm();
            });
        }
        else{
            this.dataService.updateItem(shoppingItem).subscribe(res =>
            {
                this.getItems();
                this.clearForm();
                this.isAdd = true;
            });
        }
    }

    editItem(shoppingItem: ShoppingItem){
        this.isAdd = false;
        this.shoppingItem = {  
            _id:shoppingItem._id,
            itemName:shoppingItem.itemName,
            itemQuantity:shoppingItem.itemQuantity,
            price:shoppingItem.price
        };
    }

    deleteItem(id: string){
        this.dataService.deleteItem(id).subscribe(res => this.getItems());
    }

    clearForm(){
        this.shoppingItem = {
            _id:null,
            itemName:null,
            itemQuantity:null,
            price:null
        };
    }
}