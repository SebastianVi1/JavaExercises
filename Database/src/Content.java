public class Content {
    private int id;
    private String title;
    private String artist;
    private String type;
    private int duration;
    private Long reproductions;

    public Content(int id, String title, String artist, String type,int duration,Long reproductions){
        this.duration = duration;
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.type = type;
        this.reproductions = reproductions;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getReproductions() {
        return reproductions;
    }

    public void setReproductions(long reproductions) {
        this.reproductions = reproductions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return """
                Artist: %s,
                Title: %s,
                Duration %d seconds,
                Type: %s
                """.formatted(this.artist,this.title,this.duration,this.type);
    }
}
