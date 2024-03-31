package counting


/**
 * Задача:
 *
 * Есть двумерный массив, состоящий из n массивов, каждый из которых содержит уникальные (!) целые числа.
 * Необходимо вернуть отсортированный список чисел, которые появляются во всех n массивах.
 *
 * Пример:
 * 2dArray = [[3,9,2,4,6],[1,2,3,4],[3,4,5,6]]
 *
 * Ответ:
 * [3, 4]
 */

/*
 * Временная сложность алгоритма: O(m⋅(n + logm))
 * Пространственная сложность алгоритма: O(m)
 */

fun main() {
    val result = CountingFirstUse().getNums(
        nums = arrayOf(
            intArrayOf(3, 1, 2, 4, 5),
            intArrayOf(1, 2, 3, 4),
            intArrayOf(3, 4, 5, 6)
        )
    )

    println(result)
}

class CountingFirstUse {

    fun getNums(nums: Array<IntArray>): List<Int> {
        val counts = hashMapOf<Int, Int>()
        // Подсчитываем количество появлений каждого числа в массивах - сложность O(n*m)
        for (array in nums) {
            for (x in array) {
                counts[x] = counts.getOrDefault(x, 0) + 1
            }
        }
        // Если мы после этого положим все количества вхождений чисел в Set, то сможем определить, все ли числа в одинаковом количестве входят в массивы.
        // val frequencies = hashSetOf(counts.values)
        // return frequencies.size == 1

        // Берём из хэш-мапы только те числа, которые появились во всех массивах - O(m)
        val n = nums.size
        val result = arrayListOf<Int>()
        for (key in counts.keys) {
            if (counts[key] == n) {
                result.add(key)
            }
        }

        // Сортируем получившийся список - O(m * logm)
        result.sort()

        //Итоговая временная сложность алгоритма: O(n⋅m + m⋅logm) = O(m⋅(n + logm))
        return result
    }
}