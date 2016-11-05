package appjam.sopt.teatime_demo.a_other.network;

import android.app.Application;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


public class ApplicationController extends Application {

    private static ApplicationController instance;
    private static String baseUrl = "http://52.79.88.25:5000";
    private NetworkService networkService;

    public static ApplicationController getInstance() {
        return instance;
    }

    public NetworkService getNetworkService() {
        return networkService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationController.instance = this;
        this.buildService();
    }

    private void buildService() {

        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkService = retrofit.create(NetworkService.class);
    }
}
