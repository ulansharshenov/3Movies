import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MovieStore implements SortAble{
    @Override
    public void printAllMovies(List<Movies> movies) {
        System.out.println(JsonIO.getMovies());
    }

    @Override
    public void findMovie(List<Movies> movies) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter movie name: ");
        String inputMovieName = scanner.nextLine();
        JsonIO.getMovies().stream().filter(x -> x.getName().contains(inputMovieName)).forEach(System.out::println);
    }

    @Override
    public void sortByYear(List<Movies> movies) {
        JsonIO.getMovies().stream().sorted(Comparator.comparing(Movies::getYear)).forEach(System.out::println);
    }

    @Override
    public void sortByName(List<Movies> movies) {
        JsonIO.getMovies().stream().sorted(Comparator.comparing(Movies::getName)).forEach(System.out::println);
    }

    @Override
    public void sortByDirector(List<Movies> movies) {
        JsonIO.getMovies().stream().sorted(Comparator.comparing(x -> x.getDirector().toString())).forEach(System.out::println);
    }
}
