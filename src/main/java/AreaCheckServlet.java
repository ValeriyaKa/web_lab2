import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            ServletContext servletContext = getServletContext();
            System.out.println("This message will be printed in the server console");
            double start = System.nanoTime();

            // Внутри блока try в методе doPost
            try {
                Float x = Float.parseFloat(request.getParameter("x"));
                Float y = Float.parseFloat(request.getParameter("y"));
                Float R = Float.parseFloat(request.getParameter("r"));

                if (validate(x, y, R)) {
                    String value = checkArea(x, y, R);
                    double execTime = Math.round((System.nanoTime() - start));
                    String stExecTime = String.valueOf(execTime);
                    ResultRow result = new ResultRow(x, y, R, stExecTime, value,
                            LocalDateTime.now().toLocalTime().withNano(0).toString());
                    result.setHit(value);
                    result.setExecTime(stExecTime);



                    System.out.println("Received parameters: x=" + x + ", y=" + y + ", R=" + R);
                    System.out.println("Created ResultRow object: " + result);

                    List<ResultRow> resultList = (List<ResultRow>) request.getServletContext().getAttribute("resultList");
                    if (resultList == null) {
                        resultList = new ArrayList<>();
                    }

                    resultList.add(result);
                    servletContext.setAttribute("resultList", resultList);
//                     Преобразуйте список результатов в JSON
//                ObjectMapper objectMapper = new ObjectMapper();
//                String resultListJson = objectMapper.writeValueAsString(resultList);
//                System.out.println(resultListJson);

//                // Отправьте JSON в ответе
//                response.setContentType("application/json; charset=UTF-8");
//                response.getWriter().write(resultListJson);
                    getServletContext().getRequestDispatcher("/result.jsp").include(request, response);

                    System.out.println("Updated resultList: " + resultList);
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            } catch (Exception e) {
                response.getWriter().write("{\"error\": \"" + e.toString() + "\"}");
            }
        }

            private boolean validate(float x, float y, float R) {
        return (x >= -3 && x <= 5 && y >= -3 && y <= 5 && R >= 1 && R <= 3);
    }

    private String checkArea(float x, float y, float R) {
            //квадрат
        if (x >= 0 && x <= R/2 && y <= 0 && y <= R) {
            return "попадание";
        }
        //круг
        if (x >= 0 && y >= 0 && Math.sqrt(x * x + y * y) <= R) {
            return "попадание";
        }
        //треугольник
        if (x <= 0 && y <= 0 && y >= x/2 - R/2) {
            return "попадание";
        } else {
            return "промах";
        }
    }
}
