package com.westeros.diagnostics;



import com.westeros.diagnostics.runners.IDiagnose;
import com.westeros.diagnostics.services.contract.Diagnostics;
import com.westeros.moviesclient.contract.MovieDto;
import com.westeros.moviesclient.IMoviesClient;

@org.springframework.stereotype.Component
@lombok.RequiredArgsConstructor
public class TheMovieDbApiConnectivityDiagnostics implements IDiagnose {

    private final IMoviesClient moviesClient;

    @Override
    public String getName() {
        return "TheMovieDB API Connection";
    }

    @Override
    public String getDescription() {
        return "Checks connection to TheMovieDB API";
    }

    @Override
    public Diagnostics run() {
        try {
            moviesClient.getMovie(1);
            return Diagnostics.Success(getName(), "Connection to TheMovieDB is successful");
        } catch (Exception e) {
             return Diagnostics.Failure(getName(), "API connection failed: " + e.getMessage());
        }
    }
}
