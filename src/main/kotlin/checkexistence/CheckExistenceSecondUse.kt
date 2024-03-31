package checkexistence


/**
 * Задача:
 *
 * Дан целочисленный массив nums,
 * найдите все уникальные числа x в nums, которые удовлетворяют следующему:
 * x + 1 не находится в nums и x - 1 не находится в nums.
 */

/*
Мы можем решить эту проблему простым способом — просто перебираем nums и проверяем, находится ли x + 1 или x - 1 в nums.
Если положить числа в Set, эти проверки будут стоить О(1).
*/

fun main() {
    val result = CheckExistenceSecondUse().findNumbers(
        nums = intArrayOf(5, 2, 7, 10, 3, 9),
    )

    for (i in result) {
        println("number: $i")
    }
}

class CheckExistenceSecondUse {

    // Временная сложность равна O(n), по памяти O(n).
    fun findNumbers(nums: IntArray): List<Int> {
        // список уникальных чисел, удовлетворяющих условию
        val result = mutableListOf<Int>()
        val numbersSet = mutableSetOf<Int>()

        // Кладём все числа в Set
        for (num in nums) {
            numbersSet.add(num)
        }

        for (num in nums) {
            // Проверяем условия задачи
            if (!numbersSet.contains(num + 1) && !numbersSet.contains(num - 1)) {
                result.add(num)
            }
        }

        return result
    }
}
