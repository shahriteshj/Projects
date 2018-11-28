import { Component, OnInit } from '@angular/core';
import { Item } from '../model/Item';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  items:Item[] =[
    {
      name:'iPhone 7',
      price:15000.0,
      photoPath:'assets/images/phone1.jpg'
    },
    {
      name:'iWatch',
      price:15000.0,
      photoPath:'assets/images/iwatch.jpg'
    },
    {
      name:'Juice',
      price:15000.0,
      photoPath:'assets/images/juice.jpg'
    },
    {
      name:'Perfume',
      price:15000.0,
      photoPath:'assets/images/perfume.jpg'
    },
    {
      name:'Headphones',
      price:15000.0,
      photoPath:'assets/images/headphones.jpg'
    },
    {
      name:'Shoes',
      price:15000.0,
      photoPath:'assets/images/shoes.jpg'
    }
  ]

  constructor() { }

  ngOnInit() {
  }



}
