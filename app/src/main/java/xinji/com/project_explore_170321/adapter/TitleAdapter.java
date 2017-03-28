package xinji.com.project_explore_170321.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xinji.com.project_explore_170321.R;
import xinji.com.project_explore_170321.loaddata.LoadPictureUtil;
import xinji.com.project_explore_170321.pojo.Member;
import xinji.com.project_explore_170321.pojo.Node;
import xinji.com.project_explore_170321.pojo.Topic;

/**
 * Created by Administrator on 2017/3/23.
 */

public class TitleAdapter extends BaseAdapter {

    private List<Topic> topics;

    private Context context;

    public TitleAdapter(List<Topic> topics, Context context) {
        this.topics = topics;

        this.context = context;

    }

    @Override
    public int getCount() {
        return topics.size();
    }

    @Override
    public Object getItem(int position) {
        return topics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder=null;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_titles, null, false);

            viewHolder=new ViewHolder();
            viewHolder.img_icon= (ImageView) convertView.findViewById(R.id.img_icon);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_node= (TextView) convertView.findViewById(R.id.tv_node);
            viewHolder.tv_author= (TextView) convertView.findViewById(R.id.tv_author);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        String url = topics.get(position).getMember().getAvatar_large();
        LoadPictureUtil.loadPicture(context,url,viewHolder.img_icon);

        viewHolder.tv_title.setText(topics.get(position).getTitle());
        viewHolder.tv_node.setText(topics.get(position).getNode().getName());
        viewHolder.tv_author.setText(topics.get(position).getMember().getUsername());

        return convertView;
    }

    public class ViewHolder{
        ImageView img_icon;
        TextView tv_title;
        TextView tv_node;
        TextView tv_author;

    }

}
