import { Component } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  products = [
    {
      productName: 'Product 1',
      productCode: 'PROD-001',
      available: true,
      price: 100,
      rating: 4.5
    },
    {
      productName: 'Product 2',
      productCode: 'PROD-002',
      available: false,
      price: 200,
      rating: 3.8
    },
  
  ];
}
