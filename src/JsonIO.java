import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonIO {
    private static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();

    public static String readJson(String path) {
        String json = "";
        try (FileReader fr = new FileReader(path)) {
            int c;
            while ((c = fr.read()) != -1) {
                json += (char) c;
            }
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static List<Movies> getMovies() {
        Map<String, List<Movies>> moviesMap = GSON.fromJson(readJson("movies.json"),
                new TypeToken<Map<String, List<Movies>>>() {
                }.getType());

        List<Movies> movies = new ArrayList<>();

        for (Map.Entry<String, List<Movies>> t : moviesMap.entrySet()) {
            movies.addAll(t.getValue());
        }
        return movies;

    }
}
