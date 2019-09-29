package com.kk.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;

public class AnimUtil {


    private static AnimationDrawable animationDrawable;

    public static void startTrans(Context context, View view) {
        Animation trans = AnimationUtils.loadAnimation(context, R.anim.my_trans_anim);
        view.startAnimation(trans);
    }

    public static void startTrans(View view) {
        Animation trans = new TranslateAnimation(0, 500, 0, 500);
        trans.setDuration(3000);
        view.startAnimation(trans);
    }

    public static void startScale(Context context, View view) {
        Animation scale = AnimationUtils.loadAnimation(context, R.anim.my_scale_anim);
        view.startAnimation(scale);
    }

    public static void startScale(View view) {
        Animation scale = new ScaleAnimation(0, 2, 0, 2, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(3000);
        view.startAnimation(scale);
    }

    public static void startRotate(Context context, View view) {
        Animation rotate = AnimationUtils.loadAnimation(context, R.anim.my_rotate_anim);
        view.startAnimation(rotate);
    }

    public static void startRotate(View view) {
        Animation rotate = new RotateAnimation(0, 277, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(3000);
        view.startAnimation(rotate);
    }

    public static void startAlpha(Context context, View view) {
        Animation alpha = AnimationUtils.loadAnimation(context, R.anim.my_alpha_anim);
        view.startAnimation(alpha);
    }

    public static void startAlpha(View view) {
        Animation alpha = new AlphaAnimation(0.1f, 0.6f);

        alpha.setDuration(3000);
        view.startAnimation(alpha);

    }

    public static void startAnimSet(Context context, View view) {
        Animation mix = AnimationUtils.loadAnimation(context, R.anim.my_mix_anim);
        view.startAnimation(mix);
    }

    public static void startAnimSet(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setRepeatMode(Animation.RESTART);
        animationSet.setRepeatCount(1);

        Animation rotate = new RotateAnimation(0, 277, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);

        Animation trans = new TranslateAnimation(0, 500, 0, 500);
        trans.setDuration(3000);

        Animation scale = new ScaleAnimation(0, 2, 0, 2, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(3000);

        Animation alpha = new AlphaAnimation(0.1f, 0.6f);
        alpha.setDuration(3000);

        //添加到组合动画
        animationSet.addAnimation(rotate);
        animationSet.addAnimation(trans);
        animationSet.addAnimation(scale);
        animationSet.addAnimation(alpha);

        view.startAnimation(animationSet);
    }

    public static void startAnimWithInterpolator(Context context, View view) {
        Animation scale = AnimationUtils.loadAnimation(context, R.anim.my_scale_anim);
        Interpolator interpolator = AnimationUtils.loadInterpolator(context, R.anim.my_scale_interpolator);
        scale.setInterpolator(interpolator);
        view.startAnimation(scale);
    }

    public static void startAnimItem(Context context, ListView view) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.view_anim);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        view.setLayoutAnimation(controller);
    }

    public static void startFrameAnim(ImageView iv) {
        iv.setImageResource(R.drawable.kongfu);
        animationDrawable = (AnimationDrawable) iv.getDrawable();
        animationDrawable.start();
    }

    public static void stopFrameAnim(ImageView iv) {
        animationDrawable.setOneShot(true);
        iv.setImageDrawable(animationDrawable);
        animationDrawable.stop();
    }

    public static void startPropertyAnim(final View view){
        ValueAnimator va = ValueAnimator.ofInt(view.getLayoutParams().width,500);
        va.setDuration(2000);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int) valueAnimator.getAnimatedValue();
                System.out.println("curValue = " + curValue);
                view.getLayoutParams().width = curValue;
                view.requestLayout();
            }
        });
        //启动动画
        va.start();
    }

}