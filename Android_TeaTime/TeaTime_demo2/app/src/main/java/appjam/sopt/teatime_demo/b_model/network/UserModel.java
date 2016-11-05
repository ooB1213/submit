package appjam.sopt.teatime_demo.b_model.network;

import android.util.Log;

import java.util.List;

import appjam.sopt.teatime_demo.a_other.network.ApplicationController;
import appjam.sopt.teatime_demo.a_other.network.NetworkService;
import appjam.sopt.teatime_demo.a_other.network.TeaTimePresenter;
import appjam.sopt.teatime_demo.b_model.domain.User;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * User에 관한 데이터만 관리하는 모델 클래스입니다.
 * getUserDataFromServer()는 서버에서 User 데이터 하나만 가져오는 코드이고
 * getUserListFromserver()는 서버에서 User 데이터 여러개를 가져오는 코드입니다.
 * 비동기 방식이므로 onResponse() 메소드 내에서 다시 presenter의 getObjectFromModel()(TeaTimePresenter를 구현했으므로 getObjectFromModel()메소드 사용가능)
 * 를 사용하여 프레젠터에 데이터를 보냅니다.
 */
public class UserModel {

    NetworkService networkService;
    TeaTimePresenter presenter;

    public UserModel(TeaTimePresenter presenter) {
        networkService = ApplicationController.getInstance().getNetworkService();
        this.presenter = presenter;
    }

    public void getUserDataFromServer() {
        Log.i("MyTag", "3. 요청을 받은 모델이 서버에 데이터를 요청");
        Call<User> callUserData = networkService.getObject();
        callUserData.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                Log.i("MyTag", "4. 서버에서 받아온 데이터를 프레젠터에 전송");
                presenter.getObjectFromModel(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("MyTag", t.getMessage());
            }
        });
    }

    public void getUserListFromServer() {
        Log.i("MyTag", "3. 요청을 받은 모델이 서버에 데이터를 요청");
        Call<List<User>> callUserList = networkService.getList();
        callUserList.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Response<List<User>> response, Retrofit retrofit) {
                Log.i("MyTag", "4. 서버에서 받아온 데이터를 프레젠터에 전송");
                Log.i("MyTag", response.body().get(0).name);
                presenter.getListFromModel(response.body());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
