package two_pointer/*
Второй способ:
Если у нас два списка в качестве входных параметров, то поставим один указатель в начало одного списка, а другой в начало другого.
Двигаемся, пока один из указателей не дойдет до конца списка.

Сложность алгоритма будет O(n + m).
По памяти O(1).

*/

/**
 * Задача:
 * Given two sorted integer arrays, return an array that combines both of them and is also sorted.
 */

fun main() {
    println(combine(listOf(1, 2, 4), listOf(3, 5, 6)))
}

fun combine(array1: List<Int>, array2: List<Int>): List<Int> {
    val result = arrayListOf<Int>()
    var i: Int = 0
    var j: Int = 0

    while (i < array1.size && j < array2.size) {
        if(array1[i] < array2[j]) {
            result.add(array1[i])
            i++
        } else {
            result.add(array2[j])
            j++
        }
    }

    while (i < array1.size) {
        result.add(array1[i])
        i++
    }

    while (j < array2.size) {
        result.add(array2[j])
        j++
    }

    return result
}