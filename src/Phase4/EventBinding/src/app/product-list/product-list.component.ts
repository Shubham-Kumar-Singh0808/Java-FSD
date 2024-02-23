import { Component } from '@angular/core';

interface Product {
  image: string;
  name: string;
  code: string;
  available: string;
  price: string;
  rating: number;
  showProductImage: boolean; // New property
}

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  pageTitle: string = "Product List Page";
  imageWidth: number = 80;
  imageMargin: number = 10;
  showImage: boolean = false;

  products: Product[] = [
    { image: 'https://cdnmedia.dsc-cricket.com/media/catalog/product/cache/6d9f53a3f26f3a62c1c1c9add7c6ad94/p/l/player-edition-2.jpg', name: 'Bat', code: 'P001', available: 'Yes', price: '1000', rating: 4.5, showProductImage: false },
    { image: 'https://cdn.imgbin.com/11/5/15/imgbin-tennis-balls-the-us-open-tennis-tennis-cEGhW9SVBGbx2cPjyDaN3E0rC.jpg', name: 'Ball', code: 'P002', available: 'Yes', price: '100', rating: 3.8, showProductImage: false },
    { image: 'https://img2.exportersindia.com/product_images/bc-full/2020/9/7689886/cricket-wicket-set-1601105754-5594470.jpeg', name: 'Wicket', code: 'P003', available: 'Yes', price: '1200', rating: 4, showProductImage: false },
    { image: 'https://shop.teamsg.in/cdn/shop/products/Optipro-small-2-3-scaled.jpg?v=1696577951&width=1946', name: 'Helmet', code: 'P004', available: 'Yes', price: '2000', rating: 4.2, showProductImage: false },
    { image: 'https://5.imimg.com/data5/UL/XL/LF/SELLER-12035207/cricket-keeping-gloves.jpg', name: 'Gloves', code: 'P005', available: 'Yes', price: '2500', rating: 4.7, showProductImage: false },
  ];

  toggleImage(): void {
    this.showImage = !this.showImage;
    console.log('Value of ShowImage inside function:', this.showImage);
  }

  toggleProductImage(product: Product): void {
    product.showProductImage = !product.showProductImage;
  }
}
