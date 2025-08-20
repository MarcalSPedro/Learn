fun Operadores_Aritmeticas() {
    val soma = 2 + 2;
    val subtracao =  2 - 2;
    val multiplicacao = 2 * 2;
    val divisao = 2 /  2;

    var abc = 0;

    abc = abc + 15;
    abc += 5

    // quando preciso que a expressão some 1 posso usar o ++;
    // quando preciso que o incremento seja antes do uso da variavel será definido antes

    println("primeiro abc ${abc}") // abc = 20

    println(abc++); // abc + 1; ele vai somar 1
    // primeiro ele vai exibir o valor e depois ele vai somar
    println(abc) // aqui ele já somou o +1

    println(++abc) // primeiro ele vai somar e depois ele vai exibir

    // abc++ é mais usado quando é para contagem que não precisa exibir ao usuário a informação
    // o ++abc é comumente usado quando vou precisar exibir esta mensagem já atualizada
}

fun Prioridade_Operacao() {
    var result = 2 + 3 * 4 // o resultado pelo computador será de 14
    println(result)
    result = (2 + 3) * 4  // o resultado será 20
    println(result)

    // ordem definida na ordem de prioridade
    // () o parenteses define a prioridade matematica do caso
    // * | %
    // +   -
}

fun Tipos_de_Dados() {
        var y: Boolean = false
        var npt: String = "Hello World"
        var c: Char = 'a'
        var f: Float = 10.5F
        var d: Double = 10.8752758
        var dgk = 150
        // variável indefinida
        var abc: Long = 150L
        // variável definida do tipo Long
        var i: Int = 150
        // variável do tipo inteiro
        var b: Byte = 10
        // para definir um Byte ou SHort é preciso definir explicitamente
        var s: Short = 15

        var str: String = "pode crescer indefinidamente"
}

fun Conceitos_Iniciais() {
    fun calcular_area_retangulo() {
        val base = 10; // crio a variavel de base
        val altura = 5; // crio a variavel de altura

        val area = base * altura; //
        println("a área do retangulo é de $area");
    }

    fun informacoes() {
        val nome: String = "Pedro"; // defino meu nome
        val numero_calcado: Int = 38; // defino meu numero de sapato
        val populacao_brasil: String = "212.500.00";

        println("Meu Nome é $nome, calço $numero_calcado, e o brasil tem população de $populacao_brasil")
    }

    fun Operacoes_Basicas() {
        var n1: Int = 2;
        var n2: Int = 2;

        var soma = n1 + n2;
        var divisao = n1
    }
}