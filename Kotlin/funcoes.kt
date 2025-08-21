//--- Aula 1
// palavra reservada para criar uma função é fun

// parametro é um dado passado por outra função para esta
fun helloWorld(nome: String) {
    println("Olá, Mundo!");
}

// após o parenteses é necessário definir o tipo da variavel
fun media(n1: Int, n2: Int): Int {
    val media = (n1 + n2) / 2
    return media
}

fun main() {
    // para realizar a chamada é puxando o nome e colocando parenteses
    helloWorld("Gabriel!");
    println(media(10, 0))
}

// tudo que esta dentro da chaves é da função, logo eu não consigo acessar em outras funções por isso preciso passar este valor!

//--- Aula 2 
// para a conversão 

fun main() {
    val str = "15";
    str.toByte();   
    str.toShort();
    str.toInt();
    println(str.toLong());
    str.toFloat();
    str.toDouble();

    // caso eu tente 
    val str = "abc";
    println(str.toLong()); // vai quebrar!

    // no caso do toBoolean();
    str.toBoolean(); // se não for o caso true então vai retornar false

    val a: Byte = 0;
    val b: Short = 5;
    val c: Int = 10;
    val d: Long = 15L;
    val e: Float = 20F ;
    val f: Double = 25.0;

    f.toInt();
    println(f.toInt().toByte());
    println(f.toInt().toShort());
    f.toFloat()
}


//--- Aula 3
// Funções em única linha
// pode definir pelo igual e não precisa do return 
fun helloWorld(nome: String) = println("Olá, $nome");
fun media(n1: Int, n2: Int): Int = (n1 + n2) / 2

fun main() {
    helloWorld("Pedro")
    println(media(5, 6))
}


/**
palavras reservadas
var, fun, val

qual a função de um carro
andar

no seu programa voce precisa criar as funcoes
escrevente - peticao

fun dar_andamento(peticao: String): Boolean {

}
*/

// ensinamentos de retorno
fun main() {
	val nome: String = "B"
    val caracteristica: String = "Brava"
    val idade: Byte = 24
    
    juntar_informacoes(nome, caracteristica, idade)
}

fun saldo_bancario(): Byte {
	val credito: Byte = 50
    val debito: Byte = 0
    
    // eu só exibo
    
    // aqui eu posso devolver este valor para ser reutilizado em outros lugares 
    return (debito - credito).toByte()
}

fun familia() {
	println("Fulano, Sicrano, Beltrando")
}

fun juntar_informacoes(nome: String, caracteristica: String, idade: Byte) {
    val saldo = saldo_bancario()
    val valores_a_receber = saldo + 150
    familia()
	println("A $nome está $caracteristica pois com $idade anos tem $valores_a_receber no banco")
}


// prioridade de chamada
fun main() {
    a1() // ele executa e termina
    a3()
    a4()
    a2()
    // a, c, d, b
}

fun a1() {
	println("a")
}


fun a2() {
	println("b")
}

fun a3() {
	println("c")
}

fun a4() {
	println("d")
}