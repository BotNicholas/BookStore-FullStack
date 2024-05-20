import {Component, OnInit} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {AuthorsService} from "../../services/authors/authors.service";
import {UsersService} from "../../services/users/users.service";
import { User } from '../../models/User';
import {RouterLink} from "@angular/router";
import {url, usersImagesPath} from "../../constants/constants";
import {MatDialog} from "@angular/material/dialog";
import {AddEditUserDialogComponent} from "../../dialogs/add-edit-user-dialog/add-edit-user-dialog.component";
import {DeleteConfirmationComponent} from "../../dialogs/delete-confirmation/delete-confirmation.component";

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [HttpClientModule, RouterLink],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css',
  providers: [UsersService]
})
export class UsersComponent implements OnInit{
  users: User[] = [];
  constructor(private service: UsersService, private dialog: MatDialog) {}

  ngOnInit() {
    this.service.getAll().subscribe((data:any)=>this.users = data);
  }

  addNewUser(){
    const dialogRef = this.dialog.open(AddEditUserDialogComponent, {autoFocus: false, data: {usernamesList: this.users.map(user=>user.username)}});

    dialogRef.afterClosed().subscribe((data: any) => {
      if (data) {
        // console.log(data);
        this.service.save(data).subscribe((response:any) => {
          this.users.push(response);
        });
      }
    });
  }

  editUser(user: User){
    const dialogRef = this.dialog.open(AddEditUserDialogComponent, {autoFocus: false, data: {user: user, usernamesList: this.users.map(user=>user.username)}});

    dialogRef.afterClosed().subscribe((data: any) => {
      if (data) {
        // console.log(data);
        this.service.update(user.id, data).subscribe((response:any) => {
          let userIndex = this.users.indexOf(user);
          this.users[userIndex] = response;
        });
      }
    });
  }

  deleteUser(user: User){
    const dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus:false, data: {target: 'User', object: user}});

    dialogRef.afterClosed().subscribe((data: any) => {
      if (data == "Yes"){
        this.service.delete(user.id).subscribe((response:any) => {
          if (response.status == 204) {
            this.users.splice(this.users.indexOf(user), 1);
          }
        });
      }
    });

  }

  showTouchedUser(user: User) {
    alert(`${user.id} ${user.username} ${user.password} ${user.roles} ${user.costumer?.name} ${user.image}`);
  }

  protected readonly url = url;
  protected readonly usersImagesPath = usersImagesPath;
}
