import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/service/task.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {

  arrayList = this.taskSpunta.visualizzaLista()

  newTask: any;

  constructor(private taskSpunta: TaskService) { }

  ngOnInit(): void {
  }

}
