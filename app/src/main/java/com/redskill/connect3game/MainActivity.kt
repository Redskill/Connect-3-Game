package com.redskill.connect3game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Each ImageView corresponds to one space in our grill
        var counter = findViewById<ImageView>(R.id.imageView)
        var counter2 = findViewById<ImageView>(R.id.imageView2)
        var counter3 = findViewById<ImageView>(R.id.imageView3)
        var counter4 = findViewById<ImageView>(R.id.imageView4)
        var counter5 = findViewById<ImageView>(R.id.imageView5)
        var counter6 = findViewById<ImageView>(R.id.imageView6)
        var counter7 = findViewById<ImageView>(R.id.imageView7)
        var counter8 = findViewById<ImageView>(R.id.imageView8)
        var counter9 = findViewById<ImageView>(R.id.imageView9)

        // Invisible buttons that drop a coin into the respective cell
        var button = findViewById<Button>(R.id.button)
        var button2 = findViewById<Button>(R.id.button2)
        var button3 = findViewById<Button>(R.id.button3)
        var button4 = findViewById<Button>(R.id.button4)
        var button5 = findViewById<Button>(R.id.button5)
        var button6 = findViewById<Button>(R.id.button6)
        var button7 = findViewById<Button>(R.id.button7)
        var button8 = findViewById<Button>(R.id.button8)
        var button9 = findViewById<Button>(R.id.button9)

        // Play again button & winnerTextView
        var playAgainButton = findViewById<Button>(R.id.playAgainButton)
        var winnerTextView = findViewById<TextView>(R.id.winnerTextView)

        // 0: Yellow, 1: Red , 2: Empty
        var activePlayer = 0
        var winner = ""
        var tappedCounter : Int
        var gameActive = true


        var buttonPressed = true
        var button2Pressed = true
        var button3Pressed = true
        var button4Pressed = true
        var button5Pressed = true
        var button6Pressed = true
        var button7Pressed = true
        var button8Pressed = true
        var button9Pressed = true

        // Game state is represented in form an array

        var gameState : IntArray = intArrayOf(2,2,2,2,2,2,2,2,2)
        val winningPositions : Array<IntArray> = arrayOf(
            intArrayOf(0,1,2),
            intArrayOf(3,4,5),
            intArrayOf(6,7,8),
            intArrayOf(0,3,6),
            intArrayOf(1,4,7),
            intArrayOf(2,5,8),
            intArrayOf(0,4,8),
            intArrayOf(2,4,6)
        )

        playAgainButton.setOnClickListener {
            winnerTextView.text = ""
            gameState = intArrayOf(2,2,2,2,2,2,2,2,2)
            gameActive = true

            counter.translationY = (-1500).toFloat()
            counter2.translationY = (-1500).toFloat()
            counter3.translationY = (-1500).toFloat()
            counter4.translationY = (-1500).toFloat()
            counter5.translationY = (-1500).toFloat()
            counter6.translationY = (-1500).toFloat()
            counter7.translationY = (-1500).toFloat()
            counter8.translationY = (-1500).toFloat()
            counter9.translationY = (-1500).toFloat()

            counter.setImageDrawable(null)
            counter2.setImageDrawable(null)
            counter3.setImageDrawable(null)
            counter4.setImageDrawable(null)
            counter5.setImageDrawable(null)
            counter6.setImageDrawable(null)
            counter7.setImageDrawable(null)
            counter8.setImageDrawable(null)
            counter9.setImageDrawable(null)

            buttonPressed = true
            button2Pressed = true
            button3Pressed = true
            button4Pressed = true
            button5Pressed = true
            button6Pressed = true
            button7Pressed = true
            button8Pressed = true
            button9Pressed = true

        }



        // We set all the animations to start from outside the screen
        counter.translationY = (-1500).toFloat()
        counter2.translationY = (-1500).toFloat()
        counter3.translationY = (-1500).toFloat()
        counter4.translationY = (-1500).toFloat()
        counter5.translationY = (-1500).toFloat()
        counter6.translationY = (-1500).toFloat()
        counter7.translationY = (-1500).toFloat()
        counter8.translationY = (-1500).toFloat()
        counter9.translationY = (-1500).toFloat()


        // we set all the buttons to be invisible
        button.alpha = (0).toFloat()
        button2.alpha = (0).toFloat()
        button3.alpha = (0).toFloat()
        button4.alpha = (0).toFloat()
        button5.alpha = (0).toFloat()
        button6.alpha = (0).toFloat()
        button7.alpha = (0).toFloat()
        button8.alpha = (0).toFloat()
        button9.alpha = (0).toFloat()


        // Upon user click the buttons drop the coin from above
        button.setOnClickListener {

            if (buttonPressed && gameActive) {
                buttonPressed = false
                if (activePlayer == 0) {
                    counter.setImageResource(R.drawable.yellow)
                    counter.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 1

                } else {
                    counter.setImageResource(R.drawable.red)
                    counter.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 0
                }
                tappedCounter = Integer.parseInt(counter.tag.toString())
                gameState[tappedCounter] = activePlayer

                for (winningPosition in winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                        if (activePlayer == 1) { winner = "Yellow"}
                        else { winner = "Red"}
                        // Someone has won
                        gameActive = false
                        winnerTextView.text = "$winner has won!"
                        playAgainButton.animate().alpha((1).toFloat()).setDuration(300)

                    }
                }
            }
        }

        button2.setOnClickListener {

            if (button2Pressed && gameActive) {
                button2Pressed = false
                if (activePlayer == 0) {
                    counter2.setImageResource(R.drawable.yellow)
                    counter2.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 1

                } else {
                    counter2.setImageResource(R.drawable.red)
                    counter2.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 0
                }
                tappedCounter = Integer.parseInt(counter2.tag.toString())
                gameState[tappedCounter] = activePlayer

                for (winningPosition in winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                        if (activePlayer == 1) { winner = "Yellow"}
                        else { winner = "Red"}
                        // Someone has won
                        gameActive = false
                        winnerTextView.text = "$winner has won!"
                        playAgainButton.animate().alpha((1).toFloat()).setDuration(300)
                    }
                }
            }
        }

        button3.setOnClickListener {

            if (button3Pressed && gameActive) {
                button3Pressed = false
                if (activePlayer == 0) {
                    counter3.setImageResource(R.drawable.yellow)
                    counter3.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 1

                } else {
                    counter3.setImageResource(R.drawable.red)
                    counter3.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 0
                }
                tappedCounter = Integer.parseInt(counter3.tag.toString())
                gameState[tappedCounter] = activePlayer

                for (winningPosition in winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                        if (activePlayer == 1) { winner = "Yellow"}
                        else { winner = "Red"}
                        // Someone has won
                        gameActive = false
                        winnerTextView.text = "$winner has won!"
                        playAgainButton.animate().alpha((1).toFloat()).setDuration(300)
                    }
                }
            }
        }

        button4.setOnClickListener {


            if (button4Pressed && gameActive) {
                button4Pressed = false
                if (activePlayer == 0) {
                    counter4.setImageResource(R.drawable.yellow)
                    counter4.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 1

                } else {
                    counter4.setImageResource(R.drawable.red)
                    counter4.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 0
                }
                tappedCounter = Integer.parseInt(counter4.tag.toString())
                gameState[tappedCounter] = activePlayer

                for (winningPosition in winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                        if (activePlayer == 1) { winner = "Yellow"}
                        else { winner = "Red"}
                        // Someone has won
                        gameActive = false
                        winnerTextView.text = "$winner has won!"
                        playAgainButton.animate().alpha((1).toFloat()).setDuration(300)
                    }
                }
            }
        }

        button5.setOnClickListener {


            if (button5Pressed) {
                button5Pressed = false
                if (activePlayer == 0 && gameActive) {
                    counter5.setImageResource(R.drawable.yellow)
                    counter5.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 1

                } else {
                    counter5.setImageResource(R.drawable.red)
                    counter5.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 0
                }
                tappedCounter = Integer.parseInt(counter5.tag.toString())
                gameState[tappedCounter] = activePlayer

                for (winningPosition in winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                        if (activePlayer == 1) { winner = "Yellow"}
                        else { winner = "Red"}
                        // Someone has won
                        gameActive = false
                        winnerTextView.text = "$winner has won!"
                        playAgainButton.animate().alpha((1).toFloat()).setDuration(300)
                    }
                }
            }
        }

        button6.setOnClickListener {


            if (button6Pressed && gameActive) {
                button6Pressed = false
                if (activePlayer == 0) {
                    counter6.setImageResource(R.drawable.yellow)
                    counter6.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 1

                } else {
                    counter6.setImageResource(R.drawable.red)
                    counter6.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 0
                }
                tappedCounter = Integer.parseInt(counter6.tag.toString())
                gameState[tappedCounter] = activePlayer

                for (winningPosition in winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                        if (activePlayer == 1) { winner = "Yellow"}
                        else { winner = "Red"}
                        // Someone has won
                        gameActive = false
                        winnerTextView.text = "$winner has won!"
                        playAgainButton.animate().alpha((1).toFloat()).setDuration(300)
                    }
                }
            }
        }

        button7.setOnClickListener {

            if (button7Pressed && gameActive) {
                button7Pressed = false
                if (activePlayer == 0) {
                    counter7.setImageResource(R.drawable.yellow)
                    counter7.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 1

                } else {
                    counter7.setImageResource(R.drawable.red)
                    counter7.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 0
                }
                tappedCounter = Integer.parseInt(counter7.tag.toString())
                gameState[tappedCounter] = activePlayer

                for (winningPosition in winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                        if (activePlayer == 1) { winner = "Yellow"}
                        else { winner = "Red"}
                        // Someone has won
                        gameActive = false
                        winnerTextView.text = "$winner has won!"
                        playAgainButton.animate().alpha((1).toFloat()).setDuration(300)
                    }
                }
            }
        }

        button8.setOnClickListener {

            if (button8Pressed && gameActive) {
                button8Pressed = false
                if (activePlayer == 0) {
                    counter8.setImageResource(R.drawable.yellow)
                    counter8.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 1

                } else {
                    counter8.setImageResource(R.drawable.red)
                    counter8.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 0
                }
                tappedCounter = Integer.parseInt(counter8.tag.toString())
                gameState[tappedCounter] = activePlayer

                for (winningPosition in winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                        if (activePlayer == 1) { winner = "Yellow"}
                        else { winner = "Red"}
                        // Someone has won
                        gameActive = false
                        winnerTextView.text = "$winner has won!"
                        playAgainButton.animate().alpha((1).toFloat()).setDuration(300)
                    }
                }
            }
        }

        button9.setOnClickListener {

            if (button9Pressed && gameActive) {
                button9Pressed = false
                if (activePlayer == 0) {
                    counter9.setImageResource(R.drawable.yellow)
                    counter9.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 1

                } else {
                    counter9.setImageResource(R.drawable.red)
                    counter9.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(300)
                    activePlayer = 0
                }
                tappedCounter = Integer.parseInt(counter9.tag.toString())
                gameState[tappedCounter] = activePlayer

                for (winningPosition in winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                        if (activePlayer == 1) { winner = "Yellow"}
                        else { winner = "Red"}
                        // Someone has won
                        gameActive = false
                        winnerTextView.text = "$winner has won!"
                        playAgainButton.animate().alpha((1).toFloat()).setDuration(300)
                    }
                }
            }
        }


    }
}
