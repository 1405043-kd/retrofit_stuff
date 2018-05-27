package clandestine.medict;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuestionClient {
    @GET("/c_q/")
    Call<List<Questions>> cqAll();

    @GET("/c_q/{sub}/")
    Call<List<Questions>> cqSub(@Path("sub") String sub);

    @GET("/c_q/{sub}/{chapter}/")
    Call<List<Questions>> cqSubChap(@Path("sub") String sub, @Path("chapter") String chapter);

    @GET("/x_q/")
    Call<List<Questions>> xqAll();

    @GET("/x_q/{year}/")
    Call<List<Questions>> xqYear(@Path("year") String year);

    @GET("/x_q/{year}/{MVD}/")
    Call<List<Questions>> xqYearMVD(@Path("year") String year, @Path("MVD") String MVD);

    @GET("/q_set/")
    Call<List<QuestionSet>> q_set();

    @GET("/e_history")
    Call<List<ExamHistory>> e_history();

    @GET("/e_history/{user_id}/")
    Call<List<ExamHistory>> e_history_user(@Path("user_id") String user_id);

}
