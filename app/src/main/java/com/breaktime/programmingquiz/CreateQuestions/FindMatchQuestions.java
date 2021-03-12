package com.breaktime.programmingquiz.CreateQuestions;

import android.annotation.SuppressLint;
import android.content.Context;

import com.breaktime.programmingquiz.R;

import java.util.ArrayList;

public class FindMatchQuestions {
    private ArrayList<Node> questions = new ArrayList<>();

    public FindMatchQuestions(Context context) {
        @SuppressLint("ResourceType") String size = context.getResources().getString(R.dimen.quiz_text_size_big_find_a_match);
        size = size.substring(0, size.length() - 2);
        int bigSize = (int) Double.parseDouble(size);
        questions.add(new Node("C", context.getString(R.string.c_vehicle), bigSize, R.drawable.c_vehicle, new int[]{}));                    // 0
        questions.add(new Node("C++", context.getString(R.string.c_pus_plus_vehicle), bigSize, R.drawable.c_plus_plus_vehicle, new int[]{}));                        // 1
        questions.add(new Node("C#", context.getString(R.string.c_sharp_vehicle), bigSize, R.drawable.c_sharp_vehicle, new int[]{}));                              // 2
        questions.add(new Node("Java", context.getString(R.string.java_vehicle), bigSize, R.drawable.java_vehicle, new int[]{}));                            // 3
        questions.add(new Node("Python", context.getString(R.string.python_vehicle), bigSize, R.drawable.python_vehicle, new int[]{}));                            // 4
        questions.add(new Node("Perl", context.getString(R.string.perl_vehicle), bigSize, R.drawable.perl_vehicle, new int[]{}));                              // 5
        questions.add(new Node("Lisp", context.getString(R.string.lisp_vehicle), bigSize, R.drawable.lisp_vehicle, new int[]{}));                                    // 6
        questions.add(new Node("Haskell", context.getString(R.string.haskell_vehicle), bigSize, R.drawable.haskell_vehicle, new int[]{}));                          // 7
        questions.add(new Node("Php", context.getString(R.string.php_vehicle), bigSize, R.drawable.php_vehicle, new int[]{}));                            // 8
        questions.add(new Node("Go", context.getString(R.string.go_vehicle), bigSize, R.drawable.go_vehicle, new int[]{}));                                    // 9
        questions.add(new Node("Cobol", context.getString(R.string.cobol_vehicle), bigSize, R.drawable.cobol_vehicle, new int[]{}));                    // 10
        questions.add(new Node("Matlab", context.getString(R.string.matlab_vehicle), bigSize, R.drawable.matlab_vehicle, new int[]{}));                          // 11
        questions.add(new Node("R", context.getString(R.string.r_vehicle), bigSize, R.drawable.r_vehicle, new int[]{}));                                  // 12
        questions.add(new Node("Assembler", context.getString(R.string.assembler_vehicle), bigSize, R.drawable.assembler_vehicle, new int[]{}));                          // 13
        questions.add(new Node("JavaScript", context.getString(R.string.javascript_vehicle), bigSize, R.drawable.javascript_vehicle, new int[]{}));                                // 14
        questions.add(new Node("C", context.getString(R.string.c_weapon), bigSize, R.drawable.c_weapon, new int[]{}));                        // 15
        questions.add(new Node("C++", context.getString(R.string.c_plus_plus_weapon), bigSize, R.drawable.c_plus_plus_weapon, new int[]{}));                                // 16
        questions.add(new Node("Perl", context.getString(R.string.perl_weapon), bigSize, R.drawable.perl_weapon, new int[]{}));                // 17
        questions.add(new Node("Java", context.getString(R.string.java_weapon), bigSize, R.drawable.java_weapon, new int[]{}));                          // 18
        questions.add(new Node("Scala", context.getString(R.string.scala_weapon), bigSize, R.drawable.scala_weapon, new int[]{}));                          // 19
        questions.add(new Node("JavaScript", context.getString(R.string.javascript_weapon), bigSize, R.drawable.javascript_weapon, new int[]{}));                // 20
        questions.add(new Node("Go", context.getString(R.string.go_weapon), bigSize, R.drawable.go_weapon, new int[]{}));                          // 21
        questions.add(new Node("Rust", context.getString(R.string.rust_weapon), bigSize, R.drawable.rust_weapon, new int[]{}));                              // 22
        questions.add(new Node("Bash", context.getString(R.string.bash_weapon), bigSize, R.drawable.bash_weapon, new int[]{}));                              // 23
        questions.add(new Node("Python", context.getString(R.string.python_weapon), bigSize, R.drawable.python_weapon, new int[]{}));                                // 24
        questions.add(new Node("Ruby", context.getString(R.string.ruby_weapon), bigSize, R.drawable.ruby_weapon, new int[]{}));                        // 25
        questions.add(new Node("Php", context.getString(R.string.php_weapon), bigSize, R.drawable.php_weapon, new int[]{}));                          // 26
        questions.add(new Node("C#", context.getString(R.string.c_sharp_weapon), bigSize, R.drawable.c_sharp__weapon, new int[]{}));              // 27
        questions.add(new Node("Prolog", context.getString(R.string.prolog_weapon), bigSize, R.drawable.proloh_weapon, new int[]{}));                                // 28
        questions.add(new Node("Lisp", context.getString(R.string.lisp_weapon), bigSize, R.drawable.lisp_weapon, new int[]{}));                              // 29
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
        public int image;
        public String[] answers;
        public int rightAnswer;
        public int[] denied;

        Node(String name, String helloWorldText, int helloWorldTextSize, int image, int[] denied) {
            this.name = name;
            this.helloWorldText = helloWorldText;
            this.helloWorldTextSize = helloWorldTextSize;
            this.image = image;
            this.denied = denied;
        }
    }
}
