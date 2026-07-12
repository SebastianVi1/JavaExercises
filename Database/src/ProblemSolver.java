import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProblemSolver {
    List<Content> contents;

    public ProblemSolver(){
        contents = new ArrayList<>(List.of(
                new Content(1, "Epic Song", "Artista A", "Song", 210, 1_500_000L),
                new Content(2, "Tech Talk", "Locutor B", "Podcast", 1800, 85_000L),
                new Content(3, "Sad Ballad", "Artista A", "Song", 240, 95_000L),
                new Content(4, "Daily News", "Locutor C", "Podcast", 600, 120_000L),
                new Content(5, "Dance Hit", "Artista D", "Song", 180, 3_000_000L),
                new Content(6, "True Crime", "Locutor B", "Podcast", 2400, 45_000L),
                new Content(7, "Morning Acoustic", "Artista E", "Song", 200, 220_000L),
                new Content(8, "History Hour", "Locutor D", "Podcast", 3600, 310_000L),
                new Content(9, "Latin Groove", "Artista F", "Song", 230, 410_000L),
                new Content(10, "Science Weekly", "Locutor E", "Podcast", 1500, 95_000L),
                new Content(11, "Chill Vibes", "Artista G", "Song", 300, 520_000L),
                new Content(12, "Health Matters", "Locutor F", "Podcast", 1200, 60_000L),
                new Content(13, "Evening Jazz", "Artista H", "Song", 260, 145_000L),
                new Content(14, "Startup Stories", "Locutor G", "Podcast", 2100, 80_000L),
                new Content(15, "Reggae Nights", "Artista I", "Song", 240, 330_000L),
                new Content(16, "Cooking Tips", "Locutor H", "Podcast", 900, 55_000L)
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

    //average minutes per artist of content
    public void podcasterStadistics(String podcaster){
        long countContent = contents.stream()
                .filter(c -> c.getArtist().equals(podcaster))
                .count();
        Double minutes = contents.stream()
                .filter(c -> c.getArtist().equals(podcaster))
                .map(p -> p.getDuration() / 60d)
                .reduce(0.00d, Double::sum);
        System.out.println(podcaster + " Average minutes of content: " + (countContent == 0 ? 0.0 : minutes / countContent));
    }

    public Map<String,Long> countSongOrPodcast(){
        return contents.stream()
                .collect(
                        Collectors.groupingBy(
                                Content::getType,
                                Collectors.counting()
                        )
                );
    }

}
