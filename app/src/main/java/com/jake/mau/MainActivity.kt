package com.jake.mau

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var card1ImageView: ImageView
    lateinit var card2ImageView: ImageView

    lateinit var player1ScoreTextView: TextView
    lateinit var player2ScoreTextView: TextView

    lateinit var warTextView: TextView

    lateinit var dealButton: Button

    var playerScores = intArrayOf(0, 0)

    val cardsArray = intArrayOf(
        R.drawable.clubs2,
        R.drawable.spades2,
        R.drawable.hearts2,
        R.drawable.diamonds2,
        R.drawable.clubs3,
        R.drawable.spades3,
        R.drawable.hearts3,
        R.drawable.diamonds3,
        R.drawable.clubs4,
        R.drawable.spades4,
        R.drawable.hearts4,
        R.drawable.diamonds4,
        R.drawable.clubs5,
        R.drawable.spades5,
        R.drawable.hearts5,
        R.drawable.diamonds5,
        R.drawable.clubs6,
        R.drawable.spades6,
        R.drawable.hearts6,
        R.drawable.diamonds6,
        R.drawable.clubs7,
        R.drawable.spades7,
        R.drawable.hearts7,
        R.drawable.diamonds7,
        R.drawable.clubs8,
        R.drawable.spades8,
        R.drawable.hearts8,
        R.drawable.diamonds8,
        R.drawable.clubs9,
        R.drawable.spades9,
        R.drawable.hearts9,
        R.drawable.diamonds9,
        R.drawable.clubs10,
        R.drawable.spades10,
        R.drawable.hearts10,
        R.drawable.diamonds10,
        R.drawable.clubs_jack,
        R.drawable.spades_jack,
        R.drawable.hearts_jack,
        R.drawable.diamonds_jack,
        R.drawable.clubs_queen,
        R.drawable.spades_queen,
        R.drawable.hearts_queen,
        R.drawable.clubs_king,
        R.drawable.diamonds_queen,
        R.drawable.spades_king,
        R.drawable.hearts_king,
        R.drawable.diamonds_king,
        R.drawable.clubs_ace,
        R.drawable.spades_ace,
        R.drawable.hearts_ace,
        R.drawable.diamonds_ace,
        R.drawable.joker,
        R.drawable.joker,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val random = Random

        card1ImageView = findViewById(R.id.iv_card1)
        card2ImageView = findViewById(R.id.iv_card2)

        card1ImageView.setImageResource(R.drawable.card_back)
        card2ImageView.setImageResource(R.drawable.card_back)

        player1ScoreTextView = findViewById(R.id.tv_player1)
        player2ScoreTextView = findViewById(R.id.tv_player2)

        warTextView = findViewById(R.id.tv_war)
        warTextView.visibility = View.INVISIBLE

        dealButton = findViewById(R.id.b_deal)
        dealButton.setOnClickListener{
            warTextView.visibility = View.INVISIBLE

            val card1 = random.nextInt(cardsArray.size)
            val card2 = random.nextInt(cardsArray.size)

            setCardImage(card1, card1ImageView)
            setCardImage(card2, card2ImageView)

            when {
                card1 > card2 -> playerScores[0]++
                card1 < card2 -> playerScores[1]++
                else -> warTextView.visibility = View.VISIBLE
            }

            updateScoresUI()
        }
    }

    private fun setCardImage(cardIndex: Int, imageView: ImageView) {
        imageView.setImageResource(cardsArray[cardIndex])
    }

    private fun updateScoresUI() {
        player1ScoreTextView.text = "Player 1: ${playerScores[0]}"
        player2ScoreTextView.text = "Player 2: ${playerScores[1]}"
    }
}
