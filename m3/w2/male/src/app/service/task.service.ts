import { Injectable } from '@angular/core';
import { TodoList } from '../interface/todo-list.interface';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  coseDaFare: TodoList [] = []

  constructor() { }

  visualizzaLista () {
    return this.coseDaFare
  }
}


