package model;

import java.util.Stack;

public class StackModel {
    public double evaluarExpresion(String expression) {
        Stack<Double> valores = new Stack<>();
        Stack<String> operadores = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < expression.length() && (Character.isDigit(expression.charAt(j)) || expression.charAt(j) == '.')) {
                    j++;
                }
                double valor = Double.parseDouble(expression.substring(i, j));
                valores.push(valor);
                i = j - 1;
            } else if (c == '(') {
                operadores.push("(");
            } else if (c == ')') {
                while (!operadores.peek().equals("(")) {
                    aplicarOperador(valores, operadores.pop());
                }
                operadores.pop(); // Quitamos el "(" del stack
            } else if (esOperador(c)) {
                while (!operadores.isEmpty() && !operadores.peek().equals("(") && precedencia(operadores.peek()) >= precedencia(String.valueOf(c))) {
                    aplicarOperador(valores, operadores.pop());
                }
                operadores.push(String.valueOf(c));
            } else if (Character.isLetter(c)) {
                int j = i;
                while (j < expression.length() && Character.isLetter(expression.charAt(j))) {
                    j++;
                }
                String funcion = expression.substring(i, j);
                i = j - 1;
                if (funcion.equals("sin") || funcion.equals("cos")) {
                    operadores.push(funcion);
                }
            }
        }

        while (!operadores.isEmpty()) {
            aplicarOperador(valores, operadores.pop());
        }

        return valores.pop();
    }

    private void aplicarOperador(Stack<Double> valores, String operador) {
        if (operador.equals("sin") || operador.equals("cos")) {
            double b = valores.pop();
            double resultado = operador.equals("sin") ? Math.sin(b) : Math.cos(b);
            valores.push(resultado);
        } else {
            double b = valores.pop();
            double a = valores.pop();
            switch (operador) {
                case "+":
                    valores.push(a + b);
                    break;
                case "-":
                    valores.push(a - b);
                     break;
                case "*":
                    valores.push(a * b);
                    break;
                case "/":
                    valores.push(a / b);
                    break;
            }
        }
    }

    private int precedencia(String operador) {
        if (operador.equals("+") || operador.equals("-")) {
            return 1;
        } else if (operador.equals("*") || operador.equals("/")) {
            return 2;
        } else if (operador.equals("sin") || operador.equals("cos")) {
            return 3;
        }
        return 0;
    }

    private boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}

