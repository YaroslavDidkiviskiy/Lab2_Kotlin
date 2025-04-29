fun main() {
    while (true) {
        print("Введіть суму в гривнях або 'exit' для завершення: ")
        val input = readLine()?.trim()

        if (input.equals("exit", ignoreCase = true)) {
            println("Вихід з програми.")
            break
        }

        val amount = input?.toDoubleOrNull()
        if (amount == null || amount < 0) {
            println("Некоректна сума. Спробуйте ще раз.")
            continue
        }

        print("Оберіть валюту для конвертації (usd, eur, pln): ")
        val currency = readLine()?.trim()?.lowercase()

        val rate = when (currency) {
            "usd" -> 0.027
            "eur" -> 0.025
            "pln" -> 0.11
            else -> {
                println("Невідома валюта: $currency")
                continue
            }
        }

        val result = amount * rate
        println("Результат: ${"%.2f".format(result)} $currency")
    }
}
