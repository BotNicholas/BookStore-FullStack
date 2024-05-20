import {Component, ElementRef, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormsModule, NgModel} from "@angular/forms";
import {Author} from "../../models/Author";
import {NgIf} from "@angular/common";
import {MatDatepickerInput} from "@angular/material/datepicker";
import {MatButton} from "@angular/material/button";
import {AdultDirective} from "../../directives/adult.directive";
import {MatOption, MatSelect} from "@angular/material/select";
import {CdkTextareaAutosize} from "@angular/cdk/text-field";
import {defaultMaxUploadFileSize} from "../../constants/constants";

@Component({
  selector: 'app-add-edit-author-dialog',
  standalone: true,
  imports: [MatDialogModule, MatFormField, MatInput, MatLabel, FormsModule, NgIf, MatError, MatDatepickerInput, MatButton, AdultDirective, MatSelect, MatOption, CdkTextareaAutosize],
  templateUrl: './add-edit-author-dialog.component.html',
  styleUrl: './add-edit-author-dialog.component.css'
})
export class AddEditAuthorDialogComponent {
  maxFileUploadSize: number = defaultMaxUploadFileSize;
  heading: string = "Add new";
  author: Author = new Author(0, "", "", "", new Date(), "U", "", "", "Placeholder.png", []);
  file: File | null = null;
  uploadedFileSize: number = 0;
  constructor(private dialogRef: MatDialogRef<AddEditAuthorDialogComponent>, @Inject(MAT_DIALOG_DATA) private oldAuthor: Author) {
    if (oldAuthor){
      this.heading = "Edit";
      this.copyAuthor(this.author, oldAuthor);
    }
  }

  copyAuthor(author: Author, oldAuthor: Author){
    author.id = oldAuthor.id;
    author.firstname = oldAuthor.firstname;
    author.lastname = oldAuthor.lastname;
    author.initials = oldAuthor.initials;
    author.birthDate = oldAuthor.birthDate;
    author.gender = oldAuthor.gender;
    author.contactDetails = oldAuthor.contactDetails;
    author.otherDetails = oldAuthor.otherDetails;
    author.image = oldAuthor.image;
    author.books = oldAuthor.books;
  }
  close(){
    this.dialogRef.close();
  }

  onFileUploaded(event: any, model: NgModel){
    // console.log(event);
    // console.log(event.target);
    // console.log(event.target.valid);

    //Model invalidation from CODE
    // console.log(model);
    // console.log(model.hasError("fileSize"));
    // console.log(model.control.setErrors({"fileSize": true}));
    // console.log(model.hasError("fileSize"));

    if (event.target.files[0]) {
      this.uploadedFileSize = event.target.files[0].size;
      if (this.uploadedFileSize > this.maxFileUploadSize) {
        model.control.setErrors({"fileSize": true});
      } else {
        this.file = event.target.files[0];
      }
    }

    // В Angular формы реагируют на изменения состояния и автоматически переоценивают валидность поля при каждом изменении его значения. Когда вы устанавливаете новое значение для модели формы, Angular запускает процесс проверки валидности, который по умолчанию учитывает только валидаторы, привязанные к этому полю. В вашем случае, если вы не установили новые ошибки, предыдущие ошибки связанные только с этим полем (которые вы могли установить ранее) будут сброшены, если они не поддерживаются текущим состоянием или другими валидаторами.
  }

  save(){
    const formData = new FormData(); //equivalent ti <form type="multipart/form-data"> - here it is, formData (form-data)

    if (this.file) {
      formData.append("photo", this.file, this.file.name)
      this.author.image = this.file.name;
      // console.log(this.file.name);
      // console.log(formData);
    }
    this.author.initials = this.author.firstname.toUpperCase().charAt(0) + this.author.lastname.toUpperCase().charAt(0);

    formData.append("author", JSON.stringify(this.author));

    this.dialogRef.close(formData);
  }

  protected readonly console = console;
  protected readonly defaultMaxUploadFileSize = defaultMaxUploadFileSize;
}
