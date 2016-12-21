package net.wustudio.codezone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ScoreAdapter extends BaseAdapter {

    private Context context;
    private List<ScoreData> list;

    public ScoreAdapter(Context context, List<ScoreData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return (list != null) ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return (list != null && list.size() < position) ? list.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return (list != null && list.size() < position) ? position : -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            //讀取layout
            convertView = LayoutInflater.from(this.context).inflate(R.layout.item_score, parent, false);

            //獲取所有的資料
            holder.tvCreated = (TextView) convertView.findViewById(R.id.tvCreated);
            holder.tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
            holder.tvRank = (TextView) convertView.findViewById(R.id.tvRank);
            holder.tvScore = (TextView) convertView.findViewById(R.id.tvScore);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.update(list.get(position));
        return convertView;
    }

    public static class ViewHolder {

        public TextView tvUserName;
        public TextView tvScore;
        public TextView tvRank;
        public TextView tvCreated;

        public void update(ScoreData data) {
            this.tvUserName.setText(data.getUsername());
            this.tvScore.setText(""+data.getScore());
            this.tvRank.setText(data.getRank());
            this.tvCreated.setText(data.getCreated());
        }
    }
}
