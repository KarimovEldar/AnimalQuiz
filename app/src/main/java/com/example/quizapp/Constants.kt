package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWER: String = "correct_answer"


    fun getQuestions():ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.alliqator,
            "Bear","Dog",
            "Crocodile","Alligator",
            4
        )

        // 2
        val que2 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.antelope,
            "Crab","Antelope",
            "Dolphin","Bird",
            2
        )

        // 3
        val que3 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.bear,
            "Lion","Bear",
            "Snake","Wolf",
            2
        )

        // 4
        val que4 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.beetle,
            "Bird","Beetle",
            "Crow","Human",
            2
        )

        // 5
        val que5 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.bird,
            "Crab","Beetle",
            "Dolphin","Bird",
            4
        )

        // 6
        val que6 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.butterfly,
            "Camel","Car",
            "Butterfly","Bird",
            3
        )

        // 7
        val que7 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.camel,
            "Dog","Camel",
            "Wolf","Bear",
            2
        )

        // 8
        val que8 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.cat,
            "Dog","Cat",
            "Devil","King",
            2
        )

        // 9
        val que9 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.crab,
            "Crab","Snake",
            "Plain","Scorpion",
            1
        )

        // 10
        val que10 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.crocodile,
            "Lizard","Snake",
            "Alligator","Crocodile",
            4
        )

        // 11
        val que11 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.crow,
            "Crow","Dog",
            "Cat","Eagle",
            1
        )

        val que12 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.dog,
            "Crow","Dog",
            "Cat","Eagle",
            2
        )

        val que13 = Question(
            1,"What animal is shown in the picture?",
            R.drawable.dolphin,
            "Bird","Shark",
            "Alligator","Dolphin",
            4
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        questionsList.add(que11)
        questionsList.add(que12)
        questionsList.add(que13)

        return questionsList
    }

}