import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FindByMap implements FindAble{
    @Override
    public void findMoviesByActor(List<Movies> movies) {
        scanner(movies);
    }

    private void scanner(List<Movies> movies) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter actor's name: ");
        String inputName = scanner.nextLine();
        movies.stream().filter(x -> x.getCast().stream().anyMatch(cast -> cast.getFullName().equalsIgnoreCase(inputName))).forEach(System.out::println);
    }

    @Override
    public void findMoviesByDirector(List<Movies> movies) {
        movies.stream().sorted(Comparator.comparing(x -> x.getDirector().getFullName())).forEach(System.out::println);
    }

    @Override
    public void findMoviesByYear(List<Movies> movies, int name) {
        movies.stream().filter(x -> x.getYear() == name).forEach(System.out::println);
    }

    @Override
    public void findMoviesAndRoleByActor(List<Movies> movies) {
        scanner(movies);
    }

    @Override
    public void showActorRoles(List<Movies> movies) {
        for(Movies i: movies) {
            i.printCast();
        }
    }
}
