package alex.mvc.controller;

import alex.mvc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final List<User> users = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deleteUserId = request.getParameter("delete");
        String editUserId = request.getParameter("edit");

        if (deleteUserId != null) {
            int id = Integer.parseInt(deleteUserId);
            users.removeIf(user -> user.getId() == id);
        } else if (editUserId != null) {
            int id = Integer.parseInt(editUserId);
            User editedUser = users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
            if (editedUser != null) {
                request.setAttribute("editedUser", editedUser);
                request.getRequestDispatcher("editUser.jsp").forward(request, response);
                return;
            }
        }

        request.setAttribute("users", users);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        int age = Integer.parseInt(request.getParameter("age"));
        String lastName = request.getParameter("lastName");

        String deleteUserId = request.getParameter("delete");
        String editUserId = request.getParameter("edit");

        if (deleteUserId != null) {
            int id = Integer.parseInt(deleteUserId);
            users.removeIf(user -> user.getId() == id);
        } else if (editUserId != null) {
            int id = Integer.parseInt(editUserId);
            User editedUser = users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
            if (editedUser != null) {
                editedUser.setFirstName(firstName);
                editedUser.setAge(age);
                editedUser.setLastName(lastName);
            }
        } else {

            User user = new User();
            user.setId(generateUserId());
            user.setFirstName(firstName);
            user.setAge(age);
            user.setLastName(lastName);
            users.add(user);
        }

        // Устанавливаем атрибуты в запросе перед передачей в JSP
        request.setAttribute("users", users);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    // Метод для генерации уникального идентификатора для пользователя (вам нужно его реализовать)
    private int generateUserId() {
        // Ваша логика генерации уникального идентификатора, например, можно использовать счетчик
        return users.size() + 1;
    }

}
