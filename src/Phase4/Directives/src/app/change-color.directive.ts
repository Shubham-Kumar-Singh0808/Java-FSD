import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appChangeColor]'
})
export class ChangeColorDirective {

  constructor(private elementRef: ElementRef, private renderer: Renderer2) {
    // Change the color of the text to red
    this.renderer.setStyle(this.elementRef.nativeElement, 'color', 'red');
  }

}
