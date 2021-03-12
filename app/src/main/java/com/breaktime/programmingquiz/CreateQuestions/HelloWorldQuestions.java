package com.breaktime.programmingquiz.CreateQuestions;

import android.annotation.SuppressLint;
import android.content.Context;

import com.breaktime.programmingquiz.R;

import java.util.ArrayList;

public class HelloWorldQuestions {
    private ArrayList<Node> questions = new ArrayList<>();

    @SuppressLint("ResourceType")
    public HelloWorldQuestions(Context context) {
        String size = context.getResources().getString(R.dimen.quiz_text_size_big_hello_world);
        size = size.substring(0, size.length() - 2);
        int bigSize = (int) Double.parseDouble(size);
        size = context.getResources().getString(R.dimen.quiz_text_size_normal_hello_world);
        size = size.substring(0, size.length() - 2);
        int normalSize = (int) Double.parseDouble(size);
        size = context.getResources().getString(R.dimen.quiz_text_size_small_hello_world);
        size = size.substring(0, size.length() - 2);
        int smallSize = (int) Double.parseDouble(size);
        questions.add(new Node("Assembler", context.getString(R.string.assembler), bigSize, new int[]{}));                    // 0
        questions.add(new Node("Fortran", context.getString(R.string.fortran), bigSize, new int[]{}));                        // 1
        questions.add(new Node("Lisp", context.getString(R.string.lisp), bigSize, new int[]{17}));                              // 2
        questions.add(new Node("Cobol", context.getString(R.string.cobol), bigSize, new int[]{}));                            // 3
        questions.add(new Node("Basic", context.getString(R.string.basic), bigSize, new int[]{5, 12, 22, 23, 26, 28, 33, 37, 39, 47, 48}));                            // 4
        questions.add(new Node("Logo", context.getString(R.string.logo), bigSize, new int[]{4, 12, 22, 23, 26, 28, 33, 37, 39, 47, 48}));                              // 5
        questions.add(new Node("B", context.getString(R.string.b), bigSize, new int[]{}));                                    // 6
        questions.add(new Node("Pascal", context.getString(R.string.pascal), bigSize, new int[]{}));                          // 7
        questions.add(new Node("Forth", context.getString(R.string.forth), bigSize, new int[]{}));                            // 8
        questions.add(new Node("C", context.getString(R.string.c), bigSize, new int[]{}));                                    // 9
        questions.add(new Node("Smalltalk", context.getString(R.string.smalltalk), bigSize, new int[]{}));                    // 10
        questions.add(new Node("Prolog", context.getString(R.string.prolog), bigSize, new int[]{}));                          // 11
        questions.add(new Node("Ml", context.getString(R.string.ml), bigSize, new int[]{5, 4, 22, 23, 26, 28, 33, 37, 39, 47, 48}));                                  // 12
        questions.add(new Node("Scheme", context.getString(R.string.scheme), bigSize, new int[]{}));                          // 13
        questions.add(new Node("SQL", context.getString(R.string.SQL), smallSize, new int[]{}));                                // 14
        questions.add(new Node("C++", context.getString(R.string.c_plus_plus), bigSize, new int[]{}));                        // 15
        questions.add(new Node("Ada", context.getString(R.string.ada), normalSize, new int[]{}));                                // 16
        questions.add(new Node("Common Lisp", context.getString(R.string.common_lisp), bigSize, new int[]{2}));                // 17
        questions.add(new Node("Matlab", context.getString(R.string.matlab), bigSize, new int[]{}));                          // 18
        questions.add(new Node("Eiffel", context.getString(R.string.eiffel), normalSize, new int[]{}));                          // 19
        questions.add(new Node("Objective-C", context.getString(R.string.objective_c), bigSize, new int[]{}));                // 20
        questions.add(new Node("Erlang", context.getString(R.string.erlang), bigSize, new int[]{}));                          // 21
        questions.add(new Node("Perl", context.getString(R.string.perl), bigSize, new int[]{5, 12, 4, 23, 26, 28, 33, 37, 39, 47, 48}));                              // 22
        questions.add(new Node("Caml", context.getString(R.string.caml), bigSize, new int[]{5, 12, 22, 4, 26, 28, 33, 37, 39, 47, 48}));                              // 23
        questions.add(new Node("Tcl", context.getString(R.string.tcl), bigSize, new int[]{}));                                // 24
        questions.add(new Node("Haskell", context.getString(R.string.haskell), bigSize, new int[]{}));                        // 25
        questions.add(new Node("Python", context.getString(R.string.python), bigSize, new int[]{5, 12, 22, 23, 4, 28, 33, 37, 39, 47, 48}));                          // 26
        questions.add(new Node("Visual Basic", context.getString(R.string.visual_basic), bigSize, new int[]{}));              // 27
        questions.add(new Node("Lua", context.getString(R.string.lua), bigSize, new int[]{5, 12, 22, 23, 26, 4, 33, 37, 39, 47, 48}));                                // 28
        questions.add(new Node("Ruby", context.getString(R.string.ruby), bigSize, new int[]{}));                              // 29
        questions.add(new Node("Java", context.getString(R.string.java), normalSize, new int[]{}));                              // 30
        questions.add(new Node("JavaScript", context.getString(R.string.javascript), bigSize, new int[]{46}));                  // 31
        questions.add(new Node("Php", context.getString(R.string.php), bigSize, new int[]{}));                                // 32
        questions.add(new Node("Rebol", context.getString(R.string.rebol), bigSize, new int[]{5, 12, 22, 23, 26, 28, 4, 37, 39, 47, 48}));                            // 33
        questions.add(new Node("ActionScript", context.getString(R.string.actionscript), normalSize, new int[]{}));              // 34
        questions.add(new Node("D", context.getString(R.string.d), bigSize, new int[]{}));                                    // 35
        questions.add(new Node("C#", context.getString(R.string.c_sharp), normalSize, new int[]{}));                             // 36
        questions.add(new Node("Groove", context.getString(R.string.groove), bigSize, new int[]{5, 12, 22, 23, 26, 28, 33, 4, 39, 47, 48}));                          // 37
        questions.add(new Node("Scala", context.getString(R.string.scala), bigSize, new int[]{}));                            // 38
        questions.add(new Node("F#", context.getString(R.string.f_sharp), bigSize, new int[]{5, 12, 22, 23, 26, 28, 33, 37, 4, 47, 48}));                             // 39
        questions.add(new Node("PowerShell", context.getString(R.string.windows_powershell), bigSize, new int[]{}));  // 40
        questions.add(new Node("Go", context.getString(R.string.go), bigSize, new int[]{}));                                  // 41
        questions.add(new Node("Rust", context.getString(R.string.rust), bigSize, new int[]{}));                              // 42
        questions.add(new Node("Dart", context.getString(R.string.dart), bigSize, new int[]{}));                              // 43
        questions.add(new Node("Kotlin", context.getString(R.string.kotlin), bigSize, new int[]{}));                          // 44
        questions.add(new Node("Ceylon", context.getString(R.string.ceylon), bigSize, new int[]{}));                          // 45
        questions.add(new Node("TypeScript", context.getString(R.string.typescript), bigSize, new int[]{31}));                  // 46
        questions.add(new Node("Julia", context.getString(R.string.julia), bigSize, new int[]{5, 12, 22, 23, 26, 28, 33, 37, 39, 4, 48}));                            // 47
        questions.add(new Node("Swift", context.getString(R.string.swift), bigSize, new int[]{5, 12, 22, 23, 26, 28, 33, 37, 39, 47, 4}));                            // 48
        questions.add(new Node("Brainfuck", context.getString(R.string.brainfuck), smallSize, new int[]{}));                    // 49
    }

    public ArrayList<Node> getQuestionList(int size) {
        ArrayList<Node> questionList = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();
        while (questionList.size() < size) {
            int position;
            do {
                position = (int) (Math.random() * questions.size());
            } while (isFirstQuestion(questionList.size(), questions.get(position).name) || positions.contains(position));
            Node current = questions.get(position);
            current.answers = new String[4];
            for (int i = 0; i < current.answers.length; i++) {
                int answer;
                do {
                    answer = (int) (Math.random() * questions.size());
                } while (isFirstQuestion(questionList.size(), questions.get(answer).name) || contains(answer, position, current.denied) || contains(questions.get(position).name, current.answers, questions.get(answer).name));
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

    boolean isFirstQuestion(int question, String answer) {
        if (question == 0 && answer.length() > 7) {
            return true;
        }
        return false;
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
