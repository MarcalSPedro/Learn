fun main() {
    StringTemplates()
}

fun StringTemplates() {
	// O que é uma string: é um conjunto de caracteres que por sua vez é definido dentro do aspas "";
    // exemplo de string: "Bom Dia! como você está?";
    // exemplo de caracter: "a";
    
    // Para facilitar a vida do desenvolvedor, suponhamos que exista varias variaveis
    // Quando declarar uma variavel não definir com acentuação
    // exemplo: var josé -- isso acarretara em erro
    var namorada = "bia"
    var namorado = "pedro"
    var meses = 4
    var saiu = 2
    
    // Quando for exibir esta mensagem para o usuário utilizamos o $ para acessar o valor da variavel sem precisar fugir da string;
    // exemplo: 
    println("O $namorado é namorado da $namorada")
    
    // Quando é necessário operações ou executar algum função ou validação enquanto exibe a mensage podemos colocar o ${variavel} 
    // a variavel definida pode passar por operações, mais comum com valores numericos
    println("O $namorado saiu com a $namorada por $saiu meses e, agora buscam alcançar ${meses + saiu} meses de namoro")
    
    // print() é uma função para retornar a mensagem para o usuario sem definir quebra de linha ao fim
    // println() é uma função para retornar a mensagem para o usuario adicionando definir quebra de linha ao fim da mensagem
}