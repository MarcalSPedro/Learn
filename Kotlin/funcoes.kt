/** Aula 1
*/
fun aula1() {
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
}

/** Aula 2 
 para a conversão  */
fun aula2() {
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

/**
Aula 3 
*/
func aula3() {
    // Funções em única linha
    // pode definir pelo igual e não precisa do return 
    fun helloWorld(nome: String) = println("Olá, $nome");
    fun media(n1: Int, n2: Int): Int = (n1 + n2) / 2

    fun main() {
        helloWorld("Pedro")
        println(media(5, 6))
    }
}

/**
Aula 4 */
fun aula4() {
    val str = "Programação Kotlin!";
    // acessar o index 
    
    // index 0 - P
    str[0]; // a contagem do index é sempre a partir do 0
    println(str[0]);
    // var a quantidade de caracteres
    println(str.length);

    // ver se começa o texto com o que eu passo como parametro com retorno de true ou false
    println(str.startsWith("Progra"));
    
    // o mesmo para finalizar
    println(str.endsWith("."));

    // buscar a partir da posição 5 e foi até o fim
    println(str.substring(6));
    // buscar a partir da posição deifiniida a até 
    println(str.substring(6, 8));
    // substituir o vlaor definido por:
    println(str.replace("o", "a"))

    //colocar em maiscula
    println(str.uppercase());
    // colocar em minuscula
    println(str.lowercase());
    // checar um valor
    println(str.contains("Kotlin"));

    // checar valores vazios
    str.isEmpty()
    // cortar os espaços em branco no fim e no começo
    "      ola      ".trim()
}

/**
Aula 5 - formatação de string */
fun aula5() {
    val nome = "John"
    println("Olá, $nome")

    "Olá, %s %s".format(nome, nome)
    // placeholder

    // %s - String
    // %d - int
    // %f - Ponto Flutuante
    // %c - Char
    // %b - Boolean

    val value = 5
    val salario = 16855.95

    // format ajuda na hora dos placeholders
    // por exemplo definindo assim ele vai imprimir 2 casas sendo a primeira 0 caso não exista outro valor 
    // no caso do salario posso definir quantas casas decimais tenho a partir do .2f - após o ponto vou mostrar apenas 2 casas decimais

    println("Valor: %02d - Salario: %.2f".format(value, salario))

    // no caso do brasil o preço é 1,99 no caso US 1.99
    // posso passar o parametro para que ele entenda qual a localidade sem precisar de criar varias localidades
    // Locale.(Pais) define como vai ser a saída do valor a partir do pais definido
    println("Valor: %02d - Salario: %.2f".format(Locale.US, value, salario))
}

/**
Aula6  - receber informações do teclado*/
fun aula6() {
    println("Informe um valor: ")
    // a função readLine vai esperar receber um valor pelo terminal
    val valor = readLine()

    // a função pode receber nulo
    valor.toString().toShort()
    valor.toString().toLong()

    println(valor)
}

fun Exercicios() {
    /** Escreva uma função capaz de receber a quantidade de anos e transformar em meses, dias, horas, minutos e segundos. Saida Desejada: */
    fun exe1() {
        println("Insira a quantidade de Anos: ")
        val anos = readLine().toString().toInt();
        val meses = anos * 12
        val dias = meses * 365
        val horas = dias * 24
        val minutos = horas * 60
        val segundos = minutos * 60

        println("%d ano(s) corresponde(m)".format(anos))
        println("%d meses".format(meses))
        println("%d dias".format(dias))
        println("%d horas".format(horas))
        println("%d minutos".format(minutos))
        println("%d segundos".format(segundos))
    }

    /** Escreva uma função capaz de receber uma string e retornar a quantidade de caracteres;
     */
    fun exe2() {
        println("Insira seu texto a vontade: ")
        println(readLine().toString().length)
    }

    /**
     *  Escreva uma função capaz de calcular o cubo de um número (cubo=n*n*n)
     */
    fun exe3() {
        println("Insira o número para ser calculado o cubo: ");
        val numero = readLine().toString().toInt();
        println("o cubo do seu numero é %d".format((numero*numero*numero)));
    }

    /**
     * Escreva uma função capaz de receber milhas e converter em km(1 milha = 1,6km)
     */
    fun exe4() {
        println("Insira a quantidades de milhas a ser convertidas: ")
        val milha = readLine().toString().toInt();
        println("a quantidade em km é %.2f".format(milha*1.6))
    }

    /**
     * Escreva uma função capaz de receber Celsius e converter Fahrenheit
     * F = (C * 9/5) + 32
     */
    fun exe5() {
        println("Informe a temperatura em Celsius: ")
        val celsius = readLine().toString().toFloat();
        val convert = (celsius * 9/5) + 32
        println("o valor convertido em Fahrenheit é: %.2f".format(convert))
    }

    exe5()
}

/** explicações */
fun ensinamentos() {
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
}
