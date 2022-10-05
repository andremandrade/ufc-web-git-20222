contador = 0;
contador: string = "a";
contador = null;
aluno = {
    nome: "maria",
    end: { 
        rua: "rua 2",
        num: 67
    }
}

console.log(aluno);
function abrirAlert(){
    console.log('mouse passou no texto ' + contador++);
}