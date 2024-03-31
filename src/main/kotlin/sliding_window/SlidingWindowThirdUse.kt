package sliding_window
/*
Иногда ставится условие, что подмассив должен быть определенной длины.
*/

/**
 * Задача:
 * Есть массив целых чисел nums и число k.
 * Найти сумму элементов подмассива, в котором полученная сумма будет максимальной, но длина подмассива должна быть равна k.
 *
 * Сложность алгоритма будет O(n).
 * По памяти O(1).
 */

fun main() {
    println(findBestSubarray(listOf(10, 5, 2, 6), 2))
}

fun findBestSubarray(nums: List<Int>, k: Int): Int {
    var curr = 0

    for (i in 0 until k) {
        curr += nums[i]
    }

    var answer = curr
    for (i in k until nums.size) {
        curr += nums[i] - nums[i - k]
        answer = Math.max(answer, curr)
    }

    return answer
}