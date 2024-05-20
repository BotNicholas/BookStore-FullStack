import {Component, Inject} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {DeleteDataType} from "../../utils/DeleteDataType";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-delete-confirmation',
  standalone: true,
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButton
  ],
  templateUrl: './delete-confirmation.component.html',
  styleUrl: './delete-confirmation.component.css'
})
export class DeleteConfirmationComponent {
  target: string = "";
  object: Object | null = null;

  constructor(private dialogRef: MatDialogRef<DeleteConfirmationComponent>, @Inject(MAT_DIALOG_DATA) public data: DeleteDataType) {
    this.target = data.target;
    this.object = data.object;
  }

  cancel(){
    this.dialogRef.close("No");
  }

  delete(){
    this.dialogRef.close("Yes");
  }
}
