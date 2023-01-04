package com.example.myapplication

object Constants{
    const val TOTAL_QUESTIONS:String="total_question"
    const val CORRECT_ANSWERS: String="correct_answers"
    fun getQuestions(): ArrayList<Question>{

                val questionList = ArrayList<Question>()
//a1
                val que1= Question(1,"What is 3+5?","8","10","2","4",1)

                questionList.add(que1)


                val que2= Question(2,"What is 6+5?","13","12","11","8",3)

                questionList.add(que2)

                val que3= Question(3,"What is 7+8?","6","15","13","10",2)

                questionList.add(que3)

                val que4= Question(4,"What is 4+3?","7","5","10","8",1)

                questionList.add(que4)

                val que5= Question(5,"What is 2+8?","8","10","2","9",2)

                questionList.add(que5)
//a2
               val que6= Question(6,"What is 1+7?","6","3","8","4",3)
                 questionList.add(que6)

               val que7=Question(7,"What is 4+2?","6","2","8","5",1)
                 questionList.add(que7)

               val que8=Question(8,"What is 5-4?","2","1","9","11",2)
                 questionList.add(que8)

               val que9=Question(9,"What is 11+9?","12","2","20","10",3)
                 questionList.add(que9)

               val que10=Question(10,"What is 24-16?","9","8","10","5",2)
                 questionList.add(que10)
//a3
        val que11=Question(11,"What is 3+9?","3","6","9","12",4)
        questionList.add(que11)

        val que12=Question(12,"What is 5+5?","7","8","10","5",3)
        questionList.add(que12)

        val que13=Question(13,"What is 7-5?","2","3","12","6",1)
        questionList.add(que13)

        val que14=Question(14,"What is 8+10?","2","18","15","8",2)
        questionList.add(que14)

        val que15=Question(15,"What is 25-13?","11","17","20","12",4)
        questionList.add(que15)
//semipro
        //s1
        val que16=Question(16,"What is 2*2?","4","3","1","5",1)
        questionList.add(que16)

        val que17=Question(17,"What is 2*5?", "10","30","20","15",1)
        questionList.add(que17)

        val que18=Question(18,"What is 3*9?","26","27","12","21",2)
        questionList.add(que18)

        val que19=Question(19,"What is 4*4?","9","8","12","16",4)
        questionList.add(que19)

        val que20=Question(20,"What is 25*3?","35","75","17","23",2)
        questionList.add(que20)
//s2
        val que21=Question(21,"What is 6÷3?","9","12","2","21",3)
        questionList.add(que21)

        val que22=Question(22,"What is 27÷9?","3","18","25","12",1)
        questionList.add(que22)

        val que23=Question(23,"What is 15÷3?","27","5","45","8",2)
        questionList.add(que23)

        val que24=Question(24,"What is 36÷6?","15","32","6","45",3)
        questionList.add(que24)

        val que25=Question(25,"What is 64÷4?","16","25","33","46",1)
        questionList.add(que25)
//s3
        val que26=Question(26,"What is 4*2?","12","2","8","6",3)
        questionList.add(que26)

        val que27=Question(27,"What is 10÷2?","20","8","13","5",4)
        questionList.add(que27)

        val que28=Question(28,"What is 8÷2?","6","4","16","10",2)
        questionList.add(que28)

        val que29=Question(29,"What is 300÷6?","89","100","27","50",4)
        questionList.add(que29)

        val que30=Question(30,"What is 25÷5?","5","30","24","19",1)
        questionList.add(que30)
//professional
        //p1
        val que31=Question(31,"What is 2*5+10?","3","7","10","20",4)
        questionList.add(que31)

        val que32=Question(32,"What is 10*6-6?","63","22","54","35",3)
        questionList.add(que32)

        val que33=Question(33,"What is 3+9(4)?","21","39","17","10",2)
        questionList.add(que33)

        val que34=Question(34,"What is 13-2*3?","16","7","12","6",2)
        questionList.add(que34)

        val que35=Question(35,"What is 92+4*2?","25","50","100","33",3)
        questionList.add(que35)
//p2
        val que36=Question(36,"What is 19-6*3?","1","10","23","30",1)
        questionList.add(que36)

        val que37=Question(37,"What is 4*10÷2?","20","13","37","28",1)
        questionList.add(que37)

        val que38=Question(38,"What is 8-5+(12*2)÷8?","9","12","6","18",3)
        questionList.add(que38)

        val que39=Question(39,"What is 4*25÷5?","38","34","17","20",4)
        questionList.add(que39)

        val que40=Question(40,"What is (4+3)*2?","24","14","12","34",2)
        questionList.add(que40)
//p3
        val que41=Question(41,"What is 10÷2+3?","8","37","40","25",1)
        questionList.add(que41)

        val que42=Question(42,"What is 14-3*3?","31","22","5","10",3)
        questionList.add(que42)

        val que43=Question(43,"What is 12÷2+4?","14","10","26","34",2)
        questionList.add(que43)

        val que44=Question(44,"What is (4÷2)*3?","6","13","27","15",1)
        questionList.add(que44)

        val que45=Question(45,"What is (10-3)*2?","20","7","10","14",4)
        questionList.add(que45)

                return questionList


            }
    }
