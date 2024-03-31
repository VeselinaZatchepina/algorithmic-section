package sliding_window

/**
 * Задача:
 * Есть массив положительных целых чисел nums и число k.
 * Найти длину самого длинного подмассива с суммой элементов меньше или равно k.
 *
 * Сложность алгоритма будет O(n).
 * По памяти O(1).
 */

fun main() {
    println(findSubarrayLength(listOf(4, 2, 1, 1), 5))
}

fun findSubarrayLength(nums: List<Int>, k: Int): Int {
    var left = 0
    var curr = 0
    var answer = 0

    for (right in nums.indices) {
        curr += nums[right]
        while (curr > k) {
            curr -= nums[left]
            left++
        }

        answer = Math.max(answer, right - left + 1)
    }

    return answer
}