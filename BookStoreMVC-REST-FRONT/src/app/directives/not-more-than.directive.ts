import {Directive, Input} from '@angular/core';
import {AbstractControl, NG_VALIDATORS, ValidationErrors, Validator} from "@angular/forms";

@Directive({
  selector: '[notMoreThan]',
  standalone: true,
  providers: [{provide:NG_VALIDATORS, useExisting: NotMoreThanDirective, multi: true}]
})
export class NotMoreThanDirective implements Validator{
  @Input('notMoreThan') max: number = 1;

  constructor() { }

  validate(control: AbstractControl): ValidationErrors | null {
    // console.log(`\tcomparing ${control.value} with ${this.max}`);

    if (+control.value > +this.max){
      // console.error('Not less than ' + this.max);
      return {"notMoreThan": true};
    }
    // console.log("\t\tGOOD");
    return null;
  }

}
