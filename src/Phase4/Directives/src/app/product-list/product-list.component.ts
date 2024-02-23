// product-list.component.ts

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  
  products: any[] = [
    { name: 'Product 1', code: '123', date: '2024-02-24', price: '$10', rating: 5 },
    { name: 'Product 2', code: '456', date: '2024-02-25', price: '$20', rating: 4 },
    // Add more products as needed
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
