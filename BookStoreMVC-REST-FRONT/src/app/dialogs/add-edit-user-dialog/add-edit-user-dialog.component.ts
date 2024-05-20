import {Component, ElementRef, Inject, ViewChild} from '@angular/core';
import {FormsModule, NgModel} from "@angular/forms";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {MatButton} from "@angular/material/button";
import {User} from "../../models/User";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatOption, MatSelect} from "@angular/material/select";
import {NgClass} from "@angular/common";
import {defaultMaxUploadFileSize} from "../../constants/constants";

@Component({
  selector: 'app-add-edit-user-dialog',
  standalone: true,
  imports: [
    FormsModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButton,
    MatLabel,
    MatInput,
    MatError,
    MatFormField,
    MatSelect,
    MatOption,
    NgClass
  ],
  templateUrl: './add-edit-user-dialog.component.html',
  styleUrl: './add-edit-user-dialog.component.css'
})
export class AddEditUserDialogComponent {
  @ViewChild("password", {static: true}) password: NgModel|undefined;

  user: User = new User(0, "", "", "", null, "Placeholder.png");
  newUser: boolean = true;
  heading: string = "Add new ";
  usernames: string[] = [];
  file: File | null = null;
  maxFileUploadSize: number = defaultMaxUploadFileSize;
  uploadedFileSize: number = 0;
  constructor(private dialogRef: MatDialogRef<AddEditUserDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any) {
    if (data.user) {
      this.heading = "Edit ";
      this.newUser = false;
      this.copyUsers(this.user, data.user);
    }

    // console.log(data.usernamesList);
    if (data.usernamesList) {
      this.usernames = data.usernamesList;
    }
  }

  copyUsers(user1: User, user2: User){
    user1.id = user2.id;
    user1.image = user2.image;
    user1.costumer = user2.costumer;
    user1.roles = user2.roles;
    user1.password = user2.password;
    user1.username = user2.username;
  }

  checkUsernameAvailability(usernameModel: NgModel){
    console.log(usernameModel.value);

    if (this.usernames.indexOf(usernameModel.value) >= 0) {
      usernameModel.control.setErrors({"userUsername": true});
    }
  }

  onFileUploaded(event: any, model: NgModel){
    if(event.target.files[0]){
      this.uploadedFileSize = event.target.files[0].size;
      if (this.uploadedFileSize > this.maxFileUploadSize) {
        model.control.setErrors({"fileSize": true});
      } else {
        this.file = event.target.files[0];
      }
    }
  }

  close(){
    this.dialogRef.close();
  }

  save() {
    const formData = new FormData();

    if(this.file) {
      formData.append("photo", this.file, this.file.name);
      this.user.image = this.file.name;
    }

    if (this.newUser || (!this.newUser && this.password?.value)){
      this.user.password = this.password?.value;
    }

    formData.append("user", JSON.stringify(this.user));

    this.dialogRef.close(formData);
  }
}
