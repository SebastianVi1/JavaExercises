//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    ProblemSolver problemSolver = new ProblemSolver();

    problemSolver.topThreeSongs().forEach(c -> System.out.println(c.toString()));
    problemSolver.podcasterStadistics("Locutor B");

    problemSolver.countSongOrPodcast().forEach((k,v) -> System.out.println(k + " : "+ String.valueOf(v)));


}
