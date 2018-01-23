package com.example.menglucywhh.myquarter.view.activity;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.view.fragment.RecommendFragment;
import com.example.menglucywhh.myquarter.view.fragment.SmileFragment;
import com.example.menglucywhh.myquarter.view.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.suke.widget.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.takecare)
    TextView takecare;
    @BindView(R.id.collection)
    TextView collection;
    @BindView(R.id.friend)
    TextView friend;
    @BindView(R.id.messages)
    TextView messages;
    @BindView(R.id.my_image_view)
    SimpleDraweeView myImageView;
    @BindView(R.id.night)
    TextView night;
    @BindView(R.id.my_directory)
    TextView myDirectory;
    @BindView(R.id.settings)
    TextView settings;
    @BindView(R.id.radio_recommend)
    RadioButton radioRecommend;
    @BindView(R.id.radio_smile)
    RadioButton radioSmile;
    @BindView(R.id.radio_video)
    RadioButton radioVideo;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    //TextView topText;
    private static SlidingMenu menu;
    @BindView(R.id.switchButton)
    SwitchButton switchButton;
    private FragmentManager manager;

    //默认日间模式
    private int theme = R.style.AppTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new出SlidingMenu对象
        menu = new SlidingMenu(this);
        //设置侧滑的方向.左侧
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        //TOUCHMODE_NONE不可以屏幕滑出

        // 设置滑动完剩余的宽度
        menu.setBehindOffset(210);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //绑定
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.sliding_left);

        ButterKnife.bind(this);
        //设置侧滑页面的头像展示
        Uri uri = Uri.parse("https://imgsa.baidu.com/forum/pic/item/3bc79f3df8dcd1000ac6c4fa798b4710b8122f96.jpg");
        SimpleDraweeView imageTouXiang = (SimpleDraweeView) findViewById(R.id.my_image_view);
        imageTouXiang.setImageURI(uri);

        //侧滑页面底部我的作品图标
        Drawable drawable_directory = getResources().getDrawable(R.drawable.directory);
        drawable_directory.setBounds(0, 0, 70, 70);//40,40为宽高
        myDirectory.setCompoundDrawables(null, drawable_directory, null, null);
        //侧滑页面底部设置的图标
        Drawable drawable_settings = getResources().getDrawable(R.drawable.settings);
        drawable_settings.setBounds(0, 0, 70, 70);//40,40为宽高
        settings.setCompoundDrawables(null, drawable_settings, null, null);
        //设置夜间模式左面的月亮
        Drawable drawable_night_colse = getResources().getDrawable(R.drawable.night_colse);
        drawable_night_colse.setBounds(0, 0, 35, 35);//40,40为宽高
        night.setCompoundDrawables(drawable_night_colse, null, null, null);
        //设置文字右侧的图片
        Drawable drawable_sliding_xiangyoua = getResources().getDrawable(R.drawable.sliding_xiangyoua);
        drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
        //设置textview的drawableleft大小
        Drawable drawable_my_takecare = getResources().getDrawable(R.drawable.my_takecare);
        drawable_my_takecare.setBounds(0, 0, 40, 40);
        takecare.setCompoundDrawables(drawable_my_takecare, null, drawable_sliding_xiangyoua, null);
        Drawable drawable_my_collection = getResources().getDrawable(R.drawable.my_collection);
        drawable_my_collection.setBounds(0, 0, 40, 40);
        collection.setCompoundDrawables(drawable_my_collection, null, drawable_sliding_xiangyoua, null);
        Drawable drawable_search_friend = getResources().getDrawable(R.drawable.search_friend);
        drawable_search_friend.setBounds(0, 0, 40, 40);
        friend.setCompoundDrawables(drawable_search_friend, null, drawable_sliding_xiangyoua, null);
        Drawable drawable_messages = getResources().getDrawable(R.drawable.messages);
        drawable_messages.setBounds(0, 0, 40, 40);
        messages.setCompoundDrawables(drawable_messages, null, drawable_sliding_xiangyoua, null);

        //主页底部radiobutton的drawabletop设置图片大小
        //初始值给的这些图片
        //推荐
       /* Drawable drawable_recommend_unselected = getResources().getDrawable(R.drawable.recommend_unselected);
        drawable_recommend_unselected.setBounds(0, 0, 60, 60);//60,60为宽高
        radioRecommend.setCompoundDrawables(null, drawable_recommend_unselected, null, null);*/
        Drawable drawable_recommend_selected = getResources().getDrawable(R.drawable.recommend_selected);
        drawable_recommend_selected.setBounds(0, 0, 60, 60);//60,60为宽高
        radioRecommend.setCompoundDrawables(null, drawable_recommend_selected, null, null);

        //段子
        Drawable drawable_smile_unselected = getResources().getDrawable(R.drawable.smile_unselected);
        drawable_smile_unselected.setBounds(0, 0, 60, 60);//60,60为宽高
        radioSmile.setCompoundDrawables(null, drawable_smile_unselected, null, null);
        //视频
        Drawable drawable_video_unselected = getResources().getDrawable(R.drawable.video_unselected);
        drawable_video_unselected.setBounds(0, 0, 60, 60);//60,60为宽高
        radioVideo.setCompoundDrawables(null, drawable_video_unselected, null, null);

        //顶部文字默认显示 推荐
        //topText.setText("推荐");
        manager = getSupportFragmentManager();

        RecommendFragment recommendFragment = new RecommendFragment();
        //进入页面默认展示 推荐页面
        manager.beginTransaction().replace(R.id.frag_linear, recommendFragment).commit();
        //radiogroup的选择切换改变
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //拿到事务的对象
                FragmentTransaction transaction = manager.beginTransaction();

                switch (i) {
                    case R.id.radio_recommend://推荐按钮,选中推荐,把其他的变灰
                        Drawable drawable_recommend_selected = getResources().getDrawable(R.drawable.recommend_selected);
                        drawable_recommend_selected.setBounds(0, 0, 60, 60);//60,60为宽高
                        radioRecommend.setCompoundDrawables(null, drawable_recommend_selected, null, null);
                        //把另外两个的变灰
                        Drawable drawable_smile_unselected = getResources().getDrawable(R.drawable.smile_unselected);
                        drawable_smile_unselected.setBounds(0, 0, 60, 60);//60,60为宽高
                        radioSmile.setCompoundDrawables(null, drawable_smile_unselected, null, null);

                        Drawable drawable_video_unselected = getResources().getDrawable(R.drawable.video_unselected);
                        drawable_video_unselected.setBounds(0, 0, 60, 60);//60,60为宽高
                        radioVideo.setCompoundDrawables(null, drawable_video_unselected, null, null);

                        //顶部的文字改变
                        //topText.setText("推荐");
                        //事务替换布局
                        transaction.replace(R.id.frag_linear, new RecommendFragment());

                        break;
                    case R.id.radio_smile://段子按钮,选中段子,把其他的变灰
                        Drawable drawable_smile_selected = getResources().getDrawable(R.drawable.smile_selected);
                        drawable_smile_selected.setBounds(0, 0, 60, 60);//60,60为宽高
                        radioSmile.setCompoundDrawables(null, drawable_smile_selected, null, null);
                        //把另外两个的变灰
                        Drawable drawable_recommend_unselected = getResources().getDrawable(R.drawable.recommend_unselected);
                        drawable_recommend_unselected.setBounds(0, 0, 60, 60);//60,60为宽高
                        radioRecommend.setCompoundDrawables(null, drawable_recommend_unselected, null, null);

                        Drawable drawable_video_unselected1 = getResources().getDrawable(R.drawable.video_unselected);
                        drawable_video_unselected1.setBounds(0, 0, 60, 60);//60,60为宽高
                        radioVideo.setCompoundDrawables(null, drawable_video_unselected1, null, null);
                        //顶部的文字改变
                        //topText.setText("段子");
                        //事务替换布局
                        transaction.replace(R.id.frag_linear, new SmileFragment());
                        break;
                    case R.id.radio_video://视频按钮,选中视频,把其他的变灰
                        Drawable drawable_video_selected = getResources().getDrawable(R.drawable.video_selected);
                        drawable_video_selected.setBounds(0, 0, 60, 60);//60,60为宽高
                        radioVideo.setCompoundDrawables(null, drawable_video_selected, null, null);
                        //把另外两个的变灰
                        Drawable drawable_recommend_unselected1 = getResources().getDrawable(R.drawable.recommend_unselected);
                        drawable_recommend_unselected1.setBounds(0, 0, 60, 60);//60,60为宽高
                        radioRecommend.setCompoundDrawables(null, drawable_recommend_unselected1, null, null);
                        Drawable drawable_smile_unselected1 = getResources().getDrawable(R.drawable.smile_unselected);
                        drawable_smile_unselected1.setBounds(0, 0, 60, 60);//60,60为宽高
                        radioSmile.setCompoundDrawables(null, drawable_smile_unselected1, null, null);
                        //顶部的文字改变
                        //topText.setText("视频");
                        //事务替换布局
                        transaction.replace(R.id.frag_linear, new VideoFragment());
                        break;
                }
                //事务提交,否则无效果
                transaction.commit();
            }
        });

        //切换日间夜间按钮点击事件
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                if (mode == Configuration.UI_MODE_NIGHT_YES) {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else if (mode == Configuration.UI_MODE_NIGHT_NO) {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

                recreate();
            }
        });
       //仿iphone开关的监听,选中时 未选中时候
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if(isChecked){
                    //设置夜间模式打开
                    Drawable drawable_night_open = getResources().getDrawable(R.drawable.night_open);
                    drawable_night_open.setBounds(0, 0, 35, 35);//40,40为宽高
                    night.setCompoundDrawables(drawable_night_open, null, null, null);

                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    recreate();
                }else{
                    //设置夜间模式关闭
                    Drawable drawable_night_colse = getResources().getDrawable(R.drawable.night_colse);
                    drawable_night_colse.setBounds(0, 0, 35, 35);//40,40为宽高
                    night.setCompoundDrawables(drawable_night_colse, null, null, null);

                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    recreate();
                }

            }
        });
    }

    //静态方法,可以类名.调用,在适配器里面点击头像时候调用
    public static void touClick() {
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏滑出
        menu.showMenu();
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//不可以滑出,只可以点击
    }


}
