package s1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.greenrobot.eventbus.ThreadMode;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface m {
    int priority() default 0;

    boolean sticky() default false;

    ThreadMode threadMode() default ThreadMode.POSTING;
}
