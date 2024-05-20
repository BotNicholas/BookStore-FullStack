import { Directive } from '@angular/core';
import {AbstractControl, NG_VALIDATORS, ValidationErrors, Validator} from "@angular/forms";
import {millisecondsInYear} from "../constants/constants";

@Directive({
  selector: '[adult]',
  standalone: true,
  providers: [{provide: NG_VALIDATORS, useExisting: AdultDirective, multi: true}],
})
export class AdultDirective implements Validator{

  constructor() { }

  validate(control: AbstractControl): ValidationErrors | null {
    const date1 = new Date(control.value);
    const date2 = new Date();
    //
    // console.log(date1);
    // console.log(date2);
    // console.log(Math.abs(date1.getTime() - date2.getTime()));
    // console.log(Math.abs(date1.getTime() - date2.getTime()) <= (18*millisecondsInYear));


    if( Math.abs(date1.getTime() - date2.getTime()) < (18*millisecondsInYear) ) {
      return {"adult": true};
    }
    return null;
  }

}
