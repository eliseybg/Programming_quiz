package com.breaktime.programmingquiz.CreateQuestions;

import android.annotation.SuppressLint;
import android.content.Context;

import com.breaktime.programmingquiz.R;

import java.util.ArrayList;

public class ShootingInFootQuestions {
    private ArrayList<Node> questions = new ArrayList<>();

    public ShootingInFootQuestions(Context context) {
        @SuppressLint("ResourceType") String size = context.getResources().getString(R.dimen.quiz_text_size_big_shooting_in_foot);
        size = size.substring(0, size.length() - 2);
        int bigSize = (int) Double.parseDouble(size);
        questions.add(new Node("Assembler", context.getString(R.string.assemblerShootInFoot), bigSize, new int[]{}));                    // 0
        questions.add(new Node("Fortran", context.getString(R.string.fortranShootInFoot), bigSize, new int[]{}));                        // 1
        questions.add(new Node("Lisp", context.getString(R.string.lispShootInFoot), bigSize, new int[]{}));                              // 2
        questions.add(new Node("Cobol", context.getString(R.string.cobolShootInFoot), bigSize, new int[]{}));                            // 3
        questions.add(new Node("Basic", context.getString(R.string.basicShootInFoot), bigSize, new int[]{}));                            // 4
        questions.add(new Node("Logo", context.getString(R.string.logoShootInFoot), bigSize, new int[]{}));                              // 5
        questions.add(new Node("Pascal", context.getString(R.string.pascalShootInFoot), bigSize, new int[]{}));                          // 6
        questions.add(new Node("Forth", context.getString(R.string.forthShootInFoot), bigSize, new int[]{}));                            // 7
        questions.add(new Node("C", context.getString(R.string.cShootInFoot), bigSize, new int[]{}));                                    // 8
        questions.add(new Node("Smalltalk", context.getString(R.string.smalltalkShootInFoot), bigSize, new int[]{}));                    // 9
        questions.add(new Node("Prolog", context.getString(R.string.prologShootInFoot), bigSize, new int[]{}));                          // 10
        questions.add(new Node("SQL", context.getString(R.string.SQLShootInFoot), bigSize, new int[]{}));                                // 11
        questions.add(new Node("C++", context.getString(R.string.c_plus_plus_ShootInFoot), bigSize, new int[]{}));                       // 12
        questions.add(new Node("Ada", context.getString(R.string.adaShootInFoot), bigSize, new int[]{}));                                // 13
        questions.add(new Node("Matlab", context.getString(R.string.matlabShootInFoot), bigSize, new int[]{}));                          // 14
        questions.add(new Node("Eiffel", context.getString(R.string.eiffelShootInFoot), bigSize, new int[]{}));                          // 15
        questions.add(new Node("Objective-C", context.getString(R.string.objective_c_ShootInFoot), bigSize, new int[]{}));               // 16
        questions.add(new Node("Perl", context.getString(R.string.perlShootInFoot), bigSize, new int[]{}));                              // 17
        questions.add(new Node("Haskell", context.getString(R.string.haskellShootInFoot), bigSize, new int[]{}));                        // 18
        questions.add(new Node("Python", context.getString(R.string.pythonShootInFoot), bigSize, new int[]{}));                          // 19
        questions.add(new Node("Visual Basic", context.getString(R.string.visual_basic_ShootInFoot), bigSize, new int[]{}));             // 20
        questions.add(new Node("Ruby", context.getString(R.string.rubyShootInFoot), bigSize, new int[]{}));                              // 21
        questions.add(new Node("Java", context.getString(R.string.javaShootInFoot), bigSize, new int[]{}));                              // 32
        questions.add(new Node("JavaScript", context.getString(R.string.javascriptShootInFoot), bigSize, new int[]{}));                // 23
        questions.add(new Node("Php", context.getString(R.string.phpShootInFoot), bigSize, new int[]{}));                                // 24
        questions.add(new Node("C#", context.getString(R.string.c_sharpShootInFoot), bigSize, new int[]{}));                             // 25
        questions.add(new Node("CSS", context.getString(R.string.cssShootInFoot), bigSize, new int[]{}));                                // 26
        questions.add(new Node("Delphi", context.getString(R.string.delphiShootInFoot), bigSize, new int[]{}));                          // 27
        questions.add(new Node("HTML", context.getString(R.string.htmlShootInFoot), bigSize, new int[]{}));                              // 28
        questions.add(new Node("XML", context.getString(R.string.xmlShootInFoot), bigSize, new int[]{}));                                // 29
    }

    public ArrayList<Node> getQuestionList(int size) {
        ArrayList<Node> questionList = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();
        while (questionList.size() < size) {
            int position;
            do {
                position = (int) (Math.random() * questions.size());
            } while (positions.contains(position));
            Node current = questions.get(position);
            current.answers = new String[4];
            for (int i = 0; i < current.answers.length; i++) {
                int answer;
                do {
                    answer = (int) (Math.random() * questions.size());
                } while (contains(answer, position, current.denied) || contains(questions.get(position).name, current.answers, questions.get(answer).name));
                current.answers[i] = questions.get(answer).name;
            }
            int rightAnswerPosition = (int) (Math.random() * 4);
            if (questionList.size() > 0)
                do {
                    rightAnswerPosition = (int) (Math.random() * 4);
                } while (questionList.get(questionList.size() - 1).rightAnswer == rightAnswerPosition);
            current.rightAnswer = rightAnswerPosition;
            current.answers[rightAnswerPosition] = questions.get(position).name;
            questionList.add(current);
            positions.add(position);
        }
        return questionList;
    }

    boolean contains(int answer, int current, int[] denied) {
        if (answer == current)
            return true;
        for (int i = 0; i < denied.length; i++) {
            if (answer == denied[i])
                return true;
        }
        return false;
    }

    boolean contains(String rightAnswer, String[] answers, String name) {
        if (rightAnswer.equals(name))
            return true;
        for (int i = 0; i < 4; i++) {
            if (answers[i] != null && answers[i].equals(name))
                return true;
        }
        return false;
    }

    public static class Node {
        public String name;
        public String helloWorldText;
        public int helloWorldTextSize;
        public String[] answers;
        public int rightAnswer;
        public int[] denied;

        Node(String name, String helloWorldText, int helloWorldTextSize, int[] denied) {
            this.name = name;
            this.helloWorldText = helloWorldText;
            this.helloWorldTextSize = helloWorldTextSize;
            this.denied = denied;
        }
    }
}
