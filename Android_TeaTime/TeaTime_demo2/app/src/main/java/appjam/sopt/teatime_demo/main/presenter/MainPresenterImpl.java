package appjam.sopt.teatime_demo.main.presenter;

import android.util.Log;

import java.util.List;

import appjam.sopt.teatime_demo.a_other.network.TeaTimePresenter;
import appjam.sopt.teatime_demo.b_model.domain.User;
import appjam.sopt.teatime_demo.b_model.network.UserModel;
import appjam.sopt.teatime_demo.main.view.MainView;


/**
 * MainView에 상응하는 MainPresenter입니다
 * MainPresenterImpl은 MainPresenter 인터페이스를 구현한 클래스입니다.
 * TeaTimePresenter는 모든 presenter에 구현시켜야할 인터페이스입니다
 * 단일 데이터를 받아오는 getObjectFromModel()라는 메소드와
 * 복수 데이터(리스트)를 받아오는 getListFromModel()라는 메소드를 구현해야합니다
 * Main에서는 단일 데이터를 받아오므로 getObjectFromModel()메소드에만 코드를 작성합니다.
 */
public class MainPresenterImpl implements MainPresenter, TeaTimePresenter {

    MainView view;

    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void getUserData() {
        Log.i("MyTag", "2. 요청을 받은 프레젠터가 다시 모델에 데이터를 요청");
        UserModel model = new UserModel(this);
        model.getUserDataFromServer();
    }

    /**
     * UserModel 클래스에서 프레젠터에 데이터를 보내면
     * 인자로 받아온 데이터를 다시 view에 연결시켜 갱신합니다.
     */
    @Override
    public void getObjectFromModel(Object object) {
        Log.i("MyTag", "5. 모델에서 받은 데이터로 뷰를 갱신");
        view.setDatas((User)object);
    }

    @Override
    public void getListFromModel(List<?> objectList) {

    }
}
