import { Component } from '@angular/core';

interface Product {
  productName: string;
  available: boolean;
  price: number;
  rating: number;
}

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  products: Product[] = [
    { productName: 'Product 1', available: true, price: 10, rating: 4 },
    { productName: 'Product 2', available: false, price: 25, rating: 3 },
    { productName: 'Product 3', available: true, price: 30, rating: 5 }
  ];

  constructor() { }
}
