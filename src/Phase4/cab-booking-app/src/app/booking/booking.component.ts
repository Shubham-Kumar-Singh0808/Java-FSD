import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';

declare var $: any;

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  drivers: any[] = [];
  selectedDriver: any;
  
  @ViewChild('driverDetailsModal')
  driverDetailsModal!: ElementRef;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getNearbyDrivers('Delhi', 'Mumbai'); 
  }

  getNearbyDrivers(from: string, to: string): void {
    this.http.get<any>('http://localhost:3333/nearbyDrivers', {
      params: {
        from: from,
        to: to
      }
    }).subscribe(
      response => {
        this.drivers = response;
      },
      error => {
        console.error('Error fetching nearby drivers:', error);
      }
    );
  }

  showDetails(driver: any): void {
    this.selectedDriver = driver;
    $(this.driverDetailsModal.nativeElement).modal('show');
  }

  bookNow(): void {
    this.http.post('http://localhost:3333/booking', this.selectedDriver)
      .subscribe(
        response => {
          console.log('Booking successful:', response);
          $(this.driverDetailsModal.nativeElement).modal('hide');
        },
        error => {
          console.error('Error booking:', error);
        }
      );
  }
}
