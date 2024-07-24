package com.example.quizapp

object Constants {

    const val User_Name : String = "user_name"
    const val Total_Questions : String = "total_questions"
    const val Correct_Answers : String = "correct_answers"

    fun getQuestions() : ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia", "Germany", "India",
            1
        )
        questionList.add(que1)

        val que2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina","Australia", "Germany", "India",
            2
        )
        questionList.add(que2)

        val que3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium","Australia", "Germany", "Fiji",
            1
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belgium","Kuwait", "New Zealand", "Brazil",
            4
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark","Fiji", "Argentina", "New Zealand",
            1
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Australia","Germany", "Fiji", "Kuwait",
            3
        )
        questionList.add(que6)

        val que7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Kuwait","Germany", "India", "New Zealand",
            2
        )
        questionList.add(que7)

        val que8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India","Belgium", "Germany", "Kuwait",
            1
        )
        questionList.add(que8)

        val que9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Belgium","Australia", "Germany", "Kuwait",
            4
        )
        questionList.add(que9)

        val que10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Belgium","Kuwait", "New Zealand", "Germany",
            3
        )
        questionList.add(que10)



        return questionList
    }
}