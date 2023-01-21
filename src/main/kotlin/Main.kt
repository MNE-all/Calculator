import java.lang.reflect.Executable

fun main(args: Array<String>) {
    println("Калькулятор")


    val userInput = inputValidate("Введите два числа и знак операции через пробел (прим. 2 5 +): ")
    when(userInput.third){
        '+' -> println("Результат сложения = ${userInput.first + userInput.second}")
        '-' -> println("Результат вычитания = ${userInput.first - userInput.second}")
        '/' -> println("Результат деления = ${userInput.first / userInput.second}")
        '*' -> println("Результат умножения = ${userInput.first * userInput.second}")
    }

    println(userInput)
}

fun inputValidate(message: String): Triple<Float, Float, Char>{
    val result: Triple<Float,Float,Char>

    print(message)
    try {
        val userInput = readln()
        val (a,b,c) = userInput.split(" ", limit = 3)
        when(c.single()){
            '+','-','/', '*' -> true
            else -> {
                println("Некоректный ввод данных")
                return inputValidate(message)
            }
        }
        result = Triple(a.toFloat(), b.toFloat(), c.single())
    }
    catch (e: Exception){
        println("Некоректный ввод данных")
        return inputValidate(message)
    }
    return result
}