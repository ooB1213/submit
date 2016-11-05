package appjam.sopt.teatime_demo.list.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import appjam.sopt.teatime_demo.a_other.network.TeaTimePresenter;
import appjam.sopt.teatime_demo.b_model.domain.User;
import appjam.sopt.teatime_demo.b_model.network.UserModel;
import appjam.sopt.teatime_demo.list.view.mListView;

public class ListPresenterImpl implements ListPresenter, TeaTimePresenter {

    mListView view;

    public ListPresenterImpl(mListView view) {
        this.view = view;
    }

    @Override
    public void getUserList() {
        Log.i("MyTag", "2. 요청을 받은 프레젠터가 다시 모델에 데이터를 요청");
        UserModel userModel = new UserModel(this);
        userModel.getUserListFromServer();
    }

    @Override
    public void getObjectFromModel(Object object) {

    }

    @Override
    public void getListFromModel(List<?> objectList) {
        Log.i("MyTag", "5. 모델에서 받은 데이터로 뷰를 갱신");
        ArrayList<User> userList = new ArrayList<>();
        for(int i = 0; i < objectList.size(); i++) {
            Log.i("MyTag", ((User)objectList.get(i)).name);
            userList.add((User)objectList.get(i));
        }
        view.setDatas(userList);
    }
}
