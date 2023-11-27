import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("This message will be printed in the server console2");
        System.out.println(request);
        String xParameter = request.getParameter("x");
        String yParameter = request.getParameter("y");
        String rParameter = request.getParameter("r");

        System.out.println("Received parameters: x=" + xParameter + ", y=" + yParameter + ", r=" + rParameter);


        if (xParameter != null && yParameter != null && rParameter != null) {
            // Перенаправляем запрос на AreaCheckServlet
            request.getRequestDispatcher("/AreaCheckServlet").forward(request, response);
        } else if (request.getParameter("clearResults") != null && request.getParameter("clearResults").equals("true")) {
            clearResults(request, response);
        } else {
            System.out.println("This 3message will be 3printed in the server console3");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            List<ResultRow> resultList = (List<ResultRow>) request.getServletContext().getAttribute("resultList");

            if (resultList != null) {
                String resultListJson = convertResultListToJSON(resultList);

                response.setContentType("application/json; charset=UTF-8");
                response.getWriter().write(resultListJson);
            } else {
                List<ResultRow> emptyList = new ArrayList<>();
                response.getWriter().write("{\"message\": \"нет результатов\"}");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Internal Server Error");
        }
    }

    private void clearResults(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        context.removeAttribute("resultList");

        List<ResultRow> emptyList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String emptyListJson = objectMapper.writeValueAsString(emptyList);

        response.setContentType("application/json; charset=UTF-8");
    }

    private String convertResultListToJSON(List<ResultRow> resultList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(resultList);
    }
}
