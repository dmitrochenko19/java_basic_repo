function clear(){
    let name = document.getElementById("name");
    let date = document.getElementById("date");
    let sex = document.getElementById("sex");
    name.value = "";
    date.value = "";
    sex.value = "мужчина";
}
function addStudent() {
    const name = document.getElementById("name").value;
    const date = document.getElementById("date").value;
    const sex = document.getElementById("sex").value;

    if(name===""){
        alert("Вы не ввели имя. Попробуйте ещё раз");
        clear();
        return;
    }

    if(date===""){
        alert("Вы не ввели дату. Попробуйте ещё раз");
        clear();
        return;
    }

    if(new Date(date)>new Date()){
        alert("Вы ввели недопустимую дату");
        clear();
        return;
    }

    const studentTable = document.getElementById("tbody");
    const newRow = studentTable.insertRow(studentTable.rows.length);

    const newCellName = newRow.insertCell(-1);
    newCellName.appendChild(document.createTextNode(name));

    const newCellSex = newRow.insertCell(-1);
    newCellSex.appendChild(document.createTextNode(sex));

    const newCellDate = newRow.insertCell(-1);
    newCellDate.appendChild(document.createTextNode(date));

    const newCellAge = newRow.insertCell(-1);
    const age = countAge(date);
    let r = document.createTextNode(String(age));
    newCellAge.appendChild(r);

    changeResultRow();
    clear();

}
function changeResultRow(){
    let resultCell = document.getElementById("result_age");
    resultCell.innerHTML = String(countMediumAge());
}

function countAge(date){
    let age = Math.floor((new Date()-new Date(date)) / 1000 / 60 / 60 / 24 / 365);
    return age;
}
function countMediumAge(){

    const allBody = document.getElementById("tbody");
    const allRows = allBody.getElementsByTagName("tr");
    let sumAge = 0;
    let numberOfStudents = 0;
    for (let i = 1; i < allRows.length; i++) {
        let age = parseInt(allRows[i].getElementsByTagName("td")[3].innerHTML);
        numberOfStudents+=1;
        sumAge+=age;
    }

    return Math.floor(sumAge/numberOfStudents);
}
