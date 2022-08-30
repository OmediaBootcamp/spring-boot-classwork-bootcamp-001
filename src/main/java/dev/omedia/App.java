package dev.omedia;

import dev.omedia.domain.Genre;
import dev.omedia.domain.Lyrics;
import dev.omedia.domain.Musician;
import dev.omedia.domain.Song;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

import java.io.*;
import java.util.Set;

@SpringBootApplication
@EntityScan(basePackages = {"dev.omedia.domain"})
@EnableCaching
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }

    public void serializablePractice() {
//        Genre genre = new Genre(1, "Rock", "Hard Rock", "Something");
//        Lyrics lyrics = new Lyrics(1, "simgeris teqsti", null);
//        Song song = new Song(1, "saxeli", genre, null, -1, lyrics);
//        lyrics.setSong(song);
//        Musician musician = new Musician(1,
//                "ioseb chkhikvadze",
//                Set.of(genre),
//                Set.of(song));
//        song.setMusician(musician);
//
//
//        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("genre.txt"))) {
//            os.writeObject(genre);
//            os.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("genre.txt"))) {
//            Genre genre1 = (Genre) is.readObject();
//
//            System.out.println(genre1.equals(genre));
//            System.out.println(genre1 == genre);
//            System.out.println(genre1);
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("musician.txt"))) {
//            os.writeObject(musician);
//            os.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("musician.txt"))) {
//            Musician musician1 = (Musician) is.readObject();
//
//            System.out.println(musician1.equals(musician));
//            System.out.println(musician1 == musician);
//            System.out.println(musician1);
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
}
