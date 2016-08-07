package mandar.capgemini.org.whatsapplistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.List;
import java.util.ArrayList;


public class WhatsAppListCustomAdapter extends BaseAdapter {

    private Context context;
    private List<RowItem> rowItems;

    public WhatsAppListCustomAdapter(Context context, List<RowItem> items) {
        this.context = context;
        this.rowItems = items;
    }

    @Override
    public int getCount() {
        if (null == rowItems || rowItems.isEmpty()) {
            return 0;
        }
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    static class ViewHolder {
        ImageView contact_pic;
        TextView contact_name;
        TextView contact_status;
        TextView contact_type;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService
                (Activity.LAYOUT_INFLATER_SERVICE);

        if (null == convertView) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, null);
            holder.contact_pic = (ImageView) convertView.findViewById(R.id
                    .profilePic);
            holder.contact_name = (TextView) convertView.findViewById(R.id
                    .contactName);
            holder.contact_status = (TextView) convertView.findViewById(R.id
                    .contactStatus);
            holder.contact_type = (TextView) convertView.findViewById(R.id
                    .contactType);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final RowItem item = (RowItem) getItem(position);
        holder.contact_pic.setImageResource(item.getProfile_pic());
        holder.contact_name.setText(item.getContact_name());
        holder.contact_status.setText(item.getStatus());
        holder.contact_type.setText(item.getContact_type());
        return convertView;
    }

}

