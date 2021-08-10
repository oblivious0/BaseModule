package krt.wid.ui;//package krt.wid.ui;
//
//import android.annotation.SuppressLint;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//
//import com.viewpagerindicator.GFConstant;
//import com.viewpagerindicator.PageFragment;
//
//import krt.wid.http.R;
//
///**
// * author: MaGua
// * create on:2021/5/31 9:16
// * description
// */
//public class MPageFragment extends PageFragment {
//    private ImageView iv;
//    private pageClickListener mlistener;
//
//    public MPageFragment() {
//    }
//
//    @SuppressLint("WrongConstant")
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View contextView = inflater.inflate(R.layout.fragment_page, container, false);
//        ImageButton button = contextView.findViewById(R.id.item_bt);
//        this.iv = contextView.findViewById(R.id.ft_imageView);
//        Bundle mBundle = this.getArguments();
//        int title = mBundle.getInt("arg");
//        this.iv.setImageBitmap(GFConstant.readBitMap(this.getResources(), GFConstant.PIC_LIST[title]));
//        if (title == GFConstant.PIC_LIST.length - 1) {
//            button.setImageResource(GFConstant.BT_PIC);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mlistener != null) {
//                        mlistener.btClick();
//                    }
//
//                }
//            });
//        } else {
//            button.setVisibility(8);
//        }
//
//        return contextView;
//    }
//
//    public pageClickListener getMListener() {
//        return this.mlistener;
//    }
//
//    public void setMListener(pageClickListener listener) {
//        this.mlistener = listener;
//    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        this.iv.setImageBitmap((Bitmap) null);
//        System.gc();
//    }
//
//}
