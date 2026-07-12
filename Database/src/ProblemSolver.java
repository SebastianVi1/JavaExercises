import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemSolver {
    List<Content> contents;

    public ProblemSolver(){
        contents = new ArrayList<>(List.of(
                new Content(1, "Epic Song", "Artista A", "Song", 210, 1_500_000L),
                new Content( 2, "Tech Talk", "Locutor B", "Podcast", 1800, 85_000L),
                new Content(3, "Sad Ballad", "Artista A", "Song", 240, 95_000L),
                new Content(4, "Daily News", "Locutor C", "Podcast", 600, 120_000L),
                new Content(5,"Dance Hit", "Artista D", "Song", 180, 3_000_000L),
                new Content(6, "True Crime", "Locutor B", "Podcast", 2400, 45_000L)
        ));
    }
    //get the poupluar podcast with more than 50,0000 reproductions
    public List<Content> popularPodcast(){
        return contents.stream()
                .filter(c -> c.getReproductions() >= 50_000L)
                .filter(c -> c.getType().equals("Podcast"))
                .toList();
    }

    public List<String> topThreeSongs(){
        return contents.stream()
                .filter(c -> c.getType().equals("Song"))
                .sorted(Comparator.comparing(Content::getReproductions).reversed())
                .map(c -> c.getArtist().toUpperCase() + " - " + c.getTitle().toUpperCase())
                .limit(3)
                .toList();
    }

}
