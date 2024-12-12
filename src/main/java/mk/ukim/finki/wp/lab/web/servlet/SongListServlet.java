package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "song-list-servlet", urlPatterns = "/listSongs1")
public class SongListServlet extends HttpServlet {

    private final SongService songService;
    private final SpringTemplateEngine springTemplateEngine;

    public SongListServlet(SongService songService, SpringTemplateEngine springTemplateEngine)
    {
        this.songService=songService;
        this.springTemplateEngine=springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("songs",songService.listSongs());
        springTemplateEngine.process("listSongs.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trackId = request.getParameter("trackId");
        String rating=request.getParameter("rating");
        if(rating!=null)
        {
            response.sendRedirect((request.getContextPath() + "/listSongs"));
        }
        if (trackId != null) {
            response.sendRedirect(request.getContextPath() + "/artist?trackId=" + trackId);
        }
    }
}
