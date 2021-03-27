package infama.interview.question2.movie_problem;

import org.springframework.util.Assert;

public class MovieProblem {
    public static void main(String[] args) {
        int lengthOfFlight=3;
        int [] movieDurations=new int[]{11,5,7,3,8,1,2};

        Assert.isTrue(
                moviesAvailableForFlight(
                        lengthOfFlight,
                        movieDurations
                ),
                "No movies for the flight duration");
    }

    private static boolean moviesAvailableForFlight(int lengthOfFlight,int [] movieDurations){
        for(int i=0;i<movieDurations.length-1;i++){
            for (int n=i+1;n<movieDurations.length;n++){
                int movieDuration=movieDurations[i]+movieDurations[n];
                if(movieDuration==lengthOfFlight)
                    return true;
            }
        }
        return false;
    }
}
