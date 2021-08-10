package krt.wid.ui;//package krt.wid.ui;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.viewpager.widget.ViewPager;
//
//import com.viewpagerindicator.CirclePageIndicator;
//import com.viewpagerindicator.GFConstant;
//
//import krt.wid.http.R;
//
///**
// * author: MaGua
// * create on:2021/5/31 9:29
// * description
// */
//public class MGuideFragment extends Fragment implements MPageFragment.pageClickListener {
//    private ViewPager vPager;
//    private CirclePageIndicator indicator;
//    private MPageFragment[] pfs;
//    private guidePageListener listener;
//
//    public MGuideFragment() {
//    }
//
//    public guidePageListener getListener() {
//        return this.listener;
//    }
//
//    public void setListener(guidePageListener listener) {
//        this.listener = listener;
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        this.pfs = new MPageFragment[GFConstant.PIC_LIST.length];
//        View view = inflater.inflate(R.layout.fragment_guide, container, false);
//        this.vPager = (ViewPager)view.findViewById(R.id.pager);
//        myAdpter mAdpter = new myAdpter(this.getActivity().getSupportFragmentManager());
//        this.vPager.setAdapter(mAdpter);
//        this.indicator = (CirclePageIndicator)view.findViewById(R.id.indicator);
//        this.indicator.setViewPager(this.vPager);
//        this.indicator.setFillColor(this.getActivity().getResources().getColor(GFConstant.F_COLOR));
//        this.indicator.setStrokeColor(this.getActivity().getResources().getColor(GFConstant.S_COLOR));
//        return view;
//    }
//
//    @Override
//    public void btClick() {
//        if (this.listener != null) {
//            this.listener.btClick();
//        }
//
//    }
//
//    class myAdpter extends FragmentPagerAdapter {
//        public myAdpter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int arg0) {
//            if (pfs[arg0] == null) {
//                MPageFragment fragment = new MPageFragment();
//                Bundle args = new Bundle();
//                args.putInt("arg", arg0);
//                fragment.setArguments(args);
//                fragment.setListener(MGuideFragment.this);
//                pfs[arg0] = fragment;
//            }
//
//            return pfs[arg0];
//        }
//
//        @Override
//        public int getCount() {
//            return GFConstant.PIC_LIST.length;
//        }
//    }
//
//    public interface guidePageListener {
//        void btClick();
//    }
//}
