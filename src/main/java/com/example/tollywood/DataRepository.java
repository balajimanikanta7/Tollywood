package com.example.tollywood;

import java.util.*;

public class DataRepository {

    private static final List<Hero> HEROES = new ArrayList<>();
    private static final List<Movie> MOVIES = new ArrayList<>();

    static {
        // HERO LIST
        HEROES.add(new Hero(1, "Ram Charan", "Tier 1", "/images/heroes/ramcharan.jpg"));
        HEROES.add(new Hero(2, "Chiranjeevi", "Tier 1", "/images/heroes/chiranjeevi.jpg"));
        HEROES.add(new Hero(3, "Balakrishna", "Tier 1", "/images/heroes/balakrishna.jpg"));
        HEROES.add(new Hero(4, "Nani", "Tier 2", "/images/heroes/nani.jpg"));
        HEROES.add(new Hero(5, "Vijay Deverakonda", "Tier 2", "/images/heroes/vijay.jpg"));
        HEROES.add(new Hero(6, "Pawan Kalyan", "Tier 1", "/images/heroes/pspk.jpg"));
        HEROES.add(new Hero(7, "Allu Arjun", "Tier 1", "/images/heroes/allu.jpg"));
        HEROES.add(new Hero(8, "Prabhas", "Tier 1", "/images/heroes/prabhas.jpg"));
        HEROES.add(new Hero(9, "Jr NTR", "Tier 1", "/images/heroes/ntr.jpg"));
        HEROES.add(new Hero(10, "Mahesh Babu", "Tier 1", "/images/heroes/mahesh.jpg"));
        HEROES.add(new Hero(11, "Venkatesh", "Tier 1", "/images/heroes/venkatesh.jpg"));
        HEROES.add(new Hero(12, "Naga Chaitanya", "Tier 2", "/images/heroes/chaitanya.jpg"));
        HEROES.add(new Hero(13, "Akhil Akkineni", "Tier 3", "/images/heroes/akhil.jpg"));
        HEROES.add(new Hero(14, "Ravi Teja", "Tier 1", "/images/heroes/raviteja.jpg"));
        HEROES.add(new Hero(15, "Allari Naresh", "Tier 3", "/images/heroes/allarinaresh.jpg"));

        // SAMPLE MOVIES (you will add full list)
        MOVIES.add(new Movie(1, 7, "Pushpa: The Rise",
                "2021-12-17", "₹360 Cr WW", "Blockbuster",
                "Amazon Prime Video", "/images/posters/pushpa1.jpg"));

        MOVIES.add(new Movie(2, 8, "Salaar",
                "2023-12-22", "₹700 Cr WW", "Blockbuster",
                "Netflix", "/images/posters/salaar.jpg"));
    }

    public static List<Hero> getHeroes() { return HEROES; }

    public static Optional<Hero> getHeroById(int id) {
        return HEROES.stream().filter(h -> h.getId() == id).findFirst();
    }

    public static List<Movie> getMoviesByHeroId(int heroId) {
        List<Movie> result = new ArrayList<>();
        for (Movie m : MOVIES) {
            if (m.getHeroId() == heroId) result.add(m);
        }
        return result;
    }
}
