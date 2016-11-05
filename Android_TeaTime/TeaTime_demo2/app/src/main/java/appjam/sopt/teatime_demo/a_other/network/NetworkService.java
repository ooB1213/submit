package appjam.sopt.teatime_demo.a_other.network;

import java.util.List;

import appjam.sopt.teatime_demo.b_model.domain.User;
import retrofit.Call;
import retrofit.http.GET;

public interface NetworkService {

    /******************
     * 로그인
     ******************/

    @GET("/session/object")
    Call<User> getObject();

    @GET("/session/list")
    Call<List<User>> getList();
}
