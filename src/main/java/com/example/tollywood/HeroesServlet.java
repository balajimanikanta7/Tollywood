package com.example.tollywood;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/heroes")
public class HeroesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        String heroIdParam = req.getParameter("heroId");

        List<Hero> heroes = DataRepository.getHeroes();
        Hero selectedHero = null;
        List<Movie> movies = List.of();

        if (heroIdParam != null) {
            int heroId = Integer.parseInt(heroIdParam);
            Optional<Hero> heroOpt = DataRepository.getHeroById(heroId);
            if (heroOpt.isPresent()) {
                selectedHero = heroOpt.get();
                movies = DataRepository.getMoviesByHeroId(heroId);
            }
        }

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html><html><head>");
            out.println("<meta charset='UTF-8'/>");
            out.println("<title>Tollywood Heroes Movies</title>");
            out.println("<style>");
            out.println("body { font-family: Arial; background:#0b1b3b; color:#fff; }");
            out.println(".container { max-width:1200px; margin:0 auto; padding:20px; }");
            out.println(".hero-grid { display:flex; flex-wrap:wrap; gap:15px; margin-bottom:30px; }");
            out.println(".hero-card { text-align:center; cursor:pointer; }");
            out.println(".hero-card img { width:120px; height:160px; object-fit:cover; border-radius:8px; border:2px solid #fff; }");
            out.println(".movies-grid { display:flex; flex-wrap:wrap; gap:20px; }");
            out.println(".movie-card { background:#12244f; border-radius:8px; width:260px; padding:10px; box-shadow:0 2px 6px rgba(0,0,0,0.4); }");
            out.println(".movie-card img { width:100%; height:320px; object-fit:cover; border-radius:6px; }");
            out.println(".title { font-weight:bold; font-size:16px; margin-top:8px; }");
            out.println(".meta { font-size:13px; margin-top:4px; }");
            out.println("</style>");
            out.println("</head><body><div class='container'>");

            out.println("<h1>Tollywood Heroes – Complete Filmography</h1>");
            out.println("<p>Select a hero to view all their movies.</p>");

            out.println("<div class='hero-grid'>");
            for (Hero h : heroes) {
                out.println("<div class='hero-card'>");
                out.println("<a href='heroes?heroId=" + h.getId() + "'>");
                out.println("<img src='" + h.getPhotoUrl() + "' alt='" + h.getName() + "'/>");
                out.println("</a>");
                out.println("<div>" + h.getName() + "</div>");
                out.println("</div>");
            }
            out.println("</div>");

            if (selectedHero != null) {
                out.println("<h2>" + selectedHero.getName() + " – Movies</h2>");
                out.println("<div class='movies-grid'>");
                for (Movie m : movies) {
                    out.println("<div class='movie-card'>");
                    out.println("<img src='" + m.getPosterUrl() + "'/>");
                    out.println("<div class='title'>" + m.getTitle() + "</div>");
                    out.println("<div class='meta'>Release: " + m.getReleaseDate() + "</div>");
                    out.println("<div class='meta'>Box Office: " + m.getBoxOffice() + "</div>");
                    out.println("<div class='meta'>Verdict: " + m.getVerdict() + "</div>");
                    out.println("<div class='meta'>OTT: " + m.getOttPlatform() + "</div>");
                    out.println("</div>");
                }
                out.println("</div>");
            }

            out.println("</div></body></html>");
        }
    }
}
