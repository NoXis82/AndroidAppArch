package ru.noxis.common.extend.screen

fun String.withEllipsisIf(maxChars: Int) = if (length > maxChars) "${take(maxChars)}.." else this