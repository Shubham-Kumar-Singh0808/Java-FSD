import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { ProductListComponent } from './app/products/product-list.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
