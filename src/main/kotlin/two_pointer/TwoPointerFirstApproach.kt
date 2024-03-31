package two_pointer
/*
Первый способ:
“Поставь указатели в начало и конец списка, массива или строки.
Передвигай эти указатели навстречу друг другу, пока они не встретятся.”

Сложность алгоритма будет O(n).
По памяти O(1).
*/

/**
 * Задача:
 * Return 'true' if a given string is palindrome 'false' otherwise.
 *
 * A string is a palindrome if it reads the same forwards as backwards.
 * That means, after reversing it, it is still the same string.
 * For example: "abcdcba", or ""racecar".
 */

fun main() {
    println(checkIfPalindrome("abcdcba"))
}

fun checkIfPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1

    while (left < right) {
        if (s[left] != s[right]) {
            return false
        }

        left++
        right--
    }

    return true
}