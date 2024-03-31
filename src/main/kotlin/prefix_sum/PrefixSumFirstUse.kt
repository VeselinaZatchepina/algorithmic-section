package prefix_sum

/**
 * Задача:
 *
 * Дан массив целых чисел nums, найти количество способов разбиения массива на 2 части,
 * таким образом, чтобы первая часть имела сумму элементов больше или равна сумме элементов второй части массива.
 * Вторая часть массива должна иметь как минимум 1 элемент.
 */

/*
Подход "в лоб" состоял бы в переборе каждого индекса i от 0 до nums.length - 1.
На каждом индексе мы выполняем итерацию от 0 до i, чтобы найти сумму левой части,
а затем выполняем итерацию от i + 1 до конца массива, чтобы найти сумму правой части.
Сложность алгоритма была бы O(n^2).

Если бы мы использовали подход "Prefix Sum", мы бы улучшили сложность алгоритма была бы O(n).
*/

fun main() {
    println(waysToSplitArray(listOf(4, 2, 1, 1)))
    println(waysToSplitArray2(listOf(4, 2, 1, 1)))
}

// Сложность алгоритма O(n), по памяти O(n).
fun waysToSplitArray(nums: List<Int>): Int {
    val prefix = LongArray(nums.size)
    prefix[0] = nums[0].toLong()

    // формируем наш массив prefix sum
    for (i in 1 until nums.size) {
        prefix[i] = nums[i] + prefix[i - 1]
    }

    // тут prefix = [4, 6, 7, 8]
    var answer = 0
    for (i in 0 until nums.size - 1) {
        val leftSection = prefix[i]
        val rightSection = prefix[nums.size - 1] - prefix[i]

        if(leftSection >= rightSection) {
            answer++
        }
    }

    return answer
}

// Сложность алгоритма O(n), по памяти O(1).
fun waysToSplitArray2(nums: List<Int>): Int {
    var answer = 0
    var leftSection = 0
    var total = 0

    for (num in nums) {
        total += num
    }


    for (i in 0 until nums.size - 1) {
        leftSection += nums[i]
        val rightSection = total - leftSection

        if(leftSection >= rightSection) {
            answer++
        }
    }

    return answer
}