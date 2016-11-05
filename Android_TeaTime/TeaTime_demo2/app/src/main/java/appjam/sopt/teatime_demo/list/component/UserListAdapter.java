package appjam.sopt.teatime_demo.list.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import appjam.sopt.teatime_demo.R;
import appjam.sopt.teatime_demo.b_model.domain.User;

public class UserListAdapter extends BaseAdapter {

    ArrayList<User> userList = new ArrayList<>();
    LayoutInflater inflater;

    public UserListAdapter(Context ctx) {
        inflater = LayoutInflater.from(ctx);
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return userList.size() <= 0 ? 0 : userList.size();
    }

    @Override
    public Object getItem(int i) {
        return (userList.size() <= 0 || (i < 0 || i >= userList.size())) ? null : userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        UserListViewHolder viewHolder = new UserListViewHolder();

        if(view == null) {
            view = inflater.inflate(R.layout.item_list, viewGroup, false);
            viewHolder.txtName = (TextView)view.findViewById(R.id.txtName_ListItem);
            viewHolder.txtMail = (TextView)view.findViewById(R.id.txtMail_ListItem);
            view.setTag(viewHolder);
        } else {
            viewHolder = (UserListViewHolder)view.getTag();
        }

        User user = userList.get(i);
        viewHolder.txtName.setText(user.name);
        viewHolder.txtMail.setText(user.mail);

        return view;
    }
}
