package krt.wid.demo.base;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import krt.wid.base.MBaseActivity;

/**
 * @author: MaGua
 * @create_on:2021/8/2 15:27
 * @description
 */
public abstract class BaseActivity extends MBaseActivity {

    private Unbinder mUnbinder;

    @Override
    public void bindButterKnife() {
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    public void unbindButterknife() {
        mUnbinder.unbind();
    }

    @Override
    public void beforeBindLayout() {

    }

    @Override
    public void init() {

    }

}
