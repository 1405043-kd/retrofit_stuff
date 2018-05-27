package clandestine.medict;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuestionClient {
    @GET("/c_q/{sub}/")
    Call<List<Questions>> questionsForSub(@Path("sub") String sub);
}
