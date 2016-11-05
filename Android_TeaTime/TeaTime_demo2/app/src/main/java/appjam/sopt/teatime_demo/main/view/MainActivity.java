package appjam.sopt.teatime_demo.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import appjam.sopt.teatime_demo.R;
import appjam.sopt.teatime_demo.b_model.domain.User;
import appjam.sopt.teatime_demo.list.view.ListActivity;
import appjam.sopt.teatime_demo.main.presenter.MainPresenter;
import appjam.sopt.teatime_demo.main.presenter.MainPresenterImpl;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 단일 데이터를 받아오는 MainActivity 입니다.(MainView를 구현) MVP 에서 V(View)입니다.
 * MainPresenter에 데이터를 요청하고 뷰를 갱신하는 역할만 합니다.
 */
public class MainActivity extends AppCompatActivity implements MainView {

    /**
     * 버터나이프로 레이아웃의 뷰들을 가져오는 코드입니다
     */
    @BindView(R.id.imgProfile_Main)
    ImageView imgProfile;
    @BindView(R.id.txtName_Main)
    TextView txtName;
    @BindView(R.id.txtMail_Main)
    TextView txtMail;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 버터나이프를 사용할 때 반드시! ButterKnife.bind()를 사용해주셔야 합니다.
         * 이거 까먹고 실행시키면 런타임 에러가 납니다.
         */
        ButterKnife.bind(this);
        presenter = new MainPresenterImpl(this);
    }

    /**
     * 버터나이프로 OnClick 메소드를 사용하는 방법입니다.
     * 따로 위에서 선언하지 않아도 바로 클릭 이벤트를 만들 수 있습니다.
     *
     * btnGetData_Main 이라는 버튼을 클릭했을 때 일어나는 이벤트인데
     * '서버에서 단일 데이터 받아오기' 라고 적혀있는 버튼입니다.
     */
    @OnClick(R.id.btnGetData_Main)
    void setBtnGetData() {
        Log.i("MyTag", "1. 버튼을 누르면 프레젠터에 데이터 요청");
        presenter.getUserData();
    }

    /**
     * btnMove_Main 이라는 버튼 클릭 이벤트입니다.
     * '리스트 받아오는 액티비티로 이동' 라고 적혀있는 버튼입니다.
     */
    @OnClick(R.id.btnMove_Main)
    void setBtnMove() {
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }

    /**
     * 프레젠터에서 view를 갱신할 때 사용하는 메소드입니다
     * MainView 인터페이스의 메소드를 구현한겁니다.
     */
    @Override
    public void setDatas(User user) {

        /**
         * 받아온 User 데이터의 profileUrl을 Glide 라이브러리를 이용하여 이미지뷰에 삽입하는 코드입니다.
         * Glide의 가장 기본적인 사용방법이니 익혀두시면 편합니다.
         */
        Glide.with(this)
                .load(user.profileUrl)
                .into(imgProfile);

        /**
         * 받아온 User 데이터의 이름, 메일을 텍스트뷰에 삽입하는 코드입니다
         */
        String strName = txtName.getText().toString() + user.name;
        String strMail = txtMail.getText().toString() + user.mail;
        txtName.setText(strName);
        txtMail.setText(strMail);

    }
}
