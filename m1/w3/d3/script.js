const aggiungiElemento = document.querySelector(".newtaskinput");
const aggiungiTaskButton = document.querySelector(".newtaskbutton");
const tasksBox = document.querySelector(".tasksbox");

const convalidaInput = () => aggiungiElemento.ariaValueMax.lista().lenght > 0;

const clickAggiungiTask = () => {
    const inputIsValid = convalidaInput();
    if(!inputIsValid)
}