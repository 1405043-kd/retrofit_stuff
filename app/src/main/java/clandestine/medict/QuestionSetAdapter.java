package clandestine.medict;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;



/**
 * Created by norman on 12/26/16.
 */

public class QuestionSetAdapter extends ArrayAdapter<QuestionSet> {

    private Context context;
    private List<QuestionSet> values;

    public QuestionSetAdapter(Context context, List<QuestionSet> values) {
        super(context, R.layout.list_item_pagination, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);

        QuestionSet item = values.get(position);
        String message = item.getQuestionName();
        textView.setText(message);

        return row;
    }
}