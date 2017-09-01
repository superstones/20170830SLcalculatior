package Calculator;


import java.io.IOException;

import Bean.Calculator;


/**
 * Created by Administrator on 2017/8/30.
 */
public class CalculatorServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Calculator calculator = new Calculator();
        calculator.setNum1(Float.parseFloat(request.getParameter("num1")));
        calculator.setOp(request.getParameter("op"));
        calculator.setNum2(Float.parseFloat(request.getParameter("num2")));
        float result = 0;
        System.out.println("calculator = " + calculator.getOp());
        switch (calculator.getOp().charAt(0)) {
            case '+':
                result = calculator.getNum1() + calculator.getNum2();
                break;

            case '-':
                result = calculator.getNum1() - calculator.getNum2();
                break;

            case '*':
                result = calculator.getNum1() * calculator.getNum2();
                break;

            case '/':
                result = calculator.getNum1() / calculator.getNum2();
                break;
        }
        request.setAttribute("result", result);
        request.setAttribute("calculator", calculator);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
