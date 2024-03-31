package checkexistence


/**
 * Задача:
 *
 * Есть массив уникальных целых чисел nums и некоторая целочисленную target,
 * верните индексы двух чисел так, чтобы их сумма составляла target.
 * Вы не можете использовать один и тот же индекс дважды.
 */

/*
Решение "в лоб" состояло бы в использование вложенного цикла for для перебора каждой пары индексов и проверки,
равна ли сумма target значению. Это приведет к временной сложности O(n^2).
Первый цикл for фокусируется на числе num, а второй цикл for ищет target — num в массиве.

Но мы можем построить хэш-мапу, проходя по массиву, сопоставляя каждое значение с его индексом.
По каждому индексу i, где num = nums[i], мы можем проверить нашу хэш-мапу на предмет target — num.
Добавление пар ключ-значение и проверка целевого target — все это O(1), поэтому наша временная сложность улучшится до O(n).
*/

fun main() {
    val result = CheckExistenceFirstUse().twoNumbers(
        nums = intArrayOf(5, 2, 7, 10, 3, 9),
        target = 8,
    )

    println("first index: ${result[0]} second index: ${result[1]}")
}

class CheckExistenceFirstUse {

    // Временная сложность равна O(n), по памяти O(n).
    fun twoNumbers(nums: IntArray, target: Int): IntArray {
        // key - текущее число, value - индекс числа
        val currentMap = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val num = nums[i]
            // Находим разницу между target и текущим значением массива
            val difference = target - num

            // Проверяем содержит ли наша хэшмапа индекс нашей "разницы"
            val secondNumIndex = currentMap[difference] // Сложность поиска - O(1)!
            if (secondNumIndex != null) {
                return intArrayOf(i, secondNumIndex) // Вытаскиваем индекс второго числа
            }

            // Кладём текущее число в хэшмапу
            currentMap[num] = i
        }

        return intArrayOf(-1, -1)
    }
}
