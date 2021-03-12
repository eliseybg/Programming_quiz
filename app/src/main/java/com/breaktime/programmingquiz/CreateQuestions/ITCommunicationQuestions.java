package com.breaktime.programmingquiz.CreateQuestions;

import android.content.Context;

import com.breaktime.programmingquiz.R;

import java.util.ArrayList;

public class ITCommunicationQuestions {
    private ArrayList<Node> questions = new ArrayList<>();

    public ITCommunicationQuestions(Context context) {
        questions.add(new Node("assembler", context.getString(R.string.assembler), 20, new int[]{}));                    // 0
        questions.add(new Node("fortran", context.getString(R.string.fortran), 20, new int[]{}));                        // 1
        questions.add(new Node("lisp", context.getString(R.string.lisp), 20, new int[]{17}));                              // 2
        questions.add(new Node("cobol", context.getString(R.string.cobol), 20, new int[]{}));                            // 3
        questions.add(new Node("basic", context.getString(R.string.basic), 20, new int[]{5, 12, 22, 23, 26, 28, 33, 37, 39, 47, 48}));                            // 4
        questions.add(new Node("logo", context.getString(R.string.logo), 20, new int[]{4, 12, 22, 23, 26, 28, 33, 37, 39, 47, 48}));                              // 5
        questions.add(new Node("b", context.getString(R.string.b), 20, new int[]{}));                                    // 6
        questions.add(new Node("pascal", context.getString(R.string.pascal), 20, new int[]{}));                          // 7
        questions.add(new Node("forth", context.getString(R.string.forth), 20, new int[]{}));                            // 8
        questions.add(new Node("c", context.getString(R.string.c), 20, new int[]{}));                                    // 9
        questions.add(new Node("smalltalk", context.getString(R.string.smalltalk), 20, new int[]{}));                    // 10
        questions.add(new Node("prolog", context.getString(R.string.prolog), 20, new int[]{}));                          // 11
        questions.add(new Node("ml", context.getString(R.string.ml), 20, new int[]{5, 4, 22, 23, 26, 28, 33, 37, 39, 47, 48}));                                  // 12
        questions.add(new Node("scheme", context.getString(R.string.scheme), 20, new int[]{}));                          // 13
        questions.add(new Node("SQL", context.getString(R.string.SQL), 15, new int[]{}));                                // 14
        questions.add(new Node("C++", context.getString(R.string.c_plus_plus), 20, new int[]{}));                        // 15
        questions.add(new Node("ada", context.getString(R.string.ada), 18, new int[]{}));                                // 16
        questions.add(new Node("common lisp", context.getString(R.string.common_lisp), 20, new int[]{2}));                // 17
        questions.add(new Node("matlab", context.getString(R.string.matlab), 20, new int[]{}));                          // 18
        questions.add(new Node("eiffel", context.getString(R.string.eiffel), 20, new int[]{}));                          // 19
        questions.add(new Node("objective-C", context.getString(R.string.objective_c), 20, new int[]{}));                // 20
        questions.add(new Node("erlang", context.getString(R.string.erlang), 20, new int[]{}));                          // 21
        questions.add(new Node("perl", context.getString(R.string.perl), 20, new int[]{5, 12, 4, 23, 26, 28, 33, 37, 39, 47, 48}));                              // 22
        questions.add(new Node("caml", context.getString(R.string.caml), 20, new int[]{5, 12, 22, 4, 26, 28, 33, 37, 39, 47, 48}));                              // 23
        questions.add(new Node("tcl", context.getString(R.string.tcl), 20, new int[]{}));                                // 24
        questions.add(new Node("haskell", context.getString(R.string.haskell), 20, new int[]{}));                        // 25
        questions.add(new Node("python", context.getString(R.string.python), 20, new int[]{5, 12, 22, 23, 4, 28, 33, 37, 39, 47, 48}));                          // 26
        questions.add(new Node("visual basic", context.getString(R.string.visual_basic), 20, new int[]{}));              // 27
        questions.add(new Node("lua", context.getString(R.string.lua), 20, new int[]{5, 12, 22, 23, 26, 4, 33, 37, 39, 47, 48}));                                // 28
        questions.add(new Node("ruby", context.getString(R.string.ruby), 20, new int[]{}));                              // 29
        questions.add(new Node("java", context.getString(R.string.java), 18, new int[]{}));                              // 30
        questions.add(new Node("javascript", context.getString(R.string.javascript), 20, new int[]{46}));                  // 31
        questions.add(new Node("php", context.getString(R.string.php), 20, new int[]{}));                                // 32
        questions.add(new Node("Rebol", context.getString(R.string.rebol), 20, new int[]{5, 12, 22, 23, 26, 28, 4, 37, 39, 47, 48}));                            // 33
        questions.add(new Node("Actionscript", context.getString(R.string.actionscript), 20, new int[]{}));              // 34
        questions.add(new Node("D", context.getString(R.string.d), 20, new int[]{}));                                    // 35
        questions.add(new Node("C#", context.getString(R.string.c_sharp), 18, new int[]{}));                             // 36
        questions.add(new Node("Groove", context.getString(R.string.groove), 20, new int[]{5, 12, 22, 23, 26, 28, 33, 4, 39, 47, 48}));                          // 37
        questions.add(new Node("Scala", context.getString(R.string.scala), 20, new int[]{}));                            // 38
        questions.add(new Node("F#", context.getString(R.string.f_sharp), 20, new int[]{5, 12, 22, 23, 26, 28, 33, 37, 4, 47, 48}));                             // 39
        questions.add(new Node("windows powershell", context.getString(R.string.windows_powershell), 20, new int[]{}));  // 40
        questions.add(new Node("go", context.getString(R.string.go), 20, new int[]{}));                                  // 41
        questions.add(new Node("rust", context.getString(R.string.rust), 20, new int[]{}));                              // 42
        questions.add(new Node("dart", context.getString(R.string.dart), 20, new int[]{}));                              // 43
        questions.add(new Node("kotlin", context.getString(R.string.kotlin), 20, new int[]{}));                          // 44
        questions.add(new Node("ceylon", context.getString(R.string.ceylon), 20, new int[]{}));                          // 45
        questions.add(new Node("typescript", context.getString(R.string.typescript), 20, new int[]{31}));                  // 46
        questions.add(new Node("julia", context.getString(R.string.julia), 20, new int[]{5, 12, 22, 23, 26, 28, 33, 37, 39, 4, 48}));                            // 47
        questions.add(new Node("swift", context.getString(R.string.swift), 20, new int[]{5, 12, 22, 23, 26, 28, 33, 37, 39, 47, 4}));                            // 48
        questions.add(new Node("brainfuck", context.getString(R.string.brainfuck), 16, new int[]{}));                    // 49
    }

    public ArrayList<Node> getQuestionList(int size) {
        ArrayList<Node> questionList = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();
        while (questionList.size() < size) {
            int position;
            do {
                position = (int) (Math.random() * 50);
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
