package ooh.app.funnycombination.domain.usecase

import ooh.app.funnycombination.R
import javax.inject.Inject
import kotlin.random.Random

class GenerateCombinationUseCase @Inject constructor() {
    companion object {
        val ELEMENTS = listOf<Int>(
            R.string.emoji_boss,
            R.string.emoji_ops,
            R.string.emoji_funny,
            R.string.emoji_pretty,
            R.string.emoji_wow
        )
    }

    fun generateCombination(length: Int): List<Int>{
        val combination = mutableListOf<Int>()

        for (i in 1..length){
            val index = Random.nextInt(ELEMENTS.size)
            combination.add(ELEMENTS[index])
        }

        return combination.toList()
    }
}