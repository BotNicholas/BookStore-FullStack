import { Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {BooksComponent} from "./components/books/books.component";
import {AuthorsComponent} from "./components/authors/authors.component";
import {CategoriesComponent} from "./components/categories/categories.component";
import {ContactsComponent} from "./components/contacts/contacts.component";
import {ContactTypesComponent} from "./components/contact-types/contact-types.component";
import {CostumersComponent} from "./components/costumers/costumers.component";
import {OrdersComponent} from "./components/orders/orders.component";
import {OrderItemsComponent} from "./components/order-items/order-items.component";
import {UsersComponent} from "./components/users/users.component";
import {MeComponent} from "./components/me/me.component";
import {MainComponent} from "./components/main/main.component";
import {AuthorComponent} from "./components/authors/author/author.component";
import {CategoryComponent} from "./components/categories/category/category.component";
import {ContactTypeComponent} from "./components/contact-types/contact-type/contact-type.component";
import {CostumerComponent} from "./components/costumers/costumer/costumer.component";
import {BookComponent} from "./components/books/book/book.component";

// export const routes: Routes = [
//   {path: '', component: HomeComponent},
//   {path: 'books', component: BooksComponent},
//   {path: 'authors', component: AuthorsComponent},
//   {path: 'categories', component: CategoriesComponent},
//   {path: 'contacts', component: ContactsComponent},
//   {path: 'contact-types', component: ContactTypesComponent},
//   {path: 'costumers', component: CostumersComponent},
//   {path: 'orders', component: OrdersComponent},
//   {path: 'order-items', component: OrderItemsComponent},
//   {path: 'users', component: UsersComponent},
//   {path: 'me', component: MeComponent},
//   {path: '**', redirectTo: '/'}
// ];

export const routes: Routes = [
  {path: '', component: MainComponent, children: [
      {path: '', component: HomeComponent},
      {path: 'books', children: [
          {path: '', component: BooksComponent},
          {path: ':id', component: BookComponent},
        ]},
      //Here router outlet in AuthorsComponent is not needed
      {path: 'authors', children: [
          {path: '', component: AuthorsComponent},
          {path: ':id', component: AuthorComponent},
        ]},
      //OR
      // {path: 'authors', component: AuthorsComponent},
      // {path: 'authors/:id', component: AuthorComponent},
      //
      //Here router outlet is needed, because AuthorsComponent will be rendered first, and then all the children components will be rendered inside router outlet of the parent
      // {path: 'authors', component:AuthorsComponent, children: [
      //     {path: '', component: AuthorsComponent},
      //     {path: ':id', component: AuthorComponent},
      //   ]},
      {path: 'categories', children: [
          {path: '', component: CategoriesComponent},
          {path: ':id', component: CategoryComponent},
        ]},
      {path: 'contacts', component: ContactsComponent},
      {path: 'contact-types', children: [
          {path: '', component: ContactTypesComponent},
          {path: ':id', component: ContactTypeComponent},
        ]},
      {path: 'costumers', children: [
          {path: '', component: CostumersComponent},
          {path: ':id', component: CostumerComponent},
        ]},
      {path: 'orders', component: OrdersComponent},
      {path: 'order-items', component: OrderItemsComponent},
      {path: 'users', component: UsersComponent}
    ]},
  {path: 'me', component: MeComponent},
  {path: '**', redirectTo: '/'}
];
