package appjam.sopt.teatime_demo.list.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import appjam.sopt.teatime_demo.R;
import appjam.sopt.teatime_demo.b_model.domain.User;
import appjam.sopt.teatime_demo.list.component.UserListAdapter;
import appjam.sopt.teatime_demo.list.presenter.ListPresenter;
import appjam.sopt.teatime_demo.list.presenter.ListPresenterImpl;
import appjam.sopt.teatime_demo.main.view.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends AppCompatActivity implements mListView {

    @BindView(R.id.listView_List)
    ListView listView;
    ListPresenter presenter;
    UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);
        presenter = new ListPresenterImpl(this);
        adapter = new UserListAdapter(getApplicationContext());
        listView.setAdapter(adapter);
    }

    @OnClick(R.id.btnGetData_List)
    void setBtnGetData() {
        Log.i("MyTag", "1. 버튼을 누르면 프레젠터에 데이터 요청");
        presenter.getUserList();
    }

    @OnClick(R.id.btnMove_List)
    void setBtnMove() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void setDatas(ArrayList<User> userList) {
        adapter.setUserList(userList);
    }
}
