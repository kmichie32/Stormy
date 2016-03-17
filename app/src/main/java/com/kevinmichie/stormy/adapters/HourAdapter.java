package com.kevinmichie.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinmichie.stormy.R;
import com.kevinmichie.stormy.weather.Hour;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Hour[] mHours;
    private Context mContext;

    public HourAdapter(Context context, Hour[] hours){
        mContext = context;
        mHours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_list_item, parent, false);

        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(mHours[position]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }


    public class HourViewHolder extends RecyclerView.ViewHolder implements com.kevinmichie.stormy.adapters.HourViewHolder {
        @Bind(R.id.timeLabel) TextView mTimeLabel;
        @Bind(R.id.summaryLabel) TextView mSummaryLabel;
        @Bind(R.id.temperatureLabel) TextView mTemperatureLabel;
        @Bind(R.id.iconImageView) ImageView mIconImage;

        public HourViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }

        public void bindHour(Hour hour) {
            mTimeLabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(hour.getTemperature() + "");
            mIconImage.setImageResource(hour.getIconId());

        }

       /* @Override
            public void onClick(View v) {
                String time = mTimeLabel.getText().toString();
                String temperature = mTemperatureLabel.toString();
                String summary = mSummaryLabel.toString();

                String message = String.format("At %s, it will be %s and %s",
                        time,
                        temperature,
                        summary);

                Toast.makeText(mContext,message, Toast.LENGTH_LONG).show();
            }*/
        //Can't be implemented in current method because of butterknife
        }


    }

